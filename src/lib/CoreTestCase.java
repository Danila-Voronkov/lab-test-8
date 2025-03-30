package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {
        public AppiumDriver driver;
        public static String AppiumURL = "http://localhost:4723";

    @Override
    protected void setUp() throws Exception{

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:appPackage", "org.wikipedia");
        capabilities.setCapability("appium:appActivity", ".main.MainActivity");
        capabilities.setCapability("appium:automationName", "UIAutomator2");
        //capabilities.setCapability("app", "C:\\Users\\user\\IdeaProjects\\project\\apks\\org.wikipedia.apk");
        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
    }
    @Override
    protected void tearDown() throws Exception{
        driver.quit();

    }
}
