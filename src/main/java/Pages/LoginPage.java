package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginPage {
    File propFile= new File("src\\test\\resources\\configuration.properties");
    Properties props = new Properties();
    FileInputStream inputStream;

    private ChromeDriver driver;
    public LoginPage(ChromeDriver driver)
    {
        this.driver=driver;
    }
    private By EmailFiled=By.xpath("//input[@placeholder='UserName or Email address']");
    private By PasswordFiled=By.xpath("//input[@placeholder='Password']");
    private By LoginButton=By.xpath("//button[@class='log-btn']");
    private By ForgetPassLink=By.xpath("//a[@class='forget']");
    private By ErrorBox=By.xpath("//div[@class='error-box']");
    private By ErrorText=By.xpath("//p");
    private By CloseErrorButton=By.xpath("//*[@id=\"log-in\"]/div[4]/div/button");
    private By SuccessFullLoginMsg=By.xpath("//div[@class='sucess-box']");

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

    //Check the presence of Email and Password field
    public boolean  Is_EmailAndPassFiled_Exist()
    {
        return  IsElementPresent(EmailFiled)&&IsElementPresent(PasswordFiled);
    }
    //Fill Email and Password
    public void FillEmailAndPassword(String Email,String Pass)
    {
        driver.findElement(EmailFiled).sendKeys(Email);
        driver.findElement(PasswordFiled).sendKeys(Pass);
    }

    //Check that login button is displayed and enabled
    public boolean CheckThatLoginButtonIsEnabledAndDisplayed()
    {
        return  (driver.findElement(LoginButton).isEnabled()&&driver.findElement(LoginButton).isDisplayed());
    }

    //Click on login button
    public OTPPage ClickOnLoginButton() {
        driver.findElement(LoginButton).click();

        return new OTPPage(driver);
    }
    //Check Navigation to OTP page
    public String[] CheckBeingAtOTPPage()  {
        String[] Output=new String[3];
        String Check;

        String ExpectedURL=props.getProperty("OTPPageURL");

        if (IsElementPresent(LoginButton)) {
            try {
                //Wait until an element is no longer attached to the DOM.
                FluentWait wait = new FluentWait(driver);
                wait.withTimeout(Duration.ofSeconds(10));
                wait.pollingEvery(Duration.ofSeconds(1));
                wait.ignoring(NoSuchElementException.class);

                wait.until(ExpectedConditions.stalenessOf(driver.findElement(LoginButton)));
            } catch (TimeoutException e) {
            }
        }

        String ActualURL=driver.getCurrentUrl();
        boolean check=ExpectedURL.equals(ActualURL);
        if(check) Check="true"; else Check="false";

        Output[0]=Check;
        Output[1]=ExpectedURL;
        Output[2]=ActualURL;
        return Output;
    }
   //Check The Presence of Error Message
    public boolean CheckThePresenceOfErrorMsg()
    {
        return IsElementPresent(ErrorBox);
    }
    //Check the Text Written in Error message
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

    //Close Error Box
    public void CloseErrorBox()
    {
        driver.findElement(CloseErrorButton).click();
    }
    //Check The Presence of Successfully Login Message
    public boolean CheckThePresenceOfSuccessLoginMsg()
    {
        return IsElementPresent(SuccessFullLoginMsg);
    }
    //Clear the Email and password field
    public void ClearEmail()
    {
        WebElement Email= driver.findElement(EmailFiled);
        Email.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    public void ClearPass()
    {
        WebElement pass= driver.findElement(PasswordFiled);
        pass.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

    }

    //Check that email field is empty
    public boolean IsEmailAndPassEmpty()
    {
       return (driver.findElement(EmailFiled).getText().equals(""))&&(driver.findElement(PasswordFiled).getText().equals(""));
    }
    //Click on the Forget Pass link
    public ForgetPassPage ClickOnForgetPassLink()
    {
        driver.findElement(ForgetPassLink).click();
        return new ForgetPassPage(driver);
    }

    //Check Navigation to Forget Pass page
    public String[] CheckBeingAtForgetPassPage()  {
        String[] Output=new String[3];
        String Check;

        String ExpectedURL=props.getProperty("ForgetPassPageURL");

        if (IsElementPresent(LoginButton)) {
            try {
                //Wait until an element is no longer attached to the DOM.
                FluentWait wait = new FluentWait(driver);
                wait.withTimeout(Duration.ofSeconds(5));
                wait.pollingEvery(Duration.ofSeconds(1));
                wait.ignoring(NoSuchElementException.class);

                wait.until(ExpectedConditions.stalenessOf(driver.findElement(LoginButton)));
            } catch (TimeoutException e) {
            }
        }

        String ActualURL=driver.getCurrentUrl();
        boolean check=ExpectedURL.equals(ActualURL);
        if(check) Check="true"; else Check="false";

        Output[0]=Check;
        Output[1]=ExpectedURL;
        Output[2]=ActualURL;
        return Output;
    }
    //Check the Presence of forget pass link
    public boolean CheckPresenceOfForgetPassLink()
    {
        return IsElementPresent(ForgetPassLink);
    }
}
