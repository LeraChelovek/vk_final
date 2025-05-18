package components;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;

public class CardOfGroup {
    private final SelenideElement cardOfGroup;
    public static final String cardGroupLocator= "[data-l='groupCard,POPULAR_GROUPS.popularTop']";
    private static final By recommendedGroupButton= By.xpath(".//*[text()='Подписаться']");
    public CardOfGroup(SelenideElement cardOfGroup) {
        this.cardOfGroup = cardOfGroup;
    }
    public void subscribe(){
        cardOfGroup.$(recommendedGroupButton).shouldBe(enabled.because("Кнопка для подписки не активна"), Duration.ofSeconds(20)).click();
    }
}
