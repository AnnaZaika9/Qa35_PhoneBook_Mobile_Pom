package tests;

import config.AppiumConfig;
import models.Auth;
import models.Contact;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class AddContactTest extends AppiumConfig {
    @BeforeClass
    public void precondition(){
        new AuthenticationScreen(driver)
                .login(Auth.builder().email("dasha@ukr.net").password("Ddasha$123456").build());
   }
    @Test
    public void addNewContactSuccess(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Sima"+i)
                .lastname("Wow"+i)
                .email("sima"+i+"@mail.ru")
                .phone("1234567"+i)
                .address("Haifa")
                .description("The best friend")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(),contact.getLastname())
                .isContactAddedByPhone(contact.getPhone());
    }

    @Test(invocationCount = 3)
    public void addNewContactSuccessRequiredFields(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Alon"+i)
                .lastname("Snow"+i)
                .email("alon"+i+"@mail.ru")
                .phone("1234567"+i)
                .address("Tel Aviv")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(),contact.getLastname())
                .isContactAddedByPhone(contact.getPhone());
    }
    @Test
    public void addNewContactNegativeEmptyName(){

        Contact contact = Contact.builder()
                .lastname("Log")
                .email("fob@mail.ru")
                .phone("999666555888")
                .address("Holon")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErorrMessageContaisText("name=must not be blank");

    }
    @Test
    public void addNewContactNegativeWrongEmail(){

        Contact contact = Contact.builder()
                .name("Valya")
                .lastname("Fox")
                .email("valyamail.ru")
                .phone("1114445557777")
                .address("Holon")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
               // .isErrorContainsText("Error")
                .isErorrMessageContaisText("email=must be a well-formed email address");


    }
    @Test
    public void addNewContactNegativeWrongPhone(){

        Contact contact = Contact.builder()
                .name("Vasya")
                .lastname("Was")
                .email("vasya@mail.ru")
                .phone("123")
                .address("Holon")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErorrMessageContaisText("phone=Phone number must contain only digits! And length min 10, max 15!");

    }
    @Test
    public void addNewContactNegativeEmptyPhone(){

        Contact contact = Contact.builder()
                .name("Neg")
                .lastname("Tive")
                .email("neg@mail.ru")
                .address("Kiev")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
               // .isErrorContainsText("Phone number must contain only digits! And length min 10, max 15!")
                .isErorrMessageContaisText("Phone number must contain only digits! And length min 10, max 15!");

    }

    @AfterClass
    public void postCondition(){
        new ContactListScreen(driver)
                .logout();
    }
}



