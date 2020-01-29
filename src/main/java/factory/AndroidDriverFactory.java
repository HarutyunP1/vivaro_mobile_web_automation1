package factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.AndroidCommands;

import java.util.concurrent.TimeUnit;

/**
 * @author amalyahayrapetova
 */
public class AndroidDriverFactory extends AppiumDriverFactory {

    private AppiumDriver driver;

    @Override
    public DesiredCapabilities createAppiumObject()  {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.UDID, System.getProperty("udid"));
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 220);
        capabilities.setCapability("deviceReadyTimeout", 5);
        capabilities.setCapability("ignoreUnimportantViews", true);
        capabilities.setCapability("disableAndroidWatchers", true);
        capabilities.setCapability("autoGrantPermissions", true);
        return capabilities;
    }

    @Override
    public AppiumDriver getAppiumDriver() {
        driver = new AndroidDriver<MobileElement>(AppiumServerHelper.appiumUrl, createAppiumObject());
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        return driver;
    }



}
