package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class EditContactScreen extends BaseScreen{

    public EditContactScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    AndroidElement activityViewText;
    @FindBy(id = "com.sheygam.contactapp:id/inputName")
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
    @FindBy(id = "com.sheygam.contactapp:id/updateBtn")
    AndroidElement updateButton;


    public EditContactScreen editNameOnly(String text){
        shouldHave(activityViewText,"Edit contact",5);
        System.out.println(nameEditText.getText());
        type2(nameEditText,text);
        System.out.println(nameEditText.getText());
        return this;
    }
    public ContactListScreen updateChanges(){
        updateButton.click();
        return new ContactListScreen(driver);
    }
    public EditContactScreen editFildContact(String option,String text){
        isShouldHave(activityViewText,"Edit contact", 5);
        switch (option){
            case "name" :
                type2(nameEditText,text);
                break;
            case "lastname" :
                type2(lastNameEditText,text);
                break;
            case "phone":
                type2(phoneEditText,text);
                break;
            case "email":
                type2(emailEditText,text);
                break;
            case "address":
                type2(addressEditText,text);
                break;
            case "description":
                type2(descriptionEditText,text);
                break;

        }

        return this;
    }
    public EditContactScreen editFieldContact2(String option,String text) {
        shouldHave(activityViewText, "Edit contact", 5);
        if (option.equals("name")) {
            type2(nameEditText, text);
        } else if (option.equals("lastname")) {
            type2(lastNameEditText, text);
        } else if (option.equals("phone")) {
            type2(phoneEditText, text);
        } else if (option.equals("email")) {
            type2(emailEditText, text);
        } else if (option.equals("address")) {
            type2(addressEditText, text);
        } else if (option.equals("description")) {
            type2(descriptionEditText, text);
        }

        return this;
    }
}
