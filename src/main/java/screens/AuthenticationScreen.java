package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;


public class AuthenticationScreen extends BaseScreen {
    public AuthenticationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    // @FindBy(xpath = "//*[@resourse-id ='com.sheygam.contactapp:id/inputEmail']")
    AndroidElement editTextEmail;

    @FindBy(id = "com.sheygam.contactapp:id/inputPassword")
    // @FindBy(xpath = "//*[@resourse-id ='com.sheygam.contactapp:id/inputPassword']")
    AndroidElement editTextPassword;


    @FindBy(xpath = "//*[@text= 'LOGIN']")
    //  @FindBy(id = "com.sheygam.contactapp:id/loginBtn")
    //  @FindBy(xpath = "//*[@resourse-id ='com.sheygam.contactapp:id/loginBtn']")
    AndroidElement loginButton;

    @FindBy(id = "com.sheygam.contactapp:id/regBtn")
    //@FindBy(xpath = "//*[@resourse-id ='com.sheygam.contactapp:id/regBtn']")
    AndroidElement registrationButton;

    public ContactListScreen login(Auth auth) {
        should(editTextEmail, 5);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        loginButton.click();

        return new ContactListScreen(driver);
    }


    public AuthenticationScreen fillEmail(String email) {
        should(editTextEmail, 7);
        type(editTextEmail, email);
        return this;
    }

    public AuthenticationScreen fillPassword(String password) {
        type(editTextPassword, password);
        // return new AuthenticationScreen(driver);
        return this;
    }

    public ContactListScreen submitLogin() {
        System.out.println(loginButton.getAttribute("text"));
        loginButton.click();
        return new ContactListScreen(driver);
    }


    public ContactListScreen submitRegistration() {
        registrationButton.click();
        return new ContactListScreen(driver);
    }


    public ContactListScreen registration(Auth auth) {
        should(editTextEmail, 5);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        registrationButton.click();
        return new ContactListScreen(driver);
    }
}