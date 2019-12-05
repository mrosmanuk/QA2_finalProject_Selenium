package www1alv;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

class Homepage extends Common{

    private By fullScreenBanner = By.xpath("//a[@class='close-button animated']");
    private By getFullScreenBannerFrame = By.xpath("//*[@id='mt-65cf2a318dbd5e21']");
    private By advSlider = By.xpath("//div[@class='close-button-slider desktop']");
    private By advSliderFrame = By.xpath("//*[@id='mt-b832a55b5fb34368']");
    private By cookieButton = By.xpath("//a[@class='c-button-inverse']");
    private By phoneCategory = By.xpath("//a[contains(@href,'telefoni_plansetdatori')]");
    private By xiaomi = By.xpath("//a[contains(@href,'xiaomi/opened')]");
    private By sortBySelector = By.xpath("//a[@class='select-opener select-add-info']");
    private By sortByStars = By.xpath("//li[@rel='4']");
    private By selectProduct = By.xpath("//section[@class='product ']//img");

    void startWebsite(){
        driver.get("https://www.1a.lv");
    }

    void closeFullscreenBanner() throws InterruptedException {
        Thread.sleep(4000);
        try{
            if(driver.findElement(getFullScreenBannerFrame).isDisplayed()){
            driver.switchTo().frame("mt-65cf2a318dbd5e21");
            driver.findElement(fullScreenBanner).click();}
        else{
                System.out.println("fullscreen frame not found");}}
         catch(Exception ignored){}}

    void closeBottomBanner() throws InterruptedException {
        Thread.sleep(4000);
        try{
            if(driver.findElement(advSliderFrame).isDisplayed()){
            driver.switchTo().frame("mt-b832a55b5fb34368");
            driver.findElement(advSlider).click();}
        else{
                System.out.println("bottom slider not found");}}
        catch(Exception ignored){}}

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
