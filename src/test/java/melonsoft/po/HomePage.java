package test.java.melonsoft.po;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.melonsoft.utils.PropertyLoader;

public class HomePage {
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
        driver.get(PropertyLoader.loadProperty("url"));
        wait.until(ExpectedConditions.visibilityOf(settings));
        return this;
    }

    @Step("Open Home Page at TEST instance")
    public HomePage openT() {
        String testUrl = PropertyLoader.loadProperty("url_trae_usmmbm01");

        driver.get(testUrl);
        wait.until(ExpectedConditions.visibilityOf(sweusername));
        sweusername.sendKeys("USMMBM01");
        swepassword.sendKeys("USr174");
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOf(settings));
        return this;
    }

    @Step("Exit from Siebel")
    public HomePage exit()  {
        wait.until(ExpectedConditions.elementToBeClickable(settings)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
        wait.until(ExpectedConditions.visibilityOf(sweusername));
        return this;
    }
}
