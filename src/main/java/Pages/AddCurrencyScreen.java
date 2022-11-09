package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class AddCurrencyScreen {
    public ChromeDriver driver;
    public AddCurrencyScreen(ChromeDriver driver)
    {
        this.driver=driver;
    }
    private By AddCurrencyTitle=By.xpath("//h5[contains(.,'Add Currency')]");
    private By CurrencyCountryField=By.xpath("//input[@type='text'][@id='react-select-2-input']");
    private By CurrencyCountryText=By.xpath("//div[@class='col'][contains(.,'Currency country')]//div[@class=' css-qc6sy-singleValue']");
    private By CurrencyFullNameField=By.xpath("//div[@class='col'][contains(.,'Currency Full Name')]//input");
    private By CurrencyShortNameFiled=By.xpath("//div[@class='col'][contains(.,'Currency Short Name')]//input");
    private By CurrencyCodeField=By.xpath("//div[@class='col'][contains(.,'Currency Code')]//input");
    private By AddCurrencyButton=By.xpath("//button[@class='yes-btn']");
    private By CancelButton=By.xpath("//button[@class='cancel-button']");
    private By ErrorMsg=By.xpath("//p[@class='api-error']");


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

    @Step("Scroll Down until a specific element")
    public void ScrollDown(By by) throws InterruptedException {
        WebElement element=driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(500);
    }
    @Step("Check that Add currency screen appears")
    public boolean CheckPresenceOfAddCurrencyScreen()
    {
        return IsElementPresent(AddCurrencyTitle);
    }
    @Step("Check Presence of Currency Country Field")
    public boolean CheckPresenceOfCurrencyCountryField()
    {
        return IsElementPresent(CurrencyCountryField);
    }
    @Step("Choose Currency Country")
    public void ChooseCurrencyCountry(String Country) throws InterruptedException {
        ScrollDown(CurrencyCountryField);
        driver.findElement(CurrencyCountryField).sendKeys(Country);
        driver.findElement(CurrencyCountryField).sendKeys(Keys.ENTER);
    }
    @Step("Read Data in Currency Country Field ")
    public String ReadDataInCurrencyCountryField() throws InterruptedException {

        String chosenCountry = null;
        if(IsElementPresent(CurrencyCountryText))
        {
            chosenCountry=driver.findElement(CurrencyCountryText).getText();
        }
        return (chosenCountry);
    }
    @Step("Check Presence of Currency Full Name Field")
    public boolean CheckPresenceOfCurrencyFullNameField()
    {
        return IsElementPresent(CurrencyFullNameField);
    }
    @Step("Read Data in Currency Full Name Field ")
    public String ReadDataInCurrencyFullNameField()
    {
        String currencyFullName = null;
        if(IsElementPresent(CurrencyFullNameField))
        {
            currencyFullName=driver.findElement(CurrencyFullNameField).getAttribute("value");
        }
        return (currencyFullName);
    }
    @Step("Check Presence of Currency Short Name Field")
    public boolean CheckPresenceOfCurrencyShortNameField()
    {
        return IsElementPresent(CurrencyShortNameFiled);
    }
    @Step("Read Data in Currency Short Name Field ")
    public String ReadDataInCurrencyShortNameField()
    {
        String currencyShortName = null;
        if(IsElementPresent(CurrencyShortNameFiled))
        {
            currencyShortName=driver.findElement(CurrencyShortNameFiled).getAttribute("value");
        }
        return (currencyShortName);
    }
    @Step("Check Presence of Currency Code Field")
    public boolean CheckPresenceOfCurrencyCodeField()
    {
        return IsElementPresent(CurrencyCodeField);
    }
    @Step("Read Data in Currency Code Field ")
    public String ReadDataInCurrencyCodeField()
    {
        String currencyCode = null;
        if(IsElementPresent(CurrencyCodeField))
        {
            currencyCode=driver.findElement(CurrencyCodeField).getAttribute("value");
        }
        return (currencyCode);

    }
    @Step("Check Presence of Add currency button")
    public boolean CheckPresenceOFAddCurrencyButton()
    {
        return IsElementPresent(AddCurrencyButton);
    }
    @Step("Click on Add currency button")
    public void ClickOnAddCurrencyButton() throws InterruptedException {
        ScrollDown(AddCurrencyButton);

        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(AddCurrencyButton));
        WebElement element=driver.findElement(AddCurrencyButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

    }
    @Step("Check Presence of cancel button")
    public boolean CheckPresenceOfCancelButton()
    {return IsElementPresent(CancelButton);}
    @Step("Click on Cancel  button")
    public void ClickOnCancelButton() throws InterruptedException {
        ScrollDown(CancelButton);

        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(CancelButton));

        WebElement element=driver.findElement(CancelButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    @Step("check Presence of Error Message")
    public boolean CheckPresenceOfErrorMsg()
    {
        return IsElementPresent(ErrorMsg);
    }
    @Step("Get the Text Of  Error Message")
    public String GetTextOfErrorMsg()
    {
        return(driver.findElement(ErrorMsg).getText());
    }




}
