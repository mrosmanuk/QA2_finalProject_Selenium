package www1alv;

import org.openqa.selenium.By;

class Productpage extends Common{

    private By price = By.xpath("//div[@data-sell-price-w-vat]");
    private By productName = By.xpath("//div[@class='product-main-info']/h1"); // //*[@id="product-view-container"]/div[1]/div[1]/header/div[2]/h1
    private By placeToCart = By.xpath("//*[@id='add_product_to_shopping_cart_button_top']");
    private By cartLink = By.xpath("//*[@id='shopping_cart_container']/a");

    String productPrice(){
        return driver.findElement(price).getAttribute("data-sell-price-w-vat");
    }

    String productName(){
        return driver.findElement(productName).getText();
    }

    void placeProductToCart() throws InterruptedException{
        driver.findElement(placeToCart).click();
        Thread.sleep(3000);
    }

    void navigateToCart(){
        driver.findElement(cartLink).click();
    }
}
