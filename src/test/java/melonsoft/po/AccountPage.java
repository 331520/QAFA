package test.java.melonsoft.po;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.melonsoft.utils.PropertyLoader;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class AccountPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //account page checkpoint
    @FindBy(xpath = "//*[@title='Accounts:Reporting']")
    WebElement reportingButton;

    //Task Pick Appet  'Pick Product' button "OK"
    @FindBy(xpath = "//*[@title='Pick Product:OK']")
    WebElement pickProductOKButton;

    //Pick Asset button "OK"
    @FindBy(xpath = "//*[@title='Pick Asset:OK']")
    WebElement pickPickAssetOKButton;

    //Task button "Pause"
    @FindBy(xpath = "//*[@title='Pause']")
    WebElement taskPauseButton;


    //account page checkpoint
    @FindBy(xpath = "//*[@title='Accounts:yourKONECRANES']")
    WebElement accountsyourKONECRANESButton;

    //Sr Tab checkpoint
    @FindBy(xpath = "//*[@title='Service Requests:Manual Grouping']")
    WebElement srManGrouButton;

    //Sr Tab checkpoint
    @FindBy(xpath = "//*[@title='Agreements List View:New']")
    WebElement agreeCreateNewButton;

    //Service Requests New button
    @FindBy(xpath = "//*[@title='Service Requests:New']")
    WebElement srNewButton;

    //Pick Asset:Query Globally button
    @FindBy(xpath = "//*[@title='Pick Asset:Query Globally']")
    WebElement queryGloballyButton;

    //Service Products:Add button
    @FindBy(xpath = "//*[@title='Service Products:Add']")
    WebElement agreeServiceProductsAddButton;

    //Customer P.O. #: field
    @FindBy(xpath = "//*[@aria-labelledby='PONumber_Label']")
    WebElement agrePONumberLabelField;

    //Customer P.O. Amount:
    @FindBy(xpath = "//*[@aria-labelledby='POAmt_Label']")
    WebElement agrePOAmtLabelField;

    //SP
    @FindBy(xpath = "//*[@aria-labelledby='KCSP_Label']")
    WebElement agreKCSPField;

    //Task Type field
    @FindBy(xpath = "//*[@aria-labelledby='AgreementType_Label']")
    WebElement agreTypeField;

    //Task Time Horizon field
    @FindBy(xpath = "//*[@aria-labelledby='KCTimeHorizon_Label']")
    WebElement agreKCTimeHorizonField;

    //Task KC_Eqmt_% field
    @FindBy(xpath = "//*[@aria-labelledby='KC_Eqmt_%_Value_Label']")
    WebElement agreKCEqmtField;

    //Task Service Contact Person field
    @FindBy(xpath = "//*[@aria-label='Service Contact Person']")
    WebElement agreConPerSelField;

    //Task Billing Type field
    @FindBy(xpath = "//*[@aria-label='Billing Type']")
    WebElement agreTaskBillingTypeField;

    //Task Base Index Value field
    @FindBy(xpath = "//*[@aria-label='Base Index Value']")
    WebElement agreTaskBaseIndexValueField;


    //Task Service Contact Applet 'Ok' button
    @FindBy(xpath = "//*[@title='Pick Employee:OK']")
    WebElement agreContOKButton;

    //Task 'Next' button
    @FindBy(xpath = "//*[@title='Next']")
    WebElement agreTaskNextButton;

    //Task Annual Cost Estimates 'New' button
    @FindBy(xpath = "//*[@title='Annual Cost Estimates:New']")
    WebElement agreTaskAnCostEstButton;

    //Task Service Products 'New' button
    @FindBy(xpath = "//*[@title='Line Items:New']")
    WebElement agreTaskNewServiceProductsButton;

    //Load Test Service product
    @FindBy(xpath = "//*[@title='Load Test']")
    WebElement agreTaskLoadTestServiceProduct;

    //Airbalancers Service product
    @FindBy(xpath = "//*[@title='Airbalancers']")
    WebElement agreTaskAirbalancersServiceProduct;

    //Service Products:Remove from Selected Assets button
    @FindBy(xpath = "//*[@title='Service Products:Remove from Selected Assets']")
    WebElement agreTaskRemoveFromSelectedAssets;

    //Assets:Add button
    @FindBy(xpath = "//*[@title='Assets:Add']")
    WebElement agreTaskAssetsAddButton;

    //Task ' Payment Terms:' field
    @FindBy(id = "KC_Payment_Terms_Label")
    WebElement agrePaymentTermsField;

    //KC Visits
    @FindBy(css = "td[id$='KC_Visits']")
    List <WebElement> agreKCVisits;

    //Agrreement KC_Start_Date Id
    @FindBy(css = "td[id$='KC_Start_Date']")
    List <WebElement> kcStartDate;

    //Agrreement KC_Start_Date Name
    @FindBy(name = "KC_Start_Date")
    WebElement kcStartDateEditable;

    //KC Estimated Hours
    @FindBy(css = "td[id$='KC_Estimated_Hours']")
    List <WebElement> agreKCEstimatedHours;

    //KC Selected Flag
    @FindBy(css = "td[id$='KC_Selected_Flag']")
    List <WebElement> agreKCSelectedFlag;

    //Task 'Labor Hours' field
    @FindBy(id = "1_KC_Labor_Hours")
    WebElement agreTaskLaborHoursField;

    //1-st Serv Product
    @FindBy(id = "1")
    WebElement agreTask1stServProd;

    //Task 'CMII Value' field
    @FindBy(id = "KC_CMII_Value_Label")
    WebElement agreTaskCMIIValueField;


    //Task Service Contact Person field
    //@FindBy(xpath = "//*[@aria-aria-label='Selection Field']")
    //WebElement agreConPerSelField;

    //account if field inactive
    @FindBy(id = "1_s_1_l_Account_Number")
    WebElement accIdField;

    //Task Address Line 2 field
    @FindBy(id = "KC_Bill_To_Address_Line_2_Label")
    WebElement accTaskAddress_LineField;

    //account id field active
    @FindBy(name = "Account_Number")
    WebElement accIdFieldActive;

    //KC Visits Field Active
    @FindBy(name = "KC_Visits")
    WebElement agreeKCVisits;

    //KC_Unit_Price_-_Display field
    @FindBy(name = "KC_Unit_Price_-_Display")
    WebElement getAgreeUnitPriceDisplayField;

    //account page checkpoint
    @FindBy(name = "Name")
    WebElement accLink;

    //account page checkpoint
    @FindBy(name = "KC_SR_Billing_Type")
    WebElement kcSrBillingType;

    //account page checkpoint
    @FindBy(name = "Description")
    WebElement srDescriptionActiveField;

    //KC Estimated Hours button
    @FindBy(name = "KC_Estimated_Hours")
    WebElement agreeKCEstimatedHours;

    //account page checkpoint
    @FindBy(linkText = "Service Requests")
    WebElement srTabLink;

    //More Info tab
    @FindBy(linkText = "Agreements")
    WebElement moreInfoTabLink;

    //Go to Inbox link
    @FindBy(linkText = "Go to Inbox")
    WebElement gotoInboxLink;

    //PME information label
    @FindBy(id = "KCFormSectionPMEtInf_Label")
    WebElement pmeInfoLabel;

    //account page checkpoint
    @FindBy(name = "KC_Service_Product_Code")
    WebElement spFieldActive;

    // KC Selected Flag
    @FindBy(name = "KC_Selected_Flag")
    WebElement agreeSPKCSelectedFlag;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
        PageFactory.initElements(driver, this);
    }

    @Step("Open Accounts Page")
    public AccountPage open(HashMap hm) {
        String t = hm.get("t").toString();
        String accountUrl = "";
        switch (t) {
            case "agrT":
                accountUrl = PropertyLoader.loadProperty("accountsQAUrlAgr");
                break;
            case "srT":
                accountUrl = PropertyLoader.loadProperty("accountsQAUrlSR");
                break;
            default:
                // code block
        }
        driver.get(accountUrl);
        for (int i = 0; i < 3; i++) {
            try {
                wait.until(ExpectedConditions.visibilityOf(reportingButton));
                break;
            } catch (Exception e) {
                System.out.println("error load : " + accountUrl + ". We will try to repeat now");
                driver.get(accountUrl);
            }
        }

        System.out.println("Title : " + driver.getTitle());
        hm.put("pageTitle", driver.getTitle());
        return this;
    }


    @Step("Search Account By Id")
    public AccountPage searchAccount(String accountId) {
        wait.until(ExpectedConditions.elementToBeClickable(accIdField)).click(); //crash
        wait.until(ExpectedConditions.elementToBeClickable(accIdFieldActive)).sendKeys(accountId + "\r\n");
        wait.until(ExpectedConditions.elementToBeClickable(accountsyourKONECRANESButton));
        wait.until(ExpectedConditions.visibilityOf(accLink)).click();
        return this;
    }

    @Step("Jump to Service Request Tab")
    public AccountPage goToSr() {
        wait.until(ExpectedConditions.elementToBeClickable(srTabLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(srManGrouButton));
        return this;
    }

    @Step("Jump to Agreements Tab")
    public AccountPage goToAgr() {
        wait.until(ExpectedConditions.elementToBeClickable(moreInfoTabLink));
        //Agreementstab
        //@FindBy(linkText = "Agreements")
        List<WebElement> agreeTabLink = null;
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                agreeTabLink = driver.findElements(By.linkText("Agreements"));
                if (agreeTabLink.size() > 1) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Second Agreement tab isn't exists ");
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(agreeTabLink.get(1))).click();
        wait.until(ExpectedConditions.elementToBeClickable(agreeCreateNewButton)); // crash
        return this;
    }

    @Step("Create New Service Request")
    public AccountPage createNewSR(String ctst) {
        wait.until(ExpectedConditions.elementToBeClickable(srNewButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(srManGrouButton));
        for (int i = 0; i < 10; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td[id$='KC_Service_Product_Code']"))).click();
                break;
            } catch (Exception e) {
                System.out.println("error click KC_Service_Product_Code. Repeat in 1 second");
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(spFieldActive)).sendKeys("SP21A-CARE Preventive Maint.");
        wait.until(ExpectedConditions.elementToBeClickable(spFieldActive)).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(kcSrBillingType)).sendKeys("Time & Material");
        kcSrBillingType.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td[id$='Description']"))).click();
        srDescriptionActiveField.sendKeys("Created by QAFA at " + ctst);
        srDescriptionActiveField.sendKeys(Keys.TAB);

        return this;
    }

    @Step("Create New Agreement")
    public AccountPage createNewAgree(String ctst) {
        wait.until(ExpectedConditions.elementToBeClickable(agreeCreateNewButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(gotoInboxLink));
        wait.until(ExpectedConditions.elementToBeClickable(pmeInfoLabel));
        wait.until(ExpectedConditions.elementToBeClickable(taskPauseButton)); //crash
        agrePONumberLabelField.sendKeys("QAFA1");
        agrePOAmtLabelField.sendKeys("1000");
        agreKCSPField.sendKeys("SP21A-CARE Preventive Maint.");
        agreTypeField.sendKeys("Fixed Period");
        agreKCTimeHorizonField.clear();
        agreKCTimeHorizonField.sendKeys("90");
        wait.until(ExpectedConditions.elementToBeClickable(agreConPerSelField)).click();
        List<WebElement> appletButton = agreConPerSelField.findElements(By.xpath("//*[@aria-label='Selection Field']"));
        wait.until(ExpectedConditions.elementToBeClickable(appletButton.get(3))).click();
        wait.until(ExpectedConditions.elementToBeClickable(agreContOKButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(agreTaskNextButton)).click();

        //
        System.out.println("" + driver.findElement(By.className("kc_task_header_title")).getText());
        wait.until(ExpectedConditions.visibilityOf(accTaskAddress_LineField));
        System.out.println("" + driver.findElement(By.className("kc_task_header_title")).getText()); //crash
        wait.until(ExpectedConditions.elementToBeClickable(agreTaskNextButton)).click();
        wait.until(ExpectedConditions.visibilityOf(agrePaymentTermsField));
        System.out.println("" + driver.findElement(By.className("kc_task_header_title")).getText());
        agreTaskBillingTypeField.sendKeys("Time & Material");
        agreTaskBillingTypeField.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(agreTaskNextButton)).click();
        //
        wait.until(ExpectedConditions.visibilityOf(agreTaskBaseIndexValueField));
        System.out.println("" + driver.findElement(By.className("kc_task_header_title")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(agreTaskNextButton)).click();

        //2.3. Time and Material Discounts/Markups
        wait.until(ExpectedConditions.visibilityOf(agreKCEqmtField));
        System.out.println("" + driver.findElement(By.className("kc_task_header_title")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(agreTaskNextButton)).click();

        return this;
    }

    @Step("Create New Agreement - 2.4. Annual Cost Estimates step")
    public AccountPage createNewAgree_AnnCostEst() {
        //2.4. Annual Cost Estimates step
        wait.until(ExpectedConditions.visibilityOf(agreTaskAnCostEstButton));
        System.out.println("" + driver.findElement(By.className("kc_task_header_title")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(agreTaskAnCostEstButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(agreTaskLaborHoursField));
        agreTaskLaborHoursField.sendKeys("10");
        agreTaskLaborHoursField.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(agreTaskNextButton)).click();
        return this;
    }

    @Step("Create New Agreement - 3.1. Service products and charges")
    public AccountPage createNewAgree_SPaCrg() {
        //3.1. Service products and charges
        wait.until(ExpectedConditions.visibilityOf(agreTaskCMIIValueField));
        System.out.println("" + driver.findElement(By.className("kc_task_header_title")).getText());
        //Add at least 2a Service Product:1
        wait.until(ExpectedConditions.elementToBeClickable(agreTaskNewServiceProductsButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td[id$='Product']"))).click();
        List<WebElement> appletButton = driver.findElements(By.className("siebui-icon-pick"));
        appletButton.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(agreTaskLoadTestServiceProduct)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pickProductOKButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[id$='KC_Unit_Price_-_Display']")));
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td[id$='KC_Unit_Price_-_Display']"))).click();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.name("KC_Unit_Price_-_Display"))).sendKeys("2000");

        //Add at least 2a Service Product:2
        wait.until(ExpectedConditions.elementToBeClickable(agreTaskNewServiceProductsButton)).click();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                List<WebElement> productField = driver.findElements(By.cssSelector("td[id$='Product']"));
                if (productField.size() > 1) {
                    productField.get(1).click();
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        appletButton = driver.findElements(By.className("siebui-icon-pick"));
        appletButton.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(agreTaskAirbalancersServiceProduct)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pickProductOKButton)).click();
        List<WebElement> productUnitPrice = driver.findElements(By.cssSelector("td[id$='KC_Unit_Price_-_Display']"));
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                wait.until(ExpectedConditions.elementToBeClickable(productUnitPrice.get(1))).click(); // crash
                break;
            }catch (Exception e){
                System.out.println("error click productUnitPrice field " + e.getMessage());
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.name("KC_Unit_Price_-_Display"))).sendKeys("2000");
        wait.until(ExpectedConditions.elementToBeClickable(agreTaskNextButton)).click();
        return this;
    }

    @Step("Create New Agreement - 4.1. Associate assets and service products")
    public AccountPage createNewAgree_AssAss() {
        wait.until(ExpectedConditions.visibilityOf(agreTaskRemoveFromSelectedAssets));
        System.out.println("" + driver.findElement(By.className("kc_task_header_title")).getText());
        //In the Assets applet, add at least 2 assets via the Add button
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    Thread.sleep(500);
                    wait.until(ExpectedConditions.elementToBeClickable(agreTaskAssetsAddButton)).click();
                    System.out.println("Asset Added");
                    break;
                } catch (Exception e) {
                    System.out.println("Task Assets Add Button isn't active yet");
                }
            }
            wait.until(ExpectedConditions.visibilityOf(queryGloballyButton));
            List<WebElement> assetNumberField = driver.findElements(By.cssSelector("td[id$='Account_Primary_City']"));
            wait.until(ExpectedConditions.elementToBeClickable(assetNumberField.get(i))).click();
            wait.until(ExpectedConditions.elementToBeClickable(pickPickAssetOKButton)).click();
        }
        return this;
    }

    @Step("Create New Agreement - 4.1. Associate assets and service products Add service products")
    public AccountPage createNewAgree_AssAddSP() {
        wait.until(ExpectedConditions.visibilityOf(agreeServiceProductsAddButton));
        System.out.println("" + driver.findElement(By.className("kc_task_header_title")).getText());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    Thread.sleep(500);
                    wait.until(ExpectedConditions.elementToBeClickable(agreeServiceProductsAddButton)).click();
                    break;
                } catch (Exception e) {
                    System.out.println();
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(pickProductOKButton));
            List<WebElement> assetServiceProduct = driver.findElements(By.cssSelector("td[id$='_Product']"));
            assetServiceProduct.get(i).click();
            wait.until(ExpectedConditions.elementToBeClickable(pickProductOKButton)).click();
            for (int j = 0; j < 10; j++) {
                try {
                    Thread.sleep(500);
                    wait.until(ExpectedConditions.elementToBeClickable(agreKCEstimatedHours.get(i))).click(); // crash
                    break;
                } catch (Exception e) {
                    System.out.println("error click KC_Estimated_Hours " + e.getMessage());
                }
            }
            wait.until(ExpectedConditions.visibilityOf(agreeKCEstimatedHours)).sendKeys("10");
            wait.until(ExpectedConditions.visibilityOf(agreKCVisits.get(i)));
            wait.until(ExpectedConditions.elementToBeClickable(agreKCVisits.get(i))).click();
            wait.until(ExpectedConditions.visibilityOf(agreeKCVisits)).sendKeys("3 visit/year");
            agreeKCVisits.sendKeys(Keys.TAB);

            // find  First SR Date filed
            //List<WebElement> kcStartDateList = driver.findElements((By.);
            kcStartDate.get(i).click();

            //Sex with First SR Date. For three month
            SimpleDateFormat m = new SimpleDateFormat("M");
            SimpleDateFormat y = new SimpleDateFormat("yyyy");
            String strMonth; //

            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            for (int j = 0; j < 3; j++) {
                cal.add(Calendar.MONTH, 1);
                strMonth = m.format(cal.getTime());
                String firstSrDate = strMonth + "/2/" + y.format(cal.getTime());
                // set First SR Date
                if (j==0){
                    System.out.println("First SR Date is : " + strMonth + "/2/" + y.format(cal.getTime()));
                    // set agreement's First SR Date
                    wait.until(ExpectedConditions.elementToBeClickable(kcStartDateEditable)).sendKeys(firstSrDate);
                    wait.until(ExpectedConditions.elementToBeClickable(kcStartDateEditable)).sendKeys(Keys.TAB);
                }
                //find month field
                String kcMonthCssSelectorString = "td[id$='KC_Month"+strMonth+"']";
                List<WebElement> kcMonthFieldList = driver.findElements(By.cssSelector(kcMonthCssSelectorString));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", kcMonthFieldList.get(i));
                /*
                for (int k = 0; k < 2; k++) {
                    try {
                        wait.until(ExpectedConditions.visibilityOf(kcMonthFieldList.get(i))); // crash
                    }catch (Exception e){
                        System.out.println("kcMonthFieldList is invisible");
                    }
                }
                 */
                wait.until(ExpectedConditions.elementToBeClickable(kcMonthFieldList.get(i))).click(); // crash
                wait.until(ExpectedConditions.elementToBeClickable(By.name("KC_Month"+strMonth))).sendKeys("1");
                wait.until(ExpectedConditions.elementToBeClickable(By.name("KC_Month"+strMonth))).sendKeys(Keys.TAB);

            }
            System.out.println(assetServiceProduct.size());
        }

        // select Service Products
        for (WebElement elem : agreKCSelectedFlag) {
            wait.until(ExpectedConditions.elementToBeClickable(elem)).click();
            wait.until(ExpectedConditions.elementToBeClickable(agreeSPKCSelectedFlag)).click();
            System.out.println();
        }
        return this;
    }

}
