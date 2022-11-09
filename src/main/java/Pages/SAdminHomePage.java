package Pages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.qameta.allure.Step;
import org.bouncycastle.asn1.cms.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class SAdminHomePage {
    ChromeDriver driver;
    public SAdminHomePage(ChromeDriver driver)
    {
        this.driver=driver;
    }

    File propFile= new File("src\\test\\resources\\configuration.properties");
    Properties props = new Properties();
    FileInputStream inputStream;
    public class NotCorrectMerchantData{
        public String FiledName;
        public String Expected;
        public String Actual;
    }
    private By HomePageTitle=By.xpath("//*[@id=\"merchant\"]/div/div[1]");
    private By SearchBox=By.xpath("//input[@placeholder='Search for a merchant, outlet, terminal, user...']");
    private By ProfileButton=By.xpath("//*[@id=\"navbarScroll\"]/div[2]/button[1]");
    private By LogoutButton=By.xpath("//*[@id=\"navbarScroll\"]/div[2]/button[2]");
    private By DateFiled=By.xpath("//p[@class='time']");
    private By TimeFiled= By.xpath("//p[@class='date']");
    private By RefreshButton=By.xpath("//button[@class='icon-container btn btn-primary'][1]");
    private By CreateNewButton=By.xpath("//button[contains(.,'Create New')]");
    private By AddCurrencyButton=By.xpath("//button[contains(.,'Add Currency')]");
    private By FilterButton=By.xpath("//button[contains(.,'Filter')]");
    private By SortingButton=By.xpath("//div[@class='up-down']");
    private By EditButton=By.xpath("//*[@id=\"merchant\"]/div/div[2]/table/tbody/tr[1]/td[13]/div/span[1]");
    private By AllEditButton=By.xpath("//div[@class='right-content d-flex']//span[1]");
    private By CreateMerchant=By.xpath("//h5[contains(.,'Create Merchant')]");
    private By TableOfMerchants=By.xpath("//tbody");
    private By MerchantTableRows=By.xpath("//tbody//tr");
    private By MerchantTableColumns=By.xpath("//tbody//tr//td");
    private By DetailsBtn=By.xpath("//tr//a");

    //Create Merchant Information class
    public class MerchantDetails{
        public String MerchantName,MerchantCode,CreationDate,Country,City,Phone,BusinessCategory,Currency,TSN,Terminals,Status;
        int Merchant_Index;
        public WebElement Edit_And_details_button;
        //Create a constructor of Merchant details class
        MerchantDetails(String MerchantName,String MerchantCode,String CreationDate,
                        String Country,String City,String Phone,String BusinessCategory,
                        String Currency,String TSN,String Terminals,String Status,WebElement EditBtnAndDetailBtn,int Merchant_Index){

            this.MerchantName=MerchantName;
            this.MerchantCode=MerchantCode;
            this.CreationDate=CreationDate;
            this.Country=Country;
            this.City=City;
            this.Phone=Phone;
            this.BusinessCategory=BusinessCategory;
            this.Currency=Currency;
            this.TSN=TSN;
            this.Terminals=Terminals;
            this.Status=Status;
            this.Edit_And_details_button=EditBtnAndDetailBtn;
            this.Merchant_Index=Merchant_Index;
        }

    }
    //Check that element is present
    public boolean IsElementPresent(By by)
    {
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
    //Check navigation to the Home Page by checking the presence of the title "Manage Merchants"
    public boolean CheckBeingAtSAHomePage()
    {
        return IsElementPresent(HomePageTitle);
    }
    @Step("Check presence of search box")
    public boolean CheckPresenceOfSearchBox()
    {
       return IsElementPresent(SearchBox);
    }
    @Step("Insert Text in search Bar")
    public void InsertTextIbSearchBar(String Text)
    {
        driver.findElement(SearchBox).sendKeys(Text);
    }
    @Step("Read Written Text in search bar")
    public String ReadTextInSearchBar()
    {
        return driver.findElement(SearchBox).getText();
    }
    @Step("Check Presence Of Profile Button")
    public boolean CheckPresenceOfProfileButton()
    {
        return IsElementPresent(ProfileButton);
    }
    @Step("Click On Profile Button")
    public ProfilePage ClickOnProfileButton()
    {
        driver.findElement(ProfileButton).click();
        return new ProfilePage(driver);
    }
    @Step("Check Presence of time filed in portal")
    public boolean CheckPresenceOfTimeFiled()
    {
        return IsElementPresent(TimeFiled);
    }
    @Step("Check Presence of Date filed in portal")
    public boolean CheckPresenceOfDateFiled()
    {
        return IsElementPresent(DateFiled);
    }
    @Step("Get Date and Time of the system ")
    public String[] GetDateAndTimeOfSystem()
    {
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");

        //get current date time with Date()
        Date date = new Date();

        // Now format the date
        String Date= dateFormat.format(date);
        String [] DateAndTime=new String[2];
        DateAndTime =Date.split(" ");
        return DateAndTime;

    }
    @Step("Get Date and Time from the SA hom page")
    public String[] GetDataAndTimeFromSAHomePage()
    {
        String [] DateAndTime=new String[2];
        DateAndTime[0]=driver.findElement(DateFiled).getText();
        DateAndTime[1]=driver.findElement(TimeFiled).getText();
        //Split by :
        String[] time_splitted=DateAndTime[1].split(":");
        if(time_splitted[1].length()==1) time_splitted[1]="0"+time_splitted[1]; //if minutes digit consists on one digit concatenates a zero with it
        DateAndTime[1]=time_splitted[0]+":"+time_splitted[1];//only hours and minutes
        return DateAndTime;
    }
    public String GetDateOfSystem()
    {
        //Get Date and Time from the SA hom page and from sys
        String [] DateAndTime_System=new String[2];
        DateAndTime_System=GetDateAndTimeOfSystem();
        //Split the Date of system
        String DateSys=DateAndTime_System[0];
        String[] DateOfSys_Splitted=DateSys.split("/");
        String DaySys=DateOfSys_Splitted[1];
        String MonthSys=DateOfSys_Splitted[0];
        String YearSys=DateOfSys_Splitted[2];

        String Date=YearSys+"-"+MonthSys+"-"+DateSys;
        return Date;
    }
    @Step("Compare Between date in system and on portal")
    public String[] CheckSimilarityOfDateBetweenSystemAndPortal()
    {
        //Get Date and Time from the SA hom page and from sys
        String [] DateAndTime_System=new String[2];
        String [] DateAndTime_Portal=new String[2];
        DateAndTime_System=GetDateAndTimeOfSystem();
        DateAndTime_Portal=GetDataAndTimeFromSAHomePage();

        //Split the Date of system
        String DateSys=DateAndTime_System[0];
        String[] DateOfSys_Splitted=DateSys.split("/");
        String DaySys=DateOfSys_Splitted[1];
        String MonthSys=DateOfSys_Splitted[0];
        String YearSys=DateOfSys_Splitted[2];

        //Split the Date of portal
        String DatePortal=DateAndTime_Portal[0];
        String[] DateOfPortal_Splitted=DatePortal.split(" ");
        String DayPortal=DateOfPortal_Splitted[2];
        String MonthPortal=DateOfPortal_Splitted[1];
        String YearPortal=DateOfPortal_Splitted[3];


        //Convert month form text format into numbers
        switch (MonthPortal) {
            case "Jan" -> MonthPortal = "1";
            case "Feb" -> MonthPortal = "2";
            case "Mar" -> MonthPortal = "3";
            case "Apr" -> MonthPortal = "4";
            case "May" -> MonthPortal = "5";
            case "Jun" -> MonthPortal = "6";
            case "Jul" -> MonthPortal = "7";
            case "Aug" -> MonthPortal = "8";
            case "Sep" -> MonthPortal = "9";
            case "Oct" -> MonthPortal = "10";
            case "Nov" -> MonthPortal = "11";
            case "Dec" -> MonthPortal = "12";
        }

        //Compare
        boolean check=DaySys.equals(DayPortal)&&MonthPortal.equals(MonthSys)&&(YearSys).equals(YearPortal);
        String Check=null,Comm=null;
        if(check) Check="true";
        else
        {
            Check="false";
            Comm="Error: Date presented on portal is different than the date od system \n\t"+"Date of Portal"+DatePortal+"\n\tDate of sys:"+DateSys;
        }
       String output[]={Check,Comm};
       return output;
    }

    public String[] CheckSimilarityOfTimeBetweenSystemAndPortal() {
        //Get Date and Time from the SA hom page and from sys
        String[] DateAndTime_System = new String[2];
        String[] DateAndTime_Portal = new String[2];
        DateAndTime_System = GetDateAndTimeOfSystem();
        DateAndTime_Portal = GetDataAndTimeFromSAHomePage();


        String TimeSys = DateAndTime_System[1];
        String TimePortal=DateAndTime_Portal[1];

        //Compare
        boolean check=TimePortal.equals(TimeSys);
        String Check=null,Comm=null;
        if(check) Check="true";
        else
        {
            Check="false";
            Comm="Error: Time presented on portal is different than the time of system \n\t"+"Time of Portal"+TimePortal+"\n\tTime of sys:"+TimeSys;
        }
        String output[]={Check,Comm};
        return output;
    }

    @Step("Check presence of refresh button")
    public boolean CheckPresenceOfRefreshButton()
    {
        return IsElementPresent(RefreshButton);
    }
    @Step("Click On Refresh Button")
    public void ClickOnRefreshButton() throws InterruptedException {
        ScrollTo(RefreshButton);

        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(RefreshButton));
        WebElement element=driver.findElement(RefreshButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

    }
    @Step("Check Presence of Logout button")
    public boolean CheckPresenceOfLogoutButton()
    {
        return IsElementPresent(LogoutButton);
    }
    @Step("Click on the Logout button")
    public FirstPage ClickOnLogoutButton()
    {
        driver.findElement(LogoutButton).click();
        return new FirstPage(driver);
    }
    @Step("Check Presence Of CreateNew Button")
    public boolean CheckPresenceOfCreateNewButton()
    {
        return IsElementPresent(CreateNewButton);
    }
    @Step("Check That Create New Button is enabled")
    public boolean CheckThatCreateNewButtonIsEnabled()
    {
        return (driver.findElement(CreateNewButton).isEnabled()&&driver.findElement(CreateNewButton).isDisplayed());
    }
    @Step("Scroll Down until a specific element")
    public void ScrollTo(By by) throws InterruptedException {
        WebElement element=driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(500);
    }
    @Step("Click on the create new button")
    public CreateNewMerchantPage ClickOnCreateNewButton() throws InterruptedException {
        ScrollTo(CreateNewButton);

        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(CreateNewButton));

        WebElement element=driver.findElement(CreateNewButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        return new CreateNewMerchantPage(driver);
    }
    @Step("Check Presence Of AddCurrency Button")
    public boolean CheckPresenceOfAddCurrencyButton()
    {
      return IsElementPresent(AddCurrencyButton);
    }
    @Step("Click On the Add currency button")
    public AddCurrencyScreen ClickOnAddCurrencyButton()
    {
      driver.findElement(AddCurrencyButton).click();
      return new AddCurrencyScreen(driver);
    }
    @Step("Check The Presence Of Edit merchant Button")
    public boolean CheckPresenceOfEditMerchantButton()
    {
        return IsElementPresent(EditButton);
    }
    @Step("Click On the Edit Button")
    public EditMerchantScreen ClickOnEditButton()
    {
        driver.findElement(EditButton).click();
        return new EditMerchantScreen(driver);
    }
    @Step("Check Presence Of table Of Merchants and its rows")
    public boolean CheckPresenceOfTableOfMerchants()
    {
        return IsElementPresent(TableOfMerchants)&&IsElementPresent(MerchantTableRows);
    }
    @Step("Get Contents Of table Of Merchant")
    public List<WebElement> GetContentsOfMerchantTable() throws InterruptedException {

        return driver.findElements(MerchantTableColumns);
    }

    @Step("Get a Specific Merchant from the merchant table using his name")
    public MerchantDetails GetaSpecificMerchantFromMerchantTable(String MerchantName) throws IOException, InterruptedException {

        List<WebElement> MerchantTableContents=GetContentsOfMerchantTable();
        int MerchantNum=MerchantTableContents.size()/13;
        if (MerchantNum==0) Thread.sleep(10000);
        System.out.println("Merchant num= "+MerchantNum);

        //Create array of Merchants and assign each attribute to the corresponding element in merchant object
        int j = 1;
        int i;
        MerchantDetails[] Merchants  = new MerchantDetails[MerchantNum];

        for(i=0 ;i<MerchantNum;i++) {
            System.out.println("j="+j);
            if(j<MerchantTableContents.size()) {
                String name = MerchantTableContents.get(j).getText();
                String code = MerchantTableContents.get(++j).getText();
                String creationDate = MerchantTableContents.get(++j).getText();
                String country = MerchantTableContents.get(++j).getText();
                String city = MerchantTableContents.get(++j).getText();
                String phone = MerchantTableContents.get(++j).getText();
                String businessCategory = MerchantTableContents.get(++j).getText();
                String currency = MerchantTableContents.get(++j).getText();
                String tSN = MerchantTableContents.get(++j).getText();
                String terminals = MerchantTableContents.get(++j).getText();
                String status = MerchantTableContents.get(++j).getText();
                int MerchantIndex=i;
                WebElement EditBtnAndDetailBtn=MerchantTableContents.get(++j);

                Merchants[i] = new MerchantDetails(name, code, creationDate, country, city, phone, businessCategory, currency, tSN, terminals, status,EditBtnAndDetailBtn,MerchantIndex);
                System.out.println("i="+i);
                j =j+2;
                System.out.println(Merchants[i].MerchantName);
            }
            else break;
        }
        //loop on merchants and return the merchant you are looking for
        for (i=0;i<MerchantNum;i++)
        {
            if((Merchants[i].MerchantName).equals(MerchantName)) {
                System.out.println("i="+i);
                break;
            }
        }
        //if Merchant doesn't exist in merchant tale (i=Merchant number) or there is no merchant return null
        if(i==MerchantNum||MerchantNum==0) return null;
        return Merchants[i];
    }
    @Step("Open the details screen of a specific merchant")
    public MerchantDetailsScreen OpenDetailsScreenForASpecificMerchant (String MerchantName) throws IOException, InterruptedException {
        //Get the Details of a specific merchant
        MerchantDetails Merchants  = GetaSpecificMerchantFromMerchantTable(MerchantName);
        //Get all edit and details button elements
        List<WebElement> EditAndDetailsButton=driver.findElements(DetailsBtn);
        System.out.println(EditAndDetailsButton.size());
        //wait until the details button is clickable
        WebElement element=driver.findElements(DetailsBtn).get(Merchants.Merchant_Index);
        WebDriverWait wt = new WebDriverWait(driver, 5);
        wt.until(ExpectedConditions.elementToBeClickable (element));

        JavascriptExecutor ex = (JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click();", element);

        return new MerchantDetailsScreen(driver);
    }

    @Step("Check that the Data in Merchant Name filed is correct")
    public NotCorrectMerchantData[] CheckThatMerchantDataIsRight(String ExpectedMerchantName,String ExpectedMerchantCode,
                                                                                    String ExpectedMerchantCreationDate,String ExpectedMerchantCountry,
                                                                                    String ExpectedMerchantCity,String ExpectedMerchantPhone,
                                                                                    String ExpectedMerchantBusinessCategory,
                                                                                    String ExpectedMerchantCurrency,String ExpectedMerchantTSN,
                                                                                    String ExpectedMerchantTerminals,String ExpectedMerchantStatus) throws IOException, InterruptedException {
        boolean Check=true;int i=0;

        //Get the Merchant of specific name
        MerchantDetails Merchant=GetaSpecificMerchantFromMerchantTable(ExpectedMerchantName);
       
        String[] ExpectedMerchantData={ExpectedMerchantName,ExpectedMerchantCode,ExpectedMerchantCreationDate,ExpectedMerchantCountry,ExpectedMerchantCity,ExpectedMerchantPhone,ExpectedMerchantBusinessCategory,ExpectedMerchantCurrency,ExpectedMerchantTSN,ExpectedMerchantTerminals,ExpectedMerchantStatus};
        String[] ActualMerchantData={Merchant.MerchantName,Merchant.MerchantCode,Merchant.CreationDate,Merchant.Country,Merchant.City,Merchant.Phone,Merchant.BusinessCategory,Merchant.Currency,Merchant.TSN,Merchant.Terminals,Merchant.Status};
        String[] FiledName={"MerchantName","MerchantCode","MerchantCreationDate","MerchantCountry","MerchantCity","MerchantPhone","MerchantBusinessCategory","MerchantCurrency","MerchantTSN","MerchantTerminals","MerchantStatus"};

        //Get the number of non-symmetric fields
        int numOfNonCorrectFields=0;
        for (i=0;i<11;i++)
        {
            Check=ActualMerchantData[i].equals(ExpectedMerchantData[i]);
            if (Check==false)
                numOfNonCorrectFields++;
        }
        //initialize List of the fields that contains wrong data for that merchant
        NotCorrectMerchantData[] FiledCase=new NotCorrectMerchantData[numOfNonCorrectFields];
        for (i=0;i<numOfNonCorrectFields;i++)
        {
            FiledCase[i]=new NotCorrectMerchantData();
        }

        //Loop on all Merchant fields and check if each field contains the right data or not , if not this filed will be added to the "FailedCase" List
        int j=0;
        for (i=0;i<11;i++)
        {
            Check=ActualMerchantData[i].equals(ExpectedMerchantData[i]); System.out.println(Check);
            if (Check==false)
            {
                System.out.println(i);
                FiledCase[j].FiledName=FiledName[i]; System.out.println( FiledCase[j].FiledName);
                FiledCase[j].Expected=ExpectedMerchantData[i]; System.out.println(FiledCase[j].Expected);
                FiledCase[j].Actual=ActualMerchantData[i]; System.out.println(FiledCase[j].Actual);
                j++; //count of the number of failed cases
            }
        }


        return FiledCase;

    }

    @Step("Open the Edit screen of a specific merchant")
    public MerchantDetailsScreen OpenEditScreenForASpecificMerchant (String MerchantName) throws IOException, InterruptedException {
        //Get the Details of a specific merchant
        MerchantDetails Merchants  = GetaSpecificMerchantFromMerchantTable(MerchantName);
        //Get all edit button elements
        List<WebElement> EditButtons=driver.findElements(AllEditButton);
        System.out.println(EditButtons.size());
        //wait Edit button is clickable
        WebDriverWait wt = new WebDriverWait(driver, 5);
        wt.until(ExpectedConditions.elementToBeClickable (AllEditButton));
        EditButtons.get(Merchants.Merchant_Index).click();
        return new MerchantDetailsScreen(driver);
    }
    @Step("Check The Presence Of Edit Button For A Specific Merchant")
    public boolean CheckThePresenceOfEditButtonForASpecificMerchant(String MerchantName) throws IOException, InterruptedException {
        //Get the Details of a specific merchant
        MerchantDetails Merchants  = GetaSpecificMerchantFromMerchantTable(MerchantName);
        //Get all edit button elements
        List<WebElement> EditButtons=driver.findElements(AllEditButton);
        //wait Edit button is clickable
        WebDriverWait wt = new WebDriverWait(driver, 5);
        wt.until(ExpectedConditions.elementToBeClickable (AllEditButton));
        return (EditButtons.get(Merchants.Merchant_Index)!=null);
    }




}
