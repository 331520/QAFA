package test.java.melonsoft.po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.melonsoft.utils.PropertyLoader;

import java.util.HashMap;

public class SalesCasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    By queryButton = By.xpath("//*[@title='Sales Cases:Query']");
    By salesCaseIdField = By.cssSelector("td[id$='Row_Id']");
    By salesCaseIdFieldInput = By.name("Row_Id");
    By customerAccount = By.cssSelector("a[name='Account']");


    public SalesCasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30);
    }

    @Step("Go to Sales Case Tab")
    public SalesCasePage open() {
        driver.get(PropertyLoader.loadProperty("salecaseUrl"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Settings']")));
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
