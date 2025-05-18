package tests;


import pages.LoginPage;

public class FeedBaseTest extends LoginBaseTest {
    public void logIn(){
        LoginPage loginPage=new LoginPage();
        loginPage.enterPhone("technopol43");
        loginPage.enterPassword("technopolisPassword").clickLoginButton();
    }
}
