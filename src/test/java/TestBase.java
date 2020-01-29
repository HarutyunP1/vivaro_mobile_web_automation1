import factory.AppiumServerHelper;
import factory.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;

/**
 * @author amalyahayrapetova
 */
public class TestBase {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() {
        AppiumServerHelper.startServer();
    }

    @BeforeMethod
    public void setUpMethod() throws MalformedURLException {
        driver = DriverFactory.getDriver(System.getProperty("platform"));
    }

    @AfterMethod
    public void tearDownMethod() throws MalformedURLException {
        DriverFactory.quitDriver(DriverFactory.getDriver(System.getProperty("platform")));
    }

    @AfterTest
    public void tearDownTest() {
        AppiumServerHelper.stopServer();
    }


}
