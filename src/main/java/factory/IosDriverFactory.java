package factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

/**
 * @author amalyahayrapetova
 */
public class IosDriverFactory extends AppiumDriverFactory {


    @Override
    public DesiredCapabilities createAppiumObject() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.UDID,  System.getProperty("udid"));
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 220);
        return capabilities;
    }

    @Override
    public AppiumDriver getAppiumDriver() throws MalformedURLException {
        return new IOSDriver<MobileElement>(AppiumServerHelper.appiumUrl, createAppiumObject());
    }
}
