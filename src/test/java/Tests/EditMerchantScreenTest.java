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
                                        if (Check) {
                                            Check = sAdminHomePage.CheckPresenceOfTableOfMerchants();
                                            Comm = "Error:Merchant table isn't exist";
                                            softAssert.assertEquals(Check, true, Comm);
                                            if (Check) {
                                                Thread.sleep(2000);
                                                //Check that Edit button of a specific merchant exist
                                                Check = sAdminHomePage.CheckThePresenceOfEditButtonForASpecificMerchant(props.getProperty("MerchantWhichWeWantToEditHisName"));
                                                Comm = "Error: Edit Button for Merchant " + props.getProperty("MerchantToEdit") + "isn't exist in the SA home page";
                                                softAssert.assertEquals(Check, true, Comm);

                                                //If Edit Merchant Button exist click on it and then check that Edit Merchant screen appears
                                                if (Check) {
                                                    String OldMerchantName=props.getProperty("MerchantWhichWeWantToEditHisName");
                                                    //EditMerchantScreen editMerchantScreen = sAdminHomePage.ClickOnEditButton();
                                                    EditMerchantScreen editMerchantScreen = sAdminHomePage.OpenEditScreenForASpecificMerchant(OldMerchantName);

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
                                                            String ActualMerchantName = editMerchantScreen.ReadDataInMerchantNameField();
                                                            //Check that we are editing the desired merchant
                                                            Comm = "Error:you are editing the wrong merchant";
                                                            softAssert.assertEquals(ActualMerchantName, OldMerchantName, Comm);

                                                            //if we are editing the correct merchant edit the name
                                                            if(ActualMerchantName.equals(OldMerchantName))
                                                            {
                                                                String EditedMerchantName = OldMerchantName+"Edited Name";
                                                                editMerchantScreen.ClearMerchantNameField();
                                                                editMerchantScreen.EditMerchantName(EditedMerchantName);
                                                                //Read Data in Merchant Name Field and check that its edited
                                                                ActualMerchantName = editMerchantScreen.ReadDataInMerchantNameField();
                                                                Comm = "Error:Data in merchant name filed isn't Edited";
                                                                System.out.println(ActualMerchantName);
                                                                System.out.println(OldMerchantName);
                                                                softAssert.assertNotEquals(ActualMerchantName, OldMerchantName, Comm);
                                                                //if Data is changed check that its edited correctly
                                                                if (!ActualMerchantName.equals(OldMerchantName)) {
                                                                    Comm = "Error:Data in Merchant Name is changed but to a wrong value";
                                                                    softAssert.assertEquals(ActualMerchantName, EditedMerchantName, Comm);

                                                                    //if Editing is done check the Presence of Next button
                                                                    if (ActualMerchantName.equals(EditedMerchantName)) {
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
                                                                                        //if refresh button exist click on it
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
                                                                                                    //Check That the Merchant with the Edited name exist
                                                                                                    SAdminHomePage.MerchantDetails merchantDetails = sAdminHomePage.GetaSpecificMerchantFromMerchantTable(EditedMerchantName);
                                                                                                    Comm = "Can't Find Merchant with its edited name";
                                                                                                    softAssert.assertNotEquals(merchantDetails,null, Comm);

                                                                                                    //if we can't find merchant with the new name search on it with the old name
                                                                                                    if(merchantDetails==null)
                                                                                                    {
                                                                                                        System.out.println("I'm here");
                                                                                                        merchantDetails=sAdminHomePage.GetaSpecificMerchantFromMerchantTable(OldMerchantName);
                                                                                                        Comm="Merchant name isn't edited successfully , still has the old name";
                                                                                                        softAssert.assertEquals(merchantDetails,null,Comm);

                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }


                                                                                }
                                                                            }

                                                                        }
                                                                    }
                                                                }

                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
                                                    String MerchantToEditName=props.getProperty("MerchantToEdit");
                                                    //EditMerchantScreen editMerchantScreen = sAdminHomePage.ClickOnEditButton();
                                                    EditMerchantScreen editMerchantScreen = sAdminHomePage.OpenEditScreenForASpecificMerchant(MerchantToEditName);

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
                                                            String ActualMerchantName = editMerchantScreen.ReadDataInMerchantNameField();
                                                            //Check that we are editing the desired merchant
                                                            Comm = "Error:you are editing the wrong merchant";
                                                            softAssert.assertEquals(ActualMerchantName, MerchantToEditName, Comm);

                                                            //if we are editing the correct merchant check the Presence of merchant code field
                                                            if(ActualMerchantName.equals(MerchantToEditName))
                                                            {
                                                            Check = editMerchantScreen.CheckPresenceOfMerchantCodeField();
                                                            Comm = "Error:Merchant Code field doesn't exist in Edit Merchant screen";
                                                            softAssert.assertEquals(Check, true, Comm);

                                                            //if Merchant Code filed exist Edit it
                                                            if (Check) {
                                                                String OldMerchantCode = editMerchantScreen.ReadDataInMerchantCodeField();
                                                                String EditedCode = OldMerchantCode+"Edited Code";
                                                                editMerchantScreen.ClearMerchantCodeField();
                                                                editMerchantScreen.EditMerchantCode(EditedCode);
                                                                //Read Data in Merchant Code Field and check that its edited
                                                                String ActualCode = editMerchantScreen.ReadDataInMerchantCodeField();
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
                                                                                        //if refresh button exist click on it
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
                                                                                                    SAdminHomePage.MerchantDetails merchantDetails = sAdminHomePage.GetaSpecificMerchantFromMerchantTable(MerchantToEditName);
                                                                                                    Comm = "Can't Find Merchant with Merchant" + MerchantToEditName;
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
                                                    String MerchantToEditName=props.getProperty("MerchantToEdit");
                                                    //EditMerchantScreen editMerchantScreen = sAdminHomePage.ClickOnEditButton();
                                                    EditMerchantScreen editMerchantScreen = sAdminHomePage.OpenEditScreenForASpecificMerchant(MerchantToEditName);

                                                    //Check presence of Edit Merchant screen
                                                    Check = editMerchantScreen.CheckPresenceOfEditMerchantScreen();
                                                    Comm = "Error:Clicking on the Edit Merchant Button doesn't navigate to Edit Merchant screen";
                                                    softAssert.assertEquals(Check, true, Comm);

                                                    //if Edit Screen opened successfully check the presence of merchant Name field then get the name of the merchant
                                                    if (Check) {
                                                        Check = editMerchantScreen.CheckPresenceOfMerchantNameField();
                                                        Comm = "Error:Merchant Name Filed doesn't exist in Edit Merchant Screen";
                                                        softAssert.assertEquals(Check, true, Comm);

                                                        //if Merchant name field exist get the Merchant name then check the Presence of Merchant Email field
                                                        if (Check) {
                                                            //Read Data in Merchant Name Field
                                                            String ActualMerchantName = editMerchantScreen.ReadDataInMerchantNameField();
                                                            //Check that we are editing the desired merchant
                                                            Comm = "Error:you are editing the wrong merchant";
                                                            softAssert.assertEquals(ActualMerchantName, MerchantToEditName, Comm);

                                                            //if we are editing the correct merchant check the Presence of merchant Email field
                                                            if(ActualMerchantName.equals(MerchantToEditName))
                                                            {
                                                                Check = editMerchantScreen.CheckPresenceOfMerchantEmailField();
                                                                Comm = "Error:Merchant Email field doesn't exist in Edit Merchant screen";
                                                                softAssert.assertEquals(Check, true, Comm);

                                                                //if Merchant Email filed exist Edit it
                                                                if (Check) {
                                                                    String OldMerchantEmail = editMerchantScreen.ReadDataInMerchantEmailField();
                                                                    String EditedMerchantEmail = MerchantToEditName+"Edited"; //edit with invalid email
                                                                    editMerchantScreen.ClearMerchantEmailField();
                                                                    editMerchantScreen.EditMerchantEmail(EditedMerchantEmail);
                                                                    //Read Data in Merchant Email Field and check that its edited
                                                                    String ActualMerchantEmail = editMerchantScreen.ReadDataInMerchantEmailField();
                                                                    Comm = "Error:Data in merchant Email filed isn't Edited";
                                                                    System.out.println(ActualMerchantEmail);
                                                                    System.out.println(OldMerchantEmail);
                                                                    softAssert.assertNotEquals(ActualMerchantEmail, OldMerchantEmail, Comm);
                                                                    //if Data is changed check that its edited correctly
                                                                    if (!ActualMerchantEmail.equals(OldMerchantEmail)) {
                                                                        Comm = "Error:Data in Merchant Email is changed but to a wrong value";
                                                                        softAssert.assertEquals(ActualMerchantEmail, EditedMerchantEmail, Comm);

                                                                        //if Editing is done check the Presence of Next button
                                                                        if (ActualMerchantEmail.equals(EditedMerchantEmail)) {
                                                                            Check = editMerchantScreen.CheckPresenceOfNextButton();
                                                                            Comm = "Error:Next Button doesn't exist in edit merchant screen";
                                                                            softAssert.assertEquals(Check, true, Comm);

                                                                            //if next button exist click on it
                                                                            if (Check) {
                                                                                SchemeScreenAfterEditMerchantScreen schemeScreenAfterEditMerchantScreen = editMerchantScreen.ClickOnNextButton();
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
                        Comm = "Error:Clicking on the Login button doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
                        softAssert.assertEquals(arr[0], "true", Comm);

                        //If navigated successfully to OTP page insert letters and numbers in OTP filed
                        if (arr[0].equals("true")) {
                            //Check presence of OTP field
                            Check = otpPage.CheckThePresenceOfOTPFields();
                            Comm = "Error:The OTP filed isn't exist";
                            softAssert.assertEquals(Check, true, Comm);

                            //If OTP field exist insert value in it
                            if (Check) {
                                String OTP = "111111";
                                otpPage.ClearOTPFields();
                                otpPage.InsertOTP(OTP);
                                //Check that confirm button exist
                                Check = otpPage.CheckThePresenceOfConfirmButton();
                                Comm = "Confirm button isn't exist in the OTP Page";
                                softAssert.assertEquals(Check, true, Comm);

                                //if button exist check that its enabled
                                if (Check) {
                                    Check = otpPage.IsConfirmButtonEnabled();
                                    // if button is enabled click on it
                                    if (Check) {
                                        sAdminHomePage = otpPage.ClickOnConfirmButton();
                                        //Check navigation to SA home page
                                        Check = sAdminHomePage.CheckBeingAtSAHomePage();
                                        Comm = "Error:Despite entering the right OTP user isn't navigated to the SA Home Page";
                                        softAssert.assertEquals(Check, true, Comm);

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
                                                    String MerchantToEditName = props.getProperty("MerchantToEdit");
                                                    //EditMerchantScreen editMerchantScreen = sAdminHomePage.ClickOnEditButton();
                                                    EditMerchantScreen editMerchantScreen = sAdminHomePage.OpenEditScreenForASpecificMerchant(MerchantToEditName);

                                                    //Check presence of Edit Merchant screen
                                                    Check = editMerchantScreen.CheckPresenceOfEditMerchantScreen();
                                                    Comm = "Error:Clicking on the Edit Merchant Button doesn't navigate to Edit Merchant screen";
                                                    softAssert.assertEquals(Check, true, Comm);

                                                    //if Edit Screen opened successfully check the presence of merchant Name field then get the name of the merchant
                                                    if (Check) {
                                                        Check = editMerchantScreen.CheckPresenceOfMerchantNameField();
                                                        Comm = "Error:Merchant Name Filed doesn't exist in Edit Merchant Screen";
                                                        softAssert.assertEquals(Check, true, Comm);

                                                        //if Merchant name field exist get the Merchant name then check the Presence of Merchant Email field
                                                        if (Check) {
                                                            //Read Data in Merchant Name Field
                                                            String ActualMerchantName = editMerchantScreen.ReadDataInMerchantNameField();
                                                            //Check that we are editing the desired merchant
                                                            Comm = "Error:you are editing the wrong merchant";
                                                            softAssert.assertEquals(ActualMerchantName, MerchantToEditName, Comm);

                                                            //if we are editing the correct merchant check the Presence of merchant Email field
                                                            if (ActualMerchantName.equals(MerchantToEditName)) {
                                                                Check = editMerchantScreen.CheckPresenceOfMerchantEmailField();
                                                                Comm = "Error:Merchant Email field doesn't exist in Edit Merchant screen";
                                                                softAssert.assertEquals(Check, true, Comm);

                                                                //if Merchant Email filed exist Edit it
                                                                if (Check) {
                                                                    String OldMerchantEmail = editMerchantScreen.ReadDataInMerchantEmailField();
                                                                    String EditedMerchantEmail = MerchantToEditName + "Edited@sbs.com"; //edit with valid email
                                                                    editMerchantScreen.ClearMerchantEmailField();
                                                                    editMerchantScreen.EditMerchantEmail(EditedMerchantEmail);
                                                                    //Read Data in Merchant Email Field and check that its edited
                                                                    String ActualMerchantEmail = editMerchantScreen.ReadDataInMerchantEmailField();
                                                                    Comm = "Error:Data in merchant Email filed isn't Edited";
                                                                    System.out.println(ActualMerchantEmail);
                                                                    System.out.println(OldMerchantEmail);
                                                                    softAssert.assertNotEquals(ActualMerchantEmail, OldMerchantEmail, Comm);
                                                                    //if Data is changed check that its edited correctly
                                                                    if (!ActualMerchantEmail.equals(OldMerchantEmail)) {
                                                                        Comm = "Error:Data in Merchant Email is changed but to a wrong value";
                                                                        softAssert.assertEquals(ActualMerchantEmail, EditedMerchantEmail, Comm);

                                                                        //if Editing is done check the Presence of Next button
                                                                        if (ActualMerchantEmail.equals(EditedMerchantEmail)) {
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
                                                                                            //if refresh button exist click on it
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
                                                                                                        SAdminHomePage.MerchantDetails merchantDetails = sAdminHomePage.GetaSpecificMerchantFromMerchantTable(MerchantToEditName);
                                                                                                        Comm = "Can't Find Merchant with Merchant" + MerchantToEditName;
                                                                                                        softAssert.assertNotNull(merchantDetails, Comm);

                                                                                                        //if Merchant is found Open its Edit screen then check that its Email filed has been edited
                                                                                                        if (merchantDetails != null) {
                                                                                                            editMerchantScreen = sAdminHomePage.OpenEditScreenForASpecificMerchant(MerchantToEditName);
                                                                                                            //check that edit screen is opened successfully
                                                                                                            Check = editMerchantScreen.CheckPresenceOfEditMerchantScreen();
                                                                                                            Comm = "Edit Merchant screen isn't opened";
                                                                                                            softAssert.assertEquals(Check, true, Comm);

                                                                                                            //if edit screen is opened successfully check the data in merchant email filed
                                                                                                            if (Check) {
                                                                                                                ActualMerchantEmail = editMerchantScreen.ReadDataInMerchantEmailField();
                                                                                                                Comm = "Error:Merchant Email doesn't change";
                                                                                                                softAssert.assertNotEquals(ActualMerchantName, OldMerchantEmail, Comm);

                                                                                                                //if Merchant Email changed check that it has been changed to the right data
                                                                                                                if (!ActualMerchantName.equals(OldMerchantEmail)) {
                                                                                                                    Comm = "Error:The Email has been changed to wrong value";
                                                                                                                    softAssert.assertEquals(ActualMerchantEmail, EditedMerchantEmail, Comm);
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }


                                                                                    }
                                                                                }

                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
    @Test(description = "Validation of change Merchant Country",priority =115)
    public void TC_PSA_0115() throws IOException, InterruptedException {

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
                        Comm = "Error:Clicking on the Login button doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
                        softAssert.assertEquals(arr[0], "true", Comm);

                        //If navigated successfully to OTP page insert letters and numbers in OTP filed
                        if (arr[0].equals("true")) {
                            //Check presence of OTP field
                            Check = otpPage.CheckThePresenceOfOTPFields();
                            Comm = "Error:The OTP filed isn't exist";
                            softAssert.assertEquals(Check, true, Comm);

                            //If OTP field exist insert value in it
                            if (Check) {
                                String OTP = "111111";
                                otpPage.ClearOTPFields();
                                otpPage.InsertOTP(OTP);
                                //Check that confirm button exist
                                Check = otpPage.CheckThePresenceOfConfirmButton();
                                Comm = "Confirm button isn't exist in the OTP Page";
                                softAssert.assertEquals(Check, true, Comm);

                                //if button exist check that its enabled
                                if (Check) {
                                    Check = otpPage.IsConfirmButtonEnabled();
                                    // if button is enabled click on it
                                    if (Check) {
                                        sAdminHomePage = otpPage.ClickOnConfirmButton();
                                        //Check navigation to SA home page
                                        Check = sAdminHomePage.CheckBeingAtSAHomePage();
                                        Comm = "Error:Despite entering the right OTP user isn't navigated to the SA Home Page";
                                        softAssert.assertEquals(Check, true, Comm);

                                        //If navigated successfully to SA home page check the Edit Merchant button
                                        if (Check) {
                                            Check = sAdminHomePage.CheckPresenceOfTableOfMerchants();
                                            Comm = "Error:Merchant table isn't exist";
                                            softAssert.assertEquals(Check, true, Comm);
                                            if (Check) {
                                                //Thread.sleep(2000);
                                                //Check that Edit button of a specific merchant exist
                                                Check = sAdminHomePage.CheckThePresenceOfEditButtonForASpecificMerchant(props.getProperty("MerchantToEdit"));
                                                Comm = "Error: Edit Button for Merchant " + props.getProperty("MerchantToEdit") + "isn't exist in the SA home page";
                                                softAssert.assertEquals(Check, true, Comm);

                                                //If Edit Merchant Button exist click on it and then check that Edit Merchant screen appears
                                                if (Check) {
                                                    String MerchantToEditName = props.getProperty("MerchantToEdit");
                                                    //EditMerchantScreen editMerchantScreen = sAdminHomePage.ClickOnEditButton();
                                                    EditMerchantScreen editMerchantScreen = sAdminHomePage.OpenEditScreenForASpecificMerchant(MerchantToEditName);

                                                    //Check presence of Edit Merchant screen
                                                    Check = editMerchantScreen.CheckPresenceOfEditMerchantScreen();
                                                    Comm = "Error:Clicking on the Edit Merchant Button doesn't navigate to Edit Merchant screen";
                                                    softAssert.assertEquals(Check, true, Comm);

                                                    //if Edit Screen opened successfully check the presence of merchant Name field then get the name of the merchant
                                                    if (Check) {
                                                        Check = editMerchantScreen.CheckPresenceOfMerchantNameField();
                                                        Comm = "Error:Merchant Name Filed doesn't exist in Edit Merchant Screen";
                                                        softAssert.assertEquals(Check, true, Comm);

                                                        //if Merchant name field exist get the Merchant name then check the Presence of Merchant Country field
                                                        if (Check) {
                                                            //Read Data in Merchant Name Field
                                                            String ActualMerchantName = editMerchantScreen.ReadDataInMerchantNameField();
                                                            //Check that we are editing the desired merchant
                                                            Comm = "Error:you are editing the wrong merchant";
                                                            softAssert.assertEquals(ActualMerchantName, MerchantToEditName, Comm);

                                                            //if we are editing the correct merchant check the Presence of merchant country field
                                                            if (ActualMerchantName.equals(MerchantToEditName)) {
                                                                Check = editMerchantScreen.CheckPresenceOfMerchantCountryField();
                                                                Comm = "Error:Merchant Country field doesn't exist in Edit Merchant screen";
                                                                softAssert.assertEquals(Check, true, Comm);

                                                                //if Merchant Country filed exist Edit it
                                                                if (Check) {
                                                                    String OldMerchantCountry = editMerchantScreen.ReadDataInMerchantCountryField();
                                                                    String EditedMerchantCountry =props.getProperty("EditedMerchantCountry");
                                                                    editMerchantScreen.EditMerchantCountry(EditedMerchantCountry);
                                                                    //Read Data in Merchant Country Field and check that its edited
                                                                    String ActualMerchantCountry = editMerchantScreen.ReadDataInMerchantCountryField();
                                                                    Comm = "Error:Data in merchant Country filed isn't Edited";
                                                                    System.out.println(ActualMerchantCountry);
                                                                    System.out.println(OldMerchantCountry);
                                                                    softAssert.assertNotEquals(ActualMerchantCountry, OldMerchantCountry, Comm);
                                                                    //if Data is changed check that its edited correctly
                                                                    if (!ActualMerchantName.equals(OldMerchantCountry)) {
                                                                        Comm = "Error:Data in Merchant country is changed but to a wrong value";
                                                                        softAssert.assertEquals(ActualMerchantCountry, EditedMerchantCountry, Comm);

                                                                        //if Editing is done check the Presence of Next button
                                                                        if (ActualMerchantCountry.equals(EditedMerchantCountry)) {
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
                                                                                            //if refresh button exist click on it
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
                                                                                                       //Thread.sleep(3000);
                                                                                                        //Get the Details of the Merchant which has been edited
                                                                                                        SAdminHomePage.MerchantDetails merchantDetails = sAdminHomePage.GetaSpecificMerchantFromMerchantTable(MerchantToEditName);
                                                                                                        Comm = "Can't Find Merchant with Merchant" + MerchantToEditName;
                                                                                                        softAssert.assertNotNull(merchantDetails, Comm);

                                                                                                        //if Merchant is found check that its Country filed has been edited
                                                                                                        if (merchantDetails != null) {
                                                                                                            Comm = "Error:Merchant Country doesn't change";
                                                                                                            softAssert.assertNotEquals(merchantDetails.Country, OldMerchantCountry, Comm);

                                                                                                            //if Merchant country changed check that it has been changed to the right data
                                                                                                            if (!merchantDetails.Country.equals(OldMerchantCountry)) {
                                                                                                                Comm = "Error:The Country has been changed to wrong value";
                                                                                                                softAssert.assertEquals(merchantDetails.Country, EditedMerchantCountry, Comm);
                                                                                                            }
                                                                                                        }


                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }


                                                                                    }
                                                                                }

                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
    @Test(description = "Validation of editing merchant country without editing the merchant city",priority =116)
    public void TC_PSA_0116() throws IOException, InterruptedException {

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
                        Comm = "Error:Clicking on the Login button doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
                        softAssert.assertEquals(arr[0], "true", Comm);

                        //If navigated successfully to OTP page insert letters and numbers in OTP filed
                        if (arr[0].equals("true")) {
                            //Check presence of OTP field
                            Check = otpPage.CheckThePresenceOfOTPFields();
                            Comm = "Error:The OTP filed isn't exist";
                            softAssert.assertEquals(Check, true, Comm);

                            //If OTP field exist insert value in it
                            if (Check) {
                                String OTP = "111111";
                                otpPage.ClearOTPFields();
                                otpPage.InsertOTP(OTP);
                                //Check that confirm button exist
                                Check = otpPage.CheckThePresenceOfConfirmButton();
                                Comm = "Confirm button isn't exist in the OTP Page";
                                softAssert.assertEquals(Check, true, Comm);

                                //if button exist check that its enabled
                                if (Check) {
                                    Check = otpPage.IsConfirmButtonEnabled();
                                    // if button is enabled click on it
                                    if (Check) {
                                        sAdminHomePage = otpPage.ClickOnConfirmButton();
                                        //Check navigation to SA home page
                                        Check = sAdminHomePage.CheckBeingAtSAHomePage();
                                        Comm = "Error:Despite entering the right OTP user isn't navigated to the SA Home Page";
                                        softAssert.assertEquals(Check, true, Comm);

                                        //If navigated successfully to SA home page check the Edit Merchant button
                                        if (Check) {
                                            Check = sAdminHomePage.CheckPresenceOfTableOfMerchants();
                                            Comm = "Error:Merchant table isn't exist";
                                            softAssert.assertEquals(Check, true, Comm);
                                            if (Check) {
                                               // Thread.sleep(3000);
                                                //Check that Edit button of a specific merchant exist
                                                Check = sAdminHomePage.CheckThePresenceOfEditButtonForASpecificMerchant(props.getProperty("MerchantToEdit"));
                                                Comm = "Error: Edit Button for Merchant " + props.getProperty("MerchantToEdit") + "isn't exist in the SA home page";
                                                softAssert.assertEquals(Check, true, Comm);

                                                //If Edit Merchant Button exist click on it and then check that Edit Merchant screen appears
                                                if (Check) {
                                                    String MerchantToEditName = props.getProperty("MerchantToEdit");
                                                    //EditMerchantScreen editMerchantScreen = sAdminHomePage.ClickOnEditButton();
                                                    EditMerchantScreen editMerchantScreen = sAdminHomePage.OpenEditScreenForASpecificMerchant(MerchantToEditName);

                                                    //Check presence of Edit Merchant screen
                                                    Check = editMerchantScreen.CheckPresenceOfEditMerchantScreen();
                                                    Comm = "Error:Clicking on the Edit Merchant Button doesn't navigate to Edit Merchant screen";
                                                    softAssert.assertEquals(Check, true, Comm);

                                                    //if Edit Screen opened successfully check the presence of merchant Name field then get the name of the merchant
                                                    if (Check) {
                                                        Check = editMerchantScreen.CheckPresenceOfMerchantNameField();
                                                        Comm = "Error:Merchant Name Filed doesn't exist in Edit Merchant Screen";
                                                        softAssert.assertEquals(Check, true, Comm);

                                                        //if Merchant name field exist get the Merchant name then check the Presence of Merchant Country field
                                                        if (Check) {
                                                            //Read Data in Merchant Name Field
                                                            String ActualMerchantName = editMerchantScreen.ReadDataInMerchantNameField();
                                                            //Check that we are editing the desired merchant
                                                            Comm = "Error:you are editing the wrong merchant";
                                                            softAssert.assertEquals(ActualMerchantName, MerchantToEditName, Comm);

                                                            //if we are editing the correct merchant check the Presence of merchant country field
                                                            if (ActualMerchantName.equals(MerchantToEditName)) {
                                                                //Check the presence if city filed and get the data in it before editing the country
                                                                Check = editMerchantScreen.CheckPresenceOfMerchantCityField();
                                                                Comm = "Error:Merchant city field doesn't exist in edit screen";
                                                                softAssert.assertEquals(Check, true, Comm);
                                                                // if merchant city field exist read data in it
                                                                if (Check)
                                                                {
                                                                String OldMerchantCity = editMerchantScreen.ReadDataInMerchantCityField();

                                                                Check = editMerchantScreen.CheckPresenceOfMerchantCountryField();
                                                                Comm = "Error:Merchant Country field doesn't exist in Edit Merchant screen";
                                                                softAssert.assertEquals(Check, true, Comm);

                                                                //if Merchant Country filed exist Edit it
                                                                if (Check) {
                                                                    String OldMerchantCountry = editMerchantScreen.ReadDataInMerchantCountryField();
                                                                    String EditedMerchantCountry = props.getProperty("EditedMerchantCountry");
                                                                    editMerchantScreen.EditMerchantCountry(EditedMerchantCountry);
                                                                    //Read Data in Merchant Country Field and check that its edited
                                                                    String ActualMerchantCountry = editMerchantScreen.ReadDataInMerchantCountryField();
                                                                    Comm = "Error:Data in merchant Country filed isn't Edited";
                                                                    System.out.println(ActualMerchantCountry);
                                                                    System.out.println(OldMerchantCountry);
                                                                    softAssert.assertNotEquals(ActualMerchantCountry, OldMerchantCountry, Comm);
                                                                    //if Data is changed check that its edited correctly
                                                                    if (!ActualMerchantName.equals(OldMerchantCountry)) {
                                                                        Comm = "Error:Data in Merchant country is changed but to a wrong value";
                                                                        softAssert.assertEquals(ActualMerchantCountry, EditedMerchantCountry, Comm);

                                                                        //if Editing is done check that Merchant city field is changed accordingly
                                                                        if (ActualMerchantCountry.equals(EditedMerchantCountry)) {
                                                                            String ActualMerchantCity=editMerchantScreen.ReadDataInMerchantCityField();
                                                                            Comm="Error:Despite changing county city is remained the same";
                                                                            softAssert.assertNotEquals(ActualMerchantCity,OldMerchantCity,Comm);

                                                                            //check the presence of next button
                                                                            Check = editMerchantScreen.CheckPresenceOfNextButton();
                                                                            Comm = "Error:Next Button doesn't exist in edit merchant screen";
                                                                            softAssert.assertEquals(Check, true, Comm);

                                                                            //if next button exist click on it
                                                                            if (Check) {
                                                                                SchemeScreenAfterEditMerchantScreen schemeScreenAfterEditMerchantScreen = editMerchantScreen.ClickOnNextButton();
                                                                                //if the city doesn't change after editing the country Check the presence of city error message
                                                                                if (ActualMerchantCity.equals(OldMerchantCity)) {
                                                                                    Check = editMerchantScreen.CheckPresenceOfMerchantCityErrorMsg();
                                                                                    Comm = "Error:No Error message appears despite not changing merchant city after editing merchant country";
                                                                                    softAssert.assertEquals(Check, true, Comm);

                                                                                    //if Error Message appears Check its text
                                                                                    if (Check)
                                                                                    {
                                                                                        String ActualErrorMsg=editMerchantScreen.GetTextOfMerchantCityErrorMsg();
                                                                                        String ExpectedErrorMsg=props.getProperty("NotInsertedMerchantCityErrorMsg");
                                                                                        Comm="Error message isn't right";
                                                                                        softAssert.assertEquals(ActualErrorMsg,ExpectedErrorMsg,Comm);

                                                                                    }
                                                                                }
                                                                            }


                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
