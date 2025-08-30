package pages.components;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import static com.codeborne.selenide.Selenide.sessionId;
import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attach {

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshots(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachText(String attachName, String message) {
        return message;
    }

    public static void browserConsoleLogs() {
        attachText("Browser console logs", String.join("\n", getWebDriverLogs(BROWSER)));
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        URL videoUrl = getVideoUrl();
        if (videoUrl == null) {
            return "<html><body><p>Видео недоступно</p></body></html>";
        }
        return "<html><body><video width='100%' height='100%' controls autoplay>" +
                "<source src='" + videoUrl.toString() + "' type='video/mp4'>" +
                "Ваш браузер не поддерживает видео." +
                "</video></body></html>";
    }

    public static void attachVideoFile() {
        String videoUrl = "https://selenoid.autotests.cloud/video/" + sessionId() + ".mp4";
        try (InputStream is = new URL(videoUrl).openStream()) {
            Allure.addAttachment("Видео", "video/mp4", is, "mp4");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static URL getVideoUrl() {
        String videoUrl = "https://selenoid.autotests.cloud/video/" + sessionId() + ".mp4";
        System.out.println(sessionId());
        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
