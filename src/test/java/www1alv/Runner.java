package www1alv;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
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
        homepage.closeBottomBanner();
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
        System.out.println(user.getCheckoutUserData()[1]);

    }

    @After
    public void afterProcess() throws InterruptedException{
        homepage.stopBrowser();
        softAssert.assertAll();
    }

}
