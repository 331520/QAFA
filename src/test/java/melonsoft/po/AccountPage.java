package test.java.melonsoft.po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.melonsoft.utils.PropertyLoader;

import java.util.HashMap;

public class AccountPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //account page checkpoint
    @FindBy(xpath = "//a[text()='Accounts List']")
    WebElement accListLink;

    //account page checkpoint
    @FindBy(xpath = "//*[@title='Accounts:Reporting']")
    WebElement reportingButton;

    //account page checkpoint
    @FindBy(xpath = "//*[@title='Accounts:yourKONECRANES']")
    WebElement accountsyourKONECRANESButton;

    //Sr Tab checkpoint
    @FindBy(xpath = "//*[@title='Service Requests:Manual Grouping']")
    WebElement srManGrouButton;

    //Service Requests New button
    @FindBy(xpath = "//*[@title='Service Requests:New']")
    WebElement srNewButton;

    //account if field inactive
    @FindBy(id = "1_s_1_l_Account_Number")
    WebElement accIdField;

    //account if field active
    @FindBy(name = "Account_Number")
    WebElement accIdFieldActive;

    //account page checkpoint
    @FindBy(name = "Name")
    WebElement accLink;

    //account page checkpoint
    @FindBy(name = "KC_SR_Billing_Type")
    WebElement kcSrBillingType;

   //account page checkpoint
    @FindBy(name = "Description")
    WebElement srDescriptionActiveField;

    //account page checkpoint
    @FindBy(linkText = "Service Requests")
    WebElement srTabLink;

    //account page checkpoint
    //@FindBy(css = "td[id$='KC_Service_Product_Code']")
    //@FindBy(xpath = "//*[@id='KC_Service_Product_Code']")
    //@FindBy(xpath = "//td[ends-with(@id,'KC_Service_Product_Code']")
    //WebElement spField;


    //account page checkpoint
    @FindBy(name = "KC_Service_Product_Code")
    WebElement spFieldActive;


    public AccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
        PageFactory.initElements(driver, this);
    }

    @Step("Open Accounts Page")
    public AccountPage open(HashMap hashMap) {
        driver.get(PropertyLoader.loadProperty("accountsQAUrl"));
        driver.get(PropertyLoader.loadProperty("accountsQAUrl"));
        for (int i = 0; i < 3; i++) {
            try {
                wait.until(ExpectedConditions.visibilityOf(reportingButton));
                break;
            } catch (Exception e) {
                System.out.println("error load : " + PropertyLoader.loadProperty("accountsQAUrl") + ". We will try to repeat now");
                driver.get(PropertyLoader.loadProperty("accountsQAUrl"));
            }

        }

        System.out.println("Title : " + driver.getTitle());
        hashMap.put("pageTitle", driver.getTitle());
        return this;
    }


    @Step("Search Account By Id")
    public AccountPage searchAccount(String accountId) {
        wait.until(ExpectedConditions.elementToBeClickable(accIdField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(accIdFieldActive)).sendKeys(accountId + "\r\n");
        wait.until(ExpectedConditions.elementToBeClickable(accountsyourKONECRANESButton));
        wait.until(ExpectedConditions.visibilityOf(accLink)).click();
        return this;
    }

    @Step("Jump to Service Request Tab")
    public AccountPage goToSr() {
        wait.until(ExpectedConditions.elementToBeClickable(srTabLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(srManGrouButton));
        return this;
    }

    @Step("Create New Service Request")
    public AccountPage createNewSR(String ctst) {
        wait.until(ExpectedConditions.elementToBeClickable(srNewButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(srManGrouButton));
        for (int i = 0; i < 10; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td[id$='KC_Service_Product_Code']"))).click();
                break;
            } catch (Exception e) {
                System.out.println("error click KC_Service_Product_Code. Repeat in 1 second");
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(spFieldActive)).sendKeys("SP21A-CARE Preventive Maint.");
        wait.until(ExpectedConditions.elementToBeClickable(spFieldActive)).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(kcSrBillingType)).sendKeys("Time & Material");
        kcSrBillingType.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td[id$='Description']"))).click();
        srDescriptionActiveField.sendKeys("Created by QAFA at " + ctst);
        srDescriptionActiveField.sendKeys(Keys.TAB);
        return this;
    }
}
