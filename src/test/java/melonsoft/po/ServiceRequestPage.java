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
import java.util.List;

public class ServiceRequestPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    //By serviceRequestIdField = By.cssSelector("td[id$='Row_Id']");
    //By serviceRequestDescriptionField = By.cssSelector("td[id$='Description']");
    //By salesCaseIdFieldInput = By.name("Row_Id");

    // Service Request Description Field
    @FindBy(css = "td[id$='Description']")
    WebElement serviceRequestDescriptionField;

    //Service Request Description Field active filed
    @FindBy(name = "Description")
    WebElement srDescriptionActiveField;

    //Service Requests Planning Board Calendar Button
    @FindBy(xpath = "//*[@title='Service Requests:Planning Board Calendar']")
    WebElement srPlBoardCalendarButton;

    //Service Requests Query Button
    @FindBy(xpath = "//*[@title='Service Requests:Query']")
    WebElement queryButton;

    //Service Requests Go Button
    @FindBy(xpath = "//*[@title='Service Requests:Go']")
    WebElement srGoButton;

    public ServiceRequestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30);
        PageFactory.initElements(driver, this);
    }

    @Step("Go to Service Request Tab")
    public ServiceRequestPage open() {
        driver.get(PropertyLoader.loadProperty("serviceRequestUrl"));
        for (int i = 0; i < 10; i++) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Settings']")));
                break;
            } catch (Exception e) {
                System.out.println(PropertyLoader.loadProperty("serviceRequestUrl"));
                driver.get(PropertyLoader.loadProperty("serviceRequestUrl"));
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Settings']")));
        wait.until(ExpectedConditions.elementToBeClickable(srPlBoardCalendarButton));
        return this;
    }

    @Step("Search for Service Request  By Description")
    public ServiceRequestPage searchSRByDescription(HashMap hm) {
        wait.until(ExpectedConditions.elementToBeClickable(queryButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(serviceRequestDescriptionField)).click();
        String srDescription = hm.get("srDescription").toString();
        wait.until(ExpectedConditions.elementToBeClickable(srDescriptionActiveField)).sendKeys(srDescription);
        wait.until(ExpectedConditions.elementToBeClickable(srDescriptionActiveField)).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(srGoButton)).click();
        List<WebElement> srs = driver.findElements(By.xpath("//*[@title='" + srDescription + "']"));
        hm.put("srAmount", srs.size());
        return this;
    }
}
