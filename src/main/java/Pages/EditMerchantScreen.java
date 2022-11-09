package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class EditMerchantScreen {
    public ChromeDriver driver;
    public EditMerchantScreen(ChromeDriver driver)
    {
        this.driver=driver;
    }

    private By EditMerchantTitle=By.xpath("//h5[contains(.,'Edit Merchant')]");
    private By MerchantNameField=By.xpath("//input[@name='merchantName']");
    private By MerchantCodeField=By.xpath("//input[@name='merchantCode']");
    private By MerchantCountryField=By.xpath("//input[@id='react-select-3-input']");
    private By MerchantCountryText=By.xpath("//div[@class='col'][contains(.,'Merchant country')]//div[@class=' css-qc6sy-singleValue']");
    private By MerchantCityField=By.xpath("//input[@id='react-select-4-input']");
    private By MerchantCityText=By.xpath("//div[@class='city col']//div[@class=' css-qc6sy-singleValue']");
    private By MerchantStatus=By.xpath("//input[@id='react-select-5-input']");
    private By MerchantStatusText=By.xpath("//div[@class='col'][contains(.,'Merchant Status')]//div[@class=' css-qc6sy-singleValue']");
    private By MerchantLanguageField=By.xpath("//input[@id='react-select-6-input']");
    private By MerchantStatusAndLanguageText=By.xpath("//div[@class='col'][contains(.,'Default Language')]//div[@class=' css-qc6sy-singleValue']");
    private By MerchantEmailField=By.xpath("//input[@name='email']");
    private By NextButton=By.xpath("//button[@class='yes-btn']");
    private By CancelButton=By.xpath("//button[@class='cancel-button']");
    private By MerchantNameErrorMessage=By.xpath("//div[@class='col'][contains(.,'Merchant name')]//h6");
    private By MerchantCodeErrorMessage=By.xpath("//div[@class='col'][contains(.,'Merchant Code')]//h6");
    private By MerchantEmailErrorMessage=By.xpath("//div[@class='col'][contains(.,'Merchant Email')]//h6");


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

    @Step("Scroll until reach a specific element")
    public void ScrollTo(By by) throws InterruptedException {
        WebElement element=driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(500);
    }

    @Step("Check that Edit Merchant screen appears")
    public boolean CheckPresenceOfEditMerchantScreen()
    {
        return IsElementPresent(EditMerchantTitle);
    }

       //////////////////////Check The Presence of Elements os the Edit Screen////////////////////////////////

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
    @Step("Check Presence of Merchant Status Field")
    public boolean CheckPresenceOfMerchantStatusField()
    {
        return IsElementPresent(MerchantStatus);
    }

    @Step("Check Presence of Default Language Field")
    public boolean CheckPresenceOfDefaultLanguageField()
    {
        return IsElementPresent(MerchantLanguageField);
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
    //////////////////////Clear Data////////////////////////////////
    @Step("Clear Merchant Name Field")
    public void ClearMerchantNameField()
    {
        driver.findElement(MerchantNameField).clear();
    }
    @Step("Clear Merchant Code Field")
    public void ClearMerchantCodeField(  )
    {
        driver.findElement(MerchantCodeField).clear();
    }

    @Step("Clear Merchant Email Field")
    public void ClearMerchantEmailField( )
    {
        driver.findElement(MerchantEmailField).clear();
    }

                                             //////////////////////Edit Data////////////////////////////////
    @Step("Edit Merchant Name")
    public void EditMerchantName(String MerchantName )
    {
        driver.findElement(MerchantNameField).sendKeys(MerchantName);
    }
    @Step("Edit Merchant Code")
    public void EditMerchantCode(String MerchantCode )
    {
        driver.findElement(MerchantCodeField).sendKeys(MerchantCode);
    }

    @Step("Edit Merchant Email")
    public void EditMerchantEmail(String MerchantEmail )
    {
        driver.findElement(MerchantEmailField).sendKeys(MerchantEmail);
    }

    @Step("Edit Country")
    public void EditCountry(String Country)
    {
        driver.findElement(MerchantCountryField).sendKeys(Country);
        driver.findElement(MerchantCountryField).sendKeys(Keys.ENTER);
    }

    @Step("Edit City")
    public void EditCity(String City)
    {
        driver.findElement(MerchantCityField).sendKeys(City);
        driver.findElement(MerchantCityField).sendKeys(Keys.ENTER);
    }

    @Step("Edit Status")
    public void EditMerchantStatus(String Status)
    {
        driver.findElement(MerchantStatus).sendKeys(Status);
        driver.findElement(MerchantStatus).sendKeys(Keys.ENTER);
    }

    @Step("Choose Language")
    public void ChooseLanguage(String Language)
    {
        driver.findElement(MerchantLanguageField).sendKeys(Language);
        driver.findElement(MerchantLanguageField).sendKeys(Keys.ENTER);
    }

                                          //////////////////////Read Data////////////////////////////////

    @Step("Read Data in Merchant Name Filed")
    public String ReadDataInMerchantNameField()
    {
        return (driver.findElement(MerchantNameField).getAttribute("value"));
    }

    @Step("Read Data in Merchant Code Filed")
    public String ReadDataInMerchantCodeField()
    {
        return (driver.findElement(MerchantCodeField).getAttribute("value"));
    }


    @Step("Read Data in Merchant Email Filed")
    public String ReadDataInMerchantEmailField()
    {
        return (driver.findElement(MerchantEmailField).getAttribute("value"));
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

    @Step("Read Data in Default Language Filed")
    public String ReadDataInMerchantLanguageField()
    {
        String chosenLanguage = null;
        if(IsElementPresent(MerchantStatusAndLanguageText))
        {
            List<WebElement> elements=driver.findElements(MerchantStatusAndLanguageText);
            WebElement LanguageText=elements.get(1);
            chosenLanguage=LanguageText.getText();
        }
        System.out.println(chosenLanguage);
        return (chosenLanguage);
    }
                               ///////////////////////////////////////////////////////////////////////
    @Step("Click on Next Button")
    public SchemeScreenAfterEditMerchantScreen ClickOnNextButton() throws InterruptedException {


        ScrollTo(NextButton);

        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(NextButton));


        driver.findElement(NextButton).click();
        return new SchemeScreenAfterEditMerchantScreen(driver);
    }
    @Step("Click on Cancel Button")
    public void ClickOnCancelButton() throws InterruptedException {
        ScrollTo(CancelButton);

        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(CancelButton));

        driver.findElement(CancelButton).click();


    }

                                    /////////////////Check Presence of Error Msg and Get the Text of it///////////////////////
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
    public boolean CheckPresenceOfMerchantEmailErrorMsg()
    {
        return IsElementPresent(MerchantEmailErrorMessage);
    }
    @Step("Get the Text Of Merchant Email Error Message")
    public String GetTextOfMerchantEmailErrorMsg()
    {
        return(driver.findElement(MerchantEmailErrorMessage).getText());
    }

}
