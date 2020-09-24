package test.java.melonsoft;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class BaseSetup {
    /**
     * The BaseSetup class implements an basic setup of tests
     *
     * @author Alex Arbuzov
     * @version 1.0
     * @since 2020-06-26
     */

    WebDriver driver;

    //Setup driver, waiting, and driver options
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


    //Create allure string attachment
    @Attachment
    private String attachStringToAllure() {
        return "Attach";
    }

    //Create allure screenshots
    @Attachment(value = "screenshot", type = "image/png")
    private byte[] attachScreenToAllure() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    //Create allure screenshots
    @Attachment(value = "screenshot", type = "image/png")
    public byte[] attachScreenToAllureYet() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    //current timestamp
    public String cTst() {
        Date date = new Date(System.currentTimeMillis());
        // Conversion
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
        //sdf.setTimeZone(TimeZone.getTimeZone("EEST"));
        return sdf.format(date);
    }
}
