package Tests;

import Base.BaseTest;
import Listerners.AllureListener;
import Pages.ForgetPassPage;
import Pages.LoginPage;
import Pages.OTPPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

@Listeners({AllureListener.class})
public class ForgetPassPageTest extends BaseTest {
    String Comm;
    boolean Check;

    @Test(description = "Validation of short message to enter the email registered for this account",priority =13 )
    public void TC_PSA_0013() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        ForgetPassPage forgetPassPage;
        OTPPage otpPage;

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus = firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm = "Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus, true, Comm);

        //If login button Displayed and Enabled Click on it
        if (LoginButtonStatus) {
            loginPage = firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            String arr[] = loginPage.CheckBeingAtLoginPage();
            Comm = "Error:Clicking on the Login button doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
            softAssert.assertEquals(arr[0], "true", Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of ForgetPass Link
                Check=loginPage.CheckPresenceOfForgetPassLink();
                Comm="Forget Password link isn't exist in the login page";
                softAssert.assertEquals(Check,true,Comm);

                //If forget pass link exist click on it and check navigation to the forget pass page
                if(Check)
                {
                    forgetPassPage=loginPage.ClickOnForgetPassLink();
                    //Check navigation to the forget pass page
                    arr=loginPage.CheckBeingAtForgetPassPage();
                    Comm = "Error:Clicking on the Forget Password link doesn't navigate to the forget pass page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
                    softAssert.assertEquals(arr[0], "true", Comm);

                    //If navigated successfully to forget pass page check text in the email filed
                    if (arr[0].equals("true")) {

                        //Check the Presence of email filed
                        Check = forgetPassPage.Is_EmailFiled_Exist();
                        Comm = "Error:Email Field isn't exist in the Forget Pass Page";
                        softAssert.assertEquals(Check, true, Comm);

                        //If Email Field Exist Check the message in the Email filed
                        if (Check)
                        {
                            arr = forgetPassPage.CheckMsgInEmailField();
                            Comm = "Error:The field for entering email hasn't a clear message for entering the email registered for this account\n" + "Expected Msg : " + arr[1] + "\nActual Msg :" + arr[2];
                            softAssert.assertEquals(arr[0], "true", Comm);
                        }
                    }
                }
            }
        }
        softAssert.assertAll();
    }
    @Test(description = "Validation of enter invalid email format",priority =14 )
    public void TC_PSA_0014() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        ForgetPassPage forgetPassPage;
        OTPPage otpPage;

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus = firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm = "Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus, true, Comm);

        //If login button Displayed and Enabled Click on it
        if (LoginButtonStatus) {
            loginPage = firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            String arr[] = loginPage.CheckBeingAtLoginPage();
            Comm = "Error:Clicking on the Login button doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
            softAssert.assertEquals(arr[0], "true", Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of ForgetPass Link
                Check=loginPage.CheckPresenceOfForgetPassLink();
                Comm="Forget Password link isn't exist in the login page";
                softAssert.assertEquals(Check,true,Comm);

                //If forget pass link exist click on it and check navigation to the forget pass page
                if(Check)
                {
                    forgetPassPage=loginPage.ClickOnForgetPassLink();
                    //Check navigation to the forget pass page
                    arr=loginPage.CheckBeingAtForgetPassPage();
                    Comm = "Error:Clicking on the Forget Password link doesn't navigate to the forget pass page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
                    softAssert.assertEquals(arr[0], "true", Comm);

                    //If navigated successfully to forget pass page check text in the email filed
                    if (arr[0].equals("true")) {

                        //Check the Presence of email filed
                        Check = forgetPassPage.Is_EmailFiled_Exist();
                        Comm = "Error:Email Field isn't exist in the Forget Pass Page";
                        softAssert.assertEquals(Check, true, Comm);

                        //If Email Field Exist enter invalid email format
                        if (Check)
                        {
                            String InvalidEmail="m8sbs.com"; //without @
                            forgetPassPage.InsertResetEmail(InvalidEmail);
                            //click on the Send button
                            forgetPassPage.ClickOnTheSendResetEmailButton();

                            //Check the Presence of the error box
                            Check=forgetPassPage.CheckThePresenceOfErrorMsg();
                            Comm="Error:No Error message Appears despite entering an invalid email";
                            softAssert.assertEquals(Check,true,Comm);

                            //If error message appears check its text
                            if (Check)
                            {
                                String ExpectedErrorMsg="Email not correct";
                                arr=forgetPassPage.CheckErrorText(ExpectedErrorMsg);
                                Comm = "The Error Massage of inserting an invalid email isn't as expected\n" + "Expected Msg : " + arr[1] + "\nActual Msg :" + arr[2];
                                softAssert.assertEquals(arr[0], "true", Comm);

                            }

                        }
                    }
                }
            }
        }
        softAssert.assertAll();
    }
    @Test(description = "Validation of the send reset email button",priority =15 )
    public void TC_PSA_0015() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        ForgetPassPage forgetPassPage;
        OTPPage otpPage;

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus = firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm = "Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus, true, Comm);

        //If login button Displayed and Enabled Click on it
        if (LoginButtonStatus) {
            loginPage = firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            String arr[] = loginPage.CheckBeingAtLoginPage();
            Comm = "Error:Clicking on the Login button doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
            softAssert.assertEquals(arr[0], "true", Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of ForgetPass Link
                Check=loginPage.CheckPresenceOfForgetPassLink();
                Comm="Forget Password link isn't exist in the login page";
                softAssert.assertEquals(Check,true,Comm);

                //If forget pass link exist click on it and check navigation to the forget pass page
                if(Check)
                {
                    forgetPassPage=loginPage.ClickOnForgetPassLink();
                    //Check navigation to the forget pass page
                    arr=loginPage.CheckBeingAtForgetPassPage();
                    Comm = "Error:Clicking on the Forget Password link doesn't navigate to the forget pass page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
                    softAssert.assertEquals(arr[0], "true", Comm);

                    //If navigated successfully to forget pass page check text in the email filed
                    if (arr[0].equals("true")) {

                        //Check the Presence of email filed
                        Check = forgetPassPage.Is_EmailFiled_Exist();
                        Comm = "Error:Email Field isn't exist in the Forget Pass Page";
                        softAssert.assertEquals(Check, true, Comm);

                        //If Email Field Exist enter super admin valid email format
                        if (Check)
                        {
                            forgetPassPage.InsertResetEmail(props.getProperty("ValidEmail"));
                            //click on the Send button
                            forgetPassPage.ClickOnTheSendResetEmailButton();

                            //Check the Presence of the successful message box
                            Check=forgetPassPage.CheckThePresenceOfSuccessMsg();
                            Comm="Error:No successful message Appears after clicking on the Send Reset Email button despite entering valid email";
                            softAssert.assertEquals(Check,true,Comm);

                            //If success message appears check its text
                            if (Check)
                            {
                                String ExpectedMsg="Email is sent successfully";
                                arr=forgetPassPage.CheckErrorText(ExpectedMsg);
                                Comm = "The successful sent message isn't as expected\n" + "Expected Msg : " + arr[1] + "\nActual Msg :" + arr[2];
                                softAssert.assertEquals(arr[0], "true", Comm);

                            }

                        }
                    }
                }
            }
        }
        softAssert.assertAll();
    }
    @Test(description = "Validation Of entering old password to login",priority =16,enabled = false)
    public void TC_PSA_0016() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        ForgetPassPage forgetPassPage;
        OTPPage otpPage;

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus = firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm = "Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus, true, Comm);

        //If login button Displayed and Enabled Click on it
        if (LoginButtonStatus) {
            loginPage = firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            String arr[] = loginPage.CheckBeingAtLoginPage();
            Comm = "Error:Clicking on the Login button doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
            softAssert.assertEquals(arr[0], "true", Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of ForgetPass Link
                Check=loginPage.CheckPresenceOfForgetPassLink();
                Comm="Forget Password link isn't exist in the login page";
                softAssert.assertEquals(Check,true,Comm);

                //If forget pass link exist click on it and check navigation to the forget pass page
                if(Check)
                {
                    forgetPassPage=loginPage.ClickOnForgetPassLink();
                    //Check navigation to the forget pass page
                    arr=loginPage.CheckBeingAtForgetPassPage();
                    Comm = "Error:Clicking on the Forget Password link doesn't navigate to the forget pass page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
                    softAssert.assertEquals(arr[0], "true", Comm);

                    //If navigated successfully to forget pass page check text in the email filed
                    if (arr[0].equals("true")) {

                        //Check the Presence of email filed
                        Check = forgetPassPage.Is_EmailFiled_Exist();
                        Comm = "Error:Email Field isn't exist in the Forget Pass Page";
                        softAssert.assertEquals(Check, true, Comm);

                        //If Email Field Exist enter super admin valid email format
                        if (Check)
                        {
                            forgetPassPage.InsertResetEmail(props.getProperty("ValidEmail"));
                            //click on the Send button
                            forgetPassPage.ClickOnTheSendResetEmailButton();

                            //Check the Presence of the successful message box
                            Check=forgetPassPage.CheckThePresenceOfSuccessMsg();
                            Comm="Error:No successful message Appears after clicking on the Send Reset Email button despite entering valid email";
                            softAssert.assertEquals(Check,true,Comm);

                            //If success message appears check its text
                            if (Check)
                            {
                                String ExpectedMsg="Email is sent successfully";
                                arr=forgetPassPage.CheckErrorText(ExpectedMsg);
                                Comm = "The successful sent message isn't as expected\n" + "Expected Msg : " + arr[1] + "\nActual Msg :" + arr[2];
                                softAssert.assertEquals(arr[0], "true", Comm);

                                //Changing Pass Process
                                {

                                }

                                //Navigate back to the login screen
                                driver.navigate().to(props.getProperty("LoginPageURl"));
                                //Enter Email and the old password
                                String OldPass=props.getProperty("ValidPass");
                                loginPage.FillEmailAndPassword(props.getProperty("ValidEmail"),OldPass);
                                loginPage.ClickOnLoginButton();

                                //Check presence of error message
                                Check=loginPage.CheckThePresenceOfErrorMsg();
                                Comm="Error:No Error Message appears Despite login with the old pass after editing it";
                                softAssert.assertEquals(Check,true,Comm);
                                //Check text of error message
                                if (Check)
                                {
                                    String arr1[] = loginPage.CheckErrorText(props.getProperty("LoginErrorMsg_ForWrongCredentials"));
                                    Comm = "Error:Error Message is not correct \n" + "Expected Error message : " + arr1[1] + "\nActual Error message :" + arr1[2];
                                    softAssert.assertEquals(arr1[0], "true", Comm);

                                    //Close Error Box
                                    loginPage.CloseErrorBox();
                                }
                                //Check if user navigated to otp screen or remains at login screen
                                else
                                {
                                    arr=loginPage.CheckBeingAtOTPPage();
                                    Comm = "Error:Despite entering invalid email and invalid password user is navigated to the OTP screen";
                                    softAssert.assertEquals(arr[0], "false", Comm);

                                    //Check remaining at login screen
                                    if(arr[0].equals("false"))//not navigated to otp screen
                                    {
                                        arr=loginPage.CheckBeingAtLoginPage();
                                        Comm = "Error:Despite entering invalid email and invalid password user isn't at login screen";
                                        softAssert.assertEquals(arr[0], "false", Comm);
                                    }
                                }



                            }

                        }
                    }
                }
            }
        }
        softAssert.assertAll();
    }
    @Test(description = "Validation Of entering new password to login",priority =17,enabled = false)
    public void TC_PSA_0017() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        ForgetPassPage forgetPassPage;
        OTPPage otpPage;

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus = firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm = "Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus, true, Comm);

        //If login button Displayed and Enabled Click on it
        if (LoginButtonStatus) {
            loginPage = firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            String arr[] = loginPage.CheckBeingAtLoginPage();
            Comm = "Error:Clicking on the Login button doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
            softAssert.assertEquals(arr[0], "true", Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of ForgetPass Link
                Check=loginPage.CheckPresenceOfForgetPassLink();
                Comm="Forget Password link isn't exist in the login page";
                softAssert.assertEquals(Check,true,Comm);

                //If forget pass link exist click on it and check navigation to the forget pass page
                if(Check)
                {
                    forgetPassPage=loginPage.ClickOnForgetPassLink();
                    //Check navigation to the forget pass page
                    arr=loginPage.CheckBeingAtForgetPassPage();
                    Comm = "Error:Clicking on the Forget Password link doesn't navigate to the forget pass page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
                    softAssert.assertEquals(arr[0], "true", Comm);

                    //If navigated successfully to forget pass page check text in the email filed
                    if (arr[0].equals("true")) {

                        //Check the Presence of email filed
                        Check = forgetPassPage.Is_EmailFiled_Exist();
                        Comm = "Error:Email Field isn't exist in the Forget Pass Page";
                        softAssert.assertEquals(Check, true, Comm);

                        //If Email Field Exist enter super admin valid email format
                        if (Check)
                        {
                            forgetPassPage.InsertResetEmail(props.getProperty("ValidEmail"));
                            //click on the Send button
                            forgetPassPage.ClickOnTheSendResetEmailButton();

                            //Check the Presence of the successful message box
                            Check=forgetPassPage.CheckThePresenceOfSuccessMsg();
                            Comm="Error:No successful message Appears after clicking on the Send Reset Email button despite entering valid email";
                            softAssert.assertEquals(Check,true,Comm);

                            //If success message appears check its text
                            if (Check)
                            {
                                String ExpectedMsg="Email is sent successfully";
                                arr=forgetPassPage.CheckErrorText(ExpectedMsg);
                                Comm = "The successful sent message isn't as expected\n" + "Expected Msg : " + arr[1] + "\nActual Msg :" + arr[2];
                                softAssert.assertEquals(arr[0], "true", Comm);

                                //Changing Pass Process
                                {

                                }

                                //Navigate back to the login screen
                                driver.navigate().to(props.getProperty("LoginPageURl"));
                                //Enter Email and the new password
                                String newPass=props.getProperty("SuperAdminNewPass");
                                loginPage.FillEmailAndPassword(props.getProperty("ValidEmail"),newPass);
                                loginPage.ClickOnLoginButton();

                                //Check if user navigated to otp screen
                                arr=loginPage.CheckBeingAtOTPPage();
                                Comm="Error:Clicking on the Login button doesn't navigate to the right page\n"+"Expected URL : "+arr[1]+"\nActual URL :"+arr[2];
                                softAssert.assertEquals(arr[0],"true",Comm);

                            }

                        }
                    }
                }
            }
        }
        softAssert.assertAll();
    }
    @Test(description = "Validation of go back to login screen button",priority =18)
    public void TC_PSA_0018() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        ForgetPassPage forgetPassPage;
        OTPPage otpPage;

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus = firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm = "Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus, true, Comm);

        //If login button Displayed and Enabled Click on it
        if (LoginButtonStatus) {
            loginPage = firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            String arr[] = loginPage.CheckBeingAtLoginPage();
            Comm = "Error:Clicking on the Login button doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
            softAssert.assertEquals(arr[0], "true", Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of ForgetPass Link
                Check=loginPage.CheckPresenceOfForgetPassLink();
                Comm="Forget Password link isn't exist in the login page";
                softAssert.assertEquals(Check,true,Comm);

                //If forget pass link exist click on it and check navigation to the forget pass page
                if(Check)
                {
                    forgetPassPage=loginPage.ClickOnForgetPassLink();
                    //Check navigation to the forget pass page
                    arr=loginPage.CheckBeingAtForgetPassPage();
                    Comm = "Error:Clicking on the Forget Password link doesn't navigate to the forget pass page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
                    softAssert.assertEquals(arr[0], "true", Comm);

                    //If navigated successfully to forget pass page
                    if (arr[0].equals("true")) {

                        //Back to the login screen
                        driver.navigate().back();
                        //Check navigation to the login screen
                        arr=forgetPassPage.CheckBeingAtLoginPage();
                        Comm="Error:Clicking on the back button doesn't navigate to the right page\n"+"Expected URL : "+arr[1]+"\nActual URL :"+arr[2];
                        softAssert.assertEquals(arr[0],"true",Comm);

                    }
                }
            }
        }
        softAssert.assertAll();
    }
    @Test(description = "Validation of the try to reset a password of an email that doesn't belong to any super admin",priority =19)
    public void TC_PSA_0019() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        ForgetPassPage forgetPassPage;
        OTPPage otpPage;

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus = firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm = "Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus, true, Comm);

        //If login button Displayed and Enabled Click on it
        if (LoginButtonStatus) {
            loginPage = firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            String arr[] = loginPage.CheckBeingAtLoginPage();
            Comm = "Error:Clicking on the Login button doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
            softAssert.assertEquals(arr[0], "true", Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of ForgetPass Link
                Check=loginPage.CheckPresenceOfForgetPassLink();
                Comm="Forget Password link isn't exist in the login page";
                softAssert.assertEquals(Check,true,Comm);

                //If forget pass link exist click on it and check navigation to the forget pass page
                if(Check)
                {
                    forgetPassPage=loginPage.ClickOnForgetPassLink();
                    //Check navigation to the forget pass page
                    arr=loginPage.CheckBeingAtForgetPassPage();
                    Comm = "Error:Clicking on the Forget Password link doesn't navigate to the forget pass page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
                    softAssert.assertEquals(arr[0], "true", Comm);

                    //If navigated successfully to forget pass page check text in the email filed
                    if (arr[0].equals("true")) {

                        //Check the Presence of email filed
                        Check = forgetPassPage.Is_EmailFiled_Exist();
                        Comm = "Error:Email Field isn't exist in the Forget Pass Page";
                        softAssert.assertEquals(Check, true, Comm);

                        //If Email Field Exist enter merchant email
                        if (Check)
                        {
                            forgetPassPage.InsertResetEmail(props.getProperty("MerchantEmail"));
                            //click on the Send button
                            forgetPassPage.ClickOnTheSendResetEmailButton();

                            //Check the Presence of the Error message box
                            Check=forgetPassPage.CheckThePresenceOfErrorMsg();
                            Comm="Error:No Error message Appears after clicking on the Send Reset Email button despite trying to change merchant pass through the super admin portal";
                            softAssert.assertEquals(Check,true,Comm);

                            //If Error message appears check its text
                            if (Check)
                            {
                                String ExpectedMsg="invalid Email";
                                arr=forgetPassPage.CheckErrorText(ExpectedMsg);
                                Comm = "The successful sent message isn't as expected\n" + "Expected Msg : " + arr[1] + "\nActual Msg :" + arr[2];
                                softAssert.assertEquals(arr[0], "true", Comm);

                            }

                        }
                    }
                }
            }
        }
        softAssert.assertAll();
    }
    @Test(description = "Validation of receiving the reset password email",priority =20,enabled = false)
    public void TC_PSA_0020() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        ForgetPassPage forgetPassPage;
        OTPPage otpPage;

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus = firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm = "Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus, true, Comm);

        //If login button Displayed and Enabled Click on it
        if (LoginButtonStatus) {
            loginPage = firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            String arr[] = loginPage.CheckBeingAtLoginPage();
            Comm = "Error:Clicking on the Login button doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
            softAssert.assertEquals(arr[0], "true", Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of ForgetPass Link
                Check=loginPage.CheckPresenceOfForgetPassLink();
                Comm="Forget Password link isn't exist in the login page";
                softAssert.assertEquals(Check,true,Comm);

                //If forget pass link exist click on it and check navigation to the forget pass page
                if(Check)
                {
                    forgetPassPage=loginPage.ClickOnForgetPassLink();
                    //Check navigation to the forget pass page
                    arr=loginPage.CheckBeingAtForgetPassPage();
                    Comm = "Error:Clicking on the Forget Password link doesn't navigate to the forget pass page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
                    softAssert.assertEquals(arr[0], "true", Comm);

                    //If navigated successfully to forget pass page check text in the email filed
                    if (arr[0].equals("true")) {

                        //Check the Presence of email filed
                        Check = forgetPassPage.Is_EmailFiled_Exist();
                        Comm = "Error:Email Field isn't exist in the Forget Pass Page";
                        softAssert.assertEquals(Check, true, Comm);

                        //If Email Field Exist enter merchant email
                        if (Check)
                        {
                            forgetPassPage.InsertResetEmail(props.getProperty("ValidEmail"));
                            //click on the Send button
                            forgetPassPage.ClickOnTheSendResetEmailButton();
                            //Validation of receiving the reset pass link on email
                            {
                                //open email
                                //find the email with subject "Reset Pass"
                                //open it
                                //check the Presence of the Reset pass link
                            }

                        }
                    }
                }
            }
        }
        softAssert.assertAll();
    }
    @Test(description = "Validation of the reset password link ",priority =21,enabled = false)
    public void TC_PSA_0021() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        ForgetPassPage forgetPassPage;
        OTPPage otpPage;

        //Check that Login Button at First screen is displayed and enabled
        boolean LoginButtonStatus = firstPage.CheckThatLoginButtonIsEnabledAndDisplayed();
        Comm = "Error:Login button is either not displayed or disabled";
        softAssert.assertEquals(LoginButtonStatus, true, Comm);

        //If login button Displayed and Enabled Click on it
        if (LoginButtonStatus) {
            loginPage = firstPage.ClickOnLoginButton();
            //Check Navigation to Login Page
            String arr[] = loginPage.CheckBeingAtLoginPage();
            Comm = "Error:Clicking on the Login button doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
            softAssert.assertEquals(arr[0], "true", Comm);

            //if Navigation successfully to Login page
            if (arr[0].equals("true")) {
                //Check presence of the Presence of ForgetPass Link
                Check=loginPage.CheckPresenceOfForgetPassLink();
                Comm="Forget Password link isn't exist in the login page";
                softAssert.assertEquals(Check,true,Comm);

                //If forget pass link exist click on it and check navigation to the forget pass page
                if(Check)
                {
                    forgetPassPage=loginPage.ClickOnForgetPassLink();
                    //Check navigation to the forget pass page
                    arr=loginPage.CheckBeingAtForgetPassPage();
                    Comm = "Error:Clicking on the Forget Password link doesn't navigate to the forget pass page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
                    softAssert.assertEquals(arr[0], "true", Comm);

                    //If navigated successfully to forget pass page check text in the email filed
                    if (arr[0].equals("true")) {

                        //Check the Presence of email filed
                        Check = forgetPassPage.Is_EmailFiled_Exist();
                        Comm = "Error:Email Field isn't exist in the Forget Pass Page";
                        softAssert.assertEquals(Check, true, Comm);

                        //If Email Field Exist enter merchant email
                        if (Check)
                        {
                            forgetPassPage.InsertResetEmail(props.getProperty("ValidEmail"));
                            //click on the Send button
                            forgetPassPage.ClickOnTheSendResetEmailButton();
                            //Validation of the reset pass link
                            {
                                //open email
                                //find the email with subject "Reset Pass"
                                //open it
                                //check the Presence of the Reset pass link
                                //open the reset pass link
                                //check navigation to a page of changing pass
                            }

                        }
                    }
                }
            }
        }
        softAssert.assertAll();
    }
}
