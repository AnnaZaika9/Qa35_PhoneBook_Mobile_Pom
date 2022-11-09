package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ContactListScreen extends BaseScreen {
    public ContactListScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    AndroidElement activityViewText;

    @FindBy(xpath = "//*[@content-desc= 'More options']")
    AndroidElement moreOptions;

    @FindBy(id = "com.sheygam.contactapp:id/title")
    AndroidElement logoutButton;


    @FindBy(xpath = "//*[@content-desc='add']")
    // @FindBy(xpath = "//*[@resource-id ='com.sheygam.contactapp:id/add_contact_btn']")
    AndroidElement plusButton;


    public AuthenticationScreen logout() {
        moreOptions.click();
        logoutButton.click();
        return new AuthenticationScreen(driver);
    }

    public ContactListScreen assertContactListActivityPresent() {
        Assert.assertTrue(isContactListActivityPresent());
        return this;
    }

    public boolean isContactListActivityPresent() {
        should(plusButton, 10);
        return isShouldHave(activityViewText, "Contact list", 10);
    }





}

