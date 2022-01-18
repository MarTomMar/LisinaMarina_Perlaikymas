package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitUtils {
    public static void waitForJS(WebDriver driver) {

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(new Function<>() {
            public Boolean apply(WebDriver driver) {
                return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
            }
        });
    }
}
