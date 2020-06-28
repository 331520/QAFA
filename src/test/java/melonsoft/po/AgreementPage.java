package test.java.melonsoft.po;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.melonsoft.utils.PropertyLoader;

import java.util.HashMap;
import java.util.List;

public class AgreementPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//a[text()='Agreement List']")
    WebElement agreeListLink;

    @FindBy(css = "td[id$='Agreement_Number']")
    WebElement agreeNumberField;

    @FindBy(name = "Agreement_Number")
    WebElement agreeNumberFieldInput;

    @FindBy(css = "td[id$='Agreement_Number']")
    List<WebElement> agreeNumberFieldsAll;


    public AgreementPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
        PageFactory.initElements(driver, this);
    }

    @Step("Open Agreements Page")
    public AgreementPage open(HashMap hashMap) {
        driver.get(PropertyLoader.loadProperty("agreementsUrl"));
        wait.until(ExpectedConditions.visibilityOf(agreeListLink));
        System.out.println("Title : " + driver.getTitle());
        hashMap.put("pageTitle", driver.getTitle());
        return this;
    }

    @Step("Search Agreement by Id")
    public AgreementPage searchAgreement(String agreementId) {
        wait.until(ExpectedConditions.elementToBeClickable(agreeNumberField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(agreeNumberFieldInput)).sendKeys(agreementId + "\r\n");
        return null;
    }

    @Step("Get Agreements amount")
    public AgreementPage getAgreementsAmount(HashMap hashMap) {
        agreeNumberFieldsAll.size();
        System.out.println("Agreements found " + agreeNumberFieldsAll.size());
        hashMap.put("agreementsAmount", agreeNumberFieldsAll.size());
        return null;
    }
}
