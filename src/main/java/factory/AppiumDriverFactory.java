package factory;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Utils;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @author amalyahayrapetova
 */
public abstract class AppiumDriverFactory {


    abstract DesiredCapabilities createAppiumObject();

    abstract AppiumDriver getAppiumDriver() throws MalformedURLException;
}
