package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.AfterClass;
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
    public void providerContacts(){
        new ContactListScreen(driver)
          //      .providerOfContactsHW()
                .providerContacts();
    }


    @Test
    public void removeOneContactSuccessHW(){
        new ContactListScreen(driver)
                .removeFirstContact();

    }
    @Test
    public void removeOneContactSuccess(){
        new ContactListScreen(driver)
                .removeOneContact()
                .isListSizeOneLess();

        //size less one
    }
    @Test
    public void removeAllContactSuccess() {
        new ContactListScreen(driver)
                .removeAllContacts()
           //     .isNoContactHereHW("No Contacts. Add One more!")
                .isNoContactHere();

        //text = no contact here
    }

    @AfterClass
    public void postCondition(){
        new ContactListScreen(driver)
                .logout4();
    }

}
