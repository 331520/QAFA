package test.java.melonsoft;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import test.java.melonsoft.po.AccountPage;
import test.java.melonsoft.po.HomePage;
import test.java.melonsoft.po.ServiceRequestPage;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class ServiceRequestManCr extends BaseSetup{
    /**
     * The ServiceRequestManCr implements an application that
     * tests manual creation Service Request under Account's
     * Service Request tab
     *
     * @author Alex Arbuzov
     * @version 1.0
     * @since 2020-08-25
     */

    HomePage homePage;
    AccountPage accountPage;
    ServiceRequestPage serviceRequestPage;
    HashMap hashMap;


    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        serviceRequestPage = new ServiceRequestPage(driver);
        hashMap = new HashMap();
    }

    //create sc
    @Test(priority = 1)
    public  void createServiceRequestUnderAccount(@Optional("1-1004UE9A") String accountId){
        System.out.println("check for account : " + accountId);
        hashMap.put("t", "srT");
        hashMap.put("cTst", cTst());
        //open home page
        homePage.openT(hashMap); // log in to siebel
        accountPage.open(hashMap); // go to account page
        accountPage.searchAccount(accountId); //
        accountPage.goToSr(); // go to  Service Request TAB under account
        accountPage.createNewSR(hashMap);
        serviceRequestPage.open(); // go to Service Request Page
        serviceRequestPage.searchSRByDescription(hashMap); // Search for Service Request  By Description
        assertEquals(hashMap.get("srAmount").toString(), "1", "Wrong SR count: " + hashMap.get("srDescription") + ". Expected : 1");
        homePage.exit(); //correct exit home Siebel
    }

}
