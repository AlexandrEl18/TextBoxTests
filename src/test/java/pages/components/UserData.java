package pages.components;

import com.github.javafaker.Faker;
import java.io.File;

public class UserData {
    Faker faker = new Faker();

    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final String email = faker.internet().emailAddress();
    public final String number = faker.number().digits(10);
    public final String address = faker.address().secondaryAddress();
    public final String gender = "Male";
    public final String day = "10";
    public final String month = "May";
    public final String year = "1991";
    public final String subject = "Math";
    public final String hobbies = "Sports";
    public final String state = "NCR";
    public final String city = "Delhi";
    public final File picture = new File("src/test/resources/1.png");
}