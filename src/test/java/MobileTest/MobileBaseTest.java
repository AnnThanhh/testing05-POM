package MobileTest;

import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.Capabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class MobileBaseTest {
    public AndroidDriver driver;

    @BeforeTest
    public void setUp() {
        Capabilities options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:deviceName", "emulator-5554")
                .amend("appium:platformVersion", "16")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:appPackage", "vn.tiki.app.tikiandroid")
                .amend("appium:appActivity", "vn.tiki.android.shopping.homeV3.HomeActivity")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(this.getUrl(), options);
    }

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
