import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;


import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.NoSuchElementException;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.testng.Assert.assertEquals;

public class testUI extends BaseTest{

    LoginPage loginPage;
    RegistrationPage registrationPage;
    MyAccountInformationPage myAccountInformationPage;
    ProductPage productPage;



    @Test
    public void testOpenCart(){

        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        myAccountInformationPage = new MyAccountInformationPage(driver);
        productPage = new ProductPage(driver);

        String fName = "test"+(int)(Math.random()*Integer.MAX_VALUE);
        String lName = "perlaikymas" +(int)(Math.random()*Integer.MAX_VALUE);
        String email = randomAlphabetic(10) + "@email.email";
        String phone = "+370" + (int)(Math.random()*Integer.MAX_VALUE);
        String passwd = "" + (int) (Math.random()*Integer.MAX_VALUE);
        String passwdConfirm = passwd;

        loginPage.clickMyAccount();
        loginPage.clicknewRegistration();

        registrationPage.provideFirstName(fName);
        registrationPage.provideLastName(lName);
        registrationPage.provideEmail(email);
        registrationPage.provideTelephone(phone);
        registrationPage.providePassword(passwd);
        registrationPage.provideConfirmPassword(passwdConfirm);
        registrationPage.selectAgree();
        registrationPage.selectRegBtn();
        assertEquals(driver.getTitle(), "Your Account Has Been Created!");

        registrationPage.clickcontinueButtonAfterAccountCreation();
        registrationPage.clickEditYourAccountInfo();

       String firstNameRegistrationForm =  registrationPage.firstName.getText();
       String firstNameMyAccInfoPage = myAccountInformationPage.myAccInfFirstName.getText();

       String lastNameRegistrationForm = registrationPage.lastName.getText();
       String lastNameMyAccInfoPage = myAccountInformationPage.myAccInfLastName.getText();

       String emailRegistrationForm = registrationPage.eMail.getText();
       String emailMyAccInfoPage = myAccountInformationPage.myAccInfemail.getText();

       String telephoneRegistrationForm = registrationPage.telephone.getText();
       String telephoneMyAccInfoPage = myAccountInformationPage.myAccInfTelephone.getText();


        assertEquals(firstNameRegistrationForm, firstNameMyAccInfoPage, "First Name differs." );
        assertEquals(lastNameRegistrationForm, lastNameMyAccInfoPage, "Last name differs");
        assertEquals(emailRegistrationForm, emailMyAccInfoPage, "E-mail differs");
        assertEquals(telephoneRegistrationForm, telephoneMyAccInfoPage,  "Telephone number " +
                "differs.");

        productPage.clickLaptotopsAndNotebookDropdown();
        productPage.clickShowAllLaptotopsAndNotebookDropdown();
        productPage.clickMacBookAir();
        productPage.clickAddToCart();

        String productInACart = productPage.productInACart.getText();
        String expectedCartText = "1 item(s) - $1,202.00";
        assertEquals(productInACart, expectedCartText, "Product was not added to the cart." );







    }

}
