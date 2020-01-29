package factory;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

/**
 * @author amalyahayrapetova
 */

public class DriverFactory {

    private static AppiumDriver driver;
    private static ThreadLocal<AppiumDriver> driverThread = new ThreadLocal<>();

    private static AppiumDriverFactory get(String platform) {
        switch (platform) {
            case "android":
                return new AndroidDriverFactory();
            case "ios":
                return new IosDriverFactory();
        }

        //fixme add Fluent Wait

        return null;
    }

    public static AppiumDriver getDriver(String platform) throws MalformedURLException {
        if (driverThread.get() == null) {
            switch (platform) {
                case "android":
                    driver = get("android").getAppiumDriver();
                    break;
                case "ios":
                    driver = get("ios").getAppiumDriver();
                    break;
            }
            driverThread.set(driver);
        }
        return driverThread.get();
    }


    public static void quitDriver(AppiumDriver driver) {
        driver.quit();
        driverThread.remove();
    }


}
