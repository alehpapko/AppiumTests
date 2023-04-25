package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


@ParametersAreNonnullByDefault
public class CameraAppiumDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAvd("Pixel_3a_API_33_x86_64");
        // adb shell + dumpsys window displays | grep -E CurrentFocus
        options.setAppPackage("com.android.camera2");
        options.setAppActivity("com.android.camera.CameraLauncher");
        options.setFullReset(false);
        options.setNewCommandTimeout(Duration.ofSeconds(7));
        options.setAvdLaunchTimeout(Duration.ofSeconds(30));

        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
