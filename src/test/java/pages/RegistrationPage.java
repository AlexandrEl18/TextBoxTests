package pages;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistratioResultModal;
import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent CalendarComponent = new CalendarComponent();
    RegistratioResultModal RegistratioResultModal = new RegistratioResultModal();

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

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firsrtNameImput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameImput.setValue(value);
        return this;
    }

    public RegistrationPage setLastEmail(String value) {
        emailImput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderImput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setNumber(String value) {
        numberImput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        CalendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(File file) {
        pictureInput.uploadFile(file);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.scrollTo().click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage setSubmit() {
       submitInput.click();
        return this;
    }

    public RegistrationPage verifyResultModalAppears() {
        RegistratioResultModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key,String value) {
        RegistratioResultModal.verifyResult(key,value);
        return this;
    }
}