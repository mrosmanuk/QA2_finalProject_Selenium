package www1alv;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.testng.asserts.SoftAssert;

import java.util.Arrays;

public class Runner {
    private Homepage homepage = new Homepage();
    private Productpage productpage = new Productpage();
    private Orderpage orderpage = new Orderpage();
    private ProductModel product = new ProductModel();
    private UserModel user = new UserModel();

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
        //set user data
        user.setUserName("Name");
        user.setUserLastname("Lastname");
        user.setPhoneNumber("+37120000000");
        user.setEmail("tester@tester.lv");

        //navigate and open product page
        homepage.navigateToPhone();
        homepage.navigateToBrand();
        homepage.sortByStars();
        homepage.selectProduct();

        //set and sout acquired price
        product.setProductPrice(productpage.productPrice());
        System.out.println(product.getProductPrice());

        //set and sout acquired product name
        product.setProductName(productpage.productName());
        System.out.println(product.getProductName());

        //add product to cart, navigate to cart
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

        //compare name and price from product page with name and price from pre-purchase page
        softAssert.assertEquals(product.getProductName(),orderpage.getNameBeforeCheckout());
        softAssert.assertEquals(product.getProductPrice(),orderpage.getPriceBeforeCheckout()[0]);

        //set user info from pre-purchase page into array
        user.setCheckoutUserData(orderpage.getElements());
        System.out.println(Arrays.toString(user.getCheckoutUserData()));

        //compare user info from previously set with info on pre-purchase page
        softAssert.assertEquals(user.getUserName(),user.getCheckoutUserData()[1]);
        softAssert.assertEquals(user.getUserLastname(),user.getCheckoutUserData()[2]);
        softAssert.assertEquals(user.getEmail(),user.getCheckoutUserData()[3]);
        softAssert.assertEquals(user.getPhoneNumber(),user.getCheckoutUserData()[4]);
    }

    @After
    public void afterProcess() throws InterruptedException{
        homepage.stopBrowser();
        softAssert.assertAll(); //show all assert failures
    }

}
