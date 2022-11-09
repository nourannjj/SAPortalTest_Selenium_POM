package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class ProfilePage {
    File propFile= new File("src\\test\\resources\\configuration.properties");
    Properties props = new Properties();
    FileInputStream inputStream;
    private ChromeDriver driver;
    public ProfilePage(ChromeDriver driver)
    {
        this.driver=driver;
    }
    private By ProfileScreenTitle=By.xpath("//h2[contains(., 'Super Admin Details')]");
    private By ChangePasswordButton=By.xpath("//button[contains(.,'Change Password')]");
    private By LogoutButton=By.xpath("//button[contains(.,'Log out')]");
    private By SuperAdminInformation=By.xpath("//div[@class='d-flex admin-info']//p//span");
    private By EditButton=By.xpath("");//add it

    //Create SuperAdmin Information class
    public class SuperAdminDetails{
        public String City,Role,Email,Password,PhoneNumber,Location;
        public WebElement Edit_And_details_button;
        //Create a constructor of SuperAdmin details class
        SuperAdminDetails(String City,String Role,String Email,String Password,String PhoneNumber,String Location){
            this.City=City;
            this.Role=Role;
            this.Email=Email;
            this.Password=Password;
            this.PhoneNumber=PhoneNumber;
            this.Location=Location;
        }

    }

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

    @Step("Check Being At Profile Screen")
    public String[] CheckBeingAtProfileScreen() throws IOException {


        inputStream = new FileInputStream(propFile);
        props.load(inputStream);
        String[] Output = new String[4];
        String Check;
        String Comm=null;


        String ExpectedURL = props.getProperty("ProfileURL");
        String ActualURL = driver.getCurrentUrl();
        boolean check = ExpectedURL.equals(ActualURL);
        if (check)
        {
            //check presence of profile screen items such as title
            if(!IsElementPresent(ProfileScreenTitle))
            {
                Check="false";
                Comm="User is navigated successfully to the profile screen but The Profile Screen elements doesn't exist ";

            }
            else
            {
                Check="true";
            }
        }
        else
        {
            Check="false";
            Comm="User isn't navigated to the right page\n\tThe Expected URL:"+ExpectedURL+"\n\tThe Actual URL:"+ActualURL;
        }

        Output[0]=Check;
        Output[1]=ExpectedURL;
        Output[2]=ActualURL;
        Output[3]=Comm;
        return Output;
    }
    @Step("Check the presence of change password button")
    public boolean CheckPresenceOfChangePasswordButton()
    {
        return (IsElementPresent(ChangePasswordButton));
    }
    @Step("Click on the change password button")
    public ChangePasswordScreen ClickOnChangePassButton()
    {
        driver.findElement(ChangePasswordButton).click();
        return new ChangePasswordScreen(driver);
    }
    @Step("Check the presence of super admin information")
    public boolean CheckPresenceOfSuperAdminInformation()
    {
        return (IsElementPresent(SuperAdminInformation));
    }
    @Step("Get data in SuperAdmin information fields")
    public SuperAdminDetails GetTheInformationOfSuperAdmin()
    {
            List<WebElement> ListOfMerchantInformation=driver.findElements(SuperAdminInformation);
            String city=ListOfMerchantInformation.get(0).getText();
            String Role=ListOfMerchantInformation.get(1).getText();
            String Email=ListOfMerchantInformation.get(2).getText();
            String Password=ListOfMerchantInformation.get(3).getText();
            String phone=ListOfMerchantInformation.get(4).getText();
            String Location=ListOfMerchantInformation.get(5).getText();

            SuperAdminDetails superAdminDetails=new SuperAdminDetails(city,Role,Email,Password,phone,Location);
            return superAdminDetails;

    }
    @Step("Check the Presence of Edit SuperAdmin Information Button")
    public boolean CheckPresenceOfEditSuperAdminInformationButton()
    {
        return (IsElementPresent(EditButton));
    }
    @Step("Check Presence Of Logout Button")
    public boolean CheckPresenceOfLogoutButton()
    {
        return (IsElementPresent(LogoutButton));
    }
    @Step("Click On Logout Button")
    public FirstPage ClickOnLogoutButton()
    {
        driver.findElement(LogoutButton).click();
        return new FirstPage(driver);
    }

}

