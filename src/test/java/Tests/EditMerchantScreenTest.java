package Tests;

import Base.BaseTest;
import Pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class EditMerchantScreenTest extends BaseTest {
    String Comm;
    boolean Check;

    @Test(description = "Validation of change merchant name",priority =109)
    public void TC_PSA_0109() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Edit Merchant button
                                        if (Check)
                                        {
                                            //Check that Edit Merchant button exist
                                            Check=sAdminHomePage.CheckPresenceOfEditMerchantButton();
                                            Comm="Error: Edit Merchant Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Edit Merchant Button exist click on it and then check that Edit Merchant screen appears
                                            if (Check)
                                            {
                                                EditMerchantScreen editMerchantScreen=sAdminHomePage.ClickOnEditButton();
                                                //Check presence of Edit Merchant screen
                                                Check=editMerchantScreen.CheckPresenceOfEditMerchantScreen();
                                                Comm="Error:Clicking on the Edit Merchant Button doesn't navigate to Edit Merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if Edit Screen opened successfully check the presence of merchant name field
                                                if (Check)
                                                {
                                                    Check=editMerchantScreen.CheckPresenceOfMerchantNameField();
                                                    Comm="Error:Merchant Name field doesn't exist in Edit Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Merchant name filed exist Edit it
                                                    if(Check)
                                                    {
                                                        String OldMerchantName=editMerchantScreen.ReadDataInMerchantNameField();
                                                        String EditedName="Edited Name";
                                                        editMerchantScreen.ClearMerchantNameField();
                                                        editMerchantScreen.EditMerchantName(EditedName);
                                                        //Read Data in Merchant Name Field and check that its edited
                                                        String ActualName=editMerchantScreen.ReadDataInMerchantNameField();
                                                        softAssert.assertEquals(ActualName,EditedName,Comm);
                                                        Comm="Error:Data in merchant name filed isn't Edited";
                                                        softAssert.assertNotEquals(ActualName,OldMerchantName,Comm);

                                                        //if Data is changed check that its edited correctly
                                                        if(!ActualName.equals(OldMerchantName))
                                                        {
                                                            Comm="Error:Data in Merchant name is changed but to a wrong value";
                                                            softAssert.assertEquals(ActualName,EditedName,Comm);

                                                            //if Editing is done check the Presence of Next button
                                                            if(ActualName.equals(EditedName))
                                                            {
                                                                Check=editMerchantScreen.CheckPresenceOfNextButton();
                                                                Comm="Error:Next Button doesn't exist in edit merchant screen";
                                                                softAssert.assertEquals(Check,true,Comm);

                                                                //if next button exist click on it
                                                                if(Check)
                                                                {
                                                                    SchemeScreenAfterEditMerchantScreen schemeScreenAfterEditMerchantScreen=editMerchantScreen.ClickOnNextButton();
                                                                    //Check Navigation to Scheme screen
                                                                    Check=schemeScreenAfterEditMerchantScreen.CheckPresenceOfChooseSchemePriorityScreen();
                                                                    Comm="Despite Clicking on next button in Edit Merchant screen user isn't navigated to Schemes screen";
                                                                    softAssert.assertEquals(Check,true,Comm);
                                                                    //if navigated successfully to schemes screen choose random scheme priority
                                                                    if(Check)
                                                                    {
                                                                        schemeScreenAfterEditMerchantScreen.ChooseSchemeArrangement();
                                                                        //Check Presence of Finish Button
                                                                        Check=schemeScreenAfterEditMerchantScreen.CheckPresenceOfFinishButton();
                                                                        Comm="Error:Finish button doesn't exist in schemes screen";
                                                                        softAssert.assertEquals(Check,true,Comm);

                                                                        //if Finish button exist click on it
                                                                        if(Check)
                                                                        {
                                                                            sAdminHomePage=schemeScreenAfterEditMerchantScreen.ClickOnFinishButton();

                                                                                Check=sAdminHomePage.CheckBeingAtSAHomePage();
                                                                                Comm="Error:Despite Clicking on Finish button user isn't navigated to home screen";
                                                                                softAssert.assertEquals(Check,true,Comm);

                                                                                //if Navigated successfully to SAHomePage Check the Presence of Refresh button then click on it
                                                                                if(Check)
                                                                                {
                                                                                    Check=sAdminHomePage.CheckPresenceOfRefreshButton();
                                                                                    Comm="Error:Refresh button doesn't exist in SA Home Page";
                                                                                    softAssert.assertEquals(Check,true,Comm);
                                                                                    if(Check)
                                                                                    {
                                                                                        sAdminHomePage.ClickOnRefreshButton();
                                                                                        //Check That the Merchant with the Edited name exist
                                                                                        SAdminHomePage.MerchantDetails merchantDetails=sAdminHomePage.GetaSpecificMerchantFromMerchantTable(EditedName);
                                                                                        Comm="Can't Find Merchant with its edited name";
                                                                                        softAssert.assertNotNull(merchantDetails,Comm);
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
    @Test(description = "Validation of change Unique Merchant Code",priority =110)
    public void TC_PSA_0110() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Edit Merchant button
                                        if (Check) {
                                            Check = sAdminHomePage.CheckPresenceOfTableOfMerchants();
                                            Comm = "Error:Merchant table isn't exist";
                                            softAssert.assertEquals(Check, true, Comm);
                                            if (Check) {
                                                Thread.sleep(2000);
                                                //Check that Edit button of a specific merchant exist
                                                Check = sAdminHomePage.CheckThePresenceOfEditButtonForASpecificMerchant(props.getProperty("MerchantToEdit"));
                                                Comm = "Error: Edit Button for Merchant " + props.getProperty("MerchantToEdit") + "isn't exist in the SA home page";
                                                softAssert.assertEquals(Check, true, Comm);

                                                //If Edit Merchant Button exist click on it and then check that Edit Merchant screen appears
                                                if (Check) {
                                                    EditMerchantScreen editMerchantScreen = sAdminHomePage.ClickOnEditButton();
                                                    //Check presence of Edit Merchant screen
                                                    Check = editMerchantScreen.CheckPresenceOfEditMerchantScreen();
                                                    Comm = "Error:Clicking on the Edit Merchant Button doesn't navigate to Edit Merchant screen";
                                                    softAssert.assertEquals(Check, true, Comm);

                                                    //if Edit Screen opened successfully check the presence of merchant Name field then get the name of the merchant
                                                    if (Check) {
                                                        Check = editMerchantScreen.CheckPresenceOfMerchantNameField();
                                                        Comm = "Error:Merchant Name Filed doesn't exist in Edit Merchant Screen";
                                                        softAssert.assertEquals(Check, true, Comm);

                                                        //if Merchant name field exist get the Merchant name then check the Presence of Merchant code field
                                                        if (Check) {
                                                            //Read Data in Merchant Name Field
                                                            String MerchantName = editMerchantScreen.ReadDataInMerchantNameField();

                                                            Check = editMerchantScreen.CheckPresenceOfMerchantCodeField();
                                                            Comm = "Error:Merchant Code field doesn't exist in Edit Merchant screen";
                                                            softAssert.assertEquals(Check, true, Comm);

                                                            //if Merchant Code filed exist Edit it
                                                            if (Check) {
                                                                String OldMerchantCode = editMerchantScreen.ReadDataInMerchantCodeField();
                                                                String EditedCode = "Edited Code";
                                                                editMerchantScreen.ClearMerchantCodeField();
                                                                editMerchantScreen.EditMerchantCode(EditedCode);
                                                                //Read Data in Merchant Code Field and check that its edited
                                                                String ActualCode = editMerchantScreen.ReadDataInMerchantCodeField();
                                                                softAssert.assertEquals(ActualCode, EditedCode, Comm);
                                                                Comm = "Error:Data in merchant code filed isn't Edited";
                                                                System.out.println(ActualCode);
                                                                System.out.println(OldMerchantCode);
                                                                softAssert.assertNotEquals(ActualCode, OldMerchantCode, Comm);
                                                                //if Data is changed check that its edited correctly
                                                                if (!ActualCode.equals(OldMerchantCode)) {
                                                                    Comm = "Error:Data in Merchant Code is changed but to a wrong value";
                                                                    softAssert.assertEquals(ActualCode, EditedCode, Comm);

                                                                    //if Editing is done check the Presence of Next button
                                                                    if (ActualCode.equals(EditedCode)) {
                                                                        Check = editMerchantScreen.CheckPresenceOfNextButton();
                                                                        Comm = "Error:Next Button doesn't exist in edit merchant screen";
                                                                        softAssert.assertEquals(Check, true, Comm);

                                                                        //if next button exist click on it
                                                                        if (Check) {
                                                                            SchemeScreenAfterEditMerchantScreen schemeScreenAfterEditMerchantScreen = editMerchantScreen.ClickOnNextButton();
                                                                            //Check Navigation to Scheme screen
                                                                            Check = schemeScreenAfterEditMerchantScreen.CheckPresenceOfChooseSchemePriorityScreen();
                                                                            Comm = "Despite Clicking on next button in Edit Merchant screen user isn't navigated to Schemes screen";
                                                                            softAssert.assertEquals(Check, true, Comm);
                                                                            //if navigated successfully to schemes screen choose random scheme priority
                                                                            if (Check) {
                                                                                schemeScreenAfterEditMerchantScreen.ChooseSchemeArrangement();
                                                                                //Check Presence of Finish Button
                                                                                Check = schemeScreenAfterEditMerchantScreen.CheckPresenceOfFinishButton();
                                                                                Comm = "Error:Finish button doesn't exist in schemes screen";
                                                                                softAssert.assertEquals(Check, true, Comm);

                                                                                //if Finish button exist click on it
                                                                                if (Check) {
                                                                                    sAdminHomePage = schemeScreenAfterEditMerchantScreen.ClickOnFinishButton();

                                                                                    Check = sAdminHomePage.CheckBeingAtSAHomePage();
                                                                                    Comm = "Error:Despite Clicking on Finish button user isn't navigated to home screen";
                                                                                    softAssert.assertEquals(Check, true, Comm);

                                                                                    //if Navigated successfully to SAHomePage Check the Presence of Refresh button then click on it
                                                                                    if (Check) {
                                                                                        Check = sAdminHomePage.CheckPresenceOfRefreshButton();
                                                                                        Comm = "Error:Refresh button doesn't exist in SA Home Page";
                                                                                        softAssert.assertEquals(Check, true, Comm);
                                                                                        if (Check) {
                                                                                            sAdminHomePage.ClickOnRefreshButton();
                                                                                            //Check navigation to SA home page
                                                                                            Check = sAdminHomePage.CheckBeingAtSAHomePage();
                                                                                            Comm = "Error:Despite Clicking on refresh button isn't navigated to the SA Home Page";
                                                                                            softAssert.assertEquals(Check, true, Comm);

                                                                                            //If navigated successfully to SA home page check the presence of table of merchants
                                                                                            if (Check) {
                                                                                                Check = sAdminHomePage.CheckPresenceOfTableOfMerchants();
                                                                                                Comm = "Error:Merchant table isn't exist";
                                                                                                softAssert.assertEquals(Check, true, Comm);
                                                                                                if (Check) {
                                                                                                    Thread.sleep(2000);
                                                                                                    //Get the Details of the Merchant which has been edited
                                                                                                    SAdminHomePage.MerchantDetails merchantDetails = sAdminHomePage.GetaSpecificMerchantFromMerchantTable(MerchantName);
                                                                                                    Comm = "Can't Find Merchant with Merchant" + MerchantName;
                                                                                                    softAssert.assertNotNull(merchantDetails, Comm);

                                                                                                    //if Merchant is found check that its code filed has been edited
                                                                                                    if (merchantDetails != null) {
                                                                                                        Comm = "Error:Merchant code doesn't change";
                                                                                                        softAssert.assertNotEquals(merchantDetails.MerchantCode, OldMerchantCode, Comm);

                                                                                                        //if Merchant code changed check that it has been changed to the right data
                                                                                                        if (!merchantDetails.MerchantCode.equals(OldMerchantCode)) {
                                                                                                            Comm = "Error:The Code has been changed to wrong value";
                                                                                                            softAssert.assertEquals(merchantDetails.MerchantCode, EditedCode, Comm);
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
                    }
                }
            }
        }
        softAssert.assertAll();
    }
    @Test(description = "Validation of replacing the email with an invalid email",priority =111)
    public void TC_PSA_0111() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Edit Merchant button
                                        if (Check)
                                        {
                                            //Check that Edit Merchant button exist
                                            Check=sAdminHomePage.CheckPresenceOfEditMerchantButton();
                                            Comm="Error: Edit Merchant Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Edit Merchant Button exist click on it and then check that Edit Merchant screen appears
                                            if (Check)
                                            {
                                                EditMerchantScreen editMerchantScreen=sAdminHomePage.ClickOnEditButton();
                                                //Check presence of Edit Merchant screen
                                                Check=editMerchantScreen.CheckPresenceOfEditMerchantScreen();
                                                Comm="Error:Clicking on the Edit Merchant Button doesn't navigate to Edit Merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if Edit Screen opened successfully check the presence of merchant Email field
                                                if (Check)
                                                {
                                                    Check=editMerchantScreen.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email field doesn't exist in Edit Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Merchant Email filed exist Edit it
                                                    if(Check)
                                                    {
                                                        String OldMerchantEmail=editMerchantScreen.ReadDataInMerchantEmailField();
                                                        String EditedEmail="Edited Email";
                                                        editMerchantScreen.ClearMerchantEmailField();
                                                        editMerchantScreen.EditMerchantEmail(EditedEmail);
                                                        //Read Data in Merchant Email Field and check that its edited
                                                        String ActualEmail=editMerchantScreen.ReadDataInMerchantEmailField();
                                                        softAssert.assertEquals(ActualEmail,EditedEmail,Comm);
                                                        Comm="Error:Data in merchant Email filed isn't Edited";
                                                        softAssert.assertNotEquals(ActualEmail,OldMerchantEmail,Comm);
                                                        //if Data is changed check that its edited correctly
                                                        if(!ActualEmail.equals(OldMerchantEmail))
                                                        {
                                                            Comm="Error:Data in Merchant Email is changed but to a wrong value";
                                                            softAssert.assertEquals(ActualEmail,EditedEmail,Comm);

                                                            //if edit is done successfully Check The Presence of next button
                                                            Check=editMerchantScreen.CheckPresenceOfNextButton();
                                                            Comm="Error:Next button doesn't exist in Edit Merchant screen";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //if next button exist click on it
                                                            if(Check)
                                                            {
                                                                editMerchantScreen.ClickOnNextButton();
                                                                //Check The Presence of Error Msg
                                                                Check=editMerchantScreen.CheckPresenceOfMerchantEmailErrorMsg();
                                                                Comm="Error:Despite inserting invalid email no error message appears";
                                                                softAssert.assertEquals(Check,true,Comm);
                                                                //if error message appears check its text
                                                                if(Check)
                                                                {
                                                                    String ExpectedMsg=props.getProperty("InvalidEmailErrorMsg");
                                                                    String ActualMsg=editMerchantScreen.GetTextOfMerchantEmailErrorMsg();
                                                                    Comm="Error Message isn't clear";
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
        softAssert.assertAll();
    }

    @Test(description = "Validation of change Merchant Email",priority =112)
    public void TC_PSA_0112() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Edit Merchant button
                                        if (Check)
                                        {
                                            //Check that Edit Merchant button exist
                                            Check=sAdminHomePage.CheckPresenceOfEditMerchantButton();
                                            Comm="Error: Edit Merchant Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Edit Merchant Button exist click on it and then check that Edit Merchant screen appears
                                            if (Check)
                                            {
                                                EditMerchantScreen editMerchantScreen=sAdminHomePage.ClickOnEditButton();
                                                //Check presence of Edit Merchant screen
                                                Check=editMerchantScreen.CheckPresenceOfEditMerchantScreen();
                                                Comm="Error:Clicking on the Edit Merchant Button doesn't navigate to Edit Merchant screen";
                                                softAssert.assertEquals(Check,true,Comm);

                                                //if Edit Screen opened successfully check the presence of merchant Email field
                                                if (Check)
                                                {
                                                    Check=editMerchantScreen.CheckPresenceOfMerchantEmailField();
                                                    Comm="Error:Merchant Email field doesn't exist in Edit Merchant screen";
                                                    softAssert.assertEquals(Check,true,Comm);

                                                    //if Merchant Email filed exist Edit it
                                                    if(Check)
                                                    {
                                                        String OldMerchantEmail=editMerchantScreen.ReadDataInMerchantEmailField();
                                                        String EditedEmail="Edited Email@sbs.com";
                                                        editMerchantScreen.ClearMerchantEmailField();
                                                        editMerchantScreen.EditMerchantEmail(EditedEmail);
                                                        //Read Data in Merchant Email Field and check that its edited
                                                        String ActualEmail=editMerchantScreen.ReadDataInMerchantEmailField();
                                                        softAssert.assertEquals(ActualEmail,EditedEmail,Comm);
                                                        Comm="Error:Data in merchant Email filed isn't Edited";
                                                        softAssert.assertNotEquals(ActualEmail,OldMerchantEmail,Comm);
                                                        //if Data is changed check that its edited correctly
                                                        if(!ActualEmail.equals(OldMerchantEmail))
                                                        {
                                                            Comm="Error:Data in Merchant Email is changed but to a wrong value";
                                                            softAssert.assertEquals(ActualEmail,EditedEmail,Comm);
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
