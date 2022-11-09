package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class MerchantDetailsScreen {
    private ChromeDriver driver;
    File propFile= new File("src\\test\\resources\\configuration.properties");
    Properties props = new Properties();
    FileInputStream inputStream;
    public MerchantDetailsScreen(ChromeDriver driver)
    {
        this.driver=driver;
    }
    private By MerchantNameField= By.xpath("//div[@class='d-flex align-items-center merchant-title']//h2");
    private By MerchantCodeFiled=By.xpath("//div[@class='d-flex align-items-center merchant-title']//h6");

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

    @Step("Check the presence of merchant Name filed")
    public boolean CheckThePresenceOfMerchantNameFiled()
    {
       return IsElementPresent(MerchantNameField);
    }

    @Step("Check the similarity between the Expected Merchant name and th actual name exist in the Merchant Name filed")
    public boolean CheckThatMerchantNameFiledContainsTheRightValue(String ExpectedMerchantName)
    {
        String ActualMerchantName=driver.findElement(MerchantNameField).getText();
        return (ActualMerchantName.equals(ExpectedMerchantName));
    }

    @Step("Check the presence of merchant Code filed")
    public boolean CheckThePresenceOfMerchantCodeFiled()
    {
        return IsElementPresent(MerchantCodeFiled);
    }

    @Step("Check the similarity between the Expected Merchant code and the actual code exist in the Merchant code filed")
    public boolean CheckThatMerchantCodeFiledContainsTheRightValue(String ExpectedMerchantCode)
    {
        String ActualMerchantName=driver.findElement(MerchantCodeFiled).getText();
        return (ActualMerchantName.equals(ExpectedMerchantCode));
    }

}
