package www1alv;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Homepage extends Common{

    private By advSlider = By.xpath("//*[@id=\"promo-bar\"]/div/div[2]");
    private By cookieButton = By.xpath("//*[@id=\"cookie-btns\"]/a[1]");
    private By phoneCategory = By.xpath("//*[@id=\"sidebar\"]/ul/li[1]/a");
    private By xiaomi = By.xpath("//*[@id=\"main\"]/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/a");
    private By sortBySelector = By.xpath("//*[@id=\"product_search_result_grid_container\"]/div[3]/div/fieldset[1]/div/a");
    private By sortByStars = By.xpath("//li[@rel='4']");
    private By selectProduct = By.xpath("//*[@id=\"product_search_grid_container\"]/div[4]/section[1]/div/div/div/div[2]/h3/a");

    public void startWebsite(){
        driver.get("https://www.1a.lv");
    }

    public void closeBottomBanner() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame("mt-f352938a75c64630");
        driver.findElement(advSlider).click();
    }

    public void acceptCookies() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(cookieButton).click();
    }

    public void navigateToPhone(){
        driver.findElement(phoneCategory).click();
    }

    public void navigateToBrand() throws InterruptedException {
        WebElement element = driver.findElement(xiaomi);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        driver.findElement(xiaomi).click();
    }

    public void sortByStars() throws InterruptedException {
        driver.findElement(sortBySelector).click();
        driver.findElement(sortByStars).click();
        Thread.sleep(3000);
    }

    public void selectProduct()throws InterruptedException{
        WebElement element = driver.findElement(selectProduct);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        driver.findElement(selectProduct).click();
    }
}
