package pl.swaglab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static pl.swaglab.utils.WaitForElement.waitUntilElementIsVisible;

public class HomePage extends BasePage {
    @FindBy(css = ".inventory_item button")
    private List<WebElement> addProductsButton;

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> productName;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartButton;

    @FindBy(css = "select")
    private WebElement sortList;

    @FindBy(css = ".title")
    private WebElement titleProducts;

    @FindBy(css = ".error-message-container.error")
    private WebElement errorLoginMess;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;

    @FindBy(css= ".inventory_item_container button")
    private WebElement addProductFromPageButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage addProduct(int index) {
        addProductsButton.get(index).click();
        return this;
    }

    public ShoppingCartPage goToShoppingCart() {
        shoppingCartButton.click();
        return new ShoppingCartPage(driver);
    }

    public HomePage selectLowToHighSort() {
        Select select = new Select(sortList);
        select.selectByValue("lohi");
        return this;
    }

    public HomePage selectHighToLowSort() {
        Select select = new Select(sortList);
        select.selectByValue("hilo");
        return this;
    }
    public HomePage selectZToASort(){
        Select select= new Select(sortList);
        select.selectByValue("za");
        return this;
    }
    public HomePage selectAToZSort(){
        Select select= new Select(sortList);
        select.selectByValue("az");
        return this;
    }
    public HomePage gotoProductPage( int index){
        productName.get(index).click();
        return this;
    }
    public HomePage addProductFromProductPage() {
        addProductFromPageButton.click();
        waitUntilElementIsVisible(addProductFromPageButton,wait);
        return this;
    }
    public HomePage backToProductList(){
        backToProductsButton.click();
        return this;
    }

    public String titleProductText() {
        return titleProducts.getText();
    }

    public  boolean shoppingBadge() {
        shoppingCartBadge.isDisplayed();
        return true;
    }
    public int productSize(){
       return  productName.size();
    }
    public String shoppingBadgeText(){
        return shoppingCartBadge.getText();
    }

}
