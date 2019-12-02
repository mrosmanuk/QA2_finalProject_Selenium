package www1alv;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

class Homepage extends Common{

    private By fullScreenBanner = By.xpath("/html/body/div[1]/div/div/a");
    private By getFullScreenBannerFrame = By.xpath("//*[@id=\"mt-2b89d08afae5af31\"]");
    private By advSlider = By.xpath("//div[@class='close-button-slider desktop']");// //*[@id="promo-bar"]/div/div[2]
    private By advSliderFrame = By.xpath("//*[@id=\"mt-f352938a75c64630\"]");
    private By cookieButton = By.xpath("//a[@class='c-button-inverse']");// //*[@id="cookie-btns"]/a[1]
    private By phoneCategory = By.xpath("//a[contains(@href,'telefoni_plansetdatori')]");// //*[@id="sidebar"]/ul/li[1]/a
    private By xiaomi = By.xpath("//a[contains(@href,'xiaomi/opened')]");// //*[@id="main"]/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/a
    private By sortBySelector = By.xpath("//a[@class='select-opener select-add-info']");// //*[@id="product_search_result_grid_container"]/div[3]/div/fieldset[1]/div/a
    private By sortByStars = By.xpath("//li[@rel='4']");
    private By selectProduct = By.xpath("//img[contains(@alt,'Xiaomi Mi Band 2')]");// //*[@id="product_search_grid_container"]/div[4]/section[1]/div/div/div/div[2]/h3/a

    void startWebsite(){
        driver.get("https://www.1a.lv");
    }

    void closeFullscreenBanner() throws InterruptedException {
        Thread.sleep(4000);
        if(driver.findElement(getFullScreenBannerFrame).isDisplayed()){
            driver.switchTo().frame("mt-2b89d08afae5af31");
            driver.findElement(fullScreenBanner).click();
        }}

    void closeBottomBanner() throws InterruptedException {
        Thread.sleep(4000);
        if(driver.findElement(advSliderFrame).isDisplayed()){
            driver.switchTo().frame("mt-0e985ab86eaea08c");
            driver.findElement(advSlider).click();
        }}

    void acceptCookies() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(cookieButton).click();
    }

    void navigateToPhone(){
        driver.findElement(phoneCategory).click();
    }

    void navigateToBrand() throws InterruptedException {
        WebElement element = driver.findElement(xiaomi);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        driver.findElement(xiaomi).click();
    }

    void sortByStars() throws InterruptedException {
        WebElement element = driver.findElement(sortBySelector);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        driver.findElement(sortBySelector).click();
        driver.findElement(sortByStars).click();
        Thread.sleep(3000);
    }

    void selectProduct()throws InterruptedException{
        WebElement element = driver.findElement(selectProduct);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        driver.findElement(selectProduct).click();
    }
}
