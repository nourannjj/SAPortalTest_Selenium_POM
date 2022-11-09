package Tests;

import Base.BaseTest;
import Pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class AddCurrencyScreenTest extends BaseTest {
    String Comm;
    boolean Check;

    @Test(description = "Validation that the created currency is added to the currency list in the create new merchant screen",priority =104)
    public void TC_PSA_0104() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Add Currency button
                                        if (Check)
                                        {
                                            //Check that Add Currency button exist
                                            Check=sAdminHomePage.CheckPresenceOfAddCurrencyButton();
                                            Comm="Error: Add Currency Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If  Add Currency Button exist click on it and then check that  Add Currency screen appears
                                            if (Check)
                                            {
                                                AddCurrencyScreen addCurrencyScreen= sAdminHomePage.ClickOnAddCurrencyButton();
                                                //Check presence of Add Currency screen
                                                Check=addCurrencyScreen.CheckPresenceOfAddCurrencyScreen();
                                                Comm="Error:Clicking on the Add Currency Button doesn't navigate to Add Currency screen";
                                                softAssert.assertEquals(Check,true,Comm);
                                                //if Navigated successfully to Add currency screen check Presence of Currency country field
                                                if(Check)
                                                {
                                                    Check=addCurrencyScreen.CheckPresenceOfCurrencyCountryField();
                                                    Comm="Error:Currency Country Field doesn't exist in Add currency screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Currency country field Choose any country
                                                    if(Check) {
                                                        addCurrencyScreen.ChooseCurrencyCountry(props.getProperty("CurrencyCountry"));
                                                        //Check that Country is chosen successfully
                                                        String ActualCurrencyCountry = addCurrencyScreen.ReadDataInCurrencyCountryField();
                                                        String ExpectedCurrencyCountry = props.getProperty("CurrencyCountry");
                                                        Comm = "Error The Data in Currency country field differs than the chosen one";
                                                        softAssert.assertEquals(ActualCurrencyCountry, ExpectedCurrencyCountry, Comm);

                                                        //if Country is chosen successfully Check the Presence of Currency full name field
                                                        if (ActualCurrencyCountry.equals(ExpectedCurrencyCountry)) {
                                                            Check = addCurrencyScreen.CheckPresenceOfCurrencyFullNameField();
                                                            Comm = "Error:Currency Full Name Field doesn't exist in Add currency screen";
                                                            softAssert.assertEquals(Check, true, Comm);
                                                            //if Currency full name field exist get the Value in it
                                                            if (Check)
                                                            {
                                                                String ExpectedCurrency =props.getProperty("CurrencyCountryCode");
                                                                String ActualCurrency=addCurrencyScreen.ReadDataInCurrencyFullNameField();
                                                                //Check that Read Data is as expected
                                                                Comm="Error:Data in CurrencyFullNameField isn't as expected";
                                                                softAssert.assertEquals(ActualCurrency,ExpectedCurrency,Comm);
                                                                //if Read data in CurrencyFullNameField is as expected Check The Presence of Add Currency button
                                                                if (ActualCurrency.equals(ExpectedCurrency))
                                                                {
                                                                Check = addCurrencyScreen.CheckPresenceOFAddCurrencyButton();
                                                                Comm = "Error:Add Currency Button doesn't exist in Add currency screen";
                                                                softAssert.assertEquals(Check, true, Comm);
                                                                //if Add currency button exists click on it
                                                                if (Check) {
                                                                    addCurrencyScreen.ClickOnAddCurrencyButton();
                                                                    //CheckThePresence of Refresh Button
                                                                    Check = sAdminHomePage.CheckPresenceOfRefreshButton();
                                                                    Comm = "Error:Refresh button doesn't exist";
                                                                    softAssert.assertEquals(Check, true, Comm);
                                                                    //if Refresh button exist click on it
                                                                    if (Check)
                                                                    {
                                                                        sAdminHomePage.ClickOnRefreshButton();
                                                                        //Open create Merchant screen then check Whether the new currency is added or not
                                                                        //Check the Presence of create Merchant button
                                                                        Check = sAdminHomePage.CheckPresenceOfCreateNewButton() && sAdminHomePage.CheckThatCreateNewButtonIsEnabled();
                                                                        Comm = "Error:Create Merchant Button isn't exist after Click on Add currency button";
                                                                        softAssert.assertEquals(Check, true, Comm);
                                                                        //if Create New button exist Click on it
                                                                        if (Check) {
                                                                        CreateNewMerchantPage createNewMerchantPage = sAdminHomePage.ClickOnCreateNewButton();
                                                                        //Check the Presence of create new merchant screen
                                                                        Check = createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                                        Comm = "Error:clicking on create new button doesn't navigate user to create merchant screen";
                                                                        softAssert.assertEquals(Check, true, Comm);
                                                                        //if Navigate successfully to create new Merchant screen Check the Presence of currency code field
                                                                        if (Check) {
                                                                            Check = createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                                            Comm = "Error:The Currency Field doesn't exist in create new merchant screen";
                                                                            softAssert.assertEquals(Check, true, Comm);
                                                                            //if Currency field exist Try to Choose the new currency
                                                                            if (Check) {
                                                                                createNewMerchantPage.ChooseCurrency(ExpectedCurrency);
                                                                                //Check that the chosen currency is as expected
                                                                                ActualCurrency = createNewMerchantPage.ReadDataInMerchantCurrencyCodeField();
                                                                                Comm = "Error:The added currency doesn't exist in currency menu";
                                                                                softAssert.assertEquals(ActualCurrency, ExpectedCurrency, Comm);
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
    @Test(description = "Validation of add an existing currency",priority =105)
    public void TC_PSA_0105() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Add Currency button
                                        if (Check)
                                        {
                                            //Check that Add Currency button exist
                                            Check=sAdminHomePage.CheckPresenceOfAddCurrencyButton();
                                            Comm="Error: Add Currency Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If  Add Currency Button exist click on it and then check that  Add Currency screen appears
                                            if (Check)
                                            {
                                                AddCurrencyScreen addCurrencyScreen= sAdminHomePage.ClickOnAddCurrencyButton();
                                                //Check presence of Add Currency screen
                                                Check=addCurrencyScreen.CheckPresenceOfAddCurrencyScreen();
                                                Comm="Error:Clicking on the Add Currency Button doesn't navigate to Add Currency screen";
                                                softAssert.assertEquals(Check,true,Comm);
                                                //if Navigated successfully to Add currency screen check Presence of Currency country field
                                                if(Check)
                                                {
                                                    Check=addCurrencyScreen.CheckPresenceOfCurrencyCountryField();
                                                    Comm="Error:Currency Country Field doesn't exist in Add currency screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Currency country field Choose a previously used currency country
                                                    if(Check) {
                                                        addCurrencyScreen.ChooseCurrencyCountry(props.getProperty("ExistingCurrencyCountry"));
                                                        //Check that Country is chosen successfully
                                                        String ActualCurrencyCountry = addCurrencyScreen.ReadDataInCurrencyCountryField();
                                                        String ExpectedCurrencyCountry = props.getProperty("ExistingCurrencyCountry");
                                                        Comm = "Error The Data in Currency country field differs than the chosen one";
                                                        softAssert.assertEquals(ActualCurrencyCountry, ExpectedCurrencyCountry, Comm);

                                                               //if Read data in CurrencyCountryField is as expected Check The Presence of Add Currency button
                                                                if (ActualCurrencyCountry.equals(ExpectedCurrencyCountry))
                                                                {
                                                                    Check = addCurrencyScreen.CheckPresenceOFAddCurrencyButton();
                                                                    Comm = "Error:Add Currency Button doesn't exist in Add currency screen";
                                                                    softAssert.assertEquals(Check, true, Comm);

                                                                    //if Add currency button exists click on it
                                                                    if (Check) {
                                                                        addCurrencyScreen.ClickOnAddCurrencyButton();
                                                                        //Check remaining at AddCurrency screen
                                                                        Check=addCurrencyScreen.CheckPresenceOfAddCurrencyScreen();
                                                                        Comm="Error:Despite Choosing a previously added currency No Error appears and the Add currency screen is closed";
                                                                        softAssert.assertEquals(Check,true,Comm);
                                                                        //if Add currency screen still open check the Presence of Error message
                                                                        if(Check)
                                                                        {
                                                                            //Check the Presence of Error Msg
                                                                            Check=addCurrencyScreen.CheckPresenceOfErrorMsg();
                                                                            Comm="Error:No error Message appears despite adding a previously added currency";
                                                                            softAssert.assertEquals(Check,true,Comm);

                                                                            //if Error Message Appears check the Error Message
                                                                            if(Check)
                                                                            {
                                                                                String ActualMsg=addCurrencyScreen.GetTextOfErrorMsg();
                                                                                String ExpectedMsg="Key (country)="+"("+props.getProperty("ExistingCurrencyCountry")+")"+" already exists.";
                                                                                Comm="The Error Message is wrong";
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
            }
        }
        softAssert.assertAll();
    }
    @Test(description = "Validation of cancel button",priority =106)
    public void TC_PSA_0106() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Add Currency button
                                        if (Check)
                                        {
                                            //Check that Add Currency button exist
                                            Check=sAdminHomePage.CheckPresenceOfAddCurrencyButton();
                                            Comm="Error: Add Currency Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If  Add Currency Button exist click on it and then check that  Add Currency screen appears
                                            if (Check)
                                            {
                                                AddCurrencyScreen addCurrencyScreen= sAdminHomePage.ClickOnAddCurrencyButton();
                                                //Check presence of Add Currency screen
                                                Check=addCurrencyScreen.CheckPresenceOfAddCurrencyScreen();
                                                Comm="Error:Clicking on the Add Currency Button doesn't navigate to Add Currency screen";
                                                softAssert.assertEquals(Check,true,Comm);
                                                //if Navigated successfully to Add currency screen check Presence of Currency country field
                                                if(Check)
                                                {
                                                    Check=addCurrencyScreen.CheckPresenceOfCurrencyCountryField();
                                                    Comm="Error:Currency Country Field doesn't exist in Add currency screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Currency country field Choose any country
                                                    if(Check) {
                                                        addCurrencyScreen.ChooseCurrencyCountry(props.getProperty("NotAddedCurrencyCountry"));
                                                        //Check that Country is chosen successfully
                                                        String ActualCurrencyCountry = addCurrencyScreen.ReadDataInCurrencyCountryField();
                                                        String ExpectedCurrencyCountry = props.getProperty("NotAddedCurrencyCountry");
                                                        Comm = "Error The Data in Currency country field differs than the chosen one";
                                                        softAssert.assertEquals(ActualCurrencyCountry, ExpectedCurrencyCountry, Comm);

                                                        //if Country is chosen successfully Check the Presence of Currency full name field
                                                        if (ActualCurrencyCountry.equals(ExpectedCurrencyCountry)) {
                                                            Check = addCurrencyScreen.CheckPresenceOfCurrencyFullNameField();
                                                            Comm = "Error:Currency Full Name Field doesn't exist in Add currency screen";
                                                            softAssert.assertEquals(Check, true, Comm);
                                                            //if Currency full name field exist get the Value in it
                                                            if (Check)
                                                            {
                                                                String ExpectedCurrency =props.getProperty("NotAddedCurrencyCountryCode");
                                                                String ActualCurrency=addCurrencyScreen.ReadDataInCurrencyFullNameField();
                                                                //Check that Read Data is as expected
                                                                Comm="Error:Data in CurrencyFullNameField isn't as expected";
                                                                softAssert.assertEquals(ActualCurrency,ExpectedCurrency,Comm);

                                                                //if Read data in CurrencyFullNameField is as expected Check The Presence of Cancel button
                                                                if (ActualCurrency.equals(ExpectedCurrency))
                                                                {
                                                                    Check = addCurrencyScreen.CheckPresenceOfCancelButton();
                                                                    Comm = "Error:Cancel Button doesn't exist in Add currency screen";
                                                                    softAssert.assertEquals(Check, true, Comm);

                                                                    //if Cancel button exists click on it
                                                                    if (Check) {
                                                                        addCurrencyScreen.ClickOnCancelButton();
                                                                        //Open create Merchant screen then check Whether the new currency is added or not
                                                                        //Check the Presence of create Merchant button
                                                                        Check = sAdminHomePage.CheckPresenceOfCreateNewButton()&&sAdminHomePage.CheckThatCreateNewButtonIsEnabled();
                                                                        Comm = "Error:Create Merchant Button isn't exist after Click on Cancel button";
                                                                        softAssert.assertEquals(Check, true, Comm);
                                                                        //if Create New button exist Click on it
                                                                        if (Check) {
                                                                            CreateNewMerchantPage createNewMerchantPage = sAdminHomePage.ClickOnCreateNewButton();
                                                                            //Check the Presence of create new merchant screen
                                                                            Check = createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                                            Comm = "Error:clicking on create new button doesn't navigate user to create merchant screen";
                                                                            softAssert.assertEquals(Check, true, Comm);
                                                                            //if Navigate successfully to create new Merchant screen Check the Presence of currency code field
                                                                            if (Check) {
                                                                                Check = createNewMerchantPage.CheckPresenceOfMerchantCurrencyCodeField();
                                                                                Comm = "Error:The Currency Field doesn't exist in create new merchant screen";
                                                                                softAssert.assertEquals(Check, true, Comm);
                                                                                //if Currency field exist Try to Find the not added currency
                                                                                if (Check) {
                                                                                    createNewMerchantPage.ChooseCurrency(ExpectedCurrency);
                                                                                    //Check that the chosen currency is as expected
                                                                                    ActualCurrency = createNewMerchantPage.ReadDataInMerchantCurrencyCodeField();
                                                                                    Comm = "Error:The not added currency exist in the currency menu";
                                                                                    softAssert.assertNotEquals(ActualCurrency,ExpectedCurrency, Comm);
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
