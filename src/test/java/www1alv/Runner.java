package www1alv;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.testng.asserts.SoftAssert;

import java.util.Arrays;

public class Runner {
    Homepage homepage = new Homepage();
    Productpage productpage = new Productpage();
    Orderpage orderpage = new Orderpage();

    ProductModel product = new ProductModel();
    UserModel user = new UserModel();

    private SoftAssert softAssert = new SoftAssert();

    @Before
    public void beforeProcess() throws InterruptedException {
        homepage.startBrowser();
        homepage.startWebsite();
        //homepage.closeBottomBanner();
        homepage.acceptCookies();
    }

    @Test
    public void testProcess() throws InterruptedException{
        user.setUserName("Name");
        user.setUserLastname("Lastname");
        user.setPhoneNumber("+37120000000");
        user.setEmail("tester@tester.lv");

        homepage.navigateToPhone();
        homepage.navigateToBrand();
        homepage.sortByStars();
        homepage.selectProduct();

        product.setProductPrice(productpage.productPrice());
        System.out.println(product.getProductPrice());
        product.setProductName(productpage.productName());
        System.out.println(product.getProductName());
        productpage.placeProductToCart();
        productpage.navigateToCart();

        orderpage.nextStep1();
        orderpage.nextStepWithoutReg();
        orderpage.inputName(user.getUserName());
        orderpage.inputLastname(user.getUserLastname());
        orderpage.inputEmail(user.getEmail());
        orderpage.inputPhoneNumber(user.getPhoneNumber());
        orderpage.agreeOnNoSpam();
        orderpage.acceptTerms();
        orderpage.selectDeliveryMethod();
        orderpage.nextStep2();
        orderpage.userContactOption();
        orderpage.nextStep3();

        softAssert.assertEquals(product.getProductName(),orderpage.getNameBeforeCheckout());
        softAssert.assertEquals(product.getProductPrice(),orderpage.getPriceBeforeCheckout());

        user.setCheckoutUserData(orderpage.getElements());
        System.out.println(Arrays.toString(user.getCheckoutUserData()));

        softAssert.assertEquals(user.getUserName(),user.getCheckoutUserData()[1]);
        softAssert.assertEquals(user.getUserLastname(),user.getCheckoutUserData()[2]);
        softAssert.assertEquals(user.getEmail(),user.getCheckoutUserData()[3]);
        softAssert.assertEquals(user.getPhoneNumber(),user.getCheckoutUserData()[4]);
    }

    @After
    public void afterProcess() throws InterruptedException{
        homepage.stopBrowser();
        softAssert.assertAll();
    }

}
