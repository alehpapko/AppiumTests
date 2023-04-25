import com.codeborne.selenide.Configuration;
import drivers.WebAppiumDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class WebTests {
    @BeforeAll
    public static void setup() {
        Configuration.browser = WebAppiumDriver.class.getName();
        open("https://onliner.by/");
    }

    @Test
    public void test() {
        $("div[id=\"widget-1-1\"]").click();
        sleep(7500);
    }
}
