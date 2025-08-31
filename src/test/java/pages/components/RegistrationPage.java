package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent CalendarComponent = new CalendarComponent();
    RegistrationResultModal RegistratioResultModal = new RegistrationResultModal();

    private SelenideElement firsrtNameImput = $("#firstName"),
            lastNameImput = $("#lastName"),
            emailImput = $("#userEmail"),
            genderImput = $("#genterWrapper"),
            numberImput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitInput = $("#submit");


        @Step("Открываем страницу формы регистрации")
        public RegistrationPage openPage() {
            open("https://demoqa.com/automation-practice-form");
            return this;
        }

        @Step("Вводим имя: {value}")
        public RegistrationPage setFirstName(String value) {
            firsrtNameImput.setValue(value);
            return this;
        }

        @Step("Вводим фамилию: {value}")
        public RegistrationPage setLastName(String value) {
            lastNameImput.setValue(value);
            return this;
        }

        @Step("Вводим email: {value}")
        public RegistrationPage setLastEmail(String value) {
            emailImput.setValue(value);
            return this;
        }

        @Step("Выбираем пол: {value}")
        public RegistrationPage setGender(String value) {
            genderImput.$(byText(value)).click();
            return this;
        }

        @Step("Вводим номер телефона: {value}")
        public RegistrationPage setNumber(String value) {
            numberImput.setValue(value);
            return this;
        }

        @Step("Устанавливаем дату рождения: {day}-{month}-{year}")
        public RegistrationPage setBirthDate(String day, String month, String year) {
            $("#dateOfBirthInput").click();
            CalendarComponent.setDate(day, month, year);
            return this;
        }

        @Step("Вводим предмет: {value}")
        public RegistrationPage setSubject(String value) {
            subjectInput.setValue(value).pressEnter();
            return this;
        }

        @Step("Выбираем хобби: {value}")
        public RegistrationPage setHobbies(String value) {
            hobbiesInput.$(byText(value)).click();
            return this;
        }

        @Step("Загружаем картинку: {file}")
        public RegistrationPage setPicture(File file) {
            pictureInput.uploadFile(file);
            return this;
        }

        @Step("Вводим адрес: {value}")
        public RegistrationPage setAddress(String value) {
            addressInput.setValue(value);
            return this;
        }

        @Step("Выбираем штат: {value}")
        public RegistrationPage setState(String value) {
            stateInput.scrollTo().click();
            $(byText(value)).click();
            return this;
        }

        @Step("Выбираем город: {value}")
        public RegistrationPage setCity(String value) {
            cityInput.click();
            $(byText(value)).click();
            return this;
        }

        @Step("Подтверждаем форму")
        public RegistrationPage setSubmit() {
            submitInput.click();
            return this;
        }

        @Step("Проверяем, что модальное окно с результатами появилось")
        public RegistrationPage verifyResultModalAppears() {
            RegistratioResultModal.verifyModalAppears();
            return this;
        }

        @Step("Проверяем результат: {key} = {value}")
        public RegistrationPage verifyResult(String key, String value) {
            RegistratioResultModal.verifyResult(key, value);
            return this;
        }
    }
