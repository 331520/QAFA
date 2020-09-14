package test.java.melonsoft.po;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.melonsoft.SalesCaseTest;
import test.java.melonsoft.utils.PropertyLoader;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class ServiceRequestPage {

    Logger log = Logger.getLogger(ServiceRequestPage.class.getName());
    private final WebDriver driver;
    private final WebDriverWait wait;


    // Service Request Description Field
    @FindBy(css = "td[id$='Description']")
    WebElement serviceRequestDescriptionField;

    // Service Request # Field
    @FindBy(css = "td[id$='SR_Number']")
    WebElement serviceRequestNumberField;

    // Service Request # Field
    @FindBy(css = "td[id$='SR_Number']")
    WebElement serviceRequestNumberFieldPopulated;

    // Service Request # Field
    @FindBy(css = "input[id$='SR_Number']")
    WebElement serviceRequestNumberFieldEditable;

    //Service Request Description Field active filed
    @FindBy(name = "Description")
    WebElement srDescriptionActiveField;

    //Service Requests Planning Board Calendar Button
    @FindBy(xpath = "//*[@title='Service Requests:Planning Board Calendar']")
    WebElement srPlBoardCalendarButton;

    //Service Requests Query Button
    @FindBy(xpath = "//*[@title='Service Requests:Query']")
    WebElement queryButton;

    //Service Requests Go Button
    @FindBy(xpath = "//*[@title='Service Requests:Go']")
    WebElement srGoButton;

    //Service Requests Id
    @FindBy(xpath = "//*[@aria-label='Row #']")
    WebElement srRowId;

    //Service Requests Workpackage Tab
    @FindBy(linkText = "Workpackage")
    List<WebElement> srWPTab;

    //Service Requests Work Package New Buttob
    @FindBy(xpath = "//*[@title='Workpackage:New']")
    WebElement srNewWpButton;

    //Service Requests Third Level View Bar
    @FindBy(xpath = "//*[@title='Third Level View Bar']")
    WebElement srThirdLevelViewBar;

    //Service Requests WP Pick Asset:OK
    @FindBy(xpath = "//*[@title='Pick Asset:OK']")
    WebElement srWpPickAssetOKButton;

    //Service Request WP KC Asset Number
    @FindBy(css = "td[id$='KC_Asset_Number']")
    WebElement serviceRequestKCAssetNumber;

    //Service Request WP KC Asset Number Editable
    @FindBy(name = "KC_Asset_Number")
    //List<WebElement> srWpKCAssetNumber;
    WebElement srWpKCAssetNumber;

    //Service Request WP KC Asset Number Editable
    @FindBy(name = "Asset_Number")
    WebElement srWpActionAssetNumber;

    //Service Request WP Root Asset Numbers
    @FindBy(css = "td[id$='Root_Asset_Number']")
    List<WebElement> sRWPRootAssetNumbers;

    //Service Request WP Service Product Name Field
    @FindBy(css = "td[id$='KC_Service_Product_Name']")
    WebElement sRWPWPServiceProductNameField;

    //Service Request WP Service Product Name Field
    @FindBy(name = "KC_Service_Product_Name")
    WebElement sRWPWPServiceProductNameFieldInteractable;

    //Service Requests WP Associated Products pick applet :Add buttob
    @FindBy(xpath = "//*[@title='Associated Products:Add >']")
    WebElement srWpAssociatedProductsAddbuttob;

    //Service Requests WP Associated Products pick applet -> Associated Products:OK button
    @FindBy(xpath = "//*[@title='Associated Products:OK']")
    WebElement srWpAssociatedProductsOkButton;

    //Service Requests Work Package New Buttob
    @FindBy(xpath = "//*[@title='Actions:New']")
    WebElement srNewActionButton;

    //Service Request Action KC Asset Number
    @FindBy(css = "td[id$='KC_Asset_Number']")
    WebElement serviceRequestActionAssetNumber;

    //Service Request WP Status
    @FindBy(css = "td[id$='Status']")
    WebElement sRWpStatus;

    //Service Request WP Status
    @FindBy(css = "input[id$='Status']")
    WebElement sRWpStatusEditable;

    //Service Request Action KC Asset Number
    @FindBy(css = "td[id$='Type']")
    WebElement serviceRequestActionType;

    //Service Requests WP Actions Tab BAr
    @FindBy(xpath = "//*[@summary='Actions']")
    WebElement srWpWPActionsTabBAr;

    //Service Request WP KC Asset Number Editable
    @FindBy(name = "Type")
    WebElement srWpActionType;

    //Service Request WP Action
    @FindBy(name = "KC_Name_Translation")
    WebElement srWpActionFaultCodeName;

    //Service Request WP Action's Next Step Filed
    @FindBy(css = "td[id$='KC_Next_Step']")
    WebElement sRWPRActionNextStepFiled;

    //Service Request WP Action's Next Step Filed Editable
    @FindBy(name = "KC_Next_Step")
    WebElement sRWPRActionNextStepFiledEditable;

    //Service Request WP #
    @FindBy(name = "Activity UID Show")
    WebElement sRWPNumber;

    //Service Request WP Action's Next Step Filed
    @FindBy(css = "input[aria-label='Status']")
    WebElement sRStatus;

    //Service Request WP KC Asset Number Editable
    @FindBy(name = "_KC_Sales_Case_Id")
    List<WebElement> srWpSalesCaseId;

    //Service Request WP Action's Next Step Filed
    @FindBy(css = "td[id$='KC_Sales_Case_Id']")
    List<WebElement> srWpActionSCNumber;

    public ServiceRequestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30);
        PageFactory.initElements(driver, this);
    }

    @Step("Go to Service Request Tab")
    public ServiceRequestPage open() {
        driver.get(PropertyLoader.loadProperty("serviceRequestUrl"));
        for (int i = 0; i < 10; i++) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Settings']")));
                break;
            } catch (Exception e) {
                log.debug("Error load Service Request View. Repeat..." + PropertyLoader.loadProperty("serviceRequestUrl"));
                driver.get(PropertyLoader.loadProperty("serviceRequestUrl"));
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Settings']")));
        wait.until(ExpectedConditions.elementToBeClickable(srPlBoardCalendarButton));
        return this;
    }

    @Step("Search for Service Request By Description")
    public ServiceRequestPage searchSRByDescription(HashMap hm) {
        wait.until(ExpectedConditions.elementToBeClickable(queryButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(serviceRequestDescriptionField)).click();
        String srDescription = hm.get("srDescription").toString();
        wait.until(ExpectedConditions.elementToBeClickable(srDescriptionActiveField)).sendKeys(srDescription);
        wait.until(ExpectedConditions.elementToBeClickable(srDescriptionActiveField)).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(srGoButton)).click();
        List<WebElement> srs = driver.findElements(By.xpath("//*[@title='" + srDescription + "']"));
        hm.put("srAmount", srs.size());
        return this;
    }

    @Step("Search for Service Request By Id")
    public ServiceRequestPage searchSRById(HashMap hm) {
        wait.until(ExpectedConditions.elementToBeClickable(queryButton)).click();
        log.debug("Try to search SR");
        wait.until(ExpectedConditions.elementToBeClickable(serviceRequestNumberField));
        qWaiterClick(serviceRequestNumberField);
        String srId = hm.get("srId").toString();
        wait.until(ExpectedConditions.elementToBeClickable(serviceRequestNumberFieldEditable)).sendKeys(srId + "\r\n");

        for (int i = 0; i < 5; i++) {
            try {
                //invoke "about row" window
                wait.until(ExpectedConditions.elementToBeClickable(serviceRequestNumberFieldEditable)).sendKeys(Keys.CONTROL, Keys.ALT, "k");
                log.debug("Try to get SR ID");
                Thread.sleep(500);
                wait.until(ExpectedConditions.visibilityOf(srRowId)); // srRowId
                break;
            } catch (Exception e) {
                log.debug("Error get SR RowId. Repeat" + e.getMessage());
            }
        }
        hm.put("srRowIdStr", srRowId.getText());
        log.debug("SR RowId has been received : " + srRowId.getText());
        return this;
    }

    @Step("Drill-Down into SR")
    public ServiceRequestPage drillDownSR(HashMap hm) {
        //jump to Service request Detailed view
         driver.get(PropertyLoader.loadProperty("serviceRequestDetailUrl") + hm.get("srRowIdStr").toString()); //real test
        //driver.get(PropertyLoader.loadProperty("serviceRequestDetailUrl") + "1-16GF2V42");
        //jump to Service request Detailed view
        for (int i = 0; i < 2; i++) {
            try {
                wait.until(ExpectedConditions.visibilityOf(srThirdLevelViewBar)); // crash
                break;
            }catch (Exception e){
                log.debug("Error jump to Service request Detailed view. Try to repeat...");
                driver.get(PropertyLoader.loadProperty("serviceRequestDetailUrl") + hm.get("srRowIdStr").toString()); //real test
                //driver.get(PropertyLoader.loadProperty("serviceRequestDetailUrl") + "1-16GF2V42");
            }
        }
        log.debug(driver.getTitle());
        return this;
    }

    @Step("Jump to WorkPackage TAB")
    public ServiceRequestPage jumpToWpTab() {
        wait.until(ExpectedConditions.elementToBeClickable(srWPTab.get(1))).click();
        log.debug(driver.getTitle());
        return this;
    }

    @Step("Create New WP")
    public ServiceRequestPage createNewWP(HashMap hm) {
        wait.until(ExpectedConditions.elementToBeClickable(srNewWpButton));
        log.debug(driver.getTitle());
        for (int i = 0; i < 2; i++) {

            //new WP click
            wait.until(ExpectedConditions.elementToBeClickable(srNewWpButton));
            qWaiterClick(srNewWpButton);

            wait.until(ExpectedConditions.elementToBeClickable(sRWPWPServiceProductNameField)); // array?
            qWaiterClick(sRWPWPServiceProductNameField);

            //>>>>>>>>>>
            WebElement spNamePAppletButton = null;
            for (int j = 0; j < 3; j++) {
                try {
                    Thread.sleep(500);
                    spNamePAppletButton = driver.findElement(By.cssSelector("td[id$='KC_Service_Product_Name']")).findElement(By.cssSelector("span[id$='icon']"));
                }catch (Exception e){
                    log.debug("Error detect KC_Service_Product_Name");
                }
            }
            qWaiterClick(spNamePAppletButton);
            //<<<<<<<<<<<

            wait.until(ExpectedConditions.elementToBeClickable(srWpAssociatedProductsAddbuttob)); //crash
            qWaiterClick(srWpAssociatedProductsAddbuttob);

            wait.until(ExpectedConditions.elementToBeClickable(srWpAssociatedProductsOkButton));
            qWaiterClick(srWpAssociatedProductsOkButton);

            wait.until(ExpectedConditions.elementToBeClickable(serviceRequestKCAssetNumber));
            qWaiterClick(serviceRequestKCAssetNumber);

            wait.until(ExpectedConditions.elementToBeClickable(srWpKCAssetNumber)).sendKeys("1");
            wait.until(ExpectedConditions.elementToBeClickable(srWpKCAssetNumber)).sendKeys(Keys.TAB);

            for (int j = 0; j < 10; j++) {
                try {
                    Thread.sleep(500);
                    if (sRWPRootAssetNumbers.size() > 1) {
                        log.debug("sRWPRootAssetNumbers.size : " + sRWPRootAssetNumbers.size());
                        break;
                    }
                } catch (Exception e) {
                    log.debug("insufficient assets. Wait..");
                }
            }
            log.debug(sRWPRootAssetNumbers.size() + " asset is available");

            // click i asset
            wait.until(ExpectedConditions.elementToBeClickable(sRWPRootAssetNumbers.get(i)));
            qWaiterClick(sRWPRootAssetNumbers.get(i));

            //click 'OK' button
            wait.until(ExpectedConditions.elementToBeClickable(srWpPickAssetOKButton));
            qWaiterClick(srWpPickAssetOKButton);

            log.debug("Asset selected");
            log.debug("Try to change status for WP " + i);

            List<String> messages = Arrays.asList("Unscheduled", "Scheduled", "In Progress");

            for (String s: messages) {
                log.debug("Try to set  " + s);
                wait.until(ExpectedConditions.elementToBeClickable(sRWpStatus));
                qWaiterClick(sRWpStatus);
                wait.until(ExpectedConditions.elementToBeClickable(sRWpStatusEditable));

                //sRWpStatusEditable.clear(); - it doesn't works here. I don know why
                for (int j = 0; j < 20; j++) {
                    sRWpStatusEditable.sendKeys(Keys.BACK_SPACE);
                }
                sRWpStatusEditable.sendKeys(s);
                sRWpStatusEditable.sendKeys(Keys.TAB);
            }

            log.debug("Try to create new Action for WP " + i + 1);

            //click 'New' button on 'Actions' applet
            wait.until(ExpectedConditions.elementToBeClickable(srNewActionButton));
            qWaiterClick(srNewActionButton);

            //get Root Asset #
            log.debug("Try to create new Action for WP " + sRWPRootAssetNumbers.get(0).getText());

            wait.until(ExpectedConditions.visibilityOf(srWpWPActionsTabBAr));
            for (int j = 0; j < 10; j++) {
                try {
                    Thread.sleep(500);
                    WebElement actionsKCAssetNumber = driver.findElement(By.xpath("//*[@summary='Actions']")).findElement((By.cssSelector("td[id$='_Asset_Number']")));
                    wait.until(ExpectedConditions.elementToBeClickable(actionsKCAssetNumber));
                    qWaiterClick(actionsKCAssetNumber); // crash
                }catch (Exception e){
                    log.debug("Asset Number field is not active now");
                }
            }


            wait.until(ExpectedConditions.elementToBeClickable(srWpActionAssetNumber)).click();
            srWpActionAssetNumber.sendKeys(sRWPRootAssetNumbers.get(0).getText());
            srWpActionAssetNumber.sendKeys(Keys.TAB);

            //>>>>>>> set WP action type
            WebElement actionsType = null;
            for (int j = 0; j < 3; j++) {
                try {
                    Thread.sleep(500);
                    actionsType = driver.findElement(By.xpath("//*[@summary='Actions']")).findElement((By.cssSelector("td[id$='_Type']")));
                }catch (Exception e){
                    log.debug("Asset Number field is not active now");
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(actionsType));
            qWaiterClick(actionsType);
            wait.until(ExpectedConditions.elementToBeClickable(srWpActionType)).sendKeys("Install", Keys.TAB);
            //<<<<<<<<<<<<<<<<<<<<<<<<<<<<


            //set Fault Code mname
            wait.until(ExpectedConditions.elementToBeClickable(srWpActionFaultCodeName));
            srWpActionFaultCodeName.click();
            srWpActionFaultCodeName.sendKeys("Acceptable", Keys.TAB);


            // set Action Next Step - Activate filed
            wait.until(ExpectedConditions.elementToBeClickable(sRWPRActionNextStepFiled));
            sRWPRActionNextStepFiled.click();
            //sRWPRActionNextStepFiled.sendKeys("Quote Declined", Keys.TAB);

            //define Next step value
            String nSValue = "";
            switch (i){
                case 0:
                    nSValue = "Quote";
                    break;
                case 1:
                    nSValue = "Quote Declined";
                    break;
                default:
                    log.debug("Wrong asset number: " + i);
            }

            // set Action Next Step - Set field Value
            wait.until(ExpectedConditions.elementToBeClickable(sRWPRActionNextStepFiledEditable));
            sRWPRActionNextStepFiledEditable.click();
            sRWPRActionNextStepFiledEditable.sendKeys(nSValue, Keys.TAB);

            //6) Change the statuses of both WPs with In Progress -> Completed
            log.debug("Try to Change the statuses of WP from Progress -> Completed");
            //activate field by click
            wait.until(ExpectedConditions.elementToBeClickable(sRWpStatus));
            qWaiterClick(sRWpStatus);
            wait.until(ExpectedConditions.elementToBeClickable(sRWpStatusEditable));

            //clear field and set field value
            //sRWpStatusEditable.clear(); - it doesn't works here. I don know why
            for (int j = 0; j < 20; j++) {
                sRWpStatusEditable.sendKeys(Keys.BACK_SPACE);
            }
            sRWpStatusEditable.sendKeys("Completed");
            sRWpStatusEditable.sendKeys(Keys.TAB);

            //accept js alert
            //Wait for the alert
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            try {
                alert.accept();
                log.debug("Alert wit text \r\n" + alert.getText() + "\r\n was accepted successfully");
            } catch (Exception e) {
                System.out.println("something wrong with JS alert");
            }
            log.debug("Wp created");
            wait.until(ExpectedConditions.visibilityOf(sRWPNumber));
            hm.put("wp"+i, sRWPNumber.getText());
        }
        return this;
    }

    //
    @Step("Check Service Request Status")
    public ServiceRequestPage checkSRStatus(HashMap hashMap) throws IOException, UnsupportedFlavorException {
        log.debug("Check Service Request Status");
        String srStatus = noValueFieldReader(sRStatus);
        log.debug("Service Request Status : " + srStatus);
        hashMap.put("srStatus", srStatus);
        return this;
    }

    public ServiceRequestPage checkWpScNumbers(HashMap hashMap) {
        wait.until(ExpectedConditions.visibilityOf(srWpActionSCNumber.get(0)));
        sRWPWPServiceProductNameField.click();
        wait.until(ExpectedConditions.visibilityOf(sRWPWPServiceProductNameFieldInteractable));
        sRWPWPServiceProductNameFieldInteractable.click();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                sRWPWPServiceProductNameFieldInteractable.sendKeys(Keys.ALT, Keys.RETURN);
                wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("td[id$='KC_Sales_Case_Id']"), 0));
                if (srWpActionSCNumber.get(0).getText().length() > 0){
                    log.debug("Sales Case number is defined");
                    break;
                } else {
                    log.debug("Sales Case number is NOT defined");
                }
            }catch (Exception e){

            }
        }

        log.debug("number Of Elements More Than 0 : " + srWpActionSCNumber.size());
        List<String>sCs = new ArrayList<>();
        for (WebElement element:srWpActionSCNumber) {
            log.debug("Sales Case number : " + element.getText());
            sCs.add(element.getText());
            hashMap.put("sCNumber", element.getText());
        }
        Set<String> set = new HashSet<String>(sCs);
        if(set.size() < sCs.size()){
            hashMap.put("Identical", "SC is Identical");
        } else {
            hashMap.put("Identical", "SC is NOT Identical");
        }
        return this;
    }

    public void qWaiterClick(WebElement element) {
        for (int j = 0; j < 20; j++) {
            try {
                Thread.sleep(500);
                element.click();
                log.debug("Click element successful -> " +element);
                break;
            } catch (Exception e) {
                log.debug(j+" -> Error click element. Try to repeat -> " +element);
            }
        }
    }

    public  String noValueFieldReader(WebElement element) throws IOException, UnsupportedFlavorException {
        log.debug("Try to get field value");
        wait.until(ExpectedConditions.elementToBeClickable(sRStatus));
        element.click();
        element.sendKeys(Keys.END);
        element.sendKeys(Keys.SHIFT,Keys.CONTROL,Keys.HOME);
        element.sendKeys(Keys.CONTROL, "c"); //put field value to clipboard
        String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); //get field value from clipboard
        return data;
    }


}
