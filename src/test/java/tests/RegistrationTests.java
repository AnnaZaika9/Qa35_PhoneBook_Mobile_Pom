package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationSuccess()  {

       // int i = (int)(System.currentTimeMillis()/1000)%3600;
        int i = new Random().nextInt(1000)+1000;

        new AuthenticationScreen(driver)
                .fillEmail("nikita"+i+"@ukr.net")
                .fillPassword("987654$Nikita")
                .submitRegistration()
                .assertContactListActivityPresent()
                .logout();
    }
    @Test
    public void registrationSuccessModel(){

        int i = (int)(System.currentTimeMillis()/1000)%3600;

        new AuthenticationScreen(driver)
                .registration(Auth.builder().email("misha"+i+"@gmail.com").password("123589$Misha").build())
                .assertContactListActivityPresent()
                .logout();

    }
    @Test
    public void registrationNegativeWrongEmail(){

        new AuthenticationScreen(driver)
                .fillEmail("megamail.com")
                .fillPassword("Mmm12345!")
                .submitRegistrationNegative()
                .isErorrMessageContaisText("must be a well-formed email address");

    }
//    @Test
//    public void registrationNegativeWrongPassword(){
//
//        new AuthenticationScreen(driver)
//                .registrationUnsuccessful(Auth.builder().email("man@mail.com").password("Man12").build())
//                .isErorrMessageContaisTextInAlert("At least 8 character");
//    }




}
