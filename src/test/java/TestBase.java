import factory.AppiumServerHelper;
import factory.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

/**
 * @author amalyahayrapetova
 */
public class TestBase {

    AppiumDriver driver;

    @BeforeSuite
    public void setUp() {
        AppiumServerHelper.startServer();
    }

    @BeforeClass
    public void setUpMethod() throws MalformedURLException {
        driver = DriverFactory.getDriver(System.getProperty("platform"));
    }

    @AfterClass
    public void tearDownMethod() throws MalformedURLException {
        DriverFactory.quitDriver(DriverFactory.getDriver(System.getProperty("platform")));
    }

    @AfterSuite
    public void tearDownTest() {
        AppiumServerHelper.stopServer();
    }


}
