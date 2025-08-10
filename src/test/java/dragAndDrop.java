import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class dragAndDrop {
    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void Test() throws InterruptedException {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement a = $("#column-a");
        SelenideElement b = $("#column-b");
        String textA_before = a.getText();  // Сохраняем текст прямоугольника А ДО перемещения
        String textB_before = b.getText(); // Сохраняем текст прямоугольника B ДО перемещения
        Actions actions = new Actions(WebDriverRunner.getWebDriver()); // Создаём объект Actions для эмуляции действий мыши
        actions.clickAndHold(a) // Кликаем по элементу А и удерживаем левую кнопку мыши (начинаем drag)
                .moveToElement(b) // Перемещаем курсор мыши к элементу B (место куда будем дропать)
                .release() // Отпускаем кнопку мыши (завершаем drag-and-drop операцию)
                .perform(); // Выполняем всю цепочку действий
        a.shouldHave(text(textB_before)); // Проверяем, что текст прямоугольника А после перемещения стал текстом, который был у B
        b.shouldHave(text(textA_before)); // Проверяем, что текст прямоугольника B после перемещения стал текстом, который был у A
        sleep(5000);

    }
}