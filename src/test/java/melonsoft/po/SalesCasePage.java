package test.java.melonsoft.po;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.melonsoft.utils.PropertyLoader;

import java.util.HashMap;
import java.util.List;

public class SalesCasePage {

    Logger log = Logger.getLogger(SalesCasePage.class.getName());
    private final WebDriver driver;
    private final WebDriverWait wait;

    By queryButton = By.xpath("//*[@title='Sales Cases:Query']");
    By salesCaseIdField = By.cssSelector("td[id$='Row_Id']");
    By salesCaseIdFieldInput = By.name("Row_Id");
    By customerAccount = By.cssSelector("a[name='Account']");

    @FindBy(css = "button[data-display$='LLE Configurator']")
    WebElement scLLEConfiguratorButton;

    @FindBy(css = "div[title$='Pricing Details Form Applet']")
    WebElement scPricingDetailsFormApplet;

    @FindBy(name = "KC Asset Number")
    List<WebElement> scFlKCAssetNumber;

    public SalesCasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30);
        PageFactory.initElements(driver, this);
    }

    @Step("Go to Sales Case Tab")
    public SalesCasePage open() {
        driver.get(PropertyLoader.loadProperty("salecaseUrl"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Settings']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Settings']")));
        return this;
    }

    @Step("Go to Sales Case Detail View")
    public SalesCasePage openScDetailView(HashMap hm) {
        String url = PropertyLoader.loadProperty("salesCaseDetailUrl") + hm.get("sCNumber");
        for (int i = 0; i < 3; i++) {
            try {
                log.debug("Try to open Sales Case Detail View : \r\n" + url);
                driver.get(url);
                wait.until(ExpectedConditions.visibilityOf(scLLEConfiguratorButton));
                log.debug("Page opened" + driver.getTitle());
                break;
            }catch (Exception e){
                log.debug("Error open page : " + e.getMessage() + ". Repeat...");
            }

        }
        log.debug(driver.getTitle());
        return this;
    }

    @Step("Go to Sales Case Operative Quote TAB")
    public SalesCasePage openOperativeQuoteTAB(HashMap hm) {
        String url = PropertyLoader.loadProperty("salesCaseOQlUrl").replace("<<salescasenumber>>", hm.get("sCNumber").toString());
        for (int i = 0; i < 10; i++) {
            try {
                log.debug("Try to open Sales Case Operative Quote TAB : \r\n" + url);
                driver.get(url);
                wait.until(ExpectedConditions.visibilityOf(scPricingDetailsFormApplet));
                log.debug("Page opened" + driver.getTitle());
                break;
            }catch (Exception e){
                log.debug("Error open page : " + e.getMessage() + ". Repeat...");
            }

        }


        log.debug(driver.getTitle());
        return this;
    }

    @Step("Check for Assets")
    public SalesCasePage checkOQAssets(HashMap hm) {
        wait.until(ExpectedConditions.visibilityOf(scPricingDetailsFormApplet));
        log.debug(driver.getTitle());
        log.debug("found assets " + scFlKCAssetNumber.size());
        for (WebElement element : scFlKCAssetNumber) {
            log.debug("Asset number " + element.getText());
        }
        hm.put("scAssetsQuantity", scFlKCAssetNumber.size());
        return this;
    }


    @Step("Search for Sales Case By Id")
    public SalesCasePage searchSalesCase(String scId) {
        wait.until(ExpectedConditions.elementToBeClickable(queryButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(salesCaseIdField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(salesCaseIdFieldInput)).sendKeys(scId + "\r\n");
        //wait.until(ExpectedConditions.elementToBeClickable(salesCaseIdFieldInput)).sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Get Sales Case's Customer Contact")
    public SalesCasePage getCustomerContact(HashMap hashMap) {
        String customerContact = wait.until(ExpectedConditions.visibilityOfElementLocated(customerAccount)).getText();
        System.out.println("customerContact : " + customerContact);
        hashMap.put("customerContact", customerContact);
        return this;
    }
}
