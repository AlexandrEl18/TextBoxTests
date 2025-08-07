
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {

    @BeforeEach
    void setUp() {
        System.setProperty("selenide.holdBrowserOpen", "true");
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Алексей");
        $("[id=lastName]").setValue("Бобров");
        $("[id=userEmail]").setValue("Bobrow@mail.ru");
        $(byText("Male")).click();
        $("[id=userNumber]").setValue("9995556677");

        // Клик по полю (открыть календарь)
        $("[id=dateOfBirthInput]").click();
        // Выбрать месяц
        $("[class=react-datepicker__month-select]").selectOption("May");
        // Выбрать год
        $("[class=react-datepicker__year-select]").selectOption("1999");
        // Клик по дню
        $(".react-datepicker__day--010").click();
        $("[id=subjectsInput]").setValue("Math").pressEnter();
        $(byText("Sports")).click();

        //загрузка фото
        $("[id=uploadPicture]").uploadFile(new File("/Users/aleksandrael/Downloads/IMG_1366.HEIC"));
        $("[id=currentAddress]").setValue("123 Maple St, Springfield, IL 62704");
// Скролл к этому лементу и клик
        $("[id=state]").scrollTo().click();
        $(byText("NCR")).click();

        $("[id=city]").click();
        $(byText("Delhi")).click();

        $("[id=submit]").click();

        $(".table").shouldHave(
                text("Student Name"),
                text("Алексей Бобров"),
                text("Student Email"),
                text("Bobrow@mail.ru"),
                text("Gender"),
                text("Male"),
                text("Mobile"),
                text("9995556677"),
                text("Date of Birth"),
                text("10 May,1999"),
                text("Subjects"),
                text("Math"),
                text("Hobbies"),
                text("Sports"),
                text("Picture"),
                text("IMG_1366.HEIC"),
                text("Address"),
                text("123 Maple St, Springfield, IL 62704"),
                text("State and City"),
                text("NCR Delhi")
        );
    }
}
