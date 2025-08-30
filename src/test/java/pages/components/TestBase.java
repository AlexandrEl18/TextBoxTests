package pages.components;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.selenide.AllureSelenide;

public class TestBase {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browser="chrome";
        Configuration.browserVersion="128.0";
        Configuration.browserSize="1920x1080";
        Configuration.remote="https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
    @BeforeEach
    void adListener(){
        SelenideLogger.addListener("allure",new AllureSelenide());
    }
    @AfterEach
    void AddAttachments(){
        Attach.screenshots("Last screenshots");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}