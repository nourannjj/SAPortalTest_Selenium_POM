package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class OTPPage_edge {
    public EdgeDriver driver;
    File propFile= new File("src\\test\\resources\\configuration.properties");
    Properties props = new Properties();
    FileInputStream inputStream;
    public OTPPage_edge(EdgeDriver driver)
    {
        this.driver=driver;
    }

    private By OTPMsg=By.xpath("//h2");

    private By OTP_FirstDigit=By.xpath("//input[@name='input1']");
    private By OTP_SecondDigit=By.xpath("//input[@name='input2']");
    private By OTP_ThirdDigit=By.xpath("//input[@name='input3']");
    private By OTP_FourthDigit=By.xpath("//input[@name='input4']");
    private By OTP_FifthDigit=By.xpath("//input[@name='input5']");
    private By OTP_SixthDigit=By.xpath("//input[@name='input6']");

    private By ConfirmButton=By.xpath("//button[@class='confirm-btn']");
    private By ResendButton=By.xpath("//button[@class='resend']");
    private By InvalidOTPMsg=By.xpath("//*[@id=\"otp\"]/div[1]/div[1]/h2");
    private By ErrorBox=By.xpath("//div[@class='error-box']");
    private By ErrorText=By.xpath("//p");

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

    //Check that OTP message exist
    public boolean CheckThePresenceOfOTPScreenMsg()
    {
        return IsElementPresent(OTPMsg);
    }
    //Check that OTP fields exist
    public boolean CheckThePresenceOfOTPFields()
    {
        boolean Check=IsElementPresent(OTP_FirstDigit)
                &&IsElementPresent(OTP_SecondDigit)
                &&IsElementPresent(OTP_ThirdDigit)
                &&IsElementPresent(OTP_FourthDigit)
                &&IsElementPresent(OTP_FifthDigit)
                &&IsElementPresent(OTP_SixthDigit);
        return Check;
    }
    //Check that Confirm button exist
    public boolean CheckThePresenceOfConfirmButton()
    {
        return IsElementPresent(ConfirmButton);
    }
    //Check that Resend button exist
    public boolean CheckThePresenceOfResendButton()
    {
        return IsElementPresent(ResendButton);
    }

    //Check Text of the OTP Screen
    public String[] CheckOTPScreenText(String ExpectedMsg)
    {
        String[] Msg=new String[3];
        String Check;

        String ActualMsg= driver.findElement(OTPMsg).getText();
        boolean check=ExpectedMsg.equals(ActualMsg);
        if(check) Check="true"; else Check="false";

        Msg[0]=Check;
        Msg[1]=ExpectedMsg;
        Msg[2]=ActualMsg;
        return Msg;
    }

    //clear the OTP fields
    public void ClearOTPFields()
    {
        WebElement first= driver.findElement(OTP_FirstDigit);
        WebElement second= driver.findElement(OTP_SecondDigit);
        WebElement third= driver.findElement(OTP_ThirdDigit);
        WebElement fourth= driver.findElement(OTP_FourthDigit);
        WebElement fifth= driver.findElement(OTP_FifthDigit);
        WebElement sixth= driver.findElement(OTP_SixthDigit);

        first.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        second.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        third.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        fourth.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        fifth.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        sixth.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

    }

    //Insert Otp
    public void InsertOTP(String OTP)
    {
        driver.findElement(OTP_FirstDigit).sendKeys(String.valueOf(OTP.charAt(0)));
        driver.findElement(OTP_SecondDigit).sendKeys(String.valueOf(OTP.charAt(1)));
        driver.findElement(OTP_ThirdDigit).sendKeys(String.valueOf(OTP.charAt(2)));
        driver.findElement(OTP_FourthDigit).sendKeys(String.valueOf(OTP.charAt(3)));
        driver.findElement(OTP_FifthDigit).sendKeys(String.valueOf(OTP.charAt(4)));
        driver.findElement(OTP_SixthDigit).sendKeys(String.valueOf(OTP.charAt(5)));

    }
    //Get Value inserted in the OTP filed
    public String GetValueInOTPField()
    {
        String OTP = null;
        OTP=driver.findElement(OTP_FirstDigit).getAttribute("value")+driver.findElement(OTP_SecondDigit).getAttribute("value")+driver.findElement(OTP_ThirdDigit).getAttribute("value")+driver.findElement(OTP_FourthDigit).getAttribute("value")+driver.findElement(OTP_FifthDigit).getAttribute("value")+driver.findElement(OTP_SixthDigit).getAttribute("value");
        return OTP;
    }

    //Check that confirm button is enabled
    public boolean IsConfirmButtonEnabled()
    {
        return driver.findElement(ConfirmButton).isEnabled();
    }

    //Click on the confirm button
    public void ClickOnConfirmButton()
    {
        driver.findElement(ConfirmButton).click();
    }

    //Click on the Resend button
    public void ClickOnResendButton()
    {
        driver.findElement(ResendButton).click();
    }

    //Check presence of Invalid OTP Msg
    public boolean CheckThePresenceOfInvalidOTPMsg()
    {
        return IsElementPresent(InvalidOTPMsg);
    }
    //Check Presence of Error box
    public boolean CheckThePresenceOfErrorBox()
    {
        return IsElementPresent(ErrorBox);
    }
    //Check the Text of the Blocking error message
    public String[] CheckBlockingErrorText(String ExpectedError)
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

    //Check Being to OTP page
    public String[] CheckBeingAtOTPPage() throws IOException {
        inputStream = new FileInputStream(propFile);
        props.load(inputStream);
        String[] Output=new String[3];
        String Check;

        if (IsElementPresent(ConfirmButton)) {
            try {
                //Wait until an element is no longer attached to the DOM.
                FluentWait wait = new FluentWait(driver);
                wait.withTimeout(Duration.ofSeconds(5));
                wait.pollingEvery(Duration.ofSeconds(1));
                wait.ignoring(NoSuchElementException.class);

                wait.until(ExpectedConditions.stalenessOf(driver.findElement(ConfirmButton)));
            } catch (TimeoutException e) {
            }
        }
        String ExpectedURL=props.getProperty("OTPPageURL");
        String ActualURL=driver.getCurrentUrl();
        boolean check=ExpectedURL.equals(ActualURL);
        if(check) Check="true"; else Check="false";

        Output[0]=Check;
        Output[1]=ExpectedURL;
        Output[2]=ActualURL;
        return Output;
    }

}
