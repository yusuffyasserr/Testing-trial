package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utils.ConfigReader;

// handling browser creation here instead of each time changing tests
public class DriverFactory {

    public static WebDriver createDriver() {

        String browser = ConfigReader.get("browser");

        WebDriver driver = switch (browser.toLowerCase()) {

            case "chrome" -> new ChromeDriver();

            case "edge" -> new EdgeDriver();

            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );
        };

        driver.manage().window().maximize();

        return driver;
    }
}