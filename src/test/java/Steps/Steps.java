package Steps;

import Pages.Page;
import TestData.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Steps {

    public static WebDriver webDriver = null;
    Page page ;
    TestData InfoData ;
    HashMap<String, String> HashData = new HashMap<>();

    @Given("Navigate to Website")
    public void OpenBrowser() throws InterruptedException, IOException {
        String ChromPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromPath);
        webDriver= new ChromeDriver();
        webDriver.navigate().to("https://testautomationpractice.blogspot.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Hooks.driver=webDriver;
        page = new Page(webDriver);

        // Test Data
        String Path = "D:\\Projects\\Testing Projects\\Automation Practice\\src\\main\\Test Data\\Data.xlsx";
        InfoData = new TestData(Path,"sheet1");

    }


    @And("Enter data{string}{string}{string}{string}{string}")
    public void enterData(String Name, String Email, String Phone, String Address, String Gender)  {
        page.fillingData(Name,Email,Phone,Address,Gender);

    }

    @And("User select the day : {string}")
    public void userSelectTheDay(String day) {
        page.getDay(day).click();

    }

    @And("User select the country : {string}")
    public void userSelectTheCountry(String country)  {
        page.getCountry(country);
    }

    @And("User select the color: {string}")
    public void userSelectTheColor(String Color)  {
        page.getColor(Color);
    }

    @And("User select the Date : {string}")
    public void userSelectTheDate(String Date)throws InterruptedException {
        page.getDate().sendKeys(Date);
        page.getDate().click();
        Thread.sleep(4000);
    }

    @And("Enter information data of user in Test Case : {string}")
    public void enterInformationDataOfUserInSheetAndTestCase(String TestCase) throws InterruptedException {

        HashData = InfoData.copyTestCaseDataToHashTable(Integer.parseInt(TestCase));
        page.fillDataUsingHashTable(HashData);
        Thread.sleep(4000);




    }
}
