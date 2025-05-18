package tests;

import components.CardOfGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import pages.FeedPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static components.CardOfGroup.cardGroupLocator;


public class CheckSubscribeOnGroupTest extends FeedBaseTest{
    @Test
    @Tag("FeedTests")
    @DisplayName("Check subscribe on group")
    @Timeout(40)
    public void checkSubscribeOnGroup(){
        logIn();
        FeedPage feedPage = page(FeedPage.class);
        feedPage.clickGroupLink();
        CardOfGroup groupCard = new CardOfGroup($(cardGroupLocator).shouldBe(visible.because("Нет карточки первой рекомендованной группы"), Duration.ofSeconds(20)));
        groupCard.subscribe();
        $$(cardGroupLocator).first().find(byText("Перейти")).shouldBe(visible.because("Не произошло изменеия с 'Подписаться' на 'Перейти'"),Duration.ofSeconds(5));
    }
}
