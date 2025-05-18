package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import pages.FeedPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class CheckToolBarVKEcosystemTest extends FeedBaseTest{
    @Test
    @Tag("FeedTests")
    @Timeout(60)
    @DisplayName("Check the toolbar has correct href for More")
    public void testMoreElement(){
        logIn();
        FeedPage feedPageCheckVKEcosystem = page(FeedPage.class);
        feedPageCheckVKEcosystem.clickToolbarVKEcosystem().moreLinkinToolbarVKEcosystem().click();
        feedPageCheckVKEcosystem.switchToNewTabAndVerifyUrl();
    }
}
