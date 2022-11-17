package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

public class RemoveContactTest extends AppiumConfig {
    @BeforeClass
    public void precondition(){
        new AuthenticationScreen(driver)
                .login(Auth.builder().email("dasha@ukr.net").password("Ddasha$123456").build())
                .isContactListActivityPresent();
    }
    @BeforeMethod
    public void contactCheck(){
        new ContactListScreen(driver)
                .providerOfContacts();
    }


    @Test
    public void removeOneContactSuccess(){
        new ContactListScreen(driver)
                .removeFirstContact();

        //size less one
    }
    @Test
    public void removeAllContactSuccess() {
        new ContactListScreen(driver)
                .removeAllContacts()
                .isNoContactHere("No Contacts. Add One more!");

        //text = no contact here
    }

}
