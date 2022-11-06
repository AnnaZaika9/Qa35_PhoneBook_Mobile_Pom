package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegistrationScreen extends BaseScreen {
    public LoginRegistrationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    // @FindBy(xpath = "//*[@resourse-id ='com.sheygam.contactapp:id/inputEmail']")
    //  @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.EditText[1]")
    AndroidElement editTextEmail;

    @FindBy(id = "com.sheygam.contactapp:id/inputPassword")
    //@FindBy(xpath = "//*[@resourse-id ='com.sheygam.contactapp:id/inputPassword']")
    // @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.EditText[2]")
    AndroidElement editTextPassword;

    @FindBy(id = "com.sheygam.contactapp:id/regBtn")
    //@FindBy(xpath = "//*[@resourse-id ='com.sheygam.contactapp:id/regBtn']")
    // @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.Button[1]")
    AndroidElement registrationButton;

    @FindBy(id = "com.sheygam.contactapp:id/loginBtn")
    //@FindBy(xpath = "//*[@resourse-id ='com.sheygam.contactapp:id/loginBtn']")
    // @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.Button[2]")
    AndroidElement loginButton;
}
