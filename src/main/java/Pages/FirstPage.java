package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FirstPage {
  // private ChromeDriver driver;
  private ChromeDriver driver;

    File propFile= new File("src\\test\\resources\\configuration.properties");
    Properties props = new Properties();
    FileInputStream inputStream;
   public FirstPage(ChromeDriver driver)
   {
       this.driver=driver;
   }
   private By FirstPageTitle=By.xpath("//h1[@class='title']");
   private By TextOfFirstPage=By.xpath("//h2");
   private By LoginButton=By.xpath("//button[@class='log-btn']");

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
   @Step("Check being at FirstPage by checking the URL")
    public boolean CheckNavigationToFirstPage() throws IOException {
        inputStream = new FileInputStream(propFile);
        props.load(inputStream);


        String ExpectedURL=props.getProperty("SAPortalURL_Server100");
        String ActualURL=driver.getCurrentUrl();
        boolean check=ExpectedURL.equals(ActualURL);
        if(check)
        {
            check=IsElementPresent(FirstPageTitle);
        }

       return check;

    }

    @Step("Check that text appears in the first page is correct")
    //Check Text Written in first page
    public String[] CheckTheTextOfFirstPAge()
    {
        String[] Output=new String[3];
        String Check;

        String ExpectedText="Welcome to SoftPOS please click the below button to login";
        String ActualText=driver.findElement(TextOfFirstPage).getText();

        boolean check=ExpectedText.equals(ActualText);
        if(check) Check="true"; else Check="false";

        Output[0]=Check;
        Output[1]=ExpectedText;
        Output[2]=ActualText;

        return Output;
    }

    @Step("Check that login button is displayed and enabled")
    //Check that login button is displayed and enabled
    public boolean CheckThatLoginButtonIsEnabledAndDisplayed()
    {
       return  (driver.findElement(LoginButton).isEnabled()&&driver.findElement(LoginButton).isDisplayed());
    }

    @Step("Click on login button")
    //Click on login button
    public LoginPage ClickOnLoginButton()
    {
        driver.findElement(LoginButton).click();
        return new LoginPage(driver);
    }
}
