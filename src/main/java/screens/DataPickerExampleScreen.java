package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataPickerExampleScreen extends BaseScreen{
    public DataPickerExampleScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    AndroidElement activityViewText;
    @FindBy(id = "com.sheygam.contactapp:id/dateTxt")
    AndroidElement dateTextView;
    @FindBy(id = "com.sheygam.contactapp:id/dateBtn")
    AndroidElement changeDateButton;
    @FindBy(id = "android:id/date_picker_header_date")
    AndroidElement headerDateView;   //// Sat, Dec 17
    @FindBy(id = "android:id/button1")
    AndroidElement okButton;

    @FindBy(xpath = "//*[@content-desc = '15 December 2022']")
    AndroidElement currentDate;  // 15 December 2022

    public DataPickerExampleScreen openCalendar(){
        shouldHave(activityViewText,"Date picker example",5);
        changeDateButton.click();
        return this;
    }
    public DataPickerExampleScreen selectData(String data){
        String locator = String.format("//*[@content-desc ='%s']",data);
        System.out.println(locator);
        driver.findElement(By.xpath(locator)).click();
        okButton.click();
       // currentDate.click();
        return this;
    }
    public DataPickerExampleScreen isDataChanges(String data){ //15 December 2022

        String currentData = dateTextView.getText(); //15/11/2022

        LocalDate dataTest = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH));
        System.out.println(dataTest);

        LocalDate dataEl = LocalDate.parse(currentData, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(dataEl);

        Assert.assertEquals(dataTest,dataEl);
        return this;
    }


}
