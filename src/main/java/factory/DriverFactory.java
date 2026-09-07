package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// handling browser creation here instead of each time changing tests
public class DriverFactory {

    public static WebDriver createDriver() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        return driver;
    }
}