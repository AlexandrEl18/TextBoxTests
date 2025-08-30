package pageObject;
import  pages.components.UserData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;
import pages.components.TestBase;
import static com.codeborne.selenide.logevents.SelenideLogger.step;


@Tag("start")
public class RegistrationWithPageObjectTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    UserData user = new UserData();
    @Test
    void fillFormTest() {
        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Fill form", () -> {
            registrationPage.setFirstName(user.firstName)
                    .setLastName(user.lastName)
                    .setLastEmail(user.email)
                    .setGender(user.gender)
                    .setNumber(user.number)
                    .setBirthDate(user.day, user.month, user.year)
                    .setSubject(user.subject)
                    .setHobbies(user.hobbies)
                    .setPicture(user.picture)
                    .setAddress(user.address)
                    .setState(user.state)
                    .setCity(user.city)
                    .setSubmit();
        });
        step("Verify results", () -> {
            registrationPage.verifyResultModalAppears()
                    .verifyResult("Student Name", user.firstName + " " + user.lastName)
                    .verifyResult("Student Email", user.email)
                    .verifyResult("Gender", user.gender)
                    .verifyResult("Mobile", user.number)
                    .verifyResult("Date of Birth", user.day + " " + user.month + "," + user.year)
                    .verifyResult("Subjects", user.subject)
                    .verifyResult("Hobbies", user.hobbies)
                    .verifyResult("Picture", "1.png")
                    .verifyResult("Address", user.address)
                    .verifyResult("State and City", user.state + " " + user.city);
        });
    }
}