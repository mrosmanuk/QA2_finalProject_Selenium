package www1alv;

import org.openqa.selenium.By;

class Orderpage extends Common {

    private By nextStep1 = By.xpath("//a[@class='ait-button ait-button-primary order-form-forward-button']"); // //*[@id="main"]/div/div/form/div[1]/a[3]
    private By nextWithoutReg = By.xpath("//a[@class='button btn-v2']"); // //*[@id="main"]/div/div/form/div[2]/div/b/b/div/fieldset/div/a
    private By inputName = By.xpath("//input[@id='order_main_data_name']");
    private By inputUserLastName = By.xpath("//input[@id='order_main_data_surname']");
    private By inputEmail = By.xpath("//input[@id='order_main_data_email']");
    private By inputPhoneNumber = By.xpath("//input[@id='order_main_data_contact_phone_number']");
    private By spamAgreementSelector = By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']");
    private By noSpamOption = By.xpath("//*[@id=\"ui-id-2\"]/li[2]");
    private By acceptTerms = By.xpath("//input[@id='accept_purchase_agreement']");
    private By deliveryMethod = By.xpath("//article[@data-delivery-type-id='9']");
    private By nextStep2 = By.xpath("//a[@class='ait-button ait-button-primary order-form-forward-button']"); // //*[@id="order_form"]/div[2]/div[3]/a[2]
    private By contactMethod = By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']"); // //*[@id="transfer_individual_person"]/section/div[2]/div[1]/div/span/a
    private By contactMethodByEmail = By.xpath("//a[contains(.,'E-past')]");
    private By nextStep3 = By.xpath("//a[@class='ait-button ait-button-primary order-form-forward-button']"); // //*[@id="order_form"]/div[3]/a[2]
    private By nameBeforeCheckout = By.xpath("//div[@class='ait-cart-item-info']"); // //*[@id="main"]/div/div/form/section/table/tbody/tr[2]/td[2]/div/h4/a
    private By priceBeforeCheckout = By.xpath("//span[@class='ait-cart-total-count ait-cart-total-price']"); // //*[@id="shopping-cart-total-amount"]

    void nextStep1(){
        driver.findElement(nextStep1).click();
    }

    void nextStepWithoutReg(){
        driver.findElement(nextWithoutReg).click();
    }

    void inputName(String userName){
        driver.findElement(inputName).sendKeys(userName);
    }

    void inputLastname(String userLastName){
        driver.findElement(inputUserLastName).sendKeys(userLastName);
    }

    void inputEmail(String userEmail){
        driver.findElement(inputEmail).sendKeys(userEmail);
    }

    void inputPhoneNumber(String userPhoneNumber){
        driver.findElement(inputPhoneNumber).sendKeys(userPhoneNumber);
    }

    void agreeOnNoSpam(){
        driver.findElement(spamAgreementSelector).click();
        driver.findElement(noSpamOption).click();
    }

    void acceptTerms(){
        driver.findElement(acceptTerms).click();
    }

    void selectDeliveryMethod() throws InterruptedException {
        driver.findElement(deliveryMethod).click();
        Thread.sleep(2000);
    }

    void nextStep2(){
        driver.findElement(nextStep2).click();
    }

    void userContactOption(){
        driver.findElement(contactMethod).click();
        driver.findElement(contactMethodByEmail).click();
    }

    void nextStep3(){
        driver.findElement(nextStep3).click();
    }

    String getNameBeforeCheckout(){
        return driver.findElement(nameBeforeCheckout).getText();
    }

    String[] getPriceBeforeCheckout(){
        return driver.findElement(priceBeforeCheckout).getText().split("[^\\S]+");
    }

    String[] getElements(){
        return driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/form/div[2]/div/div[1]")).getText().split("[^\\S]+");
    }
}
