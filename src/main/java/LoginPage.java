import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractObjectPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/footer/div/div/div[4]/ul/li[1]/a")
     WebElement myAccount;

    @FindBy(linkText = "Register")
     WebElement newRegistration;





    public void clickMyAccount(){
        myAccount.click();
    }
    public void clicknewRegistration(){
        newRegistration.click();
    }
}
