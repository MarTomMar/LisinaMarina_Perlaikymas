import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractObjectPage {
    protected static WebDriver driver;

    public AbstractObjectPage(org.openqa.selenium.WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
