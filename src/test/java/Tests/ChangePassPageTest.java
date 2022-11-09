package Tests;

import Base.BaseTest;
import Pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class ChangePassPageTest extends BaseTest {

    String Comm;
    boolean Check;


    @Test(description = "Validation of request old password to change password",priority =69)
    public void TC_PSA_0069() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        SAdminHomePage sAdminHomePage;
        ProfilePage profilePage;
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

                        //If navigated successfully to OTP page insert letters and numbers in OTP filed
                        if(arr[0].equals("true"))
                        {
                            //Check presence of OTP field
                            Check=otpPage.CheckThePresenceOfOTPFields();
                            Comm="Error:The OTP filed isn't exist";
                            softAssert.assertEquals(Check, true,Comm);

                            //If OTP field exist insert value in it
                            if (Check)
                            {
                                String OTP="111111";
                                otpPage.ClearOTPFields();
                                otpPage.InsertOTP(OTP);
                                //Check that confirm button exist
                                Check=otpPage.CheckThePresenceOfConfirmButton();
                                Comm="Confirm button isn't exist in the OTP Page";
                                softAssert.assertEquals(Check,true,Comm);

                                //if button exist check that its enabled
                                if(Check)
                                {
                                    Check=otpPage.IsConfirmButtonEnabled();
                                    // if button is enabled click on it
                                    if(Check) {
                                        sAdminHomePage=otpPage.ClickOnConfirmButton();
                                        //Check navigation to SA home page
                                        Check=sAdminHomePage.CheckBeingAtSAHomePage();
                                        Comm="Error:Despite entering the right OTP user isn't navigated to the SA Home Page";
                                        softAssert.assertEquals(Check,true,Comm);

                                        //If navigated successfully to SA home page check the Profile button
                                        if (Check)
                                        {
                                            //Check that Profile button exist
                                            Check=sAdminHomePage.CheckPresenceOfProfileButton();
                                            Comm="Error:Profile Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Profile Button exist click on it and then check navigation to the profile Page
                                            if (Check)
                                            {
                                                profilePage=sAdminHomePage.ClickOnProfileButton();
                                                //Check navigation to the Profile screen
                                                String[] arr2=profilePage.CheckBeingAtProfileScreen();
                                                softAssert.assertEquals(arr2[0],"true",arr2[3]);

                                                //if navigated successfully to profile screen check the presence of  the change password button
                                                if(arr2[0].equals("true"))
                                                {
                                                    Check=profilePage.CheckPresenceOfChangePasswordButton();
                                                    Comm="Error:Change Password button isn't exist in profile page";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Change Password button exist click on it and check the presence of change password screen
                                                    if(Check)
                                                    {
                                                        ChangePasswordScreen changePasswordScreen=profilePage.ClickOnChangePassButton();
                                                        //Check Navigation to Change Password screen
                                                        Check=changePasswordScreen.CheckNavigationToChangePassScreen();
                                                        Comm="Error:Despite clicking on change password button doesn't navigate user to change password screen";
                                                        softAssert.assertEquals(Check,true,Comm);

                                                        //if navigated successfully to Change Password screen check the Presence of old password filed
                                                        if (Check)
                                                        {
                                                            Check=changePasswordScreen.CheckPresenceOfOldPassField();
                                                            Comm="Error:Old Password Filed doesn't exist in changePassword screen ";
                                                            softAssert.assertEquals(Check,true,Comm);
                                                        }
                                                    }
                                                }
                                            }
                                        }

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

    @Test(description = "Validation of request new password to change password",priority =72)
    public void TC_PSA_0072() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        SAdminHomePage sAdminHomePage;
        ProfilePage profilePage;
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

                        //If navigated successfully to OTP page insert letters and numbers in OTP filed
                        if(arr[0].equals("true"))
                        {
                            //Check presence of OTP field
                            Check=otpPage.CheckThePresenceOfOTPFields();
                            Comm="Error:The OTP filed isn't exist";
                            softAssert.assertEquals(Check, true,Comm);

                            //If OTP field exist insert value in it
                            if (Check)
                            {
                                String OTP="111111";
                                otpPage.ClearOTPFields();
                                otpPage.InsertOTP(OTP);
                                //Check that confirm button exist
                                Check=otpPage.CheckThePresenceOfConfirmButton();
                                Comm="Confirm button isn't exist in the OTP Page";
                                softAssert.assertEquals(Check,true,Comm);

                                //if button exist check that its enabled
                                if(Check)
                                {
                                    Check=otpPage.IsConfirmButtonEnabled();
                                    // if button is enabled click on it
                                    if(Check) {
                                        sAdminHomePage=otpPage.ClickOnConfirmButton();
                                        //Check navigation to SA home page
                                        Check=sAdminHomePage.CheckBeingAtSAHomePage();
                                        Comm="Error:Despite entering the right OTP user isn't navigated to the SA Home Page";
                                        softAssert.assertEquals(Check,true,Comm);

                                        //If navigated successfully to SA home page check the Profile button
                                        if (Check)
                                        {
                                            //Check that Profile button exist
                                            Check=sAdminHomePage.CheckPresenceOfProfileButton();
                                            Comm="Error:Profile Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Profile Button exist click on it and then check navigation to the profile Page
                                            if (Check)
                                            {
                                                profilePage=sAdminHomePage.ClickOnProfileButton();
                                                //Check navigation to the Profile screen
                                                String[] arr2=profilePage.CheckBeingAtProfileScreen();
                                                softAssert.assertEquals(arr2[0],"true",arr2[3]);

                                                //if navigated successfully to profile screen check the presence of  the change password button
                                                if(arr2[0].equals("true"))
                                                {
                                                    Check=profilePage.CheckPresenceOfChangePasswordButton();
                                                    Comm="Error:Change Password button isn't exist in profile page";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Change Password button exist click on it and check the presence of change password screen
                                                    if(Check)
                                                    {
                                                        ChangePasswordScreen changePasswordScreen=profilePage.ClickOnChangePassButton();
                                                        //Check Navigation to Change Password screen
                                                        Check=changePasswordScreen.CheckNavigationToChangePassScreen();
                                                        Comm="Error:Despite clicking on change password button doesn't navigate user to change password screen";
                                                        softAssert.assertEquals(Check,true,Comm);

                                                        //if navigated successfully to Change Password screen check the Presence of New Password filed
                                                        if (Check)
                                                        {
                                                            Check=changePasswordScreen.CheckPresenceOFNewPassField();
                                                            Comm="Error:New Password Filed doesn't exist in changePassword screen ";
                                                            softAssert.assertEquals(Check,true,Comm);
                                                        }
                                                    }
                                                }
                                            }
                                        }

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

    @Test(description = "Validation of confirm password field matching new password",priority =73)
    public void TC_PSA_0073() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        SAdminHomePage sAdminHomePage;
        ProfilePage profilePage;
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

                        //If navigated successfully to OTP page insert letters and numbers in OTP filed
                        if(arr[0].equals("true"))
                        {
                            //Check presence of OTP field
                            Check=otpPage.CheckThePresenceOfOTPFields();
                            Comm="Error:The OTP filed isn't exist";
                            softAssert.assertEquals(Check, true,Comm);

                            //If OTP field exist insert value in it
                            if (Check)
                            {
                                String OTP="111111";
                                otpPage.ClearOTPFields();
                                otpPage.InsertOTP(OTP);
                                //Check that confirm button exist
                                Check=otpPage.CheckThePresenceOfConfirmButton();
                                Comm="Confirm button isn't exist in the OTP Page";
                                softAssert.assertEquals(Check,true,Comm);

                                //if button exist check that its enabled
                                if(Check)
                                {
                                    Check=otpPage.IsConfirmButtonEnabled();
                                    // if button is enabled click on it
                                    if(Check) {
                                        sAdminHomePage=otpPage.ClickOnConfirmButton();
                                        //Check navigation to SA home page
                                        Check=sAdminHomePage.CheckBeingAtSAHomePage();
                                        Comm="Error:Despite entering the right OTP user isn't navigated to the SA Home Page";
                                        softAssert.assertEquals(Check,true,Comm);

                                        //If navigated successfully to SA home page check the Profile button
                                        if (Check)
                                        {
                                            //Check that Profile button exist
                                            Check=sAdminHomePage.CheckPresenceOfProfileButton();
                                            Comm="Error:Profile Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Profile Button exist click on it and then check navigation to the profile Page
                                            if (Check)
                                            {
                                                profilePage=sAdminHomePage.ClickOnProfileButton();
                                                //Check navigation to the Profile screen
                                                String[] arr2=profilePage.CheckBeingAtProfileScreen();
                                                softAssert.assertEquals(arr2[0],"true",arr2[3]);

                                                //if navigated successfully to profile screen check the presence of  the change password button
                                                if(arr2[0].equals("true"))
                                                {
                                                    Check=profilePage.CheckPresenceOfChangePasswordButton();
                                                    Comm="Error:Change Password button isn't exist in profile page";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Change Password button exist click on it and check the presence of change password screen
                                                    if(Check)
                                                    {
                                                        ChangePasswordScreen changePasswordScreen=profilePage.ClickOnChangePassButton();
                                                        //Check Navigation to Change Password screen
                                                        Check=changePasswordScreen.CheckNavigationToChangePassScreen();
                                                        Comm="Error:Despite clicking on change password button doesn't navigate user to change password screen";
                                                        softAssert.assertEquals(Check,true,Comm);

                                                        //if navigated successfully to Change Password screen check the Presence of NewPass Field and Confirm New Password filed
                                                        if (Check)
                                                        {
                                                            //Check the presence of new pass field
                                                            Check=changePasswordScreen.CheckPresenceOFNewPassField();
                                                            Comm="Error: New Password Filed doesn't exist in changePassword screen ";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //Check the presence of confirm new pass field
                                                            boolean Check2=changePasswordScreen.CheckPresenceOfConfirmNewPassField();
                                                            Comm="Error:Confirm New Password Filed doesn't exist in changePassword screen ";
                                                            softAssert.assertEquals(Check2,true,Comm);

                                                            //if both 2 fields are exist send different pass to them
                                                            if(Check&&Check2)
                                                            {
                                                                changePasswordScreen.EnterNewPass("12345678");
                                                                changePasswordScreen.InsertTheConfirmNewPass("11111111");

                                                                //Check the Presence of change password button
                                                                Check=changePasswordScreen.CheckPresenceOfChangePasswordButton();
                                                                Comm="Error:Change Password button doesn't exist";
                                                                softAssert.assertEquals(Check,true,Comm);

                                                                //If Change Password button exist click on it
                                                                if (Check)
                                                                {
                                                                    changePasswordScreen.ClickOnChangePassButton();

                                                                    //Check the Presence of error Message
                                                                    Check=changePasswordScreen.CheckPresenceOFErrorMsg();
                                                                    Comm="Error:No error message appears however new pass and confirm pass field have different values";
                                                                    softAssert.assertEquals(Check,true,Comm);

                                                                    //if ErrorMessage Appears check the text
                                                                    if(Check)
                                                                    {
                                                                        arr=changePasswordScreen.CheckErrorText(props.getProperty("ChangePassErrorMsg"));
                                                                        Comm = "Error:Error Message is not correct \n" + "Expected Error message : " + arr[1] + "\nActual Error message :" + arr[2];
                                                                        softAssert.assertEquals(arr[0], "true", Comm);
                                                                    }


                                                                }
                                                            }


                                                        }
                                                    }
                                                }
                                            }
                                        }

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

    @Test(description = "Validation of confirm password field matching new password",priority =74)
    public void TC_PSA_0074() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        SAdminHomePage sAdminHomePage;
        ProfilePage profilePage;
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

                        //If navigated successfully to OTP page insert letters and numbers in OTP filed
                        if(arr[0].equals("true"))
                        {
                            //Check presence of OTP field
                            Check=otpPage.CheckThePresenceOfOTPFields();
                            Comm="Error:The OTP filed isn't exist";
                            softAssert.assertEquals(Check, true,Comm);

                            //If OTP field exist insert value in it
                            if (Check)
                            {
                                String OTP="111111";
                                otpPage.ClearOTPFields();
                                otpPage.InsertOTP(OTP);
                                //Check that confirm button exist
                                Check=otpPage.CheckThePresenceOfConfirmButton();
                                Comm="Confirm button isn't exist in the OTP Page";
                                softAssert.assertEquals(Check,true,Comm);

                                //if button exist check that its enabled
                                if(Check)
                                {
                                    Check=otpPage.IsConfirmButtonEnabled();
                                    // if button is enabled click on it
                                    if(Check) {
                                        sAdminHomePage=otpPage.ClickOnConfirmButton();
                                        //Check navigation to SA home page
                                        Check=sAdminHomePage.CheckBeingAtSAHomePage();
                                        Comm="Error:Despite entering the right OTP user isn't navigated to the SA Home Page";
                                        softAssert.assertEquals(Check,true,Comm);

                                        //If navigated successfully to SA home page check the Profile button
                                        if (Check)
                                        {
                                            //Check that Profile button exist
                                            Check=sAdminHomePage.CheckPresenceOfProfileButton();
                                            Comm="Error:Profile Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Profile Button exist click on it and then check navigation to the profile Page
                                            if (Check)
                                            {
                                                profilePage=sAdminHomePage.ClickOnProfileButton();
                                                //Check navigation to the Profile screen
                                                String[] arr2=profilePage.CheckBeingAtProfileScreen();
                                                softAssert.assertEquals(arr2[0],"true",arr2[3]);

                                                //if navigated successfully to profile screen check the presence of  the change password button
                                                if(arr2[0].equals("true"))
                                                {
                                                    Check=profilePage.CheckPresenceOfChangePasswordButton();
                                                    Comm="Error:Change Password button isn't exist in profile page";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Change Password button exist click on it and check the presence of change password screen
                                                    if(Check)
                                                    {
                                                        ChangePasswordScreen changePasswordScreen=profilePage.ClickOnChangePassButton();
                                                        //Check Navigation to Change Password screen
                                                        Check=changePasswordScreen.CheckNavigationToChangePassScreen();
                                                        Comm="Error:Despite clicking on change password button doesn't navigate user to change password screen";
                                                        softAssert.assertEquals(Check,true,Comm);

                                                        //if navigated successfully to Change Password screen check the Presence of NewPass Field and Confirm New Password filed
                                                        if (Check)
                                                        {
                                                            //Check the presence of new pass field
                                                            Check=changePasswordScreen.CheckPresenceOFNewPassField();
                                                            Comm="Error: New Password Filed doesn't exist in changePassword screen ";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //Check the presence of confirm new pass field
                                                            boolean Check2=changePasswordScreen.CheckPresenceOfConfirmNewPassField();
                                                            Comm="Error:Confirm New Password Filed doesn't exist in changePassword screen ";
                                                            softAssert.assertEquals(Check2,true,Comm);

                                                            //if both 2 fields are exist send same pass to them
                                                            if(Check&&Check2)
                                                            {
                                                                String NewPass="12345678";
                                                                changePasswordScreen.EnterNewPass(NewPass);
                                                                changePasswordScreen.InsertTheConfirmNewPass(NewPass);

                                                                //Check the Presence of change password button
                                                                Check=changePasswordScreen.CheckPresenceOfChangePasswordButton();
                                                                Comm="Error:Change Password button doesn't exist";
                                                                softAssert.assertEquals(Check,true,Comm);

                                                                //If Change Password button exist click on it
                                                                if (Check)
                                                                {
                                                                    boolean ChangePassDone=false;
                                                                    profilePage=changePasswordScreen.ClickOnChangePassButton();

                                                                    //Check that Change password screen is closed
                                                                    Check=changePasswordScreen.CheckPresenceOfChangePassScreen();
                                                                    Comm="Error:Despite clicking on change pass button the Change Password screen is still open";
                                                                    softAssert.assertEquals(Check,false,Comm);
                                                                    if (!Check) ChangePassDone=true;

                                                                    //if Change Password screen is open checkPresence of API message if yes get the text of error
                                                                    if(Check)
                                                                    {
                                                                        Check=changePasswordScreen.CheckPresenceOfAPIError();
                                                                        if(Check)
                                                                        {
                                                                            Comm="The API Error message "+"\" "+changePasswordScreen.GetErrorText()+"\""+" appears";
                                                                        }
                                                                        softAssert.assertEquals(Check,false,Comm);
                                                                    }

                                                                    //if password is changed successfully navigate to login screen
                                                                    if (ChangePassDone)
                                                                    {
                                                                        driver.navigate().to(props.getProperty("LoginPageURl"));
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
                                                                                //Login with the new pass
                                                                                loginPage.FillEmailAndPassword(props.getProperty("ValidEmail"), NewPass);
                                                                                //Check that Login Button at Login screen is displayed and enabled
                                                                                LoginButtonStatus = loginPage.CheckThatLoginButtonIsEnabledAndDisplayed();
                                                                                Comm = "Error:Login button at Login screen is either not displayed or disabled";
                                                                                softAssert.assertEquals(LoginButtonStatus, true, Comm);

                                                                                //If login button Displayed and Enabled Click on it
                                                                                if (LoginButtonStatus) {
                                                                                    otpPage = loginPage.ClickOnLoginButton(); //click on login button

                                                                                    //Check if user is navigated to otp screen
                                                                                    arr = loginPage.CheckBeingAtOTPPage();
                                                                                    Comm = "Error:User isn't navigated to Otp screen if he login with the new pass";
                                                                                    softAssert.assertEquals(arr[0], "true", Comm);

                                                                                    //if not navigated to otp screen check presence of error message
                                                                                    if (arr[0].equals("false"))
                                                                                    {
                                                                                        //Check The Presence of Error Message
                                                                                        boolean check = loginPage.CheckThePresenceOfErrorMsg();
                                                                                        Comm = "Error:A login Error Message appears when login with the new pass";
                                                                                        softAssert.assertEquals(check, false, Comm);
                                                                                    }
                                                                                }

                                                                            }
                                                                        }

                                                                    }
                                                                }
                                                            }


                                                        }
                                                    }
                                                }
                                            }
                                        }

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

    @Test(description = "Validation of expired old password after change password",priority =75)
    public void TC_PSA_0075() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        SAdminHomePage sAdminHomePage;
        ProfilePage profilePage;
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

                        //If navigated successfully to OTP page insert letters and numbers in OTP filed
                        if(arr[0].equals("true"))
                        {
                            //Check presence of OTP field
                            Check=otpPage.CheckThePresenceOfOTPFields();
                            Comm="Error:The OTP filed isn't exist";
                            softAssert.assertEquals(Check, true,Comm);

                            //If OTP field exist insert value in it
                            if (Check)
                            {
                                String OTP="111111";
                                otpPage.ClearOTPFields();
                                otpPage.InsertOTP(OTP);
                                //Check that confirm button exist
                                Check=otpPage.CheckThePresenceOfConfirmButton();
                                Comm="Confirm button isn't exist in the OTP Page";
                                softAssert.assertEquals(Check,true,Comm);

                                //if button exist check that its enabled
                                if(Check)
                                {
                                    Check=otpPage.IsConfirmButtonEnabled();
                                    // if button is enabled click on it
                                    if(Check) {
                                        sAdminHomePage=otpPage.ClickOnConfirmButton();
                                        //Check navigation to SA home page
                                        Check=sAdminHomePage.CheckBeingAtSAHomePage();
                                        Comm="Error:Despite entering the right OTP user isn't navigated to the SA Home Page";
                                        softAssert.assertEquals(Check,true,Comm);

                                        //If navigated successfully to SA home page check the Profile button
                                        if (Check)
                                        {
                                            //Check that Profile button exist
                                            Check=sAdminHomePage.CheckPresenceOfProfileButton();
                                            Comm="Error:Profile Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Profile Button exist click on it and then check navigation to the profile Page
                                            if (Check)
                                            {
                                                profilePage=sAdminHomePage.ClickOnProfileButton();
                                                //Check navigation to the Profile screen
                                                String[] arr2=profilePage.CheckBeingAtProfileScreen();
                                                softAssert.assertEquals(arr2[0],"true",arr2[3]);

                                                //if navigated successfully to profile screen check the presence of  the change password button
                                                if(arr2[0].equals("true"))
                                                {
                                                    Check=profilePage.CheckPresenceOfChangePasswordButton();
                                                    Comm="Error:Change Password button isn't exist in profile page";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Change Password button exist click on it and check the presence of change password screen
                                                    if(Check)
                                                    {
                                                        ChangePasswordScreen changePasswordScreen=profilePage.ClickOnChangePassButton();
                                                        //Check Navigation to Change Password screen
                                                        Check=changePasswordScreen.CheckNavigationToChangePassScreen();
                                                        Comm="Error:Despite clicking on change password button doesn't navigate user to change password screen";
                                                        softAssert.assertEquals(Check,true,Comm);

                                                        //if navigated successfully to Change Password screen check the Presence of NewPass Field and Confirm New Password filed
                                                        if (Check)
                                                        {
                                                            //Check the presence of new pass field
                                                            Check=changePasswordScreen.CheckPresenceOFNewPassField();
                                                            Comm="Error: New Password Filed doesn't exist in changePassword screen ";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //Check the presence of confirm new pass field
                                                            boolean Check2=changePasswordScreen.CheckPresenceOfConfirmNewPassField();
                                                            Comm="Error:Confirm New Password Filed doesn't exist in changePassword screen ";
                                                            softAssert.assertEquals(Check2,true,Comm);

                                                            //if both 2 fields are exist send same pass to them
                                                            if(Check&&Check2)
                                                            {
                                                                String NewPass="abcdefgh";
                                                                changePasswordScreen.EnterNewPass(NewPass);
                                                                changePasswordScreen.InsertTheConfirmNewPass(NewPass);

                                                                //Check the Presence of change password button
                                                                Check=changePasswordScreen.CheckPresenceOfChangePasswordButton();
                                                                Comm="Error:Change Password button doesn't exist";
                                                                softAssert.assertEquals(Check,true,Comm);

                                                                //If Change Password button exist click on it
                                                                if (Check)
                                                                {
                                                                    boolean ChangePassDone=false;
                                                                    profilePage=changePasswordScreen.ClickOnChangePassButton();

                                                                    //Check that Change password screen is closed
                                                                    Check=changePasswordScreen.CheckPresenceOfChangePassScreen();
                                                                    Comm="Error:Despite clicking on change pass button the Change Password screen is still open";
                                                                    softAssert.assertEquals(Check,false,Comm);
                                                                    if (!Check) ChangePassDone=true;

                                                                    //if Change Password screen is open checkPresence of API message if yes get the text of error
                                                                    if(Check)
                                                                    {
                                                                        Check=changePasswordScreen.CheckPresenceOfAPIError();
                                                                        if(Check)
                                                                        {
                                                                            Comm="The API Error message "+"\" "+changePasswordScreen.GetErrorText()+"\""+" appears";
                                                                        }
                                                                        softAssert.assertEquals(Check,false,Comm);
                                                                    }

                                                                    //if password is changed successfully navigate to login screen
                                                                    if (ChangePassDone)
                                                                    {
                                                                        driver.navigate().to(props.getProperty("LoginPageURl"));
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
                                                                                //Login with the Old pass
                                                                                loginPage.FillEmailAndPassword(props.getProperty("ValidEmail"), props.getProperty("ValidPass"));
                                                                                //Check that Login Button at Login screen is displayed and enabled
                                                                                LoginButtonStatus = loginPage.CheckThatLoginButtonIsEnabledAndDisplayed();
                                                                                Comm = "Error:Login button at Login screen is either not displayed or disabled";
                                                                                softAssert.assertEquals(LoginButtonStatus, true, Comm);

                                                                                //If login button Displayed and Enabled Click on it
                                                                                if (LoginButtonStatus) {
                                                                                    otpPage = loginPage.ClickOnLoginButton(); //click on login button

                                                                                    //Check The Presence of Error Message
                                                                                    boolean check = loginPage.CheckThePresenceOfErrorMsg();
                                                                                    Comm = "Error:No Error Message appears despite entering the old pass ";
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
                                                                                            Comm = "Error:Despite entering the Old user is navigated to the OTP screen";
                                                                                            softAssert.assertEquals(arr[0], "false", Comm);
                                                                                        }

                                                                                    }
                                                                                }
                                                                            }
                                                                        }

                                                                    }
                                                                }
                                                            }


                                                        }
                                                    }
                                                }
                                            }
                                        }

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

    @Test(description = "Validation of login with new password",priority =76)
    public void TC_PSA_0076() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        SAdminHomePage sAdminHomePage;
        ProfilePage profilePage;
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

                        //If navigated successfully to OTP page insert letters and numbers in OTP filed
                        if(arr[0].equals("true"))
                        {
                            //Check presence of OTP field
                            Check=otpPage.CheckThePresenceOfOTPFields();
                            Comm="Error:The OTP filed isn't exist";
                            softAssert.assertEquals(Check, true,Comm);

                            //If OTP field exist insert value in it
                            if (Check)
                            {
                                String OTP="111111";
                                otpPage.ClearOTPFields();
                                otpPage.InsertOTP(OTP);
                                //Check that confirm button exist
                                Check=otpPage.CheckThePresenceOfConfirmButton();
                                Comm="Confirm button isn't exist in the OTP Page";
                                softAssert.assertEquals(Check,true,Comm);

                                //if button exist check that its enabled
                                if(Check)
                                {
                                    Check=otpPage.IsConfirmButtonEnabled();
                                    // if button is enabled click on it
                                    if(Check) {
                                        sAdminHomePage=otpPage.ClickOnConfirmButton();
                                        //Check navigation to SA home page
                                        Check=sAdminHomePage.CheckBeingAtSAHomePage();
                                        Comm="Error:Despite entering the right OTP user isn't navigated to the SA Home Page";
                                        softAssert.assertEquals(Check,true,Comm);

                                        //If navigated successfully to SA home page check the Profile button
                                        if (Check)
                                        {
                                            //Check that Profile button exist
                                            Check=sAdminHomePage.CheckPresenceOfProfileButton();
                                            Comm="Error:Profile Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Profile Button exist click on it and then check navigation to the profile Page
                                            if (Check)
                                            {
                                                profilePage=sAdminHomePage.ClickOnProfileButton();
                                                //Check navigation to the Profile screen
                                                String[] arr2=profilePage.CheckBeingAtProfileScreen();
                                                softAssert.assertEquals(arr2[0],"true",arr2[3]);

                                                //if navigated successfully to profile screen check the presence of  the change password button
                                                if(arr2[0].equals("true"))
                                                {
                                                    Check=profilePage.CheckPresenceOfChangePasswordButton();
                                                    Comm="Error:Change Password button isn't exist in profile page";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Change Password button exist click on it and check the presence of change password screen
                                                    if(Check)
                                                    {
                                                        ChangePasswordScreen changePasswordScreen=profilePage.ClickOnChangePassButton();
                                                        //Check Navigation to Change Password screen
                                                        Check=changePasswordScreen.CheckNavigationToChangePassScreen();
                                                        Comm="Error:Despite clicking on change password button doesn't navigate user to change password screen";
                                                        softAssert.assertEquals(Check,true,Comm);

                                                        //if navigated successfully to Change Password screen check the Presence of NewPass Field and Confirm New Password filed
                                                        if (Check)
                                                        {
                                                            //Check the presence of new pass field
                                                            Check=changePasswordScreen.CheckPresenceOFNewPassField();
                                                            Comm="Error: New Password Filed doesn't exist in changePassword screen ";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //Check the presence of confirm new pass field
                                                            boolean Check2=changePasswordScreen.CheckPresenceOfConfirmNewPassField();
                                                            Comm="Error:Confirm New Password Filed doesn't exist in changePassword screen ";
                                                            softAssert.assertEquals(Check2,true,Comm);

                                                            //if both 2 fields are exist send same pass to them
                                                            if(Check&&Check2)
                                                            {
                                                                String NewPass="abcdefgh";
                                                                changePasswordScreen.EnterNewPass(NewPass);
                                                                changePasswordScreen.InsertTheConfirmNewPass(NewPass);

                                                                //Check the Presence of change password button
                                                                Check=changePasswordScreen.CheckPresenceOfChangePasswordButton();
                                                                Comm="Error:Change Password button doesn't exist";
                                                                softAssert.assertEquals(Check,true,Comm);

                                                                //If Change Password button exist click on it
                                                                if (Check)
                                                                {
                                                                    boolean ChangePassDone=false;
                                                                    profilePage=changePasswordScreen.ClickOnChangePassButton();

                                                                    //Check that Change password screen is closed
                                                                    Check=changePasswordScreen.CheckPresenceOfChangePassScreen();
                                                                    Comm="Error:Despite clicking on change pass button the Change Password screen is still open";
                                                                    softAssert.assertEquals(Check,false,Comm);
                                                                    if (!Check) ChangePassDone=true;

                                                                    //if Change Password screen is open checkPresence of API message if yes get the text of error
                                                                    if(Check)
                                                                    {
                                                                        Check=changePasswordScreen.CheckPresenceOfAPIError();
                                                                        if(Check)
                                                                        {
                                                                            Comm="The API Error message "+"\" "+changePasswordScreen.GetErrorText()+"\""+" appears";
                                                                        }
                                                                        softAssert.assertEquals(Check,false,Comm);
                                                                    }


                                                                    //if password is changed successfully navigate to login screen
                                                                    if (ChangePassDone)
                                                                    {
                                                                        driver.navigate().to(props.getProperty("LoginPageURl"));
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
                                                                                //if email and pass fields exist login with old pass
                                                                                loginPage.FillEmailAndPassword(props.getProperty("ValidEmail"), NewPass);
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
                                                                                    //if not navigated to OTP Page check remaining at Login page and the Presence of non-correct credentials msg
                                                                                    if (arr[0].equals("false"))
                                                                                    {
                                                                                       arr=loginPage.CheckBeingAtLoginPage();
                                                                                       if(arr[0].equals("true"))
                                                                                       {
                                                                                           //Check The Presence of Error Message
                                                                                           boolean check = loginPage.CheckThePresenceOfErrorMsg();
                                                                                           Comm = "Error:Error Message appears when login with the new pass ";
                                                                                           softAssert.assertNotEquals(check, true, Comm);

                                                                                       }
                                                                                    }

                                                                                }
                                                                            }
                                                                        }

                                                                    }
                                                                }
                                                            }


                                                        }
                                                    }
                                                }
                                            }
                                        }

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



}
