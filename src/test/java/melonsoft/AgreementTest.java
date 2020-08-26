package test.java.melonsoft;

import io.qameta.allure.Epic;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.melonsoft.po.AgreementPage;
import test.java.melonsoft.po.HomePage;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

@Epic("Agreements Tests")
public class AgreementTest extends BaseSetup {
    /**
     * The AgreementTest implements an application that
     * tests search exists Agreement of Konecranes company
     * by ID, check Customer Contact, and count amount of
     * Agreement
     *
     * @author Alex Arbuzov
     * @version 1.0
     * @since 2020-06-27
     */

    HomePage homePage;
    AgreementPage agreementPage;
    HashMap hashMap;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
        agreementPage = new AgreementPage(driver);
        hashMap = new HashMap();
    }


    //Search Agreement
    @Parameters({"agreementId"})
    @Test(priority = 1)
    public void openAgreements(@Optional("1-46592565857") String agreementId)  {
        System.out.println("check for agreement : " + agreementId);
        homePage.openP();
        agreementPage.open(hashMap); // go to agreements tab
        String pageTitle = hashMap.get("pageTitle").toString();
        assertEquals(pageTitle, "All Agreements Across Organization:", "Wrong Customer Account: " + pageTitle);
        agreementPage.searchAgreement(agreementId);
        agreementPage.getAgreementsAmount(hashMap);
        int expAgreementsAmount = 7; //expected agreements amount
        int actAgreementsAmount = (int) hashMap.get("agreementsAmount"); //actual agreements amount
        assertEquals(actAgreementsAmount, expAgreementsAmount, "Wrong Agreement '" + agreementId + "' amount. Expected " + expAgreementsAmount + " but found  " + actAgreementsAmount);
        homePage.exit();
    }
}
