package tests;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import pages.FeedPage;

public class CheckThemeTest extends FeedBaseTest{
    @Test
    @Tag("FeedTests")
    @Timeout(30)
    @DisplayName("Check theme of window")
    public void checkTheme(){
        logIn();
        FeedPage feedPage = page(FeedPage.class);
        feedPage.clickSettingsOfProfile().clickTheme().clickDarkTheme().clickSettingsOfProfile();
        String htmlClasses = $("html").attr("class");
        assertThat(htmlClasses.split(" ")).as("Проверка темы оформления").anyMatch(cls -> cls.equals("__ui-theme_dark"));
    }
}
