package pages;

import org.openqa.selenium.By;

public class ComposePage extends LoginPage {

    private By txtEmailSubject = By.name("subjectbox");
    private By txtEmailBody = By.xpath("//div[@aria-label='Message Body']");

    public void enterEmailSubject(String strSubject){
        driver.findElement(txtEmailSubject).sendKeys(strSubject);
    }

    public void enterEmailBody(String strMessage){
        driver.findElement(txtEmailBody).sendKeys(strMessage);
    }
}
