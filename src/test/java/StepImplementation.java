
import com.thoughtworks.gauge.Step;
import hepsiburada.helper.ElementHelper;
import hepsiburada.helper.StoreHelper;
import hepsiburada.model.ElementInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class StepImplementation extends BaseTest{


    @Step("<key> key' li elemente tikla")
    public void clickPopUp(String key) throws InterruptedException {
        Thread.sleep(5000);
        ElementInfo elmntInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By by = ElementHelper.getElementInfoToBy(elmntInfo);
        appiumDriver.findElement(by).click();
    }

    @Step("<key> key'li elementin oldugu kontrol edilir")
    public void checkElement(String key){
        ElementInfo elmntInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By by = ElementHelper.getElementInfoToBy(elmntInfo);
        Assert.assertTrue( "Element bulunamadi",appiumDriver.findElement(by).isDisplayed());
    }

    @Step("<key> key'li elemente <text> text degerini gonder")
    public void sendKeys(String key,String text){
        ElementInfo elmntInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By by = ElementHelper.getElementInfoToBy(elmntInfo);
        appiumDriver.findElement(by).sendKeys(text);
    }

    @Step("<second> saniye bekle")
    public void waitForsecond(int second) throws InterruptedException {
        Thread.sleep(1000*second);
    }
    @Step("<key> key'li element varsa tikla")
    public void clickAcceptbutton(String key) throws InterruptedException {
        ElementInfo elmntInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By by = ElementHelper.getElementInfoToBy(elmntInfo);

        if (appiumDriver.findElement(by).isDisplayed()){
            appiumDriver.findElement(by).click();
            waitForsecond(1);
        }else {
            System.out.println("Pop-up gelmedi");
        }
    }

}
