import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class githubTestSolutions {
    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void Test() throws InterruptedException {
        open("https://github.com");
        $(byText("Solutions")).hover();
        SelenideElement element = $(byText("By company size"));
        element.shouldBe(visible);

sleep(6000);
    }
}