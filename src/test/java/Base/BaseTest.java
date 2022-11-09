package Base;

import Pages.FirstPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected ChromeDriver driver;
    public static ThreadLocal<ChromeDriver> tdriver = new ThreadLocal<ChromeDriver>();
    protected EdgeDriver driver2;
    protected FirstPage firstPage;
    protected  File propFile= new File("src\\test\\resources\\configuration.properties");
    protected final Properties props = new Properties();
    FileInputStream inputStream;

    @BeforeClass
    public void BeforeClass() throws IOException {

        inputStream = new FileInputStream(propFile);
        props.load(inputStream);

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(props.getProperty("SAPortalURL_Server100"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        tdriver.set(driver);

        firstPage=new FirstPage(getDriver());

    }
    @AfterMethod
    public void AfterMethod()
    {
        //driver.navigate().to(props.getProperty("SAPortalURL_Server100"));
    }
    @AfterClass
    public void AfterClass()
    {
       // driver.close();
    }

    public ChromeDriver getDriver() {
        return tdriver.get();
    }
}
