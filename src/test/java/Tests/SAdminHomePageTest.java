package Tests;

import Base.BaseTest;
import Pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class SAdminHomePageTest extends BaseTest {
    String Comm;
    boolean Check;


    @Test(description = "Validation of Search bar",priority =36)
    public void TC_PSA_0036() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage;
        OTPPage otpPage;
        SAdminHomePage sAdminHomePage;
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

                                        //If navigated successfully to SA home page check the search box
                                        if (Check)
                                        {
                                           //Check that Search box exist
                                           Check=sAdminHomePage.CheckPresenceOfSearchBox();
                                           Comm="Error:Search Box isn't exist in the SA home page";
                                           softAssert.assertEquals(Check,true,Comm);

                                           //If search box exist send text to it then check that text is written
                                            if (Check)
                                            {
                                                String RealSearchText="merchant1";
                                                //Insert text in the search bar
                                                sAdminHomePage.InsertTextIbSearchBar(RealSearchText);
                                                //Read text in the search bar
                                                String ActualSearchText=sAdminHomePage.ReadTextInSearchBar();
                                                Check=RealSearchText.equals(ActualSearchText);
                                                Comm="Error:The written text differs from the read one\n"+"\tExpected text:"+RealSearchText+"\n\tActual Text:"+ActualSearchText;
                                                softAssert.assertEquals(Check, true,Comm);
                                            }
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
    @Test(description = "Validation of profile button",priority =37)
    public void TC_PSA_0037() throws IOException, InterruptedException {

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
                                            }
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
    @Test(description = "Validation of portal date and time",priority =38)
    public void TC_PSA_0038() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the presence of date and time field
                                        if (Check)
                                        {
                                             Check=sAdminHomePage.CheckPresenceOfDateFiled()&&sAdminHomePage.CheckPresenceOfTimeFiled();
                                             Comm="Error:Either time filed or data filed isn't presented at SA Home Page";
                                             softAssert.assertEquals(Check,true,Comm);

                                             //If Data and time filed are presented on SA Page then compare them with system time and date
                                            if (Check)
                                            {
                                                //Compare Dates
                                                arr=sAdminHomePage.CheckSimilarityOfDateBetweenSystemAndPortal();
                                                softAssert.assertEquals(arr[0],"true",arr[1]);

                                                //Compare times
                                                arr=sAdminHomePage.CheckSimilarityOfTimeBetweenSystemAndPortal();
                                                softAssert.assertEquals(arr[0],"true",arr[1]);
                                            }
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
    @Test(description = "Validation of portal date and time after a while of navigation to Home page",priority =38)
    public void TC_PSA_0038b() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the presence of date and time field
                                        if (Check)
                                        {
                                            Check=sAdminHomePage.CheckPresenceOfDateFiled()&&sAdminHomePage.CheckPresenceOfTimeFiled();
                                            Comm="Error:Either time filed or data filed isn't presented at SA Home Page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Data and time filed are presented on SA Page then compare them with system time and date
                                            if (Check)
                                            {
                                                //Compare Dates
                                                arr=sAdminHomePage.CheckSimilarityOfDateBetweenSystemAndPortal();
                                                softAssert.assertEquals(arr[0],"true",arr[1]);

                                                //Compare times
                                                arr=sAdminHomePage.CheckSimilarityOfTimeBetweenSystemAndPortal();
                                                softAssert.assertEquals(arr[0],"true",arr[1]);


                                                if(arr[0].equals("true"))
                                                {
                                                    String[] DT=sAdminHomePage.GetDataAndTimeFromSAHomePage();
                                                    String Time1=DT[1];
                                                    System.out.println(Time1);

                                                    //Wait without any actions
                                                    Thread.sleep(60000);

                                                    DT=sAdminHomePage.GetDataAndTimeFromSAHomePage();
                                                    String Time2=DT[1];
                                                    System.out.println(Time2);
                                                    //Compare times after wait
                                                    String[] arr2=sAdminHomePage.CheckSimilarityOfTimeBetweenSystemAndPortal();
                                                    if(arr2[0].equals("false"))//if time not similar check whether time is fixed or not
                                                    {
                                                        if(Time2.equals(Time1))
                                                        {
                                                            //Check the presence of refresh button
                                                            Check=sAdminHomePage.CheckPresenceOfRefreshButton();
                                                            Comm="Error:refresh button isn't exit in the home page";
                                                            softAssert.assertEquals(Check,true,Comm);

                                                            //If refresh button exist click on it
                                                            if(Check)
                                                                {
                                                                 sAdminHomePage.ClickOnRefreshButton();
                                                                 //Check the similarity between times
                                                                 arr=sAdminHomePage.CheckSimilarityOfTimeBetweenSystemAndPortal();
                                                                 //if times is similar after refreshing ant not similar before refreshing , Print a comment explaining that
                                                                    if(arr[0].equals("true"))
                                                                    {
                                                                        Comm="Error: The time and date remain unchanged, fixed at the moment the user entered the portal." +
                                                                                " Therefore, user has to refresh the page to be able to see the current time and date.";
                                                                    }
                                                                    else
                                                                    {
                                                                        Comm="Error: The time and date remain unchanged, fixed at the moment the user entered the portal before and after refreshing the page.";
                                                                    }
                                                                    softAssert.assertEquals(arr2[0],"true",Comm);
                                                                }

                                                        }

                                                    }



                                                }

                                            }
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
    @Test(description = "Validation of logout button",priority =39)
    public void TC_PSA_0039() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the logout button
                                        if (Check)
                                        {
                                            //Check that Logout button exist
                                            Check=sAdminHomePage.CheckPresenceOfLogoutButton();
                                            Comm="Error:Logout Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Logout Button exist click on it and then check navigation to the First Page
                                            if (Check)
                                            {
                                                firstPage=sAdminHomePage.ClickOnLogoutButton();
                                                //Check navigation to the First screen
                                                Check=firstPage.CheckNavigationToFirstPage();
                                                Comm="Error:Clicking on the logout button doesn't navigate user to First page";
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
        softAssert.assertAll();
    }
    @Test(description = "Validation of refresh button",priority =40)
    public void TC_PSA_0040() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the Refresh button
                                        if (Check)
                                        {
                                            //Check that refresh button exist
                                            Check=sAdminHomePage.CheckPresenceOfRefreshButton();
                                            Comm="Error:Refresh Button isn't exist in the SA home page";
                                            softAssert.assertEquals(Check,true,Comm);

                                            //If Refresh Button exist click on it and then check that page is refreshed by checking that time is changed and equals the current date
                                            if (Check)
                                            {
                                                //Get time before refreshing
                                                arr=sAdminHomePage.GetDataAndTimeFromSAHomePage();
                                                String TimeBefore=arr[1];
                                                //Wait for a min
                                                Thread.sleep(60000);
                                                //Click on refresh button
                                                sAdminHomePage.ClickOnRefreshButton();
                                                //Get the Current date
                                                arr=sAdminHomePage.GetDataAndTimeFromSAHomePage();
                                                String TimeAfter=arr[1];
                                                //Check time is changed
                                                Check=TimeAfter.equals(TimeBefore);
                                                Comm="Error:clicking on the Refresh button doesn't refresh the date";
                                                softAssert.assertEquals(Check,false,Comm);
                                                //If time changed check that it equals the current time of sys
                                                if(!Check)
                                                {
                                                   arr= sAdminHomePage.CheckSimilarityOfTimeBetweenSystemAndPortal();
                                                   Comm="Error : click on the refresh button changes the page time to a times differs from the current time";
                                                   softAssert.assertEquals(arr[0],"true",Comm);


                                                }


                                            }
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
    @Test(description = "Validation of create new merchant button",priority =41)
    public void TC_PSA_0041() throws IOException, InterruptedException {

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


                                            }
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
    @Test(description = "Validation of add currency button",priority =42)
    public void TC_PSA_0042() throws IOException, InterruptedException {

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
                                                //Check presence of  Add Currency screen
                                                Check=addCurrencyScreen.CheckPresenceOfAddCurrencyScreen();
                                                Comm="Error:Clicking on the Add Currency Button doesn't navigate to Add Currency screen";
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
        softAssert.assertAll();
    }

    @Test(description = "Validation of merchant edit button",priority =44)
    public void TC_PSA_0044() throws IOException, InterruptedException {

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
                                            }
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

    @Test(description = "Validation of merchant details button",priority =45)
    public void TC_PSA_0045() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the presence of table of merchants
                                        if (Check) {
                                            Check = sAdminHomePage.CheckPresenceOfTableOfMerchants();
                                            Comm = "Error:Merchant table isn't exist";
                                            softAssert.assertEquals(Check, true, Comm);
                                            if (Check) {
                                                Thread.sleep(2000);
                                                //click on the details button and navigate to Merchant Details screen
                                                MerchantDetailsScreen merchantDetailsScreen=sAdminHomePage.OpenDetailsScreenForASpecificMerchant(props.getProperty("MerchantName"));
                                                //Check Navigation to the details screen by checking the presence of Merchant Name Filed and Merchant code
                                                Check=merchantDetailsScreen.CheckThePresenceOfMerchantCodeFiled()&&merchantDetailsScreen.CheckThePresenceOfMerchantNameFiled();
                                                Comm="Error:Clicking on the Merchant Details button doesn't navigate to the Merchant Details screen";
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
        softAssert.assertAll();
    }

    @Test(description = "Validation of record data for each merchant",priority =46)
    public void TC_PSA_0046() throws IOException, InterruptedException {

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

                                        //If navigated successfully to SA home page check the presence of table of merchants
                                        if (Check) {
                                            Check = sAdminHomePage.CheckPresenceOfTableOfMerchants();
                                            Comm = "Error:Merchant table isn't exist";
                                            softAssert.assertEquals(Check, true, Comm);
                                            if (Check) {
                                                Thread.sleep(2000);

                                                //Check That Merchant Data Is Right , if all data is correct then the size of "notCorrectMerchantData" will be zero
                                                SAdminHomePage.NotCorrectMerchantData[] notCorrectMerchantData=sAdminHomePage.CheckThatMerchantDataIsRight(props.getProperty("MerchantName"),props.getProperty("MerchantCode"),props.getProperty("MerchantCreationDate"),props.getProperty("MerchantCountry"),props.getProperty("MerchantCity"),props.getProperty("MerchantPhone"),props.getProperty("MerchantBusinessCategory"),props.getProperty("MerchantCurrency"),props.getProperty("MerchantTSN"),props.getProperty("MerchantTerminals"),props.getProperty("MerchantStatus"));
                                                Comm="";
                                                if (notCorrectMerchantData.length!=0)
                                                {
                                                    Check = false;
                                                    for (int i = 0; i < notCorrectMerchantData.length; i++)
                                                    {
                                                        String fieldName = notCorrectMerchantData[i].FiledName;
                                                        String ExpectedValue = notCorrectMerchantData[i].Expected;
                                                        String ActualValue = notCorrectMerchantData[i].Actual;
                                                        Comm = "\n\n" + "Expected " + fieldName + ":" + ExpectedValue + "\n" + "Actual " + fieldName + ":" + ActualValue + Comm;

                                                    }
                                                }
                                                else
                                                {
                                                    Check = true;
                                                }
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
        softAssert.assertAll();
    }
}
