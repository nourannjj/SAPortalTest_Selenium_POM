package Tests;

import Base.BaseTest;
import Pages.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Test extends BaseTest {
    String Comm;
    boolean Check;

    @org.testng.annotations.Test(description = "Validation of add currency",priority =103)
    public void TC_PSA_0103() throws IOException, InterruptedException {

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
                                                                System.out.println("Check1"+Check);
                                                                //if Read data in CurrencyFullNameField is as expected Check The Presence of Add Currency button
                                                                if (ActualCurrency.equals(ExpectedCurrency))
                                                                {
                                                                    Check = addCurrencyScreen.CheckPresenceOfCancelButton();
                                                                    Comm = "Error:Cancel Currency Button doesn't exist in Add currency screen";
                                                                    softAssert.assertEquals(Check, true, Comm);
                                                                    System.out.println("Check2"+Check);
                                                                    //if Add currency button exists click on it
                                                                    if (Check) {
                                                                        addCurrencyScreen.ClickOnCancelButton();
                                                                        //Open create Merchant screen then check Whether the new currency is added or not
                                                                        //Check the Presence of create Merchant button
                                                                        Check = sAdminHomePage.CheckPresenceOfCreateNewButton()&&sAdminHomePage.CheckThatCreateNewButtonIsEnabled();
                                                                        System.out.println(Check);
                                                                        Comm = "Error:Create Merchant Button isn't exist after Click on Add currency button";
                                                                        softAssert.assertEquals(Check, true, Comm);
                                                                        //if Create New button exist Click on it
                                                                        if (Check) {
                                                                            CreateNewMerchantPage createNewMerchantPage = sAdminHomePage.ClickOnCreateNewButton();
                                                                            //Check the Presence of create new merchant screen
                                                                            Check = createNewMerchantPage.CheckPresenceOfCreateMerchantScreen();
                                                                            Comm = "Error:clicking on create new button doesn't navigate user to create merchant screen";
                                                                            softAssert.assertEquals(Check, true, Comm);

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
