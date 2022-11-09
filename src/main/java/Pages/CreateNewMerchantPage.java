package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class CreateNewMerchantPage {
    private ChromeDriver driver;
    public CreateNewMerchantPage(ChromeDriver driver)
    {
        this.driver=driver;
    }

    File propFile= new File("src\\test\\resources\\configuration.properties");
    Properties props = new Properties();
    FileInputStream inputStream;
    private By CreateMerchantTitle=By.xpath("//h5[contains(.,'Create Merchant')]");
    private By MerchantNameField=By.id("merchantName");
    private By MerchantCodeField=By.id("merchantCode");
    private By MerchantEmailField=By.xpath("//input[@type='email']");
    private By MerchantCountryField=By.xpath("//input[@type='text'][@id='react-select-3-input']");
    private By MerchantCountryText=By.xpath("//div[@class='col'][contains(.,'Merchant country')]//div[@class=' css-qc6sy-singleValue']");
    private By MerchantCityField=By.xpath("//input[@type='text'][@id='react-select-4-input']");
    private By MerchantCityText=By.xpath("//div[@class='city col']//div[@class=' css-qc6sy-singleValue']");
    private By MerchantPhoneFiled=By.xpath("//input[@class='PhoneInputInput']");
    private By MerchantStatus=By.xpath("//input[@type='text'][@id='react-select-5-input']");
    private By MerchantStatusText=By.xpath("//div[@class='col'][contains(.,'Merchant Status')]//div[@class=' css-qc6sy-singleValue']");
    private By DefaultLanguageField=By.xpath("//input[@type='text'][@id='react-select-6-input']");
    private By DefaultLanguageText=By.xpath("//div[@class='col'][contains(.,'Default Language')]//div [@class=' css-qc6sy-singleValue']");
    private By BusinessCategory=By.xpath("//input[@type='text'][@id='react-select-7-input']");
    private By BusinessCategoryText=By.xpath("//div[@class='col'][contains(.,'Business Category')]//div [@class=' css-qc6sy-singleValue']");
    private By CurrencyCode=By.xpath("//input[@type='text'][@id='react-select-8-input']");
    private By CurrencyCodeText=By.xpath("//div[@class='col'][contains(.,'Currency Code')]//div [@class=' css-qc6sy-singleValue']");
    private By StartTerminalSerialNumber=By.id("startTsn");
    private By TerminalsCount=By.id("terminalCount");
    private By NextButton=By.xpath("//button[@class='yes-btn'][contains(.,'Next')]");
    private By CancelButton=By.xpath("//button[@class='cancel-button']");
    private By MerchantNameErrorMessage=By.xpath("//div[@class='col'][contains(.,'Merchant name')]//h6");
    private By MerchantCodeErrorMessage=By.xpath("//div[@class='col'][contains(.,'Merchant Code')]//h6");
    private By MerchantEmailErrorMessage=By.xpath("//div[@class='col'][contains(.,'Merchant Email')]//h6");
    private By MerchantCountryErrorMessage=By.xpath("//div[@class='col'][contains(.,'Merchant country')]//h6");
    private By MerchantCityErrorMessage=By.xpath("//div[@class='city col'][contains(.,'Merchant city')]//h6");
    private By MerchantPhoneErrorMessage=By.xpath("//div[@class='col'][contains(.,'Merchant Phone')]//h6");
    private By MerchantStatusErrorMessage=By.xpath("//div[@class='col'][contains(.,'Merchant Status')]//h6");
    private By MerchantLanguageErrorMessage=By.xpath("//div[@class='col'][contains(.,'Default Language')]//h6");
    private By MerchantBusinessCategoryErrorMessage=By.xpath("//div[@class='col'][contains(.,'Business Category')]//h6");
    private By MerchantCurrencyCodeErrorMessage=By.xpath("//div[@class='col'][contains(.,'Currency Code')]//h6");
    private By MerchantStartTSNErrorMessage=By.xpath("//div[@class='col'][contains(.,'Start Terminal Serial Number')]//h6");
    private By MerchantTerminalsCountErrorMessage=By.xpath("//div[@class='col'][contains(.,'Terminals Count')]//h6");



    //Check that element is present
    public boolean IsElementPresent(By by)
    {
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    @Step("Check Presence of Create Merchant screen")
    public boolean CheckPresenceOfCreateMerchantScreen()
    {
        return IsElementPresent(CreateMerchantTitle);
    }
    @Step("Scroll Down until a specific element")
    public void ScrollDown(By by) throws InterruptedException {
        WebElement element=driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(500);
    }
    @Step("Scroll Down to create merchant screen")
    public void ScrollDownToCreateMerchantScreen() throws InterruptedException {
        ScrollDown(CreateMerchantTitle);
    }
    @Step("Check Presence of Merchant Name Field")
    public boolean CheckPresenceOfMerchantNameField()
    {
        return IsElementPresent(MerchantNameField);
    }

    @Step("Check Presence of Merchant Code Field")
    public boolean CheckPresenceOfMerchantCodeField()
    {
        return IsElementPresent(MerchantCodeField);
    }
    @Step("Check Presence of Merchant Email Field")
    public boolean CheckPresenceOfMerchantEmailField()
    {
        return IsElementPresent(MerchantEmailField);
    }
    @Step("Check Presence of Merchant Country Field")
    public boolean CheckPresenceOfMerchantCountryField()
    {
        return IsElementPresent(MerchantCountryField);
    }
    @Step("Check Presence of Merchant City Field")
    public boolean CheckPresenceOfMerchantCityField()
    {
        return IsElementPresent(MerchantCityField);
    }
    @Step("Check Presence of Merchant Phone Field")
    public boolean CheckPresenceOfMerchantPhoneField()
    {
        return IsElementPresent(MerchantPhoneFiled);
    }
    @Step("Check Presence of Merchant Status Field")
    public boolean CheckPresenceOfMerchantStatusField()
    {
        return IsElementPresent(MerchantStatus);
    }
    @Step("Check Presence of Default Language Field")
    public boolean CheckPresenceOfDefaultLanguageField()
    {
        return IsElementPresent(DefaultLanguageField);
    }
    @Step("Check Presence of  Business Category Field")
    public boolean CheckPresenceOfMerchantBusinessCategoryField()
    {
        return IsElementPresent(BusinessCategory);
    }
    @Step("Check Presence of Currency code Field")
    public boolean CheckPresenceOfMerchantCurrencyCodeField()
    {
        return IsElementPresent(CurrencyCode);
    }
    @Step("Check Presence of Start TSN Field")
    public boolean CheckPresenceOfStartTSNField()
    {
        return IsElementPresent(StartTerminalSerialNumber);
    }
    @Step("Check Presence of TerminalCount Field")
    public boolean CheckPresenceOfMerchantTerminalCountField()
    {
        return IsElementPresent(TerminalsCount);
    }
    @Step("Check The Presence of Next button")
    public boolean CheckPresenceOfNextButton()
    {
        return IsElementPresent(NextButton);
    }
    @Step("Check Presence of Cancel button")
    public boolean CheckPresenceOfCancelButton()
    {
        return (IsElementPresent(CancelButton));
    }
    @Step("Insert Merchant Name")
    public void InsertMerchantName(String MerchantName )
    {
        driver.findElement(MerchantNameField).sendKeys(MerchantName);
    }
    @Step("Read Data in Merchant Name Filed")
    public String ReadDataInMerchantNameField()
    {
        return (driver.findElement(MerchantNameField).getAttribute("value"));
    }
    @Step("Insert Merchant Code")
    public void InsertMerchantCode(String MerchantCode )
    {
        driver.findElement(MerchantCodeField).sendKeys(MerchantCode);
    }
    @Step("Read Data in Merchant Code Filed")
    public String ReadDataInMerchantCodeField()
    {
        return (driver.findElement(MerchantCodeField).getAttribute("value"));
    }
    @Step("Insert Merchant Email")
    public void InsertMerchantEmail(String MerchantEmail )
    {
        driver.findElement(MerchantEmailField).sendKeys(MerchantEmail);
    }
    @Step("Read Data in Merchant Email Filed")
    public String ReadDataInMerchantEmailField()
    {
        return (driver.findElement(MerchantEmailField).getAttribute("value"));
    }
    @Step("Choose Country")
    public void ChooseCountry(String Country)
    {
        driver.findElement(MerchantCountryField).sendKeys(Country);
        driver.findElement(MerchantCountryField).sendKeys(Keys.ENTER);
    }
    @Step("Read Data in Merchant Country Filed")
    public String ReadDataInMerchantCountryField()
    {
        String chosenCountry = null;
        if(IsElementPresent(MerchantCountryText))
        {
         chosenCountry=driver.findElement(MerchantCountryText).getText();
        }
        System.out.println(chosenCountry);
        return (chosenCountry);

    }
    @Step("Choose City")
    public void ChooseCity(String City)
    {
        driver.findElement(MerchantCityField).sendKeys(City);
        driver.findElement(MerchantCityField).sendKeys(Keys.ENTER);
    }
    @Step("Read Data in Merchant City Filed")
    public String ReadDataInMerchantCityField()
    {
        String chosenCity = null;
        if(IsElementPresent(MerchantCityText))
        {
            chosenCity=driver.findElement(MerchantCityText).getText();
        }
        System.out.println(chosenCity);
        return (chosenCity);
    }
    @Step("Insert Merchant Phone")
    public void InsertMerchantPhone(String Phone)
    {
       driver.findElement(MerchantPhoneFiled).sendKeys(Phone);
    }
    @Step("Read Data in Merchant Phone Filed")
    public String ReadDataInMerchantPhoneField()
    {

        return (driver.findElement(MerchantPhoneFiled).getAttribute("value"));
    }
    @Step("Choose Status")
    public void ChooseMerchantStatus(String Status)
    {
        driver.findElement(MerchantStatus).sendKeys(Status);
        driver.findElement(MerchantStatus).sendKeys(Keys.ENTER);
    }
    @Step("Read Data in Merchant Status Filed")
    public String ReadDataInMerchantStatusField()
    {
        String chosenStatus = null;
        if(IsElementPresent(MerchantStatusText))
        {
            chosenStatus=driver.findElement(MerchantStatusText).getText();
        }
        System.out.println(chosenStatus);
        return (chosenStatus);
    }
    @Step("Choose Language")
    public void ChooseLanguage(String Language)
    {
        driver.findElement(DefaultLanguageField).sendKeys(Language);
        driver.findElement(DefaultLanguageField).sendKeys(Keys.ENTER);
    }
    @Step("Read Data in Default Language Filed")
    public String ReadDataInMerchantLanguageField()
    {
        String chosenLanguage = null;
        if(IsElementPresent(DefaultLanguageText))
        {
            chosenLanguage=driver.findElement(DefaultLanguageText).getText();
        }
        System.out.println(chosenLanguage);
        return (chosenLanguage);
    }
    @Step("Choose Business Category")
    public void ChooseBusinessCategory(String businessCategory)
    {
        driver.findElement(BusinessCategory).sendKeys(businessCategory);
        driver.findElement(BusinessCategory).sendKeys(Keys.ENTER);
    }
    @Step("Read Data in Business Category Filed")
    public String ReadDataInMerchantBusinessCategoryField()
    {
        String chosenBusCategory = null;
        if(IsElementPresent(BusinessCategoryText))
        {
            chosenBusCategory=driver.findElement(BusinessCategoryText).getText();
        }
        System.out.println(chosenBusCategory);
        return (chosenBusCategory);
    }
    @Step("Choose Currency code")
    public void ChooseCurrency(String Currency)
    {
        driver.findElement(CurrencyCode).sendKeys(Currency);
        driver.findElement(CurrencyCode).sendKeys(Keys.ENTER);
    }
    @Step("Read Data in Currency code Filed")
    public String ReadDataInMerchantCurrencyCodeField()
    {
        String chosenCurrency = null;
        if(IsElementPresent(CurrencyCodeText))
        {
            chosenCurrency=driver.findElement(CurrencyCodeText).getText();
        }
        System.out.println(chosenCurrency);
        return (chosenCurrency);
    }
    @Step("Insert Start TSN")
    public void InsertStartTSN(String TSN)
    {
        driver.findElement(StartTerminalSerialNumber).sendKeys(TSN);
    }
    @Step("Read Data in Start TSN Filed")
    public String ReadDataInStartTSNField()
    {
        return (driver.findElement(StartTerminalSerialNumber).getAttribute("value"));
    }
    @Step("Insert Terminal count")
    public void InsertTerminalCount(String TerCount)
    {
        driver.findElement(TerminalsCount).sendKeys(TerCount);
    }
    @Step("Read Data in Terminal count Filed")
    public String ReadDataInTerminalCountField()
    {
        return (driver.findElement(TerminalsCount).getAttribute("value"));
    }
    @Step("Click on Next Button")
    public SchemeScreen ClickOnNextButton() throws InterruptedException {


        ScrollDown(NextButton);

        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(NextButton));

        //Actions actions = new Actions(driver);
        //actions.moveToElement(NextBtn).click().perform();
        driver.findElement(NextButton).click();
        return new SchemeScreen(driver);
    }
    @Step("Click on Cancel Button")
    public void ClickOnCancelButton() throws InterruptedException {
        ScrollDown(CancelButton);

        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(CancelButton));

        driver.findElement(CancelButton).click();
    }
    @Step("check Presence of MerchantName Error Message")
    public boolean CheckPresenceOfNotInsertedMerchantNameErrorMsg()
    {
        return IsElementPresent(MerchantNameErrorMessage);
    }
    @Step("Get the Text Of Merchant Name Error Message")
    public String GetTextOfMerchantNameErrorMsg()
    {
        return(driver.findElement(MerchantNameErrorMessage).getText());
    }
    @Step("check Presence of MerchantCode Error Message")
    public boolean CheckPresenceOfNotInsertedMerchantCodeErrorMsg()
    {
        return IsElementPresent(MerchantCodeErrorMessage);
    }
    @Step("Get the Text Of Merchant Code Error Message")
    public String GetTextOfMerchantCodeErrorMsg()
    {
        return(driver.findElement(MerchantCodeErrorMessage).getText());
    }

    @Step("check Presence of Merchant Email Error Message")
    public boolean CheckPresenceOfNotInsertedMerchantEmailErrorMsg()
    {
        return IsElementPresent(MerchantEmailErrorMessage);
    }
    @Step("Get the Text Of Merchant Email Error Message")
    public String GetTextOfMerchantEmailErrorMsg()
    {
        return(driver.findElement(MerchantEmailErrorMessage).getText());
    }

    @Step("check Presence of Merchant Country Error Message")
    public boolean CheckPresenceOfNotInsertedMerchantCountryErrorMsg()
    {
        return IsElementPresent(MerchantCountryErrorMessage);
    }
    @Step("Get the Text Of Merchant country Error Message")
    public String GetTextOfMerchantCountryErrorMsg()
    {
        return(driver.findElement(MerchantCountryErrorMessage).getText());
    }

    @Step("check Presence of Merchant City Error Message")
    public boolean CheckPresenceOfNotInsertedMerchantCityErrorMsg()
    {
        return IsElementPresent(MerchantCityErrorMessage);
    }
    @Step("Get the Text Of Merchant City Error Message")
    public String GetTextOfMerchantCityErrorMsg()
    {
        return(driver.findElement(MerchantCityErrorMessage).getText());
    }

    @Step("check Presence of Merchant Phone Error Message")
    public boolean CheckPresenceOfNotInsertedMerchantPhoneErrorMsg()
    {
        return IsElementPresent(MerchantPhoneErrorMessage);
    }
    @Step("Get the Text Of Merchant Phone Error Message")
    public String GetTextOfMerchantPhoneErrorMsg()
    {
        return(driver.findElement(MerchantPhoneErrorMessage).getText());
    }
    @Step("check Presence of Merchant Status Error Message")
    public boolean CheckPresenceOfNotInsertedMerchantStatusErrorMsg()
    {
        return IsElementPresent(MerchantStatusErrorMessage);
    }
    @Step("Get the Text Of Merchant Status Error Message")
    public String GetTextOfMerchantStatusErrorMsg()
    {
        return(driver.findElement(MerchantStatusErrorMessage).getText());
    }

    @Step("check Presence of Merchant Language Error Message")
    public boolean CheckPresenceOfNotInsertedMerchantLanguageErrorMsg()
    {
        return IsElementPresent(MerchantLanguageErrorMessage);
    }
    @Step("Get the Text Of Merchant Language Error Message")
    public String GetTextOfMerchantLanguageErrorMsg()
    {
        return(driver.findElement(MerchantLanguageErrorMessage).getText());
    }

    @Step("check Presence of Merchant BusinessCategory Error Message")
    public boolean CheckPresenceOfNotInsertedMerchantBusinessCategoryErrorMsg()
    {
        return IsElementPresent(MerchantBusinessCategoryErrorMessage);
    }
    @Step("Get the Text Of Merchant BusinessCategory Error Message")
    public String GetTextOfMerchantBusinessCategoryErrorMsg()
    {
        return(driver.findElement(MerchantBusinessCategoryErrorMessage).getText());
    }

    @Step("check Presence of Merchant Currency Error Message")
    public boolean CheckPresenceOfNotInsertedMerchantCurrencyErrorMsg()
    {
        return IsElementPresent(MerchantCurrencyCodeErrorMessage);
    }
    @Step("Get the Text Of Merchant Currency Error Message")
    public String GetTextOfMerchantBusinessCurrencyErrorMsg()
    {
        return(driver.findElement(MerchantCurrencyCodeErrorMessage).getText());
    }

    @Step("check Presence of Merchant StartTSN Error Message")
    public boolean CheckPresenceOfNotInsertedMerchantStartTSNErrorMsg()
    {
        return IsElementPresent(MerchantStartTSNErrorMessage);
    }
    @Step("Get the Text Of Merchant StartTSN Error Message")
    public String GetTextOfMerchantStartTSNErrorMsg()
    {
        return(driver.findElement(MerchantStartTSNErrorMessage).getText());
    }

    @Step("check Presence of Merchant TerminalCount Error Message")
    public boolean CheckPresenceOfNotInsertedMerchantTerminalCountErrorMsg()
    {
        return IsElementPresent(MerchantTerminalsCountErrorMessage);
    }
    @Step("Get the Text Of Merchant TerminalCount Error Message")
    public String GetTextOfMerchantBusinessTerminalCountErrorMsg()
    {
        return(driver.findElement(MerchantTerminalsCountErrorMessage).getText());
    }








}
