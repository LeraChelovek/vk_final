package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends LoadableComponent<LoginPage>{
        private final SelenideElement phoneField = $x("//*[@id='field_email']");
        private final SelenideElement passwordField=$x("//*[@id='field_password']");
        private final SelenideElement loginButton =$x("//*[contains(@value, 'Войти')]");
        private final SelenideElement filterForMainBody=$x("//*[@class='tab-filter-with-body']");
        private final SelenideElement footerLinks=$x("//*[@class='ff_links']");
        private final SelenideElement footerHrefAboutRecommendedTechnologies=$x("//*[@class='ff_rtterms']");

        @Override
        protected void isLoaded() throws Error{
            filterForMainBody.shouldBe(visible.because("Нет окна с полями для регистрации, отсутсвует в обновленном интерфейсе"));
            footerLinks.shouldBe(visible.because("Нет футера"));
            footerHrefAboutRecommendedTechnologies.shouldBe(enabled.because("Нет ссылок в футере"));
        }
        public LoginPage() {
        isLoaded();
    }
        public pages.LoginPage enterPhone(String phone) {
            phoneField.setValue(phone);
            return this;
        }
        public pages.LoginPage enterPassword(String password){
            passwordField.setValue(password);
            return this;
        }
        public void clickLoginButton() {
            loginButton.shouldBe(visible.because("Нет кнопки 'Войти'")).click();
        }
    }