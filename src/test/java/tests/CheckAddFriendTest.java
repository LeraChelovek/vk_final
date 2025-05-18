package tests;

import components.CardOfPerson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import pages.FeedPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static components.CardOfPerson.cardLocator;

public class CheckAddFriendTest extends FeedBaseTest{
   @Test
   @Tag("FeedTests")
   @DisplayName("Check add one recommended friend")
   @Timeout(30)
   public void checkAddFriendTest(){
      logIn();
      FeedPage feedPage = page(FeedPage.class);
      feedPage.clickFriendsLink();
      CardOfPerson friendCard = new CardOfPerson($(cardLocator).shouldBe(visible.because("Нет карточки первого рекомендованного друга"),Duration.ofSeconds(5)));
      String firstFriendName = friendCard.getName();
      friendCard.addToFriend();
      $(byText(firstFriendName)).closest(cardLocator).shouldNot(exist.because("Карточка добавленного друга не исчезла"), Duration.ofSeconds(7));
   }
}
