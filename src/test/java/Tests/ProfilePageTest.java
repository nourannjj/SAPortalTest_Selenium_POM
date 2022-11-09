package Tests;

import Base.BaseTest;
import Pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class ProfilePageTest extends BaseTest {
    String Comm;
    boolean Check;

    @Test(description = "Validation of editing superadmin information",priority =65)
    public void TC_PSA_0065() throws IOException, InterruptedException {

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

                                                //if navigated successfully to profile screen check the presence of Editing super admin information button
                                                if(arr2[0].equals("true"))
                                                {
                                                   Check=profilePage.CheckPresenceOfEditSuperAdminInformationButton();
                                                   Comm="Error:Editing Super Admin information isn't supported option";
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
        softAssert.assertAll();
    }
    @Test(description = "Validation of change password button action",priority =66)
    public void TC_PSA_0066() throws IOException, InterruptedException {

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
                                                        Check=changePasswordScreen.CheckNavigationToChangePassScreen();
                                                        Comm="Error:Despite clicking on change password button doesn't navigate user to change password screen";
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
        softAssert.assertAll();
    }

    @Test(description = "Validate password field does not show password",priority =67)
    public void TC_PSA_0067() throws IOException, InterruptedException {

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
                                                        Check=changePasswordScreen.CheckNavigationToChangePassScreen();
                                                        Comm="Error:Despite clicking on change password button doesn't navigate user to change password screen";
                                                        softAssert.assertEquals(Check,true,Comm);

                                                        //If navigated successfully to Change pass screen Check Presence of New Password Field and Confirm new pass field
                                                        if(Check)
                                                        {
                                                            Check = changePasswordScreen.CheckPresenceOFNewPassField();
                                                            Comm = "Error:New Password Field isn't exist";
                                                            softAssert.assertEquals(Check, true, Comm);
                                                            //if New pass field is existed type text in it then read the typed text then check whether it "******" or not
                                                            if(Check)
                                                            {
                                                                String newPass="123456";
                                                                changePasswordScreen.EnterNewPass(newPass);
                                                                String ActualNewPass=changePasswordScreen.ReadTypedDataInNewPassField();
                                                                Comm="Error:Password in the New Password Field isn't at the \"******\" format ";
                                                                softAssert.assertEquals(ActualNewPass,"******",Comm);
                                                                Comm="Error:Password in the New Password Field isn't encrypted";
                                                                softAssert.assertNotEquals(ActualNewPass,newPass,Comm);

                                                            }

                                                            Check = changePasswordScreen.CheckPresenceOfConfirmNewPassField();
                                                            Comm = "Error:Confirm New Password Field isn't exist";
                                                            softAssert.assertEquals(Check, true, Comm);
                                                            //if Confirm New pass field is existed type text in it then read the typed text then check whether it "******" or not
                                                            if(Check)
                                                            {
                                                                String ConfirmNewPass="123456";
                                                                changePasswordScreen.InsertTheConfirmNewPass(ConfirmNewPass);
                                                                String ActualNewPass=changePasswordScreen.ReadTypedDataInConfirmNewPassField();
                                                                Comm="Error:Password in the Confirm New Password Field isn't at the \"******\" format ";
                                                                softAssert.assertEquals(ActualNewPass,"******",Comm);
                                                                Comm="Error:Password in the Confirm New Password Field isn't encrypted";
                                                                softAssert.assertNotEquals(ActualNewPass,ConfirmNewPass,Comm);

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
    @Test(description = "Validation of change password button action",priority =68)
    public void TC_PSA_0068() throws IOException, InterruptedException {

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

                                                //if navigated successfully to profile screen check the presence of Logout button
                                                if(arr2[0].equals("true"))
                                                {
                                                    Check=profilePage.CheckPresenceOfLogoutButton();
                                                    Comm="Error:Logout Button doesn't exist in profile page";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if logout button exist click on it and check navigation to Login page
                                                    if(Check)
                                                    {
                                                        firstPage=profilePage.ClickOnLogoutButton();
                                                        //Check Navigation to First Page
                                                        Check = firstPage.CheckNavigationToFirstPage();
                                                        Comm = "Error:Clicking on the Logout button at profile screen doesn't navigate to the right page" ;
                                                        softAssert.assertEquals(Check,true, Comm);
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
