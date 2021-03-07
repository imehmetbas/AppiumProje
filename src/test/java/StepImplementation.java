import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.appium.java_client.MobileElement;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseTest{

    @Step("PopUp kapatıldı.")
    public void clickPopUp(){
        MobileElement elementOne = (MobileElement) appiumDriver.findElementById("com.dmall.mfandroid:id/closeBtn");
        elementOne.click();
    }
    @Step("Gizlilik kabul edildi.")
    public void clickOk(){
        MobileElement elementOne = (MobileElement) appiumDriver.findElementById("com.dmall.mfandroid:id/agreementStatusDialogCloseBtn");
        elementOne.click();
    }
    @Step("Arama alanına gidildi.")
    public void clickSearch(){
        MobileElement elementOne = (MobileElement) appiumDriver.findElementById("com.dmall.mfandroid:id/mainHeaderSearchArea");
        elementOne.click();
    }

    @Step("Arama alanına <key> yazıldı.")
    public void searchBox(String key){
        MobileElement elementTwo = (MobileElement) appiumDriver.findElementById("com.dmall.mfandroid:id/clearable_edit");
        elementTwo.sendKeys(key);
    }
}
