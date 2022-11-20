package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class EditContactTests extends AppiumConfig {
    @BeforeClass
    public void precondition(){
        new AuthenticationScreen(driver)
                .login(Auth.builder().email("dasha@ukr.net").password("Ddasha$123456").build())
                .isContactListActivityPresent();
    }
    @Test
    public void editFirstContactSuccessByName(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        new ContactListScreen(driver)
                .openEditForm()
                .editNameOnly("Wwwww"+i)
                .updateChanges()
                .isContactAddedByNameOnly("Wwwww"+i);
    }
    @Test
    public void editFirstContactSuccessByPhone(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        new ContactListScreen(driver)
                .openEditForm()
                .editFildContact("phone","11111111"+i)
                .updateChanges()
                .isContactAddedByPhone("11111111"+i);
    }
    @Test
    public void editFirstContactSuccessByLastName(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        new ContactListScreen(driver)
                .openEditForm()
                .editFildContact("lastname","QaTest"+i)
                .updateChanges()
                .isContactAddedByLastNameOnly("QaTest"+i);
    }
    @Test
    public void editFirstContactSuccessByEmail(){
        int i = new Random().nextInt(1000)+1000;
        String email = "1test"+i+"@gmail.com";
        new ContactListScreen(driver)
                .openEditForm()
                .editFildContact("email",email)
                .updateChanges()
                .isContactAddedByEmail(email);
    }

    @AfterClass
    public void postCondition(){
        new ContactListScreen(driver)
                .logout();
    }
}
