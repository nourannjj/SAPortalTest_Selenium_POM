package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class SchemeScreen {
    public ChromeDriver driver;
    public SchemeScreen(ChromeDriver driver)
    {
        this.driver=driver;
    }
    private By ScreenTitle= By.xpath("//h5[contains(.,'Create Merchant > Configuration')]");
    private By CreateButton=By.xpath("//button[@class='yes-btn']");
    private By AddButton=By.xpath("//div[@class='choose-items']//button[@class='add-btn']");
    private By ErrorMsg=By.xpath("//p[@class='api-error']");

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

    @Step("Check that Choose Scheme Priority appears")
    public boolean CheckPresenceOfChooseSchemePriorityScreen()
    {
        return IsElementPresent(ScreenTitle);
    }
    @Step("Check the Presence of Create button")
    public boolean CheckPresenceOfCreateButton()
    {
        return IsElementPresent(CreateButton);
    }
    @Step("Click On Create Button")
    public SAdminHomePage ClickOnCreateButton()
    {
      driver.findElement(CreateButton).click();
      return new SAdminHomePage(driver);
    }
    @Step("Scroll Down until a specific element")
    public void ScrollDown(By by) throws InterruptedException {
        WebElement element=driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(500);
    }
    @Step("choose random scheme arrange")
    public void ChooseSchemeArrangement() throws InterruptedException {

        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        List<WebElement> addButtons=driver.findElements(AddButton);
        for (int i=0;i<addButtons.size();i++) {
            ScrollDown(AddButton);
            wait.until(ExpectedConditions.elementToBeClickable(AddButton));
            driver.findElement(AddButton).click();
        }
    }
    @Step("Check Presence of Previously Used Data Error Message")
    public boolean CheckPresenceOfPreviouslyUsedDatErrorMessage()
    {
     return IsElementPresent(ErrorMsg) ;
    }
    @Step("Get the text of Error Msg")
    public String GetTextOfErrorMsg()
    {
        return (driver.findElement(ErrorMsg).getText());
    }

}
