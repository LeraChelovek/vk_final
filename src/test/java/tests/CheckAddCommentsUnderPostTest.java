package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import pages.FeedPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckAddCommentsUnderPostTest extends FeedBaseTest{
    private static final String comment ="Тестовый комментарий";
    @Test
    @Tag("FeedTests")
    @Timeout(30)
    @DisplayName("Check adding comments under post")
    public void checkAddCommentPost(){
        logIn();
        FeedPage feedPage = page(FeedPage.class);
        feedPage.clickComment().clickCommentTextBox().enterComment(comment).clickSendComment();
        $(byText(comment)).shouldBe(visible.because("Комментарий не отобразился"), Duration.ofSeconds(7)).shouldHave(exactText(comment));
    }
}
