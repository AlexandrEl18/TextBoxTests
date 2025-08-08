import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class githubTestContributors {
        @BeforeEach
        void setUp() {
            Configuration.browserSize = "1920x1080";
        }
        @Test
        void Test1() throws InterruptedException {
            open("https://github.com/selenide/selenide");
            $("div.BorderGrid--about-margin").$(byText("Contributors"));
            //$(byText("Contributors")) Находит первый элемент на странице, содержащий текст "Contributors".
            //.closest(".BorderGrid-cell")От найденного элемента (то есть от заголовка Contributors) поднимаемся вверх по DOM-дереву к ближайшему родительскому элементу, у которого есть класс BorderGrid-cell.Обычно это контейнер, в котором находится сам список участников.
            //.$$ ("ul li") Теперь, уже от блока .BorderGrid-cell, находим все элементы списка <li>, которые находятся внутри <ul>.Это и есть аватары или имена контрибьюторов GitHub.
            //.first() Берем первый элемент из найденного списка.
            //.hover() Наводим курсор (эмулируем наведение мыши) на этот элемент.
            $(byText("Contributors")).closest(".BorderGrid-cell").$$("ul li").first().hover();
            //.findBy(visible)Из всей коллекции выбирается первый элемент, который видим (visible — это предикат Condition.visible).То есть: «Найди первый div.Popover, который действительно отображается (не скрыт через CSS)».
            $$(".Popover").findBy(visible).shouldHave(text("Andrei Solntsev"));

            sleep(5000);
        }
    }