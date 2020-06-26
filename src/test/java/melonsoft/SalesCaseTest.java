package test.java.melonsoft;

import io.qameta.allure.Epic;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.melonsoft.po.HomePage;
import test.java.melonsoft.po.SalesCasePage;
import java.util.HashMap;
import static org.testng.Assert.assertEquals;

@Epic("Sales Case Tests")
public class SalesCaseTest extends BaseSetup {

    HomePage homePage;
    SalesCasePage salesCasePage;
    HashMap hashMap;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
        salesCasePage = new SalesCasePage(driver);
    }


    //test sales case page
    @Parameters({"scId"})
    @Test(priority = 1)
    public void openSalesCase(@Optional("1-16DBZCFA") String scId) throws InterruptedException {
        System.out.println(scId);
        homePage.open();
        String actualTitle = driver.getTitle();
        salesCasePage.open();
        salesCasePage.searchSalesCase(scId);
        salesCasePage.getCustomerContact(hashMap);
        homePage.exit();
        assertEquals(hashMap.get("customerContact"), "SYNLAIT MILK LIMITED", "Wrong Customer Account: " + hashMap.get("customerContact"));
    }

    //test sales case page
    @Parameters({"scId"})
    @Test(priority = 2)
    public void openSalesCaseF(@Optional("1-16DBZCFA") String scId) throws InterruptedException {
        System.out.println(scId);
        homePage.open();
        //String actualTitle =  driver.getTitle();
        salesCasePage.open();
        salesCasePage.searchSalesCase(scId);
        salesCasePage.getCustomerContact(hashMap);
        homePage.exit();
        assertEquals(hashMap.get("customerContact"), "SYNLAIT MILK LIMITE", "Wrong Customer Account: " + hashMap.get("customerContact"));
    }
}
