package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtils {

    public static String takeScreenshot(
            WebDriver driver,
            String testName) {

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        String fileName =
                testName + "_" +
                        System.currentTimeMillis() +
                        ".png";

        Path destination =
                Path.of(
                        "target",
                        "screenshots",
                        fileName
                );

        try {

            Files.createDirectories(
                    destination.getParent()
            );

            Files.copy(
                    source.toPath(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to save screenshot for test: "
                            + testName,
                    e
            );
        }

        return destination.toString();
    }
}