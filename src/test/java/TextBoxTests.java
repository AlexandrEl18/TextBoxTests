import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextBoxTests {
    @BeforeEach
    void setUp() {
        System.setProperty("selenide.holdBrowserOpen", "true");
    }
    @Test
    void fillFormTest(){
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Alexey Petrov");

        $("[id=userEmail]").setValue("Alexey@mail.ru");

        $("[id=currentAddress]").setValue("Адрес: ул. Ленина, д. 42, кв. 17\n" +
                "Город: Новосибирск\n" +
                "Область: Новосибирская область\n" +
                "Индекс: 630099\n" +
                "Страна: Россия\n");

        $("[id=permanentAddress]").setValue("Улица: ул. Ленина, д. 42, кв. 17\n" +
                "Город: Новосибирск\n" +
                "Область: Новосибирская область\n" +
                "Почтовый индекс: 630099\n" +
                "Страна: Россия\n");

        $("[id=submit]").scrollIntoView(true).click();

        String outputText = $("[id=output]").getText();

        assertTrue(outputText.contains("Name:Alexey Petrov"));
        assertTrue(outputText.contains("Email:Alexey@mail.ru"));
        assertTrue(outputText.contains("Current Address :Адрес: ул. Ленина, д. 42, кв. 17"));
        assertTrue(outputText.contains("Город: Новосибирск"));
        assertTrue(outputText.contains("Область: Новосибирская область"));
        assertTrue(outputText.contains("Индекс: 630099"));
        assertTrue(outputText.contains("Страна: Россия"));
        assertTrue(outputText.contains("Permananet Address :Улица: ул. Ленина, д. 42, кв. 17"));

    }



}
