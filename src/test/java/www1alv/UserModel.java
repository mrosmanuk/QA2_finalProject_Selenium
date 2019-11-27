package www1alv;

import org.openqa.selenium.WebElement;

import java.util.List;

public class UserModel {
    private String userName;
    private String userLastName;
    private String email;
    private String phoneNumber;
    private String[] checkoutUserData;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastname() {
        return userLastName;
    }

    public void setUserLastname(String userLastname) {
        this.userLastName = userLastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String[] getCheckoutUserData() {
        return checkoutUserData;
    }

    public void setCheckoutUserData(String[] checkoutUserData) {
        this.checkoutUserData = checkoutUserData;
    }
}
