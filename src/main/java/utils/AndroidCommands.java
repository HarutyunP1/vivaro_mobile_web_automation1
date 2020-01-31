package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author amalyahayrapetova
 *
 */


/**
 * ABD Shell Commands
 * adb shell input keyevent 3 // Home btn
 * adb shell input keyevent 4 // Back btn
 * adb shell input keyevent 5 // Call
 * adb shell input keyevent 6 // End call
 * adb shell input keyevent 26  // Turn Android device ON and OFF. It will toggle device to on/off status.
 * adb shell input keyevent 27 // Camera
 * adb shell input keyevent 64 // Open browser
 * adb shell input keyevent 66 // Enter
 * adb shell input keyevent 67 // Delete (backspace)
 * adb shell input keyevent 207 // Contacts
 * adb shell input keyevent 220 / 221 // Brightness down/up
 * adb shell input keyevent 277 / 278 /279 // Cut/Copy/Paste
 */

public class AndroidCommands {

    private AndroidDriver driver;

    public AndroidCommands(WebDriver driver) throws MalformedURLException {
        this.driver = (AndroidDriver) driver;
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


    /**
     * Adb command KeyEvents
     */
    public String shellKeyEvents(int key) {
        List<String> commandArgs = Arrays.asList("input keyevent " + key);
        Map<String, Object> command = ImmutableMap.of(
                "command", "adb",
                "args", commandArgs
        );
        return ((String) driver.executeScript("mobile: shell", command));

    }

}
