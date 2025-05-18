package components;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;

public class VKEcosystemElement {
    private final SelenideElement elementOfVKEcosystem;
    public VKEcosystemElement(SelenideElement elementOfVKEcosystem){
        this.elementOfVKEcosystem=elementOfVKEcosystem;
    }
    public void click(){
        elementOfVKEcosystem.shouldBe(visible.because("Проверка на видимость элемента тулбара Вк экосистемы"), Duration.ofSeconds(10)).click();
    }
}


