package Tests;

import Base.BaseTest;
import Pages.FirstPage;
import Pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class FirstPageTest extends BaseTest {
    String Comm;


    @Test(description = "Validation Of First screen message",priority =1 )
    public void TC_PSA_0001() throws IOException {

        SoftAssert softAssert=new SoftAssert();

        //Check Navigation to the first Page
        boolean check= firstPage.CheckNavigationToFirstPage();
        Comm="The URL navigate User to wrong page";
        softAssert.assertEquals(check,true,Comm);

        //Check the spelling of the text represented in the first page
        String[]arr=firstPage.CheckTheTextOfFirstPAge();
        Comm="There is a spelling Error in the Text of First Page: \n \t -Expected Text: "+arr[1]+"."+"\n\t -Actual Text="+arr[2]+".";

        softAssert.assertEquals(arr[0],"true",Comm);
        softAssert.assertAll();

    }
    @Test(description = "Validation Of login button",priority =2 )
    public void TC_PSA_0002() throws IOException {

        SoftAssert softAssert=new SoftAssert();
        LoginPage loginPage;

        //Check that Login Button is displayed and enabled
        boolean LoginButtonStatus=firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm="Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus,true,Comm);

        //If login button Displayed and Enabled Click on it
        if(LoginButtonStatus)
        {
            loginPage=firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            String arr[]=loginPage.CheckBeingAtLoginPage();
            Comm="Error:Clicking on the Login button doesn't navigate to the Login page\n"+"Expected URL : "+arr[1]+"\nActual URL :"+arr[2];
            softAssert.assertEquals(arr[0],"true",Comm);

        }

        softAssert.assertAll();

    }
}
