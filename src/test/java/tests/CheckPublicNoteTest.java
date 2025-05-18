package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import pages.FeedPage;
import static org.junit.jupiter.api.Assertions.*;
import static com.codeborne.selenide.Selenide.page;

public class CheckPublicNoteTest extends FeedBaseTest{
    private static final String noteText ="Не пугайтесь, тут просто тренируются в тестировании), простите за беспокойство";
    @Test
    @Tag("FeedTests")
    @DisplayName("Check public note")
    @Timeout(30)
    public void checkPublicNoteTest(){
        logIn();
        FeedPage feedPage = page(FeedPage.class);
        feedPage.clickPublic().clickPublicNote().clickTextBoxNote().enterNoteText(noteText).clickPublicAfterInput();

        String contentOfNote = feedPage.getContentOfNote();
        assertEquals(noteText,contentOfNote,"Тексты не одинаковы");
    }
}
