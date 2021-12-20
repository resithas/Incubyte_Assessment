package functions;

import pages.HomePage;

public class Home {

    static private HomePage homePage = new HomePage();

    public static void startMailCompose(){
        homePage.startMailCompose();
    }

    public static boolean isInboxDisplayed(){
     return homePage.isInboxDisplayed();
    }

    public static boolean isComposeWindowDisplayed(){
        return homePage.isComposeWindowDisplayed();
    }
}
