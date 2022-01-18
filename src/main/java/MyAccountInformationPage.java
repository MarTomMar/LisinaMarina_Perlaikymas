import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountInformationPage extends AbstractObjectPage {
    public MyAccountInformationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "input-firstname")
    WebElement myAccInfFirstName;

    @FindBy (id = "input-lastname")
    WebElement myAccInfLastName;

    @FindBy (id = "input-email")
    WebElement myAccInfemail;

    @FindBy (id = "input-telephone")
    WebElement myAccInfTelephone;






}
