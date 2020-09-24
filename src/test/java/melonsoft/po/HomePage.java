package test.java.melonsoft.po;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.melonsoft.SalesCaseTest;
import test.java.melonsoft.utils.PropertyLoader;

import java.util.HashMap;

public class HomePage {
    Logger log = Logger.getLogger(HomePage.class.getName());

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//*[@title='Settings']")
    WebElement settings;

    @FindBy(xpath = "//*[@title='Logout']")
    WebElement logout;

    @FindBy(xpath = "//*[@name='SWEUserName']")
    WebElement sweusername;

    @FindBy(xpath = "//*[@name='SWEPassword']")
    WebElement swepassword;

    @FindBy(linkText = "Login")
    WebElement loginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
        PageFactory.initElements(driver, this);
    }

    @Step("Open Home Page")
    public HomePage openP() {
        log.debug("try to open Siebel");
        driver.get(PropertyLoader.loadProperty("url"));
        wait.until(ExpectedConditions.visibilityOf(settings));
        return this;
    }

    @Step("Open Home Page at TEST instance")
    public HomePage openT(HashMap hm) {
        log.debug("Open Home Page at UAT instance");
        String t = hm.get("t").toString();
        String testUrl = PropertyLoader.loadProperty("url_trae_usmmbm01");
        String username = "";
        switch (t) {
            case "agrT":
                username = PropertyLoader.loadProperty("agreeTestUser");
                break;
            case "srT":
                username = PropertyLoader.loadProperty("sRequTestUser");
                break;
            default:
                // code block
        }

        driver.get(testUrl);
        wait.until(ExpectedConditions.visibilityOf(sweusername));
        sweusername.sendKeys(username);
        swepassword.sendKeys("USr174");
        loginButton.click();
        log.debug("Try to open  Home page. Please wait up to 30 seconds");
        wait.until(ExpectedConditions.visibilityOf(settings));
        log.debug("Home page. Please wait up to 30 seconds");
        log.debug(driver.getTitle() + ". Home page. Please wait up to 30 seconds");
        return this;
    }

    @Step("Exit from Siebel")
    public HomePage exit() {
        for (int j = 0; j <10; j++) {
            try {
                Thread.sleep(500);
                wait.until(ExpectedConditions.elementToBeClickable(settings)).click();
                log.debug("Settings opened");
                break;
            } catch (Exception e) {
                log.debug("Settings Button isn't active yet");
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
        wait.until(ExpectedConditions.visibilityOf(sweusername));
        return this;
    }

    public void waiting(int i) {
        int c = 0;
        for (int j = 0; j <i/10 ; j++) {
            try {
                Thread.sleep(i/10*1000);
                c+=i/10;
                log.debug(c + " seconds passed");
            }catch (Exception e){

            }
        }
    }
}
