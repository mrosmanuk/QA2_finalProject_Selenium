package www1alv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common {
    public static WebDriver driver;

    public void startBrowser(){
        String driverPath = ("src\\test\\resources\\");
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void stopBrowser() throws InterruptedException{
        Thread.sleep(9000);
        driver.quit();
    }
}
