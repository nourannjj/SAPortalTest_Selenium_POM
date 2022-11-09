package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ForgetPassPage {
    ChromeDriver driver;
    File propFile= new File("src\\test\\resources\\configuration.properties");
    Properties props = new Properties();
    FileInputStream inputStream;
    public ForgetPassPage(ChromeDriver driver)
    {
        this.driver=driver;
    }
    private By EmailFiled=By.xpath("//input[@class='input']");
    private By SendResetEmailButton=By.xpath("//button[@class='log-btn']");
    private By ErrorBox=By.xpath("//div[@class='error-box']");
    private By ErrorText=By.xpath("//p");
    private By SuccessFullSendEmailMsg=By.xpath("//div[@class='sucess-box']");
    private By msgText=By.xpath("//p");

    @Step("Check that element is present Step...")
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

    @Step("Check the presence of Email field Step...")
    //Check the presence of Email field
    public boolean  Is_EmailFiled_Exist()
    {
        return  IsElementPresent(EmailFiled);
    }
    //Check the message in the Email filed
    public String[] CheckMsgInEmailField()
    {
        String[] msg=new String[3];
        String Check;

        String ExpectedMsg="Enter email address to send new password";
        String ActualMsg=driver.findElement(EmailFiled).getAttribute("placeholder");
        boolean check=ExpectedMsg.equals(ActualMsg);
        if(check) Check="true"; else Check="false";

        msg[0]=Check;
        msg[1]=ExpectedMsg;
        msg[2]=ActualMsg;
        return msg;
    }
    @Step("enter the Email:{0} in the reset email filed Step...")
    //Insert Reset Email
    public void InsertResetEmail(String Email)
    {
        driver.findElement(EmailFiled).sendKeys(Email);

    }
    @Step("Check That Email is empty Step...")
    //Check That Email is empty
    public boolean CheckEmailAndPassFiledEmpty()
    {
        return driver.findElement(EmailFiled).getText().equals("");
    }

    @Step("Clear the Email field Step...")
    //Clear the Email field
    public void ClearEmail()
    {
        WebElement Email= driver.findElement(EmailFiled);
        Email.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }

    @Step("Check the presence of Send Email button Step...")
    //Check the presence of Send Email button
    public boolean  Is_SendEmailButton_Exist()
    {
        return  IsElementPresent(SendResetEmailButton);
    }

    @Step("Check that Send Email button is displayed and enabled Step...")
    //Check that Send Email button is displayed and enabled
    public boolean CheckThatLoginButtonIsEnabledAndDisplayed()
    {
        return  (driver.findElement(SendResetEmailButton).isEnabled()&&driver.findElement(SendResetEmailButton).isDisplayed());
    }

    @Step("Click on the Send Reset Email button Step...")
    //Click on the Send Reset Email button
    public void ClickOnTheSendResetEmailButton()
    {
        driver.findElement(SendResetEmailButton).click();
    }

    @Step("Check The Presence of Error Message Step...")
    //Check The Presence of Error Message
    public boolean CheckThePresenceOfErrorMsg()
    {
        return IsElementPresent(ErrorBox);
    }


    @Step("Check that Message displayed in the Error box is correct Step...")
    //Check the Message in the Error box
    public String[] CheckErrorText(String ExpectedError)
    {
        String[] Output=new String[3];
        String Check;

        String ActualError= driver.findElement(ErrorText).getText();
        boolean check=ExpectedError.equals(ActualError);
        if(check) Check="true"; else Check="false";

        Output[0]=Check;
        Output[1]=ExpectedError;
        Output[2]=ActualError;
        return Output;
    }

    @Step("Check The Presence of Successful Message Step...")
    //Check The Presence of Successful Message
    public boolean CheckThePresenceOfSuccessMsg()
    {
        return IsElementPresent(SuccessFullSendEmailMsg);
    }


    @Step("Check that text in the Successful message is correct Step...")
    //Check the text in the Successful message
    public String[] CheckSuccessText(String ExpectedMsg)
    {
        String[] Output=new String[3];
        String Check;

        String ActualMsg= driver.findElement(msgText).getText();
        boolean check=ExpectedMsg.equals(ActualMsg);
        if(check) Check="true"; else Check="false";

        Output[0]=Check;
        Output[1]=ExpectedMsg;
        Output[2]=ActualMsg;
        return Output;
    }


    @Step("Check Navigation to login page Step...")
    //Check Navigation to login page
    public String[] CheckBeingAtLoginPage() throws IOException {
        inputStream = new FileInputStream(propFile);
        props.load(inputStream);
        String[] Output=new String[3];
        String Check;

        String ExpectedURL=props.getProperty("LoginPageURl");
        String ActualURL=driver.getCurrentUrl();
        boolean check=ExpectedURL.equals(ActualURL);
        if(check) Check="true"; else Check="false";

        Output[0]=Check;
        Output[1]=ExpectedURL;
        Output[2]=ActualURL;
        return Output;
    }

}
