package Tests;

import Base.BaseTest;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class OTPPageTest extends BaseTest {
    String Comm;
    boolean Check;

    @Test(description = "Validation Of OTP screen message",priority =22)
    public void TC_PSA_0022() throws IOException, InterruptedException {

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

                        //If navigated successfully to OTP page check the OTP screen message
                        if(arr[0].equals("true"))
                        {
                            Check=otpPage.CheckThePresenceOfOTPScreenMsg();
                            Comm="Error:No message appears on the OTP screen";
                            softAssert.assertEquals(Check,true,Comm);

                            //if the OTP screen message appears check its text
                            String ExpectedMsg=props.getProperty("OTPScreenMsg");
                            arr=otpPage.CheckOTPScreenText(ExpectedMsg);
                            Comm = "Error:The Message in the OTP screen isn't as expected \n" + "Expected msg : " + arr[1] + "\nActual msg :" + arr[2];
                            softAssert.assertEquals(arr[0], "true", Comm);

                        }


                    }
                }
            }
        }
        softAssert.assertAll();
    }
    @Test(description = "Validation Of accepting numbers and letters in OTP fields ",priority =23)
    public void TC_PSA_0023() throws IOException, InterruptedException {

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
                                String OTP= "1a1a1a";
                                otpPage.InsertOTP(OTP);
                                //Check similarity between the inserted otp and the Actual appeared otp
                                String ActualOTP=otpPage.GetValueInOTPField();
                                Check=ActualOTP.equals(OTP);
                                Comm="Error:OTP filed contains wrong value"+"\nThe Expected OTP:"+OTP+"\nThe Actual OTP appears in OTP filed is:"+ActualOTP;
                                softAssert.assertEquals(Check,true,Comm);
                            }
                        }
                    }
                }
            }
        }
        softAssert.assertAll();
    }
    @Test(description = "Validation Of blocking account after many entering wrong OTP",priority =26)
    public void TC_PSA_0026() throws IOException, InterruptedException {

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
                                //enter wrong OTP 4 times
                                String OTP= "222222";
                              for (int i=0;i<4;i++)
                                {
                                otpPage.ClearOTPFields();
                                otpPage.InsertOTP(OTP);
                                //Check that confirm button exist
                                Check=otpPage.CheckThePresenceOfConfirmButton();
                                Comm="Confirm button isn't exist in the OTP Page";
                                softAssert.assertEquals(Check,true,Comm);

                                //if you confirm button exist check that its enabled
                                if(Check)
                                  {
                                    Check=otpPage.IsConfirmButtonEnabled();
                                    // if button is enabled click on it
                                      if(Check)
                                      {
                                          otpPage.ClickOnConfirmButton();
                                          //Check the presence of error msg
                                          Check=otpPage.CheckThePresenceOfInvalidOTPMsg();
                                          Comm="Error:the invalid OTP message doesn't appear despite entering wrong otp";
                                      }
                                  }

                                }
                              //Insert the right otp
                                otpPage.ClearOTPFields();
                                otpPage.InsertOTP("111111");
                                //Check that confirm button exist
                                Check=otpPage.CheckThePresenceOfConfirmButton();
                                Comm="Confirm button isn't exist in the OTP Page";
                                softAssert.assertEquals(Check,true,Comm);

                                //if you confirm button exist check that its enabled
                                if(Check) {
                                    Check = otpPage.IsConfirmButtonEnabled();
                                    // if button is enabled click on it
                                    if (Check) {
                                        otpPage.ClickOnConfirmButton();
                                        //Check remaining at OTP screen
                                        arr = otpPage.CheckBeingAtOTPPage();
                                        Comm = "Error:User isn't remaining at OTP screen although he is supposed to be blocked\n\t" + "Expected URL : " + arr[1] + "\n\tActual URL :" + arr[2];
                                        softAssert.assertEquals(arr[0], "true", Comm);

                                        //If reaming At otp page check the presence of error message
                                        if(arr.equals("true"))
                                        {
                                        //Check the presence of blocking error message then check its text
                                        Check = otpPage.CheckThePresenceOfErrorBox();
                                        Comm = "Error: No Blocking Error Message appears despite entering wrong otp many times ";
                                        softAssert.assertEquals(Check, true, Comm);
                                        if (Check)
                                           {
                                            String ExpectedError = "BlockingAccountMsg";
                                            arr = otpPage.CheckBlockingErrorText(ExpectedError);
                                            Comm = "Error:The Error message isn't as expected\n" + "Expected Message : " + arr[1] + "\nActual Message :" + arr[2];
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
        softAssert.assertAll();
    }
    @Test(description = "Validation Of entering old or invalid OTP ",priority =27)
    public void TC_PSA_0027() throws IOException, InterruptedException {

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
                                //enter invalid OTP
                                String OTP= "2a2222";
                                otpPage.ClearOTPFields();
                                otpPage.InsertOTP(OTP);
                                //Check that confirm button exist
                                Check=otpPage.CheckThePresenceOfConfirmButton();
                                Comm="Confirm button isn't exist in the OTP Page";
                                softAssert.assertEquals(Check,true,Comm);

                                //if you confirm button exist check that its enabled
                                if(Check)
                                {
                                    Check=otpPage.IsConfirmButtonEnabled();
                                    // if button is enabled click on it
                                    if(Check) {
                                        otpPage.ClickOnConfirmButton();
                                        //Check remaining at OTP screen
                                        arr = otpPage.CheckBeingAtOTPPage();
                                        Comm = "Error:Despite entering invalid otp user isn't remaining at OTP page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
                                        softAssert.assertEquals(arr[0], "true", Comm);

                                        //If user remaining at OTP screen check the presence of error message
                                        if (arr[0].equals("true"))
                                        {
                                            //Check the presence of Invalid OTP error message
                                            Check = otpPage.CheckThePresenceOfInvalidOTPMsg();
                                            Comm = "Error:Despite Entering invalid OTP no error message appears ";
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
        softAssert.assertAll();
    }
    @Test(description = "Validation Of the OTP is one time and expires with the first use",priority =28)
    public void TC_PSA_0028() throws IOException, InterruptedException {

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
                                //enter OTP
                                System.out.println("Enter OTP");
                                Scanner scanner=new Scanner(System.in);
                                String OTP=scanner.nextLine();

                                otpPage.ClearOTPFields();
                                otpPage.InsertOTP(OTP);
                                //Check that confirm button exist
                                Check=otpPage.CheckThePresenceOfConfirmButton();
                                Comm="Confirm button isn't exist in the OTP Page";
                                softAssert.assertEquals(Check,true,Comm);

                                //if you confirm button exist check that its enabled
                                if(Check)
                                {
                                    Check=otpPage.IsConfirmButtonEnabled();
                                    // if button is enabled click on it
                                    if(Check) {
                                        otpPage.ClickOnConfirmButton();
                                        //open a new session at microformat edge and enter the same used otp
                                        WebDriverManager.edgedriver().setup();
                                        driver2=new EdgeDriver();
                                        driver2.get(props.getProperty("SAPortalURL_Server250"));
                                        driver2.manage().window().maximize();
                                        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                                        FirstPage_edge firstPage_edge;
                                        firstPage_edge=new FirstPage_edge(driver2);
                                        LoginPage_edge loginPage_edge=firstPage_edge.ClickOnLoginButton();
                                        loginPage_edge.FillEmailAndPassword(props.getProperty("ValidEmail"),props.getProperty("ValidPass"));
                                        OTPPage_edge otpPage_edge=loginPage_edge.ClickOnLoginButton();
                                        otpPage_edge.InsertOTP(OTP);
                                        otpPage_edge.ClickOnConfirmButton();

                                        //Check remaining at otp screen
                                        arr=otpPage_edge.CheckBeingAtOTPPage();
                                        Comm = "Error:Despite entering a previously used OTP user isn't remaining at OTP page\n" + "Expected URL :" + arr[1] + "\nActual URL :" + arr[2];
                                        softAssert.assertEquals(arr[0], "true", Comm);
                                        if(arr[0].equals("true"))
                                        {
                                            //Check the presence of Invalid OTP error message
                                            Check = otpPage.CheckThePresenceOfInvalidOTPMsg();
                                            Comm = "Error:Despite Entering a previously used OTP no error message appears ";
                                            softAssert.assertEquals(Check, true, Comm);
                                        }
                                        driver2.close();

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
    @Test(description = "Validation Of entering valid OTP to login",priority =29)
    public void TC_PSA_0029() throws IOException, InterruptedException {

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
                //Check presence of email and pass field
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
                                        SAdminHomePage sAdminHomePage=otpPage.ClickOnConfirmButton();
                                        //Check navigation to SA home page
                                        Check=sAdminHomePage.CheckBeingAtSAHomePage();
                                        Comm="Error:Despite entering the right OTP user isn't navigated to the SA Home Page";
                                        softAssert.assertEquals(Check,true,Comm);

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
    @Test(description = "Validation Of clearing entered fields of OTP",priority =30)
    public void TC_PSA_0030() throws IOException, InterruptedException {

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
                                //clear the inserted OTP and get the value in the OTP field then check that its empty
                                otpPage.ClearOTPFields();
                                Check=otpPage.GetValueInOTPField().equals("");
                                Comm="Error:Clearing the OTP filed option isn't working";
                                softAssert.assertEquals(Check,true,Comm);
                            }
                        }
                    }
                }
            }
        }
        softAssert.assertAll();
    }
    @Test(description = "Validation Of confirm button",priority =31)
    public void TC_PSA_0031() throws IOException, InterruptedException {

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
                                        SAdminHomePage sAdminHomePage=otpPage.ClickOnConfirmButton();
                                        //Check navigation to SA home page
                                        Check=sAdminHomePage.CheckBeingAtSAHomePage();
                                        Comm="Error:Despite entering the right OTP user clicking on the confirm button doesn't navigate user to the SA Home Page";
                                        softAssert.assertEquals(Check,true,Comm);

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
    @Test(description = "Validation Of resend otp code button",priority =32)
    public void TC_PSA_0032() throws IOException, InterruptedException {

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

                        //If navigated successfully to OTP page insert letters and numbers in OTP filed
                        if(arr[0].equals("true")) {
                            //Check the presence of Resend OTP button
                            Check = otpPage.CheckThePresenceOfResendButton();
                            Comm = "Error:The Resend button isn't exist in the OTP Page";
                            softAssert.assertEquals(Check, true, Comm);

                            //if resend button exist click on it
                            if (Check) {
                                otpPage.ClickOnResendButton();
                                //Check the Presence of OTP Resending successful message
                                Check = otpPage.CheckThePresenceOfSuccessOTPResendMsg();
                                Comm = "Error:No successfully message appears when clicking on the Resend OTP button";
                                //if OTP is sent successfully enter the new OTP
                                //Check presence of OTP field
                                Check=otpPage.CheckThePresenceOfOTPFields();
                                Comm="Error:The OTP filed isn't exist";
                                softAssert.assertEquals(Check, true,Comm);

                                //If OTP field exist insert value in it
                                if (Check)
                                {
                                    System.out.println("Enter new OTP");
                                    Scanner scanner=new Scanner(System.in);
                                    String OTP=scanner.nextLine();
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
                                            SAdminHomePage sAdminHomePage=otpPage.ClickOnConfirmButton();
                                            //Check navigation to SA home page
                                            Check=sAdminHomePage.CheckBeingAtSAHomePage();
                                            Comm="Error: entering the new OTP doesn't navigate user to the SA Home Page";
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
        softAssert.assertAll();
    }
    @Test(description = "Validation of go back to login screen button",priority =34)
    public void TC_PSA_0034() throws IOException, InterruptedException {

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
                        Comm = "Error:Clicking on the Login button doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
                        softAssert.assertEquals(arr[0], "true", Comm);

                        //If navigated successfully to OTP page click on back button and check navigation to login screen
                        if (arr[0].equals("true")) {

                            //Click on back button
                            driver.navigate().back();
                            //Check navigation to login screen
                            arr=otpPage.CheckBeingAtLoginPage();
                            Comm = "Error:Clicking on the back icon doesn't navigate to the right page\n" + "Expected URL : " + arr[1] + "\nActual URL :" + arr[2];
                            softAssert.assertEquals(arr[0], "true", Comm);

                            //If navigated successfully to login page check the presence of login page elements
                            if(arr[0].equals("true"))
                            {
                                Check=loginPage.Is_EmailAndPassFiled_Exist();
                                Comm="Email and password fileds aren't exist in the login page after navigating back from OTP screen";
                                softAssert.assertEquals(Check,true,Comm);
                            }
                        }


                    }
                }
            }
        }
        softAssert.assertAll();
    }
}
