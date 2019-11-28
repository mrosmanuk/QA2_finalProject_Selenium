package www1alv;

class UserModel {
    private String userName;
    private String userLastName;
    private String email;
    private String phoneNumber;
    private String[] checkoutUserData;

    String getUserName() {
        return userName;
    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    String getUserLastname() {
        return userLastName;
    }

    void setUserLastname(String userLastname) {
        this.userLastName = userLastname;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    String[] getCheckoutUserData() {
        return checkoutUserData;
    }

    void setCheckoutUserData(String[] checkoutUserData) {
        this.checkoutUserData = checkoutUserData;
    }
}
