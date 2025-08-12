package pageObject;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import java.io.File;
import static java.lang.Thread.sleep;


public class RegistrationWithPageObjectTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        Faker faker=new Faker();

        String userName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                number = faker.number().digits(10),
                address = faker.address().secondaryAddress(),
                gender = "Male",
                day = "10",
                month="May",
                year = "1991",
                subject = "Math",
                hobbies = "Sports",
                state = "NCR",
                city = "Delhi";
        File pictures = new File("/Users/aleksandrael/Downloads/IMG_1366.HEIC");

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setLastEmail(email)
                .setGender(gender)
                .setNumber(number)
                .setBirthDate(day,month,year)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setPicture(pictures)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .setSubmit();
        ;
        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", number)
                .verifyResult("Date of Birth", "10 May,1991")
                .verifyResult("Subjects", "Math")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "IMG_1366.HEIC")
                .verifyResult("Address", address)
                .verifyResult("State and City", "NCR Delhi");


        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
