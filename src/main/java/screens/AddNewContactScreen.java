package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.Contact;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddNewContactScreen extends BaseScreen{
    public AddNewContactScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputName']")
          //  (id = "'com.sheygam.contactapp:id/inputName'")
    AndroidElement nameEditText;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputLastName']")
    AndroidElement lastNameEditText;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    AndroidElement emailEditText;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPhone']")
    AndroidElement phoneEditText;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputAddress']")
    AndroidElement addressEditText;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputDesc']")
    AndroidElement descriptionEditText;
    @FindBy(xpath = "//*[@resource-id ='com.sheygam.contactapp:id/createBtn']")
    AndroidElement createButton;
    @FindBy(id = "android:id/message")
    AndroidElement errorTextView;
    @FindBy(id="android:id/button1")
    AndroidElement okBtn;

    public AddNewContactScreen fillContactForm(Contact contact){
        should(nameEditText,5);

        type2(nameEditText, contact.getName());
        type2(lastNameEditText,contact.getLastname());
        type2(emailEditText,contact.getEmail());
        type2(phoneEditText,contact.getPhone());
        type2(addressEditText,contact.getAddress());
        type2(descriptionEditText,contact.getDescription());

        return this;
    }
    public ContactListScreen submitContactForm(){
        createButton.click();
        return new ContactListScreen(driver);
    }
    public AddNewContactScreen submitContactFormNegative(){
        createButton.click();
        return this;
    }

    public AddNewContactScreen isErorrMessageContaisText(String text){
        pause(5000);
        Assert.assertTrue(errorTextView.getText().contains(text));
        okBtn.click();

        return this;
    }
    public AddNewContactScreen isErrorContainsText(String text){
        Alert alert = new WebDriverWait(driver,5)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertTrue(alert.getText().contains(text));
        alert.accept();

        return this;
    }


  
}
