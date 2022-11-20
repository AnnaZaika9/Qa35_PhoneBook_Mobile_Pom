package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

public class DatePickerTests extends AppiumConfig {
    @BeforeClass
    public void precondition(){
        new AuthenticationScreen(driver)
                .login(Auth.builder().email("dasha@ukr.net").password("Ddasha$123456").build());
    }
    @Test
    public void selectDataCurrentMouth(){
        new ContactListScreen(driver)
                .openDatePickerScreen()
                .openCalendar()
                .selectData("15 December 2022")
               .isDataChanges("15 December 2022");
    }

    @AfterClass
    public void postCondition(){
        new ContactListScreen(driver)
                .logout4();
    }

}
