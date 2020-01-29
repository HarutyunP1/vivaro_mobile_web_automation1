package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author amalyahayrapetova
 */

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {


    AppiumDriver driver;
    WebDriverWait webDriverWait;
    TouchAction touchAction;


    /**
     * Constructor
     * @param driver
     */
    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        try {
            this.driver = driver;
        } catch (Exception ignored) {

        }
        this.webDriverWait = new WebDriverWait(driver, 5, 250);
        this.touchAction = new TouchAction(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

    /**
     * Open url
     * @param url
     */
    abstract void openUrl(String url);

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

}
