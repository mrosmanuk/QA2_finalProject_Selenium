package www1alv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Orderpage extends Common {

    private By nextStep1 = By.xpath("//*[@id=\"main\"]/div/div/form/div[1]/a[3]");
    private By nextWithoutReg = By.xpath("//*[@id=\"main\"]/div/div/form/div[2]/div/b/b/div/fieldset/div/a");
    private By inputName = By.xpath("//*[@id=\"order_main_data_name\"]");
    private By inputUserLastName = By.xpath("//*[@id=\"order_main_data_surname\"]");
    private By inputEmail = By.xpath("//*[@id=\"order_main_data_email\"]");
    private By inputPhoneNumber = By.xpath("//*[@id=\"order_main_data_contact_phone_number\"]");
    private By spamAgreementSelector = By.xpath("//*[@id=\"order_form\"]/div[2]/div[1]/div[2]/section/div[1]/div[1]/div[3]/span/a");
    private By noSpamOption = By.xpath("//*[@id=\"ui-id-2\"]/li[2]");
    private By acceptTerms = By.xpath("//*[@id=\"accept_purchase_agreement\"]");
    private By deliveryMethod = By.xpath("//article[@data-delivery-type-id='9']");
    private By nextStep2 = By.xpath("//*[@id=\"order_form\"]/div[2]/div[3]/a[2]");
    private By contactMethod = By.xpath("//*[@id=\"transfer_individual_person\"]/section/div[2]/div[1]/div/span/a");
    private By contactMethodByEmail = By.xpath("//a[contains(.,'E-past')]");
    private By nextStep3 = By.xpath("//*[@id=\"order_form\"]/div[3]/a[2]");
    private By nameBeforeCheckout = By.xpath("//*[@id=\"main\"]/div/div/form/section/table/tbody/tr[2]/td[2]/div/h4/a");
    private By priceBeforeCheckout = By.xpath("//*[@id=\"shopping-cart-total-amount\"]");

    public void nextStep1(){
        driver.findElement(nextStep1).click();
    }

    public void nextStepWithoutReg(){
        driver.findElement(nextWithoutReg).click();
    }

    public void inputName(String userName){
        driver.findElement(inputName).sendKeys(userName);
    }

    public void inputLastname(String userLastName){
        driver.findElement(inputUserLastName).sendKeys(userLastName);
    }

    public void inputEmail(String userEmail){
        driver.findElement(inputEmail).sendKeys(userEmail);
    }

    public void inputPhoneNumber(String userPhoneNumber){
        driver.findElement(inputPhoneNumber).sendKeys(userPhoneNumber);
    }

    public void agreeOnNoSpam(){
        driver.findElement(spamAgreementSelector).click();
        driver.findElement(noSpamOption).click();
    }

    public void acceptTerms(){
        driver.findElement(acceptTerms).click();
    }

    public void selectDeliveryMethod() throws InterruptedException {
        driver.findElement(deliveryMethod).click();
        Thread.sleep(2000);
    }

    public void nextStep2(){
        driver.findElement(nextStep2).click();
    }

    public void userContactOption(){
        driver.findElement(contactMethod).click();
        driver.findElement(contactMethodByEmail).click();
    }

    public void nextStep3(){
        driver.findElement(nextStep3).click();
    }

    public String getNameBeforeCheckout(){
        return driver.findElement(nameBeforeCheckout).getText();
    }

    public String getPriceBeforeCheckout(){
        return driver.findElement(priceBeforeCheckout).getText().substring(0,5);
    }

    public String[] getElements(){
        return driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/form/div[2]/div/div[1]")).getText().split("");
    }
}
