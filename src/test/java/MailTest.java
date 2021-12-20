import common.Constants;
import data.ExcelKeyData;
import data.LoginData;
import functions.Compose;
import functions.Home;
import functions.Login;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.ExcelUtil;


public class MailTest {


    @AfterMethod
    public void quitBrowser(){
        Login.quitDriver();
    }

    @Test
    public void testComposeMail(){
        SoftAssert softAssert = new SoftAssert();
        LoginData loginData = ExcelUtil.getLoginData(ExcelKeyData.TEST_SAMPLE_CREDS_01);

        String subject = Constants.SUBJECT;
        String emailBody = Constants.EMAIL_BODY;

        Login.loadLoginPage(Constants.SITE_URL);

        //login to inbox
        Login.loginToMail(loginData.userName,loginData.password);
        softAssert.assertTrue(Home.isInboxDisplayed(),"Inbox not displayed");

        //Compose mail
        Home.startMailCompose();
        softAssert.assertTrue(Home.isComposeWindowDisplayed(),"Mail compose screen not displayed");
        Compose.enterEmailSubject(subject);
        Compose.enterEmailBody(emailBody);

        softAssert.assertAll();
    }

}
