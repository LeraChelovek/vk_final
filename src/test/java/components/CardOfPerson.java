package components;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public class CardOfPerson {
    public static final String cardLocator= ".uslider_i";
    private static final By recommendedFriendButton= By.xpath(".//*[text()='Добавить в друзья']");
    private final By nameLocator=By.xpath(".//*[@class='entity-item_info']");
    private final SelenideElement cardOfRecommendedFriend;
    public CardOfPerson(SelenideElement cardOfRecommendedFriend) {
        this.cardOfRecommendedFriend = cardOfRecommendedFriend;
    }
    public String getName() {
        return cardOfRecommendedFriend.$(nameLocator).shouldBe(visible.because("Не видно имени друга"), Duration.ofSeconds(6)).getText().trim();
    }
    public void addToFriend(){
        cardOfRecommendedFriend.$(recommendedFriendButton).shouldBe(enabled.because("Кнопка для добавления друга не активна"), Duration.ofSeconds(20)).click();
    }
}
