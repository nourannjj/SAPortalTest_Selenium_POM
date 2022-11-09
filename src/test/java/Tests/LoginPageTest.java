package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.OTPPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginPageTest extends BaseTest {
    String Comm;
    boolean Check;

    @Test(description = "Validation Of logging in with valid email and valid password",priority =3 )
    public void TC_PSA_0003() throws IOException, InterruptedException {

        SoftAssert softAssert=new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus=firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm="Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus,true,Comm);

        //If login button Displayed and Enabled Click on it
        if(LoginButtonStatus)
        {
            loginPage=firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            String arr[]=loginPage.CheckBeingAtLoginPage();
            Comm="Error:Clicking on the Login button doesn't navigate to the right page\n"+"Expected URL : "+arr[1]+"\nActual URL :"+arr[2];
            softAssert.assertEquals(arr[0],"true",Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true"))
            {
                //Check presence of the Presence of email and pass field
                Check=loginPage.Is_EmailAndPassFiled_Exist();
                Comm="Email or pass filed doesn't exist";
                softAssert.assertEquals(Check,true,Comm);

                if(Check)
                {   //Enter Email and Pass
                    loginPage.FillEmailAndPassword(props.getProperty("ValidEmail"), props.getProperty("ValidPass"));
                    //Check that Login Button at Login screen is displayed and enabled
                    LoginButtonStatus = loginPage.CheckThatLoginButtonIsEnabledAndDisplayed();
                    Comm = "Error:Login button at Login screen is either not displayed or disabled";
                    softAssert.assertEquals(LoginButtonStatus, true, Comm);

                    //If login button Displayed and Enabled Click on it
                    if (LoginButtonStatus) {
                        otpPage = loginPage.ClickOnLoginButton();
                        //Check Navigation to OTP screen
                        String arr1[] = loginPage.CheckBeingAtOTPPage();
                        Comm = "Error:Clicking on the Login button doesn't navigate to the OTP page\n" + "Expected URL : " + arr1[1] + "\nActual URL :" + arr1[2];
                        softAssert.assertEquals(arr1[0], "true", Comm);
                    }
                }

            }

        }
        softAssert.assertAll();

    }

    @Test(description = "Validation Of logging in with invalid email and invalid password",priority =4 )
    public void TC_PSA_0004() throws IOException, InterruptedException {

        SoftAssert softAssert=new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        String[] arr = new String[3];

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus=firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm="Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus,true,Comm);

        //If login button Displayed and Enabled Click on it
        if(LoginButtonStatus)
        {
            loginPage=firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            arr=loginPage.CheckBeingAtLoginPage();
            Comm="Error:Clicking on the Login button doesn't navigate to the right page\n"+"Expected URL : "+arr[1]+"\nActual URL :"+arr[2];
            softAssert.assertEquals(arr[0],"true",Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of email and pass field
                Check = loginPage.Is_EmailAndPassFiled_Exist();
                Comm = "Email or pass filed doesn't exist";
                softAssert.assertEquals(Check, true, Comm);
                //if Email and password fields are exist enter the credentials
                if (Check)
                {
                     //Enter Invalid Email and Pass
                     loginPage.FillEmailAndPassword(props.getProperty("InvalidEmail"),props.getProperty("InvalidPass"));
                     //Check that Login Button at Login screen is displayed and enabled
                     LoginButtonStatus=loginPage.CheckThatLoginButtonIsEnabledAndDisplayed();
                     Comm="Error:Login button at Login screen is either not displayed or disabled";
                     softAssert.assertEquals(LoginButtonStatus,true,Comm);

                     //If login button Displayed and Enabled Click on it
                     if(LoginButtonStatus) {
                     otpPage = loginPage.ClickOnLoginButton(); //click on login button

                    //Check first remaining at login screen
                    // arr = loginPage.CheckBeingAtLoginPage();
                     //if (arr[0].equals("true"))

                        //Check The Presence of Error Message
                        boolean check = loginPage.CheckThePresenceOfErrorMsg();
                        Comm = "Error:No Error Message appears despite entering invalid email and invalid password";
                        softAssert.assertEquals(check, true, Comm);

                        //if the Error box Appears check that it contains the right error message
                        if (check)
                        {
                            String arr1[] = loginPage.CheckErrorText(props.getProperty("LoginErrorMsg_ForWrongCredentials"));
                            Comm = "Error:Error Message is not correct \n" + "Expected Error message : " + arr1[1] + "\nActual Error message :" + arr1[2];
                            softAssert.assertEquals(arr1[0], "true", Comm);

                            //Close Error Box
                            loginPage.CloseErrorBox();
                        }

                       else
                       {
                         //Check if user is navigated to otp screen and if yes an error appears
                         arr = loginPage.CheckBeingAtOTPPage();
                         if(arr[0].equals("true"))//navigated to otp screen
                         {
                             Comm = "Error:Despite entering invalid email and invalid password user is navigated to the OTP screen";
                             softAssert.assertEquals(arr[0], "false", Comm);
                         }

                       }
                }
                }

            }

        }
        softAssert.assertAll();
    }
    @Test(description = "Validation Of logging in with invalid email and valid password",priority =5)
    public void TC_PSA_0005() throws IOException, InterruptedException {

        SoftAssert softAssert=new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        String[] arr = new String[3];

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus=firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm="Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus,true,Comm);

        //If login button Displayed and Enabled Click on it
        if(LoginButtonStatus)
        {
            loginPage=firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            arr=loginPage.CheckBeingAtLoginPage();
            Comm="Error:Clicking on the Login button doesn't navigate to the right page\n"+"Expected URL : "+arr[1]+"\nActual URL :"+arr[2];
            softAssert.assertEquals(arr[0],"true",Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of email and pass field
                Check = loginPage.Is_EmailAndPassFiled_Exist();
                Comm = "Email or pass filed doesn't exist";
                softAssert.assertEquals(Check, true, Comm);

                if (Check)
                {
                    //Enter Invalid Email and Pass
                    loginPage.FillEmailAndPassword(props.getProperty("InvalidEmail"),props.getProperty("ValidPass"));
                    //Check that Login Button at Login screen is displayed and enabled
                    LoginButtonStatus=loginPage.CheckThatLoginButtonIsEnabledAndDisplayed();
                    Comm="Error:Login button at Login screen is either not displayed or disabled";
                    softAssert.assertEquals(LoginButtonStatus,true,Comm);

                    //If login button Displayed and Enabled Click on it
                    if(LoginButtonStatus) {
                        otpPage = loginPage.ClickOnLoginButton(); //click on login button

                        //Check The Presence of Error Message
                        boolean check = loginPage.CheckThePresenceOfErrorMsg();
                        Comm = "Error:No Error Message appears despite entering invalid email and valid password";
                        softAssert.assertEquals(check, true, Comm);

                        //if the Error box Appears check that it contains the right error message
                        if (check)
                        {
                            String arr1[] = loginPage.CheckErrorText(props.getProperty("LoginErrorMsg_ForWrongCredentials"));
                            Comm = "Error:Error Message is not correct \n" + "Expected Error message : " + arr1[1] + "\nActual Error message :" + arr1[2];
                            softAssert.assertEquals(arr1[0], "true", Comm);

                            //Close Error Box
                            loginPage.CloseErrorBox();
                        }

                        else
                        {
                            //Check if user is navigated to otp screen and if yes an error appears
                            arr = loginPage.CheckBeingAtOTPPage();
                            if(arr[0].equals("true"))//navigated to otp screen
                            {
                                Comm = "Error:Despite entering invalid email and valid password user is navigated to the OTP screen";
                                softAssert.assertEquals(arr[0], "false", Comm);
                            }

                        }
                    }
                }

            }

        }
        softAssert.assertAll();
    }
    @Test(description = "Validation Of logging in with valid email and invalid password",priority =6)
    public void TC_PSA_0006() throws IOException, InterruptedException {

        SoftAssert softAssert=new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        String[] arr = new String[3];

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus=firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm="Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus,true,Comm);

        //If login button Displayed and Enabled Click on it
        if(LoginButtonStatus)
        {
            loginPage=firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            arr=loginPage.CheckBeingAtLoginPage();
            Comm="Error:Clicking on the Login button doesn't navigate to the right page\n"+"Expected URL : "+arr[1]+"\nActual URL :"+arr[2];
            softAssert.assertEquals(arr[0],"true",Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of email and pass field
                Check = loginPage.Is_EmailAndPassFiled_Exist();
                Comm = "Email or pass filed doesn't exist";
                softAssert.assertEquals(Check, true, Comm);

                if (Check)
                {
                    //Enter Invalid Email and Pass
                    loginPage.FillEmailAndPassword(props.getProperty("ValidEmail"),props.getProperty("InvalidPass"));
                    //Check that Login Button at Login screen is displayed and enabled
                    LoginButtonStatus=loginPage.CheckThatLoginButtonIsEnabledAndDisplayed();
                    Comm="Error:Login button at Login screen is either not displayed or disabled";
                    softAssert.assertEquals(LoginButtonStatus,true,Comm);

                    //If login button Displayed and Enabled Click on it
                    if(LoginButtonStatus) {
                        otpPage = loginPage.ClickOnLoginButton(); //click on login button

                        //Check The Presence of Error Message
                        boolean check = loginPage.CheckThePresenceOfErrorMsg();
                        Comm = "Error:No Error Message appears despite entering valid email and invalid password";
                        softAssert.assertEquals(check, true, Comm);

                        //if the Error box Appears check that it contains the right error message
                        if (check)
                        {
                            String arr1[] = loginPage.CheckErrorText(props.getProperty("LoginErrorMsg_ForWrongCredentials"));
                            Comm = "Error:Error Message is not correct \n" + "Expected Error message : " + arr1[1] + "\nActual Error message :" + arr1[2];
                            softAssert.assertEquals(arr1[0], "true", Comm);

                            //Close Error Box
                            loginPage.CloseErrorBox();
                        }

                        else
                        {
                            //Check if user is navigated to otp screen and if yes an error appears
                            arr = loginPage.CheckBeingAtOTPPage();
                            if(arr[0].equals("true"))//navigated to otp screen
                            {
                                Comm = "Error:Despite entering valid email and invalid password user is navigated to the OTP screen";
                                softAssert.assertEquals(arr[0], "false", Comm);
                            }

                        }
                    }
                }

            }

        }
        softAssert.assertAll();
    }
    @Test(description = "Validation Of successful logging in message",priority =7)
    public void TC_PSA_0007() throws IOException, InterruptedException {

        SoftAssert softAssert=new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        String[] arr = new String[3];

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus=firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm="Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus,true,Comm);

        //If login button Displayed and Enabled Click on it
        if(LoginButtonStatus)
        {
            loginPage=firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            arr=loginPage.CheckBeingAtLoginPage();
            Comm="Error:Clicking on the Login button doesn't navigate to the right page\n"+"Expected URL : "+arr[1]+"\nActual URL :"+arr[2];
            softAssert.assertEquals(arr[0],"true",Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of email and pass field
                Check = loginPage.Is_EmailAndPassFiled_Exist();
                Comm = "Email or pass filed doesn't exist";
                softAssert.assertEquals(Check, true, Comm);

                if (Check)
                {
                    //Enter Invalid Email and Pass
                    loginPage.FillEmailAndPassword(props.getProperty("ValidEmail"),props.getProperty("ValidPass"));
                    //Check that Login Button at Login screen is displayed and enabled
                    LoginButtonStatus=loginPage.CheckThatLoginButtonIsEnabledAndDisplayed();
                    Comm="Error:Login button at Login screen is either not displayed or disabled";
                    softAssert.assertEquals(LoginButtonStatus,true,Comm);

                    //If login button Displayed and Enabled Click on it
                    if(LoginButtonStatus) {
                        otpPage = loginPage.ClickOnLoginButton(); //click on login button

                        //Check the presence of successfully login message
                        Check=loginPage.CheckThePresenceOfSuccessLoginMsg();
                        Comm="Error: Despite entering correct email and password no successfully login message appears";
                        softAssert.assertEquals(Check,true,Comm);

                    }
                }

            }

        }
        softAssert.assertAll();
    }
    @Test(description = "Validation Of unsuccessful logging in message with reason",priority =8)
    public void TC_PSA_0008() throws IOException, InterruptedException {

        SoftAssert softAssert=new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        String[] arr = new String[3];

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus=firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm="Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus,true,Comm);

        //If login button Displayed and Enabled Click on it
        if(LoginButtonStatus)
        {
            loginPage=firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            arr=loginPage.CheckBeingAtLoginPage();
            Comm="Error:Clicking on the Login button doesn't navigate to the right page\n"+"Expected URL : "+arr[1]+"\nActual URL :"+arr[2];
            softAssert.assertEquals(arr[0],"true",Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of email and pass field
                Check = loginPage.Is_EmailAndPassFiled_Exist();
                Comm = "Email or pass filed doesn't exist";
                softAssert.assertEquals(Check, true, Comm);

                if (Check)
                {
                    //Enter Invalid Email and Pass
                    loginPage.FillEmailAndPassword(props.getProperty("InvalidEmail"),props.getProperty("ValidPass"));
                    //Check that Login Button at Login screen is displayed and enabled
                    LoginButtonStatus=loginPage.CheckThatLoginButtonIsEnabledAndDisplayed();
                    Comm="Error:Login button at Login screen is either not displayed or disabled";
                    softAssert.assertEquals(LoginButtonStatus,true,Comm);

                    //If login button Displayed and Enabled Click on it
                    if(LoginButtonStatus) {
                        otpPage = loginPage.ClickOnLoginButton(); //click on login button

                        //Check The Presence of Error Message
                        boolean check = loginPage.CheckThePresenceOfErrorMsg();
                        Comm = "Error:No Error Message appears despite entering invalid email ";
                        softAssert.assertEquals(check, true, Comm);

                        //if the Error box Appears check that it contains the right error message
                        if (check)
                        {
                            String arr1[] = loginPage.CheckErrorText(props.getProperty("LoginErrorMsg_ForWrongCredentials"));
                            Comm = "Error:Error Message is not correct \n" + "Expected Error message : " + arr1[1] + "\nActual Error message :" + arr1[2];
                            softAssert.assertEquals(arr1[0], "true", Comm);

                            //Close Error Box
                            loginPage.CloseErrorBox();
                        }

                        else
                        {
                            //Check if user is navigated to otp screen and if yes an error appears
                            arr = loginPage.CheckBeingAtOTPPage();
                            if(arr[0].equals("true"))//navigated to otp screen
                            {
                                Comm = "Error:Despite entering invalid email user is navigated to the OTP screen";
                                softAssert.assertEquals(arr[0], "false", Comm);
                            }

                        }

                    }
                }

            }

        }
        softAssert.assertAll();
    }
    @Test(description = "Validation Of logging in with only credential of super admins",priority =9 )
    public void TC_PSA_0009() throws IOException, InterruptedException {

        SoftAssert softAssert=new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        String[] arr = new String[3];

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus=firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm="Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus,true,Comm);

        //If login button Displayed and Enabled Click on it
        if(LoginButtonStatus)
        {
            loginPage=firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            arr=loginPage.CheckBeingAtLoginPage();
            Comm="Error:Clicking on the Login button doesn't navigate to the right page\n"+"Expected URL : "+arr[1]+"\nActual URL :"+arr[2];
            softAssert.assertEquals(arr[0],"true",Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of email and pass field
                Check = loginPage.Is_EmailAndPassFiled_Exist();
                Comm = "Email or pass filed doesn't exist";
                softAssert.assertEquals(Check, true, Comm);

                if (Check)
                {
                    //Enter Email and pass of merchant not super admin
                    loginPage.FillEmailAndPassword(props.getProperty("MerchantEmail"),props.getProperty("MerchantPass"));
                    //Check that Login Button at Login screen is displayed and enabled
                    LoginButtonStatus=loginPage.CheckThatLoginButtonIsEnabledAndDisplayed();
                    Comm="Error:Login button at Login screen is either not displayed or disabled";
                    softAssert.assertEquals(LoginButtonStatus,true,Comm);

                    //If login button Displayed and Enabled Click on it
                    if(LoginButtonStatus) {
                        otpPage = loginPage.ClickOnLoginButton(); //click on login button

                        //Check The Presence of Error Message
                        boolean check = loginPage.CheckThePresenceOfErrorMsg();
                        Comm = "Error:No Error Message appears despite login with merchant credentials on the SA portal";
                        softAssert.assertEquals(check, true, Comm);

                        //if the Error box Appears check that it contains the right error message
                        if (check)
                        {
                            String arr1[] = loginPage.CheckErrorText(props.getProperty("LoginErrorMsg_forLoginWithNotSuperAdminAccount"));
                            Comm = "Error:Error Message is not correct \n" + "Expected Error message : " + arr1[1] + "\nActual Error message :" + arr1[2];
                            softAssert.assertEquals(arr1[0], "true", Comm);

                            //Close Error Box
                            loginPage.CloseErrorBox();
                        }

                        else
                        {
                            //Check if user is navigated to otp screen and if yes an error appears
                            arr = loginPage.CheckBeingAtOTPPage();
                            if(arr[0].equals("true"))//navigated to otp screen
                            {
                                Comm = "Error:Despite login with merchant credentials user is navigated to the OTP screen";
                                softAssert.assertEquals(arr[0], "false", Comm);
                            }

                        }
                    }
                }

            }

        }
        softAssert.assertAll();
    }
    @Test(description = "Validation Of logging in with only credential of super admins not user credentials",priority =9 )
    public void TC_PSA_0009b() throws IOException, InterruptedException {

        SoftAssert softAssert=new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        String[] arr = new String[3];

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus=firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm="Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus,true,Comm);

        //If login button Displayed and Enabled Click on it
        if(LoginButtonStatus)
        {
            loginPage=firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            arr=loginPage.CheckBeingAtLoginPage();
            Comm="Error:Clicking on the Login button doesn't navigate to the right page\n"+"Expected URL : "+arr[1]+"\nActual URL :"+arr[2];
            softAssert.assertEquals(arr[0],"true",Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of email and pass field
                Check = loginPage.Is_EmailAndPassFiled_Exist();
                Comm = "Email or pass filed doesn't exist";
                softAssert.assertEquals(Check, true, Comm);

                if (Check)
                {
                    //Enter Email and pass of merchant not super admin
                    loginPage.FillEmailAndPassword(props.getProperty("UserEmail"),props.getProperty("UserPass"));
                    //Check that Login Button at Login screen is displayed and enabled
                    LoginButtonStatus=loginPage.CheckThatLoginButtonIsEnabledAndDisplayed();
                    Comm="Error:Login button at Login screen is either not displayed or disabled";
                    softAssert.assertEquals(LoginButtonStatus,true,Comm);

                    //If login button Displayed and Enabled Click on it
                    if(LoginButtonStatus) {
                        otpPage = loginPage.ClickOnLoginButton(); //click on login button

                        //Check The Presence of Error Message
                        boolean check = loginPage.CheckThePresenceOfErrorMsg();
                        Comm = "Error:No Error Message appears despite login with user credentials on the SA portal";
                        softAssert.assertEquals(check, true, Comm);

                        //if the Error box Appears check that it contains the right error message
                        if (check)
                        {
                            String arr1[] = loginPage.CheckErrorText(props.getProperty("LoginErrorMsg_forLoginWithNotSuperAdminAccount"));
                            Comm = "Error:Error Message is not correct \n" + "Expected Error message : " + arr1[1] + "\nActual Error message :" + arr1[2];
                            softAssert.assertEquals(arr1[0], "true", Comm);

                            //Close Error Box
                            loginPage.CloseErrorBox();
                        }

                        else
                        {
                            //Check if user is navigated to otp screen and if yes an error appears
                            arr = loginPage.CheckBeingAtOTPPage();
                            if(arr[0].equals("true"))//navigated to otp screen
                            {
                                Comm = "Error:Despite login with user credentials user is navigated to the OTP screen";
                                softAssert.assertEquals(arr[0], "false", Comm);
                            }

                        }
                    }
                }

            }

        }
        softAssert.assertAll();
    }
    @Test(description = "Validation Of logging in with only credential of super admins not supervisor credentials",priority =9 )
    public void TC_PSA_0009c() throws IOException, InterruptedException {

        SoftAssert softAssert=new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        String[] arr = new String[3];

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus=firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm="Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus,true,Comm);

        //If login button Displayed and Enabled Click on it
        if(LoginButtonStatus)
        {
            loginPage=firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            arr=loginPage.CheckBeingAtLoginPage();
            Comm="Error:Clicking on the Login button doesn't navigate to the right page\n"+"Expected URL : "+arr[1]+"\nActual URL :"+arr[2];
            softAssert.assertEquals(arr[0],"true",Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of email and pass field
                Check = loginPage.Is_EmailAndPassFiled_Exist();
                Comm = "Email or pass filed doesn't exist";
                softAssert.assertEquals(Check, true, Comm);

                if (Check)
                {
                    //Enter Email and pass of merchant not super admin
                    loginPage.FillEmailAndPassword(props.getProperty("SupEmail"),props.getProperty("SupPass"));
                    //Check that Login Button at Login screen is displayed and enabled
                    LoginButtonStatus=loginPage.CheckThatLoginButtonIsEnabledAndDisplayed();
                    Comm="Error:Login button at Login screen is either not displayed or disabled";
                    softAssert.assertEquals(LoginButtonStatus,true,Comm);

                    //If login button Displayed and Enabled Click on it
                    if(LoginButtonStatus) {
                        otpPage = loginPage.ClickOnLoginButton(); //click on login button

                        //Check The Presence of Error Message
                        boolean check = loginPage.CheckThePresenceOfErrorMsg();
                        Comm = "Error:No Error Message appears despite login with supervisor credentials on the SA portal";
                        softAssert.assertEquals(check, true, Comm);

                        //if the Error box Appears check that it contains the right error message
                        if (check)
                        {
                            String arr1[] = loginPage.CheckErrorText(props.getProperty("LoginErrorMsg_forLoginWithNotSuperAdminAccount"));
                            Comm = "Error:Error Message is not correct \n" + "Expected Error message : " + arr1[1] + "\nActual Error message :" + arr1[2];
                            softAssert.assertEquals(arr1[0], "true", Comm);

                            //Close Error Box
                            loginPage.CloseErrorBox();
                        }

                        else
                        {
                            //Check if user is navigated to otp screen and if yes an error appears
                            arr = loginPage.CheckBeingAtOTPPage();
                            if(arr[0].equals("true"))//navigated to otp screen
                            {
                                Comm = "Error:Despite login with supervisor credentials user is navigated to the OTP screen";
                                softAssert.assertEquals(arr[0], "false", Comm);
                            }

                        }
                    }
                }

            }

        }
        softAssert.assertAll();
    }

    @Test(description = "Validation Of blocking account after many entering wrong password",priority =10 )
    public void TC_PSA_0010() throws IOException, InterruptedException {

        SoftAssert softAssert=new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        String[] arr = new String[3];

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus=firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm="Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus,true,Comm);

        //If login button Displayed and Enabled Click on it
        if(LoginButtonStatus)
        {
            loginPage=firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            arr=loginPage.CheckBeingAtLoginPage();
            Comm="Error:Clicking on the Login button doesn't navigate to the right page\n"+"Expected URL : "+arr[1]+"\nActual URL :"+arr[2];
            softAssert.assertEquals(arr[0],"true",Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of email and pass field
                Check = loginPage.Is_EmailAndPassFiled_Exist();
                Comm = "Email or pass filed doesn't exist";
                softAssert.assertEquals(Check, true, Comm);

                if (Check)
                {
                    //Enter invalid Email and pass 4 times
                    for (int i=0;i<4;i++)
                    {
                    loginPage.FillEmailAndPassword(props.getProperty("InvalidEmail"),props.getProperty("InvalidPass"));
                    //Check that Login Button at Login screen is displayed and enabled
                    LoginButtonStatus=loginPage.CheckThatLoginButtonIsEnabledAndDisplayed();
                    Comm="Error:Login button at Login screen is either not displayed or disabled";
                    softAssert.assertEquals(LoginButtonStatus,true,Comm);

                    //If login button Displayed and Enabled Click on it
                    if(LoginButtonStatus) {
                        otpPage = loginPage.ClickOnLoginButton(); //click on login button

                        //Check The Presence of Error Message
                        boolean check = loginPage.CheckThePresenceOfErrorMsg();
                        Comm = "Error:No Error Message appears despite login with supervisor credentials on the SA portal";
                        softAssert.assertEquals(check, true, Comm);

                        //if the Error box Appears check that it contains the right error message
                        if (check) {
                            //Close Error Box then clear email and password filed
                            loginPage.CloseErrorBox();
                            loginPage.ClearEmail();
                            loginPage.ClearPass();
                        }
                        else
                        {
                            //Check if user is navigated to otp screen and if yes an error appears
                            arr = loginPage.CheckBeingAtOTPPage();
                            if (arr[0].equals("true"))//navigated to otp screen
                            {
                                Comm = "Error:Despite login with supervisor credentials user is navigated to the OTP screen";
                                softAssert.assertEquals(arr[0], "false", Comm);
                            }

                        }
                    }
                    }
                    //Login with right credentials

                    loginPage.FillEmailAndPassword(props.getProperty("ValidEmail"),props.getProperty("ValidPass"));
                    //Check that Login Button at Login screen is displayed and enabled
                    LoginButtonStatus=loginPage.CheckThatLoginButtonIsEnabledAndDisplayed();
                    Comm="Error:Login button at Login screen is either not displayed or disabled";
                    softAssert.assertEquals(LoginButtonStatus,true,Comm);


                    //If login button Displayed and Enabled Click on it
                    if(LoginButtonStatus) {
                        otpPage = loginPage.ClickOnLoginButton(); //click on login button

                        //Check The Presence of Error Message
                        boolean check = loginPage.CheckThePresenceOfErrorMsg();
                        Comm = "Error:No Error Message appears informing that this account is blocked despite inserting invalid email and password for 4 times";
                        softAssert.assertEquals(check, true, Comm);

                        //if the Error box Appears check that it contains the right error message
                        if (check) {
                            //Close Error Box
                            loginPage.CloseErrorBox();
                        } else {
                            //Check if user is navigated to otp screen and if yes an error appears
                            arr = loginPage.CheckBeingAtOTPPage();
                            if (arr[0].equals("true"))//navigated to otp screen
                            {
                                Comm = "Error:Despite account is supposed to be blocked user is navigated to the OTP screen";
                                softAssert.assertEquals(arr[0], "false", Comm);
                            }
                        }
                    }
                }

            }

        }
        softAssert.assertAll();
    }

    @Test(description = "Validation Of login button",priority =11 )
    public void TC_PSA_0011() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        String[] arr = new String[3];

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus = firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm = "Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus, true, Comm);

        //If login button Displayed and Enabled Click on it
        if (LoginButtonStatus) {
            loginPage = firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            arr = loginPage.CheckBeingAtLoginPage();
            Comm = "Error:Clicking on the Login button doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
            softAssert.assertEquals(arr[0], "true", Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of email and pass field
                Check = loginPage.Is_EmailAndPassFiled_Exist();
                Comm = "Email or pass filed doesn't exist";
                softAssert.assertEquals(Check, true, Comm);

                if (Check) {
                    loginPage.FillEmailAndPassword(props.getProperty("ValidEmail"), props.getProperty("ValidPass"));
                    //Check that Login Button at Login screen is displayed and enabled
                    LoginButtonStatus = loginPage.CheckThatLoginButtonIsEnabledAndDisplayed();
                    Comm = "Error:Login button at Login screen is either not displayed or disabled";
                    softAssert.assertEquals(LoginButtonStatus, true, Comm);

                    //If login button Displayed and Enabled Click on it
                    if (LoginButtonStatus) {
                        otpPage = loginPage.ClickOnLoginButton(); //click on login button

                        //Check navigation to OTP screen
                        arr = loginPage.CheckBeingAtOTPPage();
                        Comm="Error:Clicking on the Login button doesn't navigate to the right page\n"+"Expected URL : "+arr[1]+"\nActual URL :"+arr[2];
                        softAssert.assertEquals(arr[0], "true", Comm);


                    }
                }
            }
        }
        softAssert.assertAll();
    }
    @Test(description = "Validation Of clearing email and password fields every time entering the screen",priority =12)
    public void TC_PSA_0012() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        String[] arr = new String[3];

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus = firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm = "Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus, true, Comm);

        //If login button Displayed and Enabled Click on it
        if (LoginButtonStatus) {
            loginPage = firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            arr = loginPage.CheckBeingAtLoginPage();
            Comm = "Error:Clicking on the Login button doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
            softAssert.assertEquals(arr[0], "true", Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of email and pass field
                Check = loginPage.Is_EmailAndPassFiled_Exist();
                Comm = "Email or pass filed doesn't exist";
                softAssert.assertEquals(Check, true, Comm);

                if (Check) {
                   Check=loginPage.IsEmailAndPassEmpty();
                   Comm="Error:Email and Password filed isn't empty every time entering the screen";
                   softAssert.assertEquals(Check,true,Comm);
                }
            }
        }
        softAssert.assertAll();
    }

}
