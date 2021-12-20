package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends LoginPage {

    private By btnCompose = By.xpath("//*[@role='button'][text()='Compose']");
    private By btnSend = By.xpath("//div[@role='button' and text()='Send']");

    private By lnkInbox = By.xpath("//a[contains(text(),'Inbox')]");

    public void startMailCompose(){
        driver.findElement(btnCompose).click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(btnSend));
    }

    public boolean isInboxDisplayed(){
        return driver.findElement(lnkInbox).isDisplayed();
    }

    public boolean isComposeWindowDisplayed(){
        return driver.findElement(btnSend).isDisplayed();
    }
}
