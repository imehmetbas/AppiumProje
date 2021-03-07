import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static org.apache.logging.log4j.core.Logger logger = (org.apache.logging.log4j.core.Logger) LogManager.getLogger(BaseTest.class);
    protected static AppiumDriver appiumDriver;

    @BeforeScenario
    public void beforeScenario() throws MalformedURLException {
        logger.info("Android platformu seçildi. Android üzerinde proje kaldırılıyor.");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.dmall.mfandroid");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.dmall.mfandroid.activity.base.Splash");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 250);
//
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        appiumDriver = new AndroidDriver(url, capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        logger.info("Android üzerinde proje kaldırıldı");
    }

    @AfterScenario
    public void afterScenario() {

        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }
}