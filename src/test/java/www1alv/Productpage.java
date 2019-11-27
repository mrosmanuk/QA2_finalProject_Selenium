package www1alv;

import org.openqa.selenium.By;

public class Productpage extends Common{

    private By price = By.xpath("//div[@data-sell-price-w-vat]");
    private By productName = By.xpath("//*[@id=\"product-view-container\"]/div[1]/div[1]/header/div[2]/h1");
    private By placeToCart = By.xpath("//*[@id=\"add_product_to_shopping_cart_button_top\"]");
    private By cartLink = By.xpath("//*[@id=\"shopping_cart_container\"]/a");

    public String productPrice(){
        return driver.findElement(price).getAttribute("data-sell-price-w-vat");
    }

    public String productName(){
        return driver.findElement(productName).getText();
    }

    public void placeProductToCart(){
        driver.findElement(placeToCart).click();
    }

    public void navigateToCart(){
        driver.findElement(cartLink).click();
    }

}
