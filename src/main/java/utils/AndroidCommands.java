package utils;

import com.google.common.collect.ImmutableMap;
import factory.DriverFactory;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author amalyahayrapetova
 */

public class AndroidCommands {

    private static AndroidDriver driver;

    public AndroidCommands() throws MalformedURLException {
        driver = (AndroidDriver) DriverFactory.getDriver(System.getProperty("android"));
    }


    /**
     * Get device ud id
     */

    public String getUdId() {
        List<String> lsArgs = Arrays.asList("devices -l");
        Map<String, Object> lsCmd = ImmutableMap.of(
                "command", "adb",
                "args", lsArgs
        );
        String lsOutput = ((String) driver.executeScript("mobile: shell", lsCmd)).split("")[0];
        return lsOutput;
    }

}
