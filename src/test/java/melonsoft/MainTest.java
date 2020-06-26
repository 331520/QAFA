package test.java.melonsoft;

import io.qameta.allure.Epic;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.melonsoft.po.HomePage;
import test.java.melonsoft.po.SalesCasePage;
import test.java.melonsoft.utils.RetryAnalyzer;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;
@Epic("Login")
public class MainTest extends BaseSetup {

    HomePage homePage;
    SalesCasePage salesCasePage;
    HashMap hashMap;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
        salesCasePage = new SalesCasePage(driver);
    }


    //test login to Siebel
    @Parameters({"browser"})
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void successLogin(@Optional("fFox") String browser) throws InterruptedException {
        System.out.println(browser);
        homePage.open();
        String actualTitle =  driver.getTitle();
        homePage.exit();
        assertEquals(actualTitle, "Siebel", "Siebel's homepage wasn't opened. Instead was opened : " + actualTitle);
    }


}
