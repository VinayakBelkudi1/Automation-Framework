package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ScreenShotUtil {

    public static void takeScreenshot(WebDriver driver, String testName) throws IOException {

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMDd_HHMMSS"));
        String path = System.getProperty("user.dir") + "/test-output/screenshots/" + testName + "_" + timestamp + ".png";
        
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(path);

        FileUtils.copyFile(src, dest);
        }

        
    }
