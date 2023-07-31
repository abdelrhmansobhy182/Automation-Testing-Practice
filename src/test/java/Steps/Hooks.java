package Steps;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver=null;
    @After
    public void closeBrowser(){
        driver.quit();
    }
}
