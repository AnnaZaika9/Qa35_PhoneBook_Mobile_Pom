package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;


public class LoginTests extends AppiumConfig {

    @Test
    public void loginSuccess(){
//       boolean res = new SplashScreen(driver)
//                .checkVersion("1.0.0")   //AuthenticationScreen
        boolean res =  new AuthenticationScreen(driver)
                .fillEmail("dasha@ukr.net")  //AuthenticationScreen
                .fillPassword("Ddasha$123456")   //AuthenticationScreen
                .submitLogin()  //ContactListScreen
                .isContactListActivityPresent();
        Assert.assertTrue(res);

    }
    @Test
    public void loginSuccessModel(){
//        boolean res =new SplashScreen(driver)
//                .checkVersion("1.0.0")
        boolean res =  new AuthenticationScreen(driver)
                .login(Auth.builder().email("masha@gmail.com").password("123589$Masha").build())
                .isContactListActivityPresent();
        Assert.assertTrue(res);

    }

    @AfterMethod
    public void logoutFromSys(){
        new ContactListScreen(driver)
                .logout();
    }

}
