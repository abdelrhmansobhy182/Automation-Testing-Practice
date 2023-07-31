package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.lang.model.element.Name;
import java.util.HashMap;
import java.util.List;

public class Page {

    WebDriver driver;


    public Page(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private WebElement getName()
    {
        return driver.findElement(By.xpath("//*[@id=\"name\"]"));

    }
    private WebElement getEmail()
    {
        return driver.findElement(By.xpath("//*[@id=\"email\"]"));

    }
    private WebElement getPhone()
    {
        return driver.findElement(By.xpath("//*[@id=\"phone\"]"));

    }
    private WebElement getAddress()
    {
        return driver.findElement(By.xpath("//*[@id=\"textarea\"]"));

    }
    private WebElement getGender(Character G)
    {
        if (G=='M'||G=='m')
            return driver.findElement(By.xpath("//*[@id=\"male\"]"));
        else
            return driver.findElement(By.xpath("//*[@id=\"female\"]"));


    }

    public WebElement getDay(String Day)
    {

        WebElement day=  driver.findElement(By.id(Day));
        new Actions(driver).scrollToElement(day).perform();
        return day;
    }
    public void getCountry(String Country)
    {
        WebElement Countries =driver.findElement(By.id("country"));
        new Actions(driver).scrollToElement(Countries).perform();
        Select select = new Select(Countries);
        select.selectByVisibleText(Country);
    }
    public void getColor(String Color)
    {
        WebElement Colors =driver.findElement(By.id("colors"));
        new Actions(driver).scrollToElement(Colors).perform();
        Select select = new Select(Colors);
        select.selectByVisibleText(Color);
    }
    public WebElement getDate()
    {
        WebElement DateBox =driver.findElement(By.id("datepicker"));
        new Actions(driver).scrollToElement(DateBox).perform();
        return DateBox ;
    }



    public void fillingData(String Name, String Email, String Phone, String Address, String Gender)
    {
        getName().sendKeys(Name);
        getEmail().sendKeys(Email);
        getPhone().sendKeys(Phone);
        getAddress().sendKeys(Address);
        getGender(Gender.charAt(0)).click();

    }

    public void fillDataUsingHashTable(HashMap<String, String> Data) {

        fillingData(Data.get("Name"),Data.get("Email"),Data.get("Phone"),Data.get("Address"),Data.get("Gender"));
        System.out.println(Data.get("Day"));
        getDay(Data.get("Day")).click();
        getCountry(Data.get("Country"));
        getColor(Data.get("Color"));

    }




}
