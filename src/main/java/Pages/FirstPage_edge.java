package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstPage_edge {
   private EdgeDriver driver;
   public FirstPage_edge(EdgeDriver driver)
   {
       this.driver=driver;
   }
   private By FirstPageTitle=By.xpath("//h1[@class='title']");
   private By TextOfFirstPage=By.xpath("//h2");
   private By LoginButton=By.xpath("//button[@class='log-btn']");
   //Get the Title of the first page
    public boolean CheckNavigationToFirstPage()
    {
        String Title="SoftPOS Control panel";
        boolean check= driver.findElement(FirstPageTitle).getText().equals(Title);
        return check;

    }

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

    //Check that login button is displayed and enabled
    public boolean CheckThatLoginButtonIsEnabledAndDisplayed()
    {
       return  (driver.findElement(LoginButton).isEnabled()&&driver.findElement(LoginButton).isDisplayed());
    }

    //Click on login button
    public LoginPage_edge ClickOnLoginButton()
    {
        driver.findElement(LoginButton).click();
        return new LoginPage_edge(driver);
    }
}
