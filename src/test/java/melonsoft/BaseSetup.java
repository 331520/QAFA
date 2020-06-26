package test.java.melonsoft;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class BaseSetup {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(ITestContext iTestContext) {
        WebDriverManager.getInstance(CHROME).setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        iTestContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        //screenshot.getScreenshot(result);
        attachStringToAllure();
        attachScreenToAllure();
        driver.quit();
    }

    @Attachment
    private String attachStringToAllure() {
        return "Attach";
    }

    @Attachment(value = "screenshot", type = "image/png")
    private byte[] attachScreenToAllure() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
