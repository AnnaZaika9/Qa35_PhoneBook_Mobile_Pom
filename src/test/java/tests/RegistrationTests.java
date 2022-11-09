package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationSuccess()  {

        int i = (int)(System.currentTimeMillis()/1000)%3600;

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



}
