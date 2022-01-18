import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractObjectPage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    WebElement firstName;

    @FindBy(id = "input-lastname")
    WebElement lastName;

    @FindBy(id = "input-email")
    WebElement eMail;

    @FindBy(id = "input-telephone")
    WebElement telephone;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(id = "input-confirm")
    WebElement passwordConfirm;

    @FindBy(name = "agree")
    WebElement agreeButton;


    @FindBy(xpath = "//*[@id='content']/form/div/div/input[2]")
    WebElement continueBtn;

    @FindBy(xpath  = "//*[@id='content']/div/div")
    WebElement continueButtonAfterAccountCreation;

    @FindBy (linkText = "Edit your account information")
    WebElement editYourAccountInfo;


    public void clickEditYourAccountInfo(){
        editYourAccountInfo.click();
    }

    public void provideFirstName(String fName) {
        firstName.sendKeys(fName);
    }


    public void provideLastName(String lName) {
        lastName.sendKeys(lName);
    }

    public void provideEmail(String email) {
        eMail.sendKeys(email);
    }

    public void provideTelephone(String phone) {
        telephone.sendKeys(phone);
    }

    public void providePassword(String passwd) {
        password.sendKeys(passwd);
    }

    public void provideConfirmPassword(String passwdConfirm) {
        passwordConfirm.sendKeys(passwdConfirm);
    }

    public void selectAgree() {
        agreeButton.click();
    }

    public void selectRegBtn() {
        continueBtn.click();
    }

    public void clickcontinueButtonAfterAccountCreation (){
        continueButtonAfterAccountCreation.click();
    }



}
