package Tests;

import Base.BaseTest;
import Pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class CreateMerchantScreenTest extends BaseTest {

    String Comm;
    boolean Check;
    @Test(description = "Validation of Entering merchant name",priority =80)
    public void TC_PSA_0080() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen check the presence of merchant name field
                                                if(Check)
                                                {
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:the Merchant name filed doesn't exist in Create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Merchant name field exist insert data in it then check that data is typed successfully by reading the data in that field
                                                    if (Check)
                                                    {
                                                        createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName"));
                                                        String ActualMerchantName=createNewMerchantPage.ReadDataInMerchantNameField();
                                                        Comm="Error:The Data Typed in merchant name filed is wrong"+"\n"+"Expected Name is: "+props.getProperty("NewMerchantName")+"\n"+"Actual Name is: "+ActualMerchantName;
                                                        softAssert.assertEquals(ActualMerchantName,props.getProperty("NewMerchantName"),Comm);
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
    @Test(description = "Validation of Entering Unique Merchant Code",priority =81)
    public void TC_PSA_0081() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen check the presence of merchant code field
                                                if(Check)
                                                {
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:the Merchant Code filed doesn't exist in Create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Merchant code field exist insert data in it then check that data is typed successfully by reading the data in that field
                                                    if (Check)
                                                    {
                                                        createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode"));
                                                        String ActualMerchantCode=createNewMerchantPage.ReadDataInMerchantCodeField();
                                                        Comm="Error:The Data Typed in merchant Code filed is wrong"+"\n"+"Expected Code is: "+props.getProperty("NewMerchantCode")+"\n"+"Actual Code is: "+ActualMerchantCode;
                                                        softAssert.assertEquals(ActualMerchantCode,props.getProperty("NewMerchantCode"),Comm);
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
    @Test(description = "Validation of Entering Merchant Email",priority =82)
    public void TC_PSA_0082() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen check the presence of merchant Email field
                                                if(Check)
                                                {
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:the Merchant Email filed doesn't exist in Create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Merchant Email field exist insert data in it then check that data is typed successfully by reading the data in that field
                                                    if (Check)
                                                    {
                                                        String ExpectedMerchantEmail="NewMerchant@sbs.com";
                                                        createNewMerchantPage.InsertMerchantEmail(ExpectedMerchantEmail);
                                                        String ActualMerchantEmail=createNewMerchantPage.ReadDataInMerchantEmailField();
                                                        Comm="Error:The Data Typed in merchant Email filed is wrong"+"\n"+"Expected Email is: "+ExpectedMerchantEmail+"\n"+"Actual Email is: "+ActualMerchantEmail;
                                                        softAssert.assertEquals(ActualMerchantEmail,ExpectedMerchantEmail,Comm);
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
    @Test(description = "Validation of adding an existing Email used before for another merchant",priority =83)
    public void TC_PSA_0083() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen Insert all merchant information but use insert a previously used Merchant Email
                                                if(Check)
                                                {
                                                    boolean TotalCheck=true;

                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert a previously used Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("UsedEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if  Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //If all fields exist click on the next button
                                                    if(TotalCheck)
                                                    {
                                                        SchemeScreen schemeScreen=createNewMerchantPage.ClickOnNextButton();
                                                        //Check the Presence of scheme screen
                                                        Check=schemeScreen.CheckPresenceOfChooseSchemePriorityScreen();
                                                        Comm="Error:Clicking on next button doesn't navigate to scheme screen";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if navigated successfully to scheme screen Choose random scheme arrangement
                                                        if(Check)
                                                        {
                                                            schemeScreen.ChooseSchemeArrangement();
                                                        }
                                                        //Click on create button then check presence of usedEmail error message
                                                        schemeScreen.ClickOnCreateButton();
                                                        //check presence of usedEmail error message
                                                        Check=schemeScreen.CheckPresenceOfPreviouslyUsedDatErrorMessage();
                                                        Comm="NO Error message appears despite creating a new merchant with a previously used Email";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //Check the Text of the Message
                                                        if(Check)
                                                        {
                                                            String ActualMsg=schemeScreen.GetTextOfErrorMsg();
                                                            String ExpectedMsg=props.getProperty("AnAlreadyExistEmailMsg");
                                                            Comm="Error:The Error Msg isn't as expected";
                                                            softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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

    @Test(description = "Validation of creating a merchant with the same data used previously but with the change of only the data that caused the duplicate error",priority =84)
    public void TC_PSA_0084() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen Insert all merchant information but use insert a previously used Merchant Email
                                                if(Check)
                                                {
                                                    boolean TotalCheck=true;

                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert a previously used Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if  Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //If all fields exist click on the next button
                                                    if(TotalCheck)
                                                    {
                                                        SchemeScreen schemeScreen=createNewMerchantPage.ClickOnNextButton();
                                                        //Check the Presence of scheme screen
                                                        Check=schemeScreen.CheckPresenceOfChooseSchemePriorityScreen();
                                                        Comm="Error:Clicking on next button doesn't navigate to scheme screen";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if navigated successfully to scheme screen Choose random scheme arrangement
                                                        if(Check)
                                                        {
                                                            schemeScreen.ChooseSchemeArrangement();
                                                        }
                                                        //Click on create button then check presence table of merchants
                                                        sAdminHomePage=schemeScreen.ClickOnCreateButton();
                                                        //check presence table of merchants
                                                        Check=sAdminHomePage.CheckPresenceOfTableOfMerchants();
                                                        Comm="Error:Table of Merchants isn't visible after click on create button";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //Check the Presence of created merchant in merchant table
                                                        SAdminHomePage.MerchantDetails merchantDetails=sAdminHomePage.GetaSpecificMerchantFromMerchantTable(props.getProperty("NewMerchantName"));
                                                        Comm="Error:The Created merchant"+props.getProperty("NewMerchantName")+" isn't added to the table of merchants";
                                                        softAssert.assertNotNull(merchantDetails,Comm);
                                                        //if Merchant exist check its data
                                                        String Date=sAdminHomePage.GetDateOfSystem();
                                                        SAdminHomePage.NotCorrectMerchantData[] notCorrectMerchantFields=sAdminHomePage.CheckThatMerchantDataIsRight(props.getProperty("NewMerchantName"),props.getProperty("NewMerchantCode"),Date,props.getProperty("NewMerchantCountry"),props.getProperty("NewMerchantCity"),props.getProperty("NewMerchantPhone_MerchantTable"),props.getProperty("BusinessCategoty"),props.getProperty("CurrencyCode"),props.getProperty("MerchantTSN"),props.getProperty("TerminalsCount"),props.getProperty("NewMerchantStatus"));
                                                        //if There are not-correct filed
                                                        int NumberOfNotCorrectFields=notCorrectMerchantFields.length;
                                                        Comm="";
                                                        for(int i=0;i<NumberOfNotCorrectFields;i++) {
                                                            Comm =Comm+ notCorrectMerchantFields[i].FiledName+"contains wrong data"+"\t"+"Expected:"+notCorrectMerchantFields[i].Expected+"\t"+"Actual:"+notCorrectMerchantFields[i].Actual+"\n";
                                                        }
                                                        softAssert.assertEquals(NumberOfNotCorrectFields,0,Comm);

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
    @Test(description = "Validation of choosing Merchant country",priority =85)
    public void TC_PSA_0085() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen check the presence of merchant country field
                                                if(Check)
                                                {
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:the Merchant Country filed doesn't exist in Create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Merchant Country field exist insert data in it then check that data is typed successfully by reading the data in that field
                                                    if (Check)
                                                    {
                                                        String ExpectedMerchantCountry="Egypt";
                                                        createNewMerchantPage.ChooseCountry(ExpectedMerchantCountry);
                                                        String ActualMerchantCountry=createNewMerchantPage.ReadDataInMerchantCountryField();
                                                        Comm="Error:The Data Typed in merchant Country filed is wrong"+"\n"+"Expected Country is: "+ExpectedMerchantCountry+"\n"+"Actual Country is: "+ActualMerchantCountry;
                                                        softAssert.assertEquals(ActualMerchantCountry,ExpectedMerchantCountry,Comm);
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
    @Test(description = "Validation of choosing Merchant city",priority =86)
    public void TC_PSA_0086() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen check the presence of merchant City field
                                                if(Check)
                                                {
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:the Merchant City filed doesn't exist in Create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Merchant City field exist Check it empty first then insert data in it then check that data is typed successfully by reading the data in that field
                                                    if (Check)
                                                    {
                                                        String ActualMerchantCity;
                                                        String ExpectedMerchantCity;

                                                        //Check the Presence of Country field
                                                        Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                        Comm="Error:the Merchant Country filed doesn't exist in Create Merchant screen";
                                                        softAssert.assertEquals(Check,true,Comm);

                                                        //if Merchant country field exist choose a country first
                                                        createNewMerchantPage.ChooseCountry("Egypt");

                                                        //Choose city
                                                        ExpectedMerchantCity="Cairo Governorate";
                                                        createNewMerchantPage.ChooseCity(ExpectedMerchantCity);
                                                        ActualMerchantCity=createNewMerchantPage.ReadDataInMerchantCityField();
                                                        Comm="Error:The Data Typed in merchant City filed is wrong"+"\n"+"Expected City is: "+ExpectedMerchantCity+"\n"+"Actual City is: "+ActualMerchantCity;
                                                        softAssert.assertEquals(ActualMerchantCity,ExpectedMerchantCity,Comm);

                                                        //Change Country and check that City field isn't the previous chosen one (Cairo)
                                                        createNewMerchantPage.ChooseCountry("Saudi Arabia");

                                                        ActualMerchantCity=createNewMerchantPage.ReadDataInMerchantCityField();
                                                        Comm="Error:City field isn't empty despite choosing another country (Saudi Arabia)"+"\n"+"Expected City is: "+" "+"\n"+"Actual City is: "+ActualMerchantCity;
                                                        softAssert.assertNotEquals(ActualMerchantCity,"Cairo Governorate",Comm);
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

    @Test(description = "Validation of Entering Merchant Phone",priority =87)
    public void TC_PSA_0087() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen check the presence of merchant Phone field
                                                if(Check)
                                                {
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:the Merchant Phone filed doesn't exist in Create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Merchant Phone field exist insert data in it then check that data is typed successfully by reading the data in that field
                                                    if (Check)
                                                    {
                                                        String ActualMerchantPhone;
                                                        String ExpectedMerchantPhone;

                                                        ExpectedMerchantPhone=props.getProperty("NewMerchantPhone");
                                                        createNewMerchantPage.InsertMerchantPhone(ExpectedMerchantPhone);
                                                        ActualMerchantPhone=createNewMerchantPage.ReadDataInMerchantPhoneField();
                                                        Comm="Error:The Data Typed in merchant Phone filed is wrong"+"\n"+"Expected Phone is: "+ExpectedMerchantPhone+"\n"+"Actual Phone is: "+ActualMerchantPhone;
                                                        softAssert.assertEquals(ActualMerchantPhone,ExpectedMerchantPhone,Comm);

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

    @Test(description = "Validation of entering invalid phone number",priority =88)
    public void TC_PSA_0088() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant Email field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("InvalidPhoneNum")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //Check the Presence of Next Button
                                                    Check=createNewMerchantPage.CheckPresenceOfNextButton();
                                                    Comm="Error:Next Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        createNewMerchantPage.ClickOnNextButton();
                                                        //Check Remaining at create merchant screen if yes check the Presence of a proper error message
                                                        Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                        Comm="Error:user moves to another screen than Create Merchant screen despite phone field contains invalid value is empty ";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if user remains at create Merchant check the presence of error message
                                                        if(Check)
                                                        {
                                                            Check=createNewMerchantPage.CheckPresenceOfNotInsertedMerchantPhoneErrorMsg();
                                                            Comm="Error:No Error msg appears despite the merchant Phone field is empty";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //if Error Msg appears Check the Text of the Message
                                                            if (Check)
                                                            {
                                                                String ActualMsg=createNewMerchantPage.GetTextOfMerchantPhoneErrorMsg();
                                                                String ExpectedMsg=props.getProperty("NotValidPhoneNumMsg");
                                                                Comm="Error:Error Msg isn't as expected";
                                                                softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation of add an existing Phone number used before for another merchant",priority =89)
    public void TC_PSA_0089() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen Insert all merchant information but use insert a previously used Merchant Email
                                                if(Check)
                                                {
                                                    boolean TotalCheck=true;

                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert a previously used Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("UsedMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if  Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //If all fields exist click on the next button
                                                    if(TotalCheck)
                                                    {
                                                        SchemeScreen schemeScreen=createNewMerchantPage.ClickOnNextButton();
                                                        //Check the Presence of scheme screen
                                                        Check=schemeScreen.CheckPresenceOfChooseSchemePriorityScreen();
                                                        Comm="Error:Clicking on next button doesn't navigate to scheme screen";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if navigated successfully to scheme screen Choose random scheme arrangement
                                                        if(Check)
                                                        {
                                                            schemeScreen.ChooseSchemeArrangement();
                                                        }
                                                        //Click on create button then check presence of usedEmail error message
                                                        schemeScreen.ClickOnCreateButton();
                                                        //check presence of usedEmail error message
                                                        Check=schemeScreen.CheckPresenceOfPreviouslyUsedDatErrorMessage();
                                                        Comm="NO Error message appears despite creating a new merchant with a previously used Phone";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //Check the Text of the Message
                                                        if(Check)
                                                        {
                                                            String ActualMsg=schemeScreen.GetTextOfErrorMsg();
                                                            String ExpectedMsg=props.getProperty("AnAlreadyExistPhoneMsg");
                                                            Comm="Error:The Error Msg isn't as expected";
                                                            softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation of choosing Merchant Status",priority =90)
    public void TC_PSA_0090() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen check the presence of merchant Status field
                                                if(Check)
                                                {
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:the Merchant Status filed doesn't exist in Create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Merchant Status field exist insert data in it then check that data is typed successfully by reading the data in that field
                                                    if (Check)
                                                    {
                                                        String ActualMerchantStatus;
                                                        String ExpectedMerchantStatus;

                                                        ExpectedMerchantStatus=props.getProperty("NewMerchantStatus");
                                                        createNewMerchantPage.ChooseMerchantStatus(ExpectedMerchantStatus);
                                                        ActualMerchantStatus=createNewMerchantPage.ReadDataInMerchantStatusField();
                                                        Comm="Error:The Data Typed in merchant Status filed is wrong"+"\n"+"Expected Status is: "+ExpectedMerchantStatus+"\n"+"Actual Status is: "+ActualMerchantStatus;
                                                        softAssert.assertEquals(ActualMerchantStatus,ExpectedMerchantStatus,Comm);

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

    @Test(description = "Validation of choosing Business Category",priority =91)
    public void TC_PSA_0091() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen check the presence of merchant Business category field
                                                if(Check)
                                                {
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:the Merchant  Business category filed doesn't exist in Create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Merchant  Business category field exist insert data in it then check that data is typed successfully by reading the data in that field
                                                    if (Check)
                                                    {
                                                        String ActualMerchantBusinessCategory;
                                                        String ExpectedMerchantBusinessCategory;

                                                        ExpectedMerchantBusinessCategory=props.getProperty("BusinessCategoty");
                                                        createNewMerchantPage.ChooseBusinessCategory(ExpectedMerchantBusinessCategory);
                                                        ActualMerchantBusinessCategory=createNewMerchantPage.ReadDataInMerchantBusinessCategoryField();
                                                        Comm="Error:The Data Typed in merchant Status filed is wrong"+"\n"+"Expected Status is: "+ExpectedMerchantBusinessCategory+"\n"+"Actual Status is: "+ActualMerchantBusinessCategory;
                                                        softAssert.assertEquals(ActualMerchantBusinessCategory,ExpectedMerchantBusinessCategory,Comm);

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
    @Test(description = "Validation of choosing Merchant Currency",priority =92)
    public void TC_PSA_0092() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen check the presence of merchant CurrencyCode field
                                                if(Check)
                                                {
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:the Merchant CurrencyCode filed doesn't exist in Create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Merchant  CurrencyCode field exist insert data in it then check that data is typed successfully by reading the data in that field
                                                    if (Check)
                                                    {
                                                        String ActualMerchantCurrencyCode;
                                                        String ExpectedMerchantCurrencyCode;

                                                        ExpectedMerchantCurrencyCode=props.getProperty("CurrencyCode");
                                                        createNewMerchantPage.ChooseCurrency(ExpectedMerchantCurrencyCode);
                                                        ActualMerchantCurrencyCode=createNewMerchantPage.ReadDataInMerchantCurrencyCodeField();
                                                        Comm="Error:The Data Typed in merchant Status filed is wrong"+"\n"+"Expected CurrencyCode is: "+ExpectedMerchantCurrencyCode+"\n"+"Actual CurrencyCode is: "+ActualMerchantCurrencyCode;
                                                        softAssert.assertEquals(ActualMerchantCurrencyCode,ExpectedMerchantCurrencyCode,Comm);

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
    @Test(description = "Validation of entering Merchant Start Terminal Serial Number",priority =93)
    public void TC_PSA_0093() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen check the presence of merchant StartTerminalSerialNumber field
                                                if(Check)
                                                {
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:the Merchant StartTerminalSerialNumber filed doesn't exist in Create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Merchant  StartTerminalSerialNumber field exist insert data in it then check that data is typed successfully by reading the data in that field
                                                    if (Check)
                                                    {
                                                        String ActualMerchantStartTerminalSerialNumber;
                                                        String ExpectedMerchantStartTerminalSerialNumber;

                                                        ExpectedMerchantStartTerminalSerialNumber=props.getProperty("StartTsN");
                                                        createNewMerchantPage.InsertStartTSN(ExpectedMerchantStartTerminalSerialNumber);
                                                        ActualMerchantStartTerminalSerialNumber=createNewMerchantPage.ReadDataInStartTSNField();
                                                        Comm="Error:The Data Typed in merchant StartTsN filed is wrong"+"\n"+"ExpectedStartTsN is: "+ExpectedMerchantStartTerminalSerialNumber+"\n"+"Actual StartTsN is: "+ActualMerchantStartTerminalSerialNumber;
                                                        softAssert.assertEquals(ActualMerchantStartTerminalSerialNumber,ExpectedMerchantStartTerminalSerialNumber,Comm);

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
    @Test(description = "Validation of entering a unique start serial number",priority =94)
    public void TC_PSA_0094() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen Insert all merchant information but use insert a previously used Merchant Email
                                                if(Check)
                                                {
                                                    boolean TotalCheck=true;

                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert a previously used Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("UsedStartTSNPhone")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if  Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //If all fields exist click on the next button
                                                    if(TotalCheck)
                                                    {
                                                        SchemeScreen schemeScreen=createNewMerchantPage.ClickOnNextButton();
                                                        //Check the Presence of scheme screen
                                                        Check=schemeScreen.CheckPresenceOfChooseSchemePriorityScreen();
                                                        Comm="Error:Clicking on next button doesn't navigate to scheme screen";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if navigated successfully to scheme screen Choose random scheme arrangement
                                                        if(Check)
                                                        {
                                                            schemeScreen.ChooseSchemeArrangement();
                                                        }
                                                        //Click on create button then check presence of usedEmail error message
                                                        schemeScreen.ClickOnCreateButton();
                                                        //check presence of used error message
                                                        Check=schemeScreen.CheckPresenceOfPreviouslyUsedDatErrorMessage();
                                                        Comm="NO Error message appears despite creating a new merchant with a previously used Start TSN";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //Check the Text of the Message
                                                        if(Check)
                                                        {
                                                            String ActualMsg=schemeScreen.GetTextOfErrorMsg();
                                                            String ExpectedMsg=props.getProperty("AnAlreadyExistStartTSNMsg");
                                                            Comm="Error:The Error Msg isn't as expected";
                                                            softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation of a proper error message when entering a serial number less than 6 digits",priority =95)
    public void TC_PSA_0095() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen Insert all merchant information but use insert a previously used Merchant Email
                                                if(Check)
                                                {
                                                    boolean TotalCheck=true;

                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert a previously used Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN(invalid start TSN _only 3 digits)
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("InvalidStartTSN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if  Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //If all fields exist click on the next button
                                                    if(TotalCheck)
                                                    {
                                                        SchemeScreen schemeScreen=createNewMerchantPage.ClickOnNextButton();
                                                        //check that user isn't navigated to SchemeScreen
                                                        Check=schemeScreen.CheckPresenceOfChooseSchemePriorityScreen();
                                                        Comm="Error:Despite Entering Invalid Start TSN (3 digits) User is navigated to Choose Scheme Priority Screen ";
                                                        softAssert.assertEquals(Check,false,Comm);
                                                        //if user isn't navigated to ChooseSchemePriorityScreen , Check the Presence of error message at StartTSN field
                                                        if(!Check)
                                                        {
                                                            Check=createNewMerchantPage.CheckPresenceOfNotInsertedMerchantStatusErrorMsg();
                                                            Comm="Error:No Error Message appears Despite entering invalid Start TSN";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //if Error Message Exist Check its Text
                                                            String ActualMsg=createNewMerchantPage.GetTextOfMerchantStartTSNErrorMsg();
                                                            String ExpectedMsg=props.getProperty("InvalidStartTSNErrorMsg");
                                                            Comm="Error:Error Message isn't as expected";
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
    @Test(description = "Validation of the inability to take terminal serial numbers that have already been reserved for another merchant ",priority =96)
    public void TC_PSA_0096() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen Insert all merchant information but use insert a previously used Merchant Email
                                                if(Check)
                                                {
                                                    boolean TotalCheck=true;

                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert a previously used Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert Start TSN which is reserved for within another range
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTSNWithinPreviouslyUsedRange")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if  Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //If all fields exist click on the next button
                                                    if(TotalCheck)
                                                    {
                                                        SchemeScreen schemeScreen=createNewMerchantPage.ClickOnNextButton();
                                                        //Check the Presence of scheme screen
                                                        Check=schemeScreen.CheckPresenceOfChooseSchemePriorityScreen();
                                                        Comm="Error:Clicking on next button doesn't navigate to scheme screen";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if navigated successfully to scheme screen Choose random scheme arrangement
                                                        if(Check)
                                                        {
                                                            schemeScreen.ChooseSchemeArrangement();
                                                        }
                                                        //Click on create button then check presence of usedEmail error message
                                                        schemeScreen.ClickOnCreateButton();
                                                        //check presence of used error message
                                                        Check=schemeScreen.CheckPresenceOfPreviouslyUsedDatErrorMessage();
                                                        Comm="NO Error message appears despite creating a new merchant with  Start TSN which is reserved for another merchant's range of terminals";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //Check the Text of the Message
                                                        if(Check)
                                                        {
                                                            String ActualMsg=schemeScreen.GetTextOfErrorMsg();
                                                            String ExpectedMsg=props.getProperty("AnAlreadyExistStartTSNMsg");
                                                            Comm="Error:The Error Msg isn't as expected";
                                                            softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation of blocking typing in the terminal count field until entering the \"start terminal serial number\" ",priority =97)
    public void TC_PSA_0097() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen Insert all merchant information but use insert a previously used Merchant Email
                                                if(Check)
                                                {
                                                    boolean TotalCheck=true;

                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert a previously used Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field // but don't insert any value in start TSN field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);


                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    TotalCheck=TotalCheck&Check;
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }
                                                    //Check that no data is typed in terminal count field
                                                    String ActualData=createNewMerchantPage.ReadDataInTerminalCountField();
                                                    Comm="Despite user doesn't insert data in start TSN filed he could insert data in terminal count field";
                                                    softAssert.assertNotEquals(ActualData,props.getProperty("TerminalsCount"),Comm);


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
    @Test(description = "Validation of Entering Merchant Terminals Count",priority =98)
    public void TC_PSA_0098() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen check the presence of merchant TerminalCount field
                                                if(Check)
                                                {
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:the Merchant TerminalCount filed doesn't exist in Create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Merchant TerminalCount field exist insert data in it then check that data is typed successfully by reading the data in that field
                                                    if (Check)
                                                    {
                                                        String ActualMerchantTerminalCount;
                                                        String ExpectedMerchantStartTerminalCount;

                                                        ExpectedMerchantStartTerminalCount=props.getProperty("TerminalsCount");
                                                        createNewMerchantPage.InsertTerminalCount(ExpectedMerchantStartTerminalCount);
                                                        ActualMerchantTerminalCount=createNewMerchantPage.ReadDataInTerminalCountField();
                                                        Comm="Error:The Data Typed in merchant TerminalsCount filed is wrong"+"\n"+"Expected TerminalsCount is: "+ExpectedMerchantStartTerminalCount+"\n"+"Actual TerminalCount is: "+ActualMerchantTerminalCount;
                                                        softAssert.assertEquals(ActualMerchantTerminalCount,ExpectedMerchantStartTerminalCount,Comm);

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
    @Test(description = "Validation of mandatory data entering - Name Field",priority =99)
    public void TC_PSA_0099a() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant Name field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert a previously used Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //Check the Presence of Next Button
                                                    Check=createNewMerchantPage.CheckPresenceOfNextButton();
                                                    Comm="Error:Next Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        createNewMerchantPage.ClickOnNextButton();
                                                        //Check Remaining at create merchant screen if yes check the Presence of a proper error message
                                                        Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                        Comm="Error:user moves to another screen than Create Merchant screen despite the name field is empty ";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if user remains at create Merchant check the presence of error message
                                                        if(Check)
                                                        {
                                                            Check=createNewMerchantPage.CheckPresenceOfNotInsertedMerchantNameErrorMsg();
                                                            Comm="Error:No Error msg appears despite the merchant name field is empty";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //if Error Msg appears Check the Text of the Message
                                                            if (Check)
                                                            {
                                                                String ActualMsg=createNewMerchantPage.GetTextOfMerchantNameErrorMsg();
                                                                String ExpectedMsg=props.getProperty("RequiredFailedErrorMsg");
                                                                Comm="Error:Error Msg isn't as expected";
                                                                softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation of mandatory data entering - Code Field",priority =99)
    public void TC_PSA_0099b() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant Code field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);


                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert a previously used Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //Check the Presence of Next Button
                                                    Check=createNewMerchantPage.CheckPresenceOfNextButton();
                                                    Comm="Error:Next Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        createNewMerchantPage.ClickOnNextButton();
                                                        //Check Remaining at create merchant screen if yes check the Presence of a proper error message
                                                        Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                        Comm="Error:user moves to another screen than Create Merchant screen despite the name field is empty ";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if user remains at create Merchant check the presence of error message
                                                        if(Check)
                                                        {
                                                            Check=createNewMerchantPage.CheckPresenceOfNotInsertedMerchantCodeErrorMsg();
                                                            Comm="Error:No Error msg appears despite the merchant Code field is empty";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //if Error Msg appears Check the Text of the Message
                                                            if (Check)
                                                            {
                                                                String ActualMsg=createNewMerchantPage.GetTextOfMerchantCodeErrorMsg();
                                                                String ExpectedMsg=props.getProperty("RequiredFailedErrorMsg");
                                                                Comm="Error:Error Msg isn't as expected";
                                                                softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation of mandatory data entering - Email Field",priority =99)
    public void TC_PSA_0099c() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant Email field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //Check the Presence of Next Button
                                                    Check=createNewMerchantPage.CheckPresenceOfNextButton();
                                                    Comm="Error:Next Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        createNewMerchantPage.ClickOnNextButton();
                                                        //Check Remaining at create merchant screen if yes check the Presence of a proper error message
                                                        Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                        Comm="Error:user moves to another screen than Create Merchant screen despite the name field is empty ";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if user remains at create Merchant check the presence of error message
                                                        if(Check)
                                                        {
                                                            Check=createNewMerchantPage.CheckPresenceOfNotInsertedMerchantEmailErrorMsg();
                                                            Comm="Error:No Error msg appears despite the merchant Email field is empty";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //if Error Msg appears Check the Text of the Message
                                                            if (Check)
                                                            {
                                                                String ActualMsg=createNewMerchantPage.GetTextOfMerchantEmailErrorMsg();
                                                                String ExpectedMsg=props.getProperty("RequiredFailedErrorMsg");
                                                                Comm="Error:Error Msg isn't as expected";
                                                                softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation of mandatory data entering - Country Field",priority =99)
    public void TC_PSA_0099d() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant Country field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //Check the Presence of Next Button
                                                    Check=createNewMerchantPage.CheckPresenceOfNextButton();
                                                    Comm="Error:Next Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        createNewMerchantPage.ClickOnNextButton();
                                                        //Check Remaining at create merchant screen if yes check the Presence of a proper error message
                                                        Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                        Comm="Error:user moves to another screen than Create Merchant screen despite the name field is empty ";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if user remains at create Merchant check the presence of error message
                                                        if(Check)
                                                        {
                                                            Check=createNewMerchantPage.CheckPresenceOfNotInsertedMerchantCountryErrorMsg();
                                                            Comm="Error:No Error msg appears despite the merchant Country field is empty";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //if Error Msg appears Check the Text of the Message
                                                            if (Check)
                                                            {
                                                                String ActualMsg=createNewMerchantPage.GetTextOfMerchantCountryErrorMsg();
                                                                String ExpectedMsg=props.getProperty("RequiredFailedErrorMsg");
                                                                Comm="Error:Error Msg isn't as expected";
                                                                softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation of mandatory data entering - City Field",priority =99)
    public void TC_PSA_0099e() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant City field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //Check the Presence of Next Button
                                                    Check=createNewMerchantPage.CheckPresenceOfNextButton();
                                                    Comm="Error:Next Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        createNewMerchantPage.ClickOnNextButton();
                                                        //Check Remaining at create merchant screen if yes check the Presence of a proper error message
                                                        Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                        Comm="Error:user moves to another screen than Create Merchant screen despite the name field is empty ";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if user remains at create Merchant check the presence of error message
                                                        if(Check)
                                                        {
                                                            Check=createNewMerchantPage.CheckPresenceOfNotInsertedMerchantCityErrorMsg();
                                                            Comm="Error:No Error msg appears despite the merchant City field is empty";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //if Error Msg appears Check the Text of the Message
                                                            if (Check)
                                                            {
                                                                String ActualMsg=createNewMerchantPage.GetTextOfMerchantCityErrorMsg();
                                                                String ExpectedMsg=props.getProperty("RequiredFailedErrorMsg");
                                                                Comm="Error:Error Msg isn't as expected";
                                                                softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation of mandatory data entering - phone Field",priority =99)
    public void TC_PSA_0099f() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant Email field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //Check the Presence of Next Button
                                                    Check=createNewMerchantPage.CheckPresenceOfNextButton();
                                                    Comm="Error:Next Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        createNewMerchantPage.ClickOnNextButton();
                                                        //Check Remaining at create merchant screen if yes check the Presence of a proper error message
                                                        Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                        Comm="Error:user moves to another screen than Create Merchant screen despite the name field is empty ";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if user remains at create Merchant check the presence of error message
                                                        if(Check)
                                                        {
                                                            Check=createNewMerchantPage.CheckPresenceOfNotInsertedMerchantPhoneErrorMsg();
                                                            Comm="Error:No Error msg appears despite the merchant Phone field is empty";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //if Error Msg appears Check the Text of the Message
                                                            if (Check)
                                                            {
                                                                String ActualMsg=createNewMerchantPage.GetTextOfMerchantPhoneErrorMsg();
                                                                String ExpectedMsg=props.getProperty("RequiredFailedErrorMsg");
                                                                Comm="Error:Error Msg isn't as expected";
                                                                softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation of mandatory data entering - Status Field",priority =99)
    public void TC_PSA_0099g() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant Email field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //Check the Presence of Next Button
                                                    Check=createNewMerchantPage.CheckPresenceOfNextButton();
                                                    Comm="Error:Next Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        createNewMerchantPage.ClickOnNextButton();
                                                        //Check Remaining at create merchant screen if yes check the Presence of a proper error message
                                                        Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                        Comm="Error:user moves to another screen than Create Merchant screen despite the name field is empty ";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if user remains at create Merchant check the presence of error message
                                                        if(Check)
                                                        {
                                                            Check=createNewMerchantPage.CheckPresenceOfNotInsertedMerchantStatusErrorMsg();
                                                            Comm="Error:No Error msg appears despite the merchant Status field is empty";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //if Error Msg appears Check the Text of the Message
                                                            if (Check)
                                                            {
                                                                String ActualMsg=createNewMerchantPage.GetTextOfMerchantStatusErrorMsg();
                                                                String ExpectedMsg=props.getProperty("RequiredFailedErrorMsg");
                                                                Comm="Error:Error Msg isn't as expected";
                                                                softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation of mandatory data entering - Language Field",priority =99)
    public void TC_PSA_0099h() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant Email field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //Check the Presence of Next Button
                                                    Check=createNewMerchantPage.CheckPresenceOfNextButton();
                                                    Comm="Error:Next Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        createNewMerchantPage.ClickOnNextButton();
                                                        //Check Remaining at create merchant screen if yes check the Presence of a proper error message
                                                        Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                        Comm="Error:user moves to another screen than Create Merchant screen despite the name field is empty ";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if user remains at create Merchant check the presence of error message
                                                        if(Check)
                                                        {
                                                            Check=createNewMerchantPage.CheckPresenceOfNotInsertedMerchantLanguageErrorMsg();
                                                            Comm="Error:No Error msg appears despite the merchant Language field is empty";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //if Error Msg appears Check the Text of the Message
                                                            if (Check)
                                                            {
                                                                String ActualMsg=createNewMerchantPage.GetTextOfMerchantLanguageErrorMsg();
                                                                String ExpectedMsg=props.getProperty("RequiredFailedErrorMsg");
                                                                Comm="Error:Error Msg isn't as expected";
                                                                softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation of mandatory data entering - Business category Field",priority =99)
    public void TC_PSA_0099i() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant Email field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //Check the Presence of Next Button
                                                    Check=createNewMerchantPage.CheckPresenceOfNextButton();
                                                    Comm="Error:Next Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        createNewMerchantPage.ClickOnNextButton();
                                                        //Check Remaining at create merchant screen if yes check the Presence of a proper error message
                                                        Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                        Comm="Error:user moves to another screen than Create Merchant screen despite the name field is empty ";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if user remains at create Merchant check the presence of error message
                                                        if(Check)
                                                        {
                                                            Check=createNewMerchantPage.CheckPresenceOfNotInsertedMerchantBusinessCategoryErrorMsg();
                                                            Comm="Error:No Error msg appears despite the merchant BusinessCategory field is empty";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //if Error Msg appears Check the Text of the Message
                                                            if (Check)
                                                            {
                                                                String ActualMsg=createNewMerchantPage.GetTextOfMerchantBusinessCategoryErrorMsg();
                                                                String ExpectedMsg=props.getProperty("RequiredFailedErrorMsg");
                                                                Comm="Error:Error Msg isn't as expected";
                                                                softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation of mandatory data entering -Currency code Field",priority =99)
    public void TC_PSA_0099j() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant Email field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //Check the Presence of Next Button
                                                    Check=createNewMerchantPage.CheckPresenceOfNextButton();
                                                    Comm="Error:Next Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        createNewMerchantPage.ClickOnNextButton();
                                                        //Check Remaining at create merchant screen if yes check the Presence of a proper error message
                                                        Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                        Comm="Error:user moves to another screen than Create Merchant screen despite the name field is empty ";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if user remains at create Merchant check the presence of error message
                                                        if(Check)
                                                        {
                                                            Check=createNewMerchantPage.CheckPresenceOfNotInsertedMerchantCurrencyErrorMsg();
                                                            Comm="Error:No Error msg appears despite the merchant Currency field is empty";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //if Error Msg appears Check the Text of the Message
                                                            if (Check)
                                                            {
                                                                String ActualMsg=createNewMerchantPage.GetTextOfMerchantBusinessCurrencyErrorMsg();
                                                                String ExpectedMsg=props.getProperty("RequiredFailedErrorMsg");
                                                                Comm="Error:Error Msg isn't as expected";
                                                                softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation of mandatory data entering - StartTerminalSerialNumber Field",priority =99)
    public void TC_PSA_0099k() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant Email field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count Number code Field Exist insert your Terminal Count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //Check the Presence of Next Button
                                                    Check=createNewMerchantPage.CheckPresenceOfNextButton();
                                                    Comm="Error:Next Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        createNewMerchantPage.ClickOnNextButton();
                                                        //Check Remaining at create merchant screen if yes check the Presence of a proper error message
                                                        Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                        Comm="Error:user moves to another screen than Create Merchant screen despite the name field is empty ";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if user remains at create Merchant check the presence of error message
                                                        if(Check)
                                                        {
                                                            Check=createNewMerchantPage.CheckPresenceOfNotInsertedMerchantStartTSNErrorMsg();
                                                            Comm="Error:No Error msg appears despite the merchant StartTSN field is empty";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //if Error Msg appears Check the Text of the Message
                                                            if (Check)
                                                            {
                                                                String ActualMsg=createNewMerchantPage.GetTextOfMerchantStartTSNErrorMsg();
                                                                String ExpectedMsg=props.getProperty("RequiredFailedErrorMsg");
                                                                Comm="Error:Error Msg isn't as expected";
                                                                softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation of mandatory data entering - Terminals count Field",priority =99)
    public void TC_PSA_0099l() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant Email field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //Check the Presence of Next Button
                                                    Check=createNewMerchantPage.CheckPresenceOfNextButton();
                                                    Comm="Error:Next Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        createNewMerchantPage.ClickOnNextButton();
                                                        //Check Remaining at create merchant screen if yes check the Presence of a proper error message
                                                        Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                        Comm="Error:user moves to another screen than Create Merchant screen despite the name field is empty ";
                                                        softAssert.assertEquals(Check,true,Comm);
                                                        //if user remains at create Merchant check the presence of error message
                                                        if(Check)
                                                        {
                                                            Check=createNewMerchantPage.CheckPresenceOfNotInsertedMerchantTerminalCountErrorMsg();
                                                            Comm="Error:No Error msg appears despite the merchant Terminals count field is empty";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //if Error Msg appears Check the Text of the Message
                                                            if (Check)
                                                            {
                                                                String ActualMsg=createNewMerchantPage.GetTextOfMerchantBusinessTerminalCountErrorMsg();
                                                                String ExpectedMsg=props.getProperty("RequiredFailedErrorMsg");
                                                                Comm="Error:Error Msg isn't as expected";
                                                                softAssert.assertEquals(ActualMsg,ExpectedMsg,Comm);
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
    @Test(description = "Validation on optional data entering",priority =100)
    public void TC_PSA_00100() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant Email field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count  Field Exist insert your terminal count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //Check the Presence of Next Button
                                                    Check=createNewMerchantPage.CheckPresenceOfNextButton();
                                                    Comm="Error:Next Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        SchemeScreen schemeScreen=createNewMerchantPage.ClickOnNextButton();
                                                        //Check navigation to Schemes screen
                                                        Check=schemeScreen.CheckPresenceOfChooseSchemePriorityScreen();
                                                        Comm="Error:User isn't navigated to Schemes screen cause of not inserting photo for merchant ";
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
    @Test(description = "Validation of Next button",priority =101)
    public void TC_PSA_00101() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant Email field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count Field Exist insert your Start Terminal count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //Check the Presence of Next Button
                                                    Check=createNewMerchantPage.CheckPresenceOfNextButton();
                                                    Comm="Error:Next Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        SchemeScreen schemeScreen=createNewMerchantPage.ClickOnNextButton();
                                                        //Check Presence of schemes screen
                                                        Check=schemeScreen.CheckPresenceOfChooseSchemePriorityScreen();
                                                        Comm="Error:Clicking on Next button doesn't navigate user to Schemes screen";
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
    @Test(description = "Validation of Cancel button",priority =102)
    public void TC_PSA_00102() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Create New button
                                        if (Check)
                                        {
                                            //Check that Create New button exist
                                            Check=sAdminHomePage.CheckPresenceOfCreateNewButton();
                                            Comm="Error:Create New Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Create New Button exist click on it and then check that create merchant screen appears
                                            if (Check)
                                            {
                                                CreateNewMerchantPage createNewMerchantPage=sAdminHomePage.ClickOnCreateNewButton();
                                                //Check presence of create merchant screen
                                                Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                Comm="Error:Clicking on the Create New Button doesn't navigate to create new merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if navigated successfully to create merchant screen insert data in all field except the Merchant Email field
                                                if(Check)
                                                {
                                                    //Check the Presence of Merchant Name Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Name Field Exist insert Merchant Name
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantName(props.getProperty("NewMerchantName")); }

                                                    //Check the Presence of Merchant Code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCodeField();
                                                    Comm="Error:Merchant Code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Code Field Exist insert Merchant Code
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantCode(props.getProperty("NewMerchantCode")); }

                                                    //Check the Presence of Merchant Email Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Email Field Exist insert Merchant Email
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantEmail(props.getProperty("NewMerchantEmail")); }

                                                    //Check the Presence of Merchant Country Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCountryField();
                                                    Comm="Error:Merchant Country Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Country Field Exist insert Merchant Country
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCountry(props.getProperty("NewMerchantCountry")); }

                                                    //Check the Presence of Merchant City Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCityField();
                                                    Comm="Error:Merchant City Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant City Field Exist insert Merchant City
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCity(props.getProperty("NewMerchantCity")); }

                                                    //Check the Presence of Merchant Phone Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantPhoneField();
                                                    Comm="Error:Merchant Phone Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Phone Field Exist insert Merchant Phone
                                                    if(Check)
                                                    { createNewMerchantPage.InsertMerchantPhone(props.getProperty("NewMerchantPhone")); }

                                                    //Check the Presence of Merchant Status Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantStatusField();
                                                    Comm="Error:Merchant Status Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Merchant Status Field Exist insert Merchant Status
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseMerchantStatus(props.getProperty("NewMerchantStatus")); }

                                                    //Check the Presence of Default Language Field
                                                    Check=createNewMerchantPage.CheckPresenceOfDefaultLanguageField();
                                                    Comm="Error:Default Language Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Default Language Field Exist insert your Default Language
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseLanguage(props.getProperty("DefaultLanguage")); }

                                                    //Check the Presence of BusinessCategory Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantBusinessCategoryField();
                                                    Comm="Error:BusinessCategory Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if BusinessCategory Field Exist insert your BusinessCategory
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseBusinessCategory(props.getProperty("BusinessCategoty")); }

                                                    //Check the Presence of Currency code Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                    Comm="Error:Currency code Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Currency code Field Exist insert your Currency code
                                                    if(Check)
                                                    { createNewMerchantPage.ChooseCurrency(props.getProperty("CurrencyCode")); }

                                                    //Check the Presence of Start Terminal Serial Number Field
                                                    Check=createNewMerchantPage.CheckPresenceOfStartTSNField();
                                                    Comm="Error:Start Terminal Serial Number Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Start Terminal Serial Number code Field Exist insert your Start TSN
                                                    if(Check)
                                                    { createNewMerchantPage.InsertStartTSN(props.getProperty("StartTsN")); }

                                                    //Check the Presence of Terminal Count Field
                                                    Check=createNewMerchantPage.CheckPresenceOfMerchantTerminalCountField();
                                                    Comm="Error:Terminal Count Field doesn't exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    //if Terminal count Field Exist insert your Start Terminal count
                                                    if(Check)
                                                    { createNewMerchantPage.InsertTerminalCount(props.getProperty("TerminalsCount")); }

                                                    //Check the Presence of Cancel Button
                                                    Check=createNewMerchantPage.CheckPresenceOfCancelButton();
                                                    Comm="Error:Cancel Button Doesn't Exist in create Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);
                                                    if(Check)
                                                    {
                                                        createNewMerchantPage.ClickOnCancelButton();
                                                        //Check thar create screen is canceled
                                                        Check=createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                        Comm="Error:Clicking on cancel button doesn't Cancel the create Merchant screen";
                                                        softAssert.assertEquals(Check,false,Comm);
                                                        //if Create Merchant is canceled successfully check that Merchant isn't added to Merchant table
                                                        if(!Check)
                                                        {
                                                            SAdminHomePage.MerchantDetails merchantDetails=sAdminHomePage.GetaSpecificMerchantFromMerchantTable(props.getProperty("NewMerchantName"));
                                                            Comm="Error:Despite Clicking on cancel button Merchant is added to Merchant table";
                                                            softAssert.assertNull(merchantDetails,Comm);

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
