import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected static WebDriver driver;


    @BeforeSuite
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }
    @BeforeMethod
    public void openHomePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");

    }

    @AfterMethod
    public static void closeBrowser(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

    @AfterSuite
    public static void quitDriver(){
        driver.quit();
    }
}
