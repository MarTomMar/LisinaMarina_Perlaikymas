import Utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractObjectPage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptotopsAndNotebookDropdown;

    @FindBy (linkText = "Show All Laptops & Notebooks")
    WebElement showAllLaptotopsAndNotebookDropdown;

    @FindBy (linkText = "MacBook Air")
    WebElement macBookAir;

    @FindBy(id = "button-cart")
    WebElement buttonAddToCart;

    @FindBy(xpath = "//*[@id='cart']/button")
    WebElement productInACart;

    public void clickLaptotopsAndNotebookDropdown(){
        laptotopsAndNotebookDropdown.click();
    }

    public void clickShowAllLaptotopsAndNotebookDropdown(){
        showAllLaptotopsAndNotebookDropdown.click();
    }
    public void clickMacBookAir(){
        macBookAir.click();
    }

    public void clickAddToCart() {
        buttonAddToCart.click();
        WaitUtils.waitForJS(driver);
    }
    public void checkProductAddedToTheCart() {
        productInACart.getText();
    }






}






