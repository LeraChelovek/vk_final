package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import io.github.bonigarcia.wdm.WebDriverManager;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class LoginBaseTest {
    protected static final String OK_URL = "https://ok.ru/";
    @BeforeEach
    @Timeout(20)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        open("https://ok.ru/");
    }
    @AfterEach
    @Timeout(20)
    public void close(){
        closeWebDriver();
    }
}
