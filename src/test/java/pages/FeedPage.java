package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import components.VKEcosystemElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;


public class FeedPage extends LoadableComponent<FeedPage>{
    private final String partURLofProjectPage="ru/projects/";
    private final SelenideElement columnOfContent=$x("//*[@id='middleColumn']");
    private final SelenideElement comment=$x("//*[@aria-label='Комментарии']");
    private final SelenideElement sendComment=$x("//*[@uid='sendComment']");
    private final SelenideElement groupLink=$x("//*[text()='Группы']");
    private final SelenideElement recommendationsAdditionalColumn=$x("//*[@class='hookBlock']");
    private final SelenideElement feedLink=$x("//*[text()='Лента']");
    private final SelenideElement commentTextBox=$x("//*[@id='ok-e-d']");
    private final SelenideElement themeLocator=$x("//*[@data-module='ThemeSelector']");
    private final SelenideElement contentOfNote=$x("//*[@class='media-text_cnt']");
    private final SelenideElement publicButtonAfterInput =$x("//*[text()='Поделиться']");
    private final SelenideElement darkThemeLocator=$x("//*[text()='Тёмная']");
    private final SelenideElement textboxOfNote=$x("//*[@role='textbox']");
    private final SelenideElement publicationLink=$x("//*[text()='Опубликовать']");
    private final SelenideElement publicationNote=$x("//*[text()='Запись']");
    private final SelenideElement friendsLink=$x("//*[text()='Друзья']");
    private final SelenideElement toolbarVKEcosystem=$x("//*[@class='vk_ecosystem_toolbar h-mod']");
    private final SelenideElement settingsOfProfile=$x("//*[@aria-label='Настройки профиля']");
    private final SelenideElement moreLinkToolbarVKEcosystem=$x("//*[@class='vk-ecosystem-link __more']");
    private final SelenideElement searchLine = $x("//*[@placeholder='Искать на сайте']");
    private final SelenideElement musicLinkAfterSearch =$x("//*[@id='tab-music']");
    private final SelenideElement bestSearchMatch=$x("//*[contains(@class,'best-match-tracks')]");

    public VKEcosystemElement moreLinkinToolbarVKEcosystem() {
        return new VKEcosystemElement(moreLinkToolbarVKEcosystem);
    }
    @Override
    protected void isLoaded(){
        columnOfContent.should(Condition.exist.because("Нет колонны с контентом"));
        feedLink.should(Condition.exist.because("Нет ссылки на ленту"));
        recommendationsAdditionalColumn.should(Condition.exist.because("Нет колонки с рекомендациями"));
    }
    public FeedPage() {
        isLoaded();
    }
    public FeedPage clickDarkTheme(){
        darkThemeLocator.shouldBe(visible.because("Нет выбора темной темы"),Duration.ofSeconds(5)).shouldBe(clickable).click();
        return this;
    }
    public FeedPage clickSearchLine(){
        searchLine.shouldBe(visible.because(""),Duration.ofSeconds(5)).shouldBe(clickable).click();
        return this;
    }
    public FeedPage clickComment(){
        comment.shouldBe(visible.because("Нет возможности добавить комментарий"),Duration.ofSeconds(5)).shouldBe(clickable).click();
        return this;
    }
    public FeedPage clickSendComment(){
        sendComment.shouldBe(visible.because("Нет возможности отправить комментарий"),Duration.ofSeconds(5)).shouldBe(clickable).click();
        return this;
    }
    public FeedPage clickCommentTextBox(){
        commentTextBox.shouldBe(visible.because("Нет возможности написать комментарий"),Duration.ofSeconds(5)).shouldBe(clickable).click();
        return this;
    }
    public FeedPage clickMusicTab(){
        musicLinkAfterSearch.shouldBe(visible.because(""), Duration.ofSeconds(5)).shouldBe(clickable).click();
        return this;
    }
    public FeedPage clickToolbarVKEcosystem() {
        toolbarVKEcosystem.shouldBe(visible.because("Нет тулбара от VK"),Duration.ofSeconds(5)).shouldBe(clickable).click();
        return this;
    }
    public FeedPage clickTheme(){
        themeLocator.shouldBe(visible.because("Нет выбора смены Темы"),Duration.ofSeconds(5)).shouldBe(clickable).click();
        return this;
    }
    public FeedPage clickSettingsOfProfile(){
        settingsOfProfile.shouldBe(visible,Duration.ofSeconds(5)).shouldBe(clickable.because("Нет тулбара настроек профиля")).click();
        return this;
    }
    public FeedPage clickPublic(){
        publicationLink.shouldBe(visible,Duration.ofSeconds(5)).shouldBe(clickable.because("Не нажимается кнопка 'Опубликовать'")).click();
        return this;
    }
    public FeedPage clickPublicNote(){
        publicationNote.shouldBe(visible,Duration.ofSeconds(5)).shouldBe(clickable.because("Не нажимается ссылка 'Запись для публикации'")).click();
        return this;
    }
    public FeedPage clickTextBoxNote(){
        textboxOfNote.shouldBe(clickable.because("Не нажимается место для текста при создании публикации"),Duration.ofSeconds(5)).click();
        return this;
    }
    public String getTextOfMusicianBlock(){
        return bestSearchMatch.shouldBe(visible.because("Нет исполнителя, подходящего запросу"),Duration.ofSeconds(5)).getText().trim();
    }
    public FeedPage enterNoteText(String text){
        textboxOfNote.setValue(text);
        return this;
    }
    public FeedPage enterComment(String text){
        commentTextBox.setValue(text);
        return this;
    }
    public FeedPage enterInSearchLineText(String text){
        searchLine.setValue(text).pressEnter();
        return this;
    }
    public String getContentOfNote(){
        return contentOfNote.shouldBe(visible.because("Нет контента из записи публикации"), Duration.ofSeconds(10)).getText().trim();
    }
    public void clickFriendsLink(){
        friendsLink.shouldBe(visible, Duration.ofSeconds(10)).shouldBe(clickable).click();
    }
    public FeedPage clickGroupLink(){
        groupLink.shouldBe(visible.because("Нет ссылки на группы"), Duration.ofSeconds(10)).shouldBe(clickable).click();
        return this;
    }
    public void clickPublicAfterInput(){
        publicButtonAfterInput.shouldBe(visible, Duration.ofSeconds(10)).shouldBe(clickable.because("Нет кнопки 'Поделиться'")).click();
    }
    public void switchToNewTabAndVerifyUrl(){
        Wait().until(d -> webdriver().driver().getWebDriver().getWindowHandles().size() > 1);
        switchTo().window(1);
        webdriver().shouldHave(urlContaining(partURLofProjectPage), Duration.ofSeconds(30));
    }
}
