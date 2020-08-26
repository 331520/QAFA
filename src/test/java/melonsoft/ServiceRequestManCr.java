package test.java.melonsoft;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import test.java.melonsoft.po.AccountPage;
import test.java.melonsoft.po.HomePage;

import java.util.HashMap;

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
    HashMap hashMap;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        hashMap = new HashMap();
    }

    //create sc
    @Test(priority = 1)
    public  void createSalesCAseUnderAccount(@Optional("1-1005U03T") String accountId){
        System.out.println("check for account : " + accountId);
        //open home page
        homePage.openT();
        accountPage.open(hashMap);
        accountPage.searchAccount(accountId);
        accountPage.goToSr();
        accountPage.createNewSR("str");
        homePage.exit(); //correct exit home Siebel
    }

}
