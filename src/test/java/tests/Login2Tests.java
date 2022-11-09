package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;


public class Login2Tests extends AppiumConfig {

    @Test
    public void loginSuccess()  {

        new AuthenticationScreen(driver)
                .fillEmail("dasha@ukr.net") //AuthenticationScreen
                .fillPassword("Ddasha$123456")  //AuthenticationScreen
                .submitLogin()//ContactListScreen
                .assertContactListActivityPresent()
                .logout();

    }
    @Test
    public void loginSuccessModel(){
        new AuthenticationScreen(driver)
                .login(Auth.builder().email("masha@gmail.com").password("123589$Masha").build())
                .assertContactListActivityPresent()
                .logout();

    }
}