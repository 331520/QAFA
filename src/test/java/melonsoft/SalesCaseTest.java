package test.java.melonsoft;

import io.qameta.allure.Epic;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.melonsoft.po.HomePage;
import test.java.melonsoft.po.SalesCasePage;
import test.java.melonsoft.po.ServiceRequestPage;
import test.java.melonsoft.utils.PropertyLoader;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.HashMap;

import static org.testng.Assert.assertEquals;

@Epic("Sales Case Tests")
public class SalesCaseTest extends BaseSetup {
    /**
     * The SalesCaseTest implements an application that
     * tests search exists Sales Case process of Konecranes company
     * by ID and check Customer Contact
     * <p>
     * Creation of OQ SC from SR - 2020-09-09
     *
     * @author Alex Arbuzov
     * @version 1.0
     * @since 2020-06-26
     */

    Logger log = Logger.getLogger(SalesCaseTest.class.getName());
    HomePage homePage;
    SalesCasePage salesCasePage;
    ServiceRequestPage serviceRequestPage;
    HashMap hashMap;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
        salesCasePage = new SalesCasePage(driver);
        serviceRequestPage = new ServiceRequestPage(driver);
        hashMap = new HashMap();
    }


    /**
     * This method is used to Creation of OQ SC from SR.
     * For correct work please set Service Request ID in the
     * config.properties file, for 'sReqNumberForSC' parameter.
     *
     */

    @Test(priority = 1, enabled = true)
    public void createSalesCaseFromSR() throws IOException, UnsupportedFlavorException {
        log.debug("Start create Sales Case From SR");
        hashMap.put("t", "srT");
        hashMap.put("srId", PropertyLoader.loadProperty("sReqNumberForSC"));
        //open home page
        homePage.openT(hashMap); // log in to siebel
        serviceRequestPage.open();
        serviceRequestPage.searchSRById(hashMap);
        serviceRequestPage.drillDownSR(hashMap);
        serviceRequestPage.jumpToWpTab();
        serviceRequestPage.createNewWP(hashMap);
        serviceRequestPage.checkSRStatus(hashMap);
        assertEquals(hashMap.get("srStatus").toString(), "Completed", "Wrong SR status: " + hashMap.get("srStatus") + ". ");
        homePage.waiting(120);
        serviceRequestPage.checkWpScNumbers(hashMap);
        assertEquals(hashMap.get("Identical").toString(), "SC is Identical", "Wrong CS numbers status on WPs: " + hashMap.get("Identical") + ". ");
        salesCasePage.openScDetailView(hashMap);
        salesCasePage.openOperativeQuoteTAB(hashMap);
        salesCasePage.checkOQAssets(hashMap);
        assertEquals(hashMap.get("scAssetsQuantity").toString(), "2", "Wrong Asset Quantity  on SC: " + hashMap.get("Quantity") + ". ");
        homePage.exit(); //correct exit home Siebel
    }

    //Search Sales Case and check Customer Contact
    @Parameters({"scId"})
    @Test(enabled = false, testName = "Search Sales Case and check Customer Contact")
    public void openSalesCase(@Optional("1-16DBZCFA") String scId) {
        System.out.println(scId);
        homePage.openP();
        //String actualTitle = driver.getTitle();
        salesCasePage.open();
        salesCasePage.searchSalesCase(scId);
        salesCasePage.getCustomerContact(hashMap);
        homePage.exit();
        assertEquals(hashMap.get("customerContact"), "SYNLAIT MILK LIMITED", "Wrong Customer Account: " + hashMap.get("customerContact"));
    }

    //check Customer Contact
/*    @Parameters({"scId"})
    @Test(priority = 2)
    public void openSalesCaseF(@Optional("1-16DBZCFA") String scId)  {
        System.out.println(scId);
        homePage.open();
        //String actualTitle =  driver.getTitle();
        salesCasePage.open();
        salesCasePage.searchSalesCase(scId);
        salesCasePage.getCustomerContact(hashMap);
        homePage.exit();
        assertEquals(hashMap.get("customerContact"), "SYNLAIT MILK LIMITE", "Wrong Customer Account: " + hashMap.get("customerContact"));
    }*/
}
