package functions;

import pages.ComposePage;

public class Compose {

    static private ComposePage composePage = new ComposePage();

    public static void enterEmailSubject(String strSubject){
        composePage.enterEmailSubject(strSubject);
    }

    public static void enterEmailBody(String strMessage){
        composePage.enterEmailBody(strMessage);
    }
}
