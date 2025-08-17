package MobileTest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

public class DemoTest extends MobileBaseTest{
    @Test
    public void DemoTest(){
        WebElement el1 = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
        el1.click();

        var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(512, 2327);
        var end = new Point (546, 774);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));


        finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        start = new Point(655, 2265);
        end = new Point (688, 873);
        swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

        WebElement el2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sữa bột NAN INFINIPRO A2 3 với công thức đầu tiên chứa đạm A2, 6HMO & Lợi khuẩn kép nhập khẩu Thụy Sĩ - Hộp 800g (2 - 6 tuổi)\")"));
        el2.click();

    }
}
