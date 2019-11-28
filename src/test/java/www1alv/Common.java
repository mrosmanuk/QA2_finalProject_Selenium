package www1alv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Common {
    static WebDriver driver;

    void startBrowser(){
        String driverPath = ("src\\test\\resources\\");
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    void stopBrowser() throws InterruptedException{
        Thread.sleep(9000);
        driver.quit();
    }
}
