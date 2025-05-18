package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import pages.FeedPage;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckSearchMusicianTest extends FeedBaseTest{
    private static final String text ="Ольга Бузова";
    @Test
    @Tag("FeedTests")
    @DisplayName("Check search musician by name")
    @Timeout(30)
    public void checkSearchMusician(){
        logIn();
        FeedPage feedPage = page(FeedPage.class);
        feedPage.clickSearchLine().enterInSearchLineText(text).clickMusicTab();
        String textOfMusicianBlock=feedPage.getTextOfMusicianBlock();
        assertTrue(textOfMusicianBlock.contains(text), "Текст '" + text + "' не найден в блоке музыканта");
    }
}
