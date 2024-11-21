import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {
    @Test
    void successfulSearchTest() {
        Configuration.pageLoadStrategy = "eager";
        open("https://www.google.ru/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("http://ru.selenide.org"));
    }

    @Test
    void successfulYaSearchTest() {
        open("https://ya.ru/");
        $("[name=text]").setValue("selenide").pressEnter();
        $("[id=search-result]").shouldHave(text("ru.selenide.org"));
    }

    @Test
    void successfulYaSearchTest() {
        open("ya.ru");
        $("[name=text]").setValue("VK").pressEnter();
        $("[id=search-result]").shouldHave(text("vk.ru"));
    }

}
