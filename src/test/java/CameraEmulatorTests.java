import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import drivers.CameraAppiumDriver;

import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.launchApp;


public class CameraEmulatorTests {
    SelenideAppiumElement nextButton = $(AppiumBy.id("com.android.camera2:id/confirm_button"));
    SelenideAppiumElement dontAllowButton = $(AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button"));
    SelenideAppiumElement cameraShatterButton = $(AppiumBy.id("com.android.camera2:id/shutter_button"));
    SelenideAppiumElement openGalleryIcon = $(AppiumBy.id("com.android.camera2:id/rounded_thumbnail_view"));
    SelenideAppiumElement deletePhotoButton = $(AppiumBy.id("com.android.camera2:id/filmstrip_bottom_control_delete"));

    @BeforeAll
    public static void startup() {
        Configuration.browser = CameraAppiumDriver.class.getName();
        launchApp();
    }

    @Test
    public void testCamera() {
        nextButton.click(tap());
        dontAllowButton.click(tap());
        cameraShatterButton.click(tap());
        openGalleryIcon.click(tap());
        deletePhotoButton.click(tap());

        cameraShatterButton.shouldBe(Condition.visible);
    }
}
