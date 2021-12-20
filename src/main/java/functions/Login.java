package functions;

import pages.LoginPage;

public class Login {

    static private LoginPage loginPage = new LoginPage();

    public static void quitDriver(){
        loginPage.quitDriver();
    }

    public static void loadLoginPage(String siteURL){
        loginPage.loadLoginPage(siteURL);
    }

    public static void loginToMail(String strUserName, String strPassword){
        loginPage.loginToMail(strUserName, strPassword);
    }
}
