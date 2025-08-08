import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;


public class githubTest {
    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void Test1()throws InterruptedException {
        open("https://github.com/");
        $("[placeholder='Search or jump to...']").click();
        //после клика вылазит дополнительное окно
        $("#query-builder-test").setValue("selenide").pressEnter();
        //<a class="prc-Link-Link-85e08" href="/selenide/selenide"><span
        $("a[href='/selenide/selenide']").click();
        //<a class="url fn" rel="author" data-hovercard-type="organization" data-hovercard-url="/orgs/selenide/hovercard" data-octo-click="hovercard-link-click" data-octo-dimensions="link_type:self" href="/selenide" aria-keyshortcuts="Alt+ArrowUp">
        $("a[href='/selenide']").shouldHave(Condition.text("selenide"));

        sleep(5000);// не забдь после удаления убрать у метода throws InterruptedException



    }
}