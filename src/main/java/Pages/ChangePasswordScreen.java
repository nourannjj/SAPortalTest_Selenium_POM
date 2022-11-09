package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChangePasswordScreen {
    private ChromeDriver driver;
    public ChangePasswordScreen(ChromeDriver driver)
    {
        this.driver=driver;
    }


    private By ScreenTitle= By.xpath("//h5[contains(.,'Change Password')]");
    private By NewPasswordField=By.xpath("//input [@name='password']");
    private By ConfirmNewPassField=By.xpath("//input [@name='confirmPassword']");
    private By OldPassField=By.xpath("");
    private By ChangePassButton=By.xpath("//button[@class='yes-btn']");
    private By CancelButton=By.xpath("//button[@class='cancel-button']");
    private By ErrorPassMsg=By.xpath("//h6");
    private By APIError=By.xpath("//p[@class='api-error']");


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

    @Step("Check navigation to change password screen ")
    public boolean CheckNavigationToChangePassScreen()
    {
        return (IsElementPresent(ScreenTitle)&&IsElementPresent(NewPasswordField)&&IsElementPresent(ConfirmNewPassField));
    }

    @Step("Check Presence of New Pass field")
    public boolean CheckPresenceOFNewPassField()
    {
        return (IsElementPresent(NewPasswordField));
    }
    @Step("Enter New Pass")
    public void EnterNewPass(String NewPass)
    {
        driver.findElement(NewPasswordField).sendKeys(NewPass);
    }
    @Step("Read the typed data in New pass field")
    public String ReadTypedDataInNewPassField()
    {
        return (driver.findElement(NewPasswordField).getAttribute("value"));
    }
    @Step("Check Presence of Confirm New Pass field")
    public boolean CheckPresenceOfConfirmNewPassField()
    {
        return (IsElementPresent(ConfirmNewPassField));
    }
    @Step("Insert the Confirm new pass")
    public void InsertTheConfirmNewPass(String ConfirmPass)
    {
        driver.findElement(ConfirmNewPassField).sendKeys(ConfirmPass);
    }
    @Step("Read the typed data in Confirm pass field")
    public String ReadTypedDataInConfirmNewPassField()
    {
        return (driver.findElement(ConfirmNewPassField).getAttribute("value"));
    }
    @Step("Check The Presence of change password button")
    public boolean CheckPresenceOfChangePasswordButton()
    {
        return IsElementPresent(ChangePassButton);
    }
    @Step("Click on change password button")
    public ProfilePage ClickOnChangePassButton()
    {
        driver.findElement(ChangePassButton).click();
        return new ProfilePage(driver);
    }
    @Step("Click on Cancel button")
    public ProfilePage ClickOnCancelButton()
    {
        driver.findElement(CancelButton).click();
        return new ProfilePage(driver);
    }
    @Step("Check Presence Of Old Pass Field")
    public boolean CheckPresenceOfOldPassField()
    {
        return (IsElementPresent(OldPassField));
    }
    @Step("Check the Presence of Pass error message")
    public boolean CheckPresenceOFErrorMsg()
    {
        return IsElementPresent(ErrorPassMsg);
    }
    @Step("Check the Text Written in Error message")
    public String[] CheckErrorText(String ExpectedError)
    {
        String[] Output=new String[3];
        String Check;

        String ActualError= driver.findElement(ErrorPassMsg).getText();
        boolean check=ExpectedError.equals(ActualError);
        if(check) Check="true"; else Check="false";

        Output[0]=Check;
        Output[1]=ExpectedError;
        Output[2]=ActualError;
        return Output;
    }
    @Step("Check Presence of change password screen")
    public boolean CheckPresenceOfChangePassScreen()
    {
        return (IsElementPresent(ScreenTitle)&&IsElementPresent(NewPasswordField)&&IsElementPresent(ConfirmNewPassField));
    }
    @Step("CheckPresence of API error")
    public boolean CheckPresenceOfAPIError()
    {
       return IsElementPresent(APIError);
    }
    @Step("Get the ErrorText")
    public String GetErrorText()
    {
        return (driver.findElement(APIError).getText());
    }
}
