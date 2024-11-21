import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverConditions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {
    @Test
    void successfulSearchTestGoogle_textGoogle() {
        Configuration.pageLoadStrategy = "eager";
        open("https://www.google.ru/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://ru.selenide.org"));
    }

    @Test
    void successfulYaSearchTestGoogle_textGoogle() {
        open("https://ya.ru/");
        $("[name=text]").setValue("selenide").pressEnter();
        $("[id=search-result]").shouldHave(text("ru.selenide.org"));
    }

    @Test
    void successfulYaSearchTest_textVK() {
        open("https://ya.ru/");
        $("[name=text]").setValue("VK").pressEnter();
        $("[id=search-result]").shouldHave(text("vk.ru"));
    }

}
