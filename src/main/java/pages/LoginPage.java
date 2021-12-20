package pages;

import common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    protected static WebDriver driver;

    private By txtEmailID = By.xpath("//input[@type='email']");
    private By txtEmailPassword = By.xpath("//input[@type='password']");
    private By btnNext = By.xpath("//span[text()='Next']/parent::button");
    private By btnCompose = By.xpath("//*[@role='button'][text()='Compose']");

    public void quitDriver(){
        driver.quit();
    }

    public void loadLoginPage(String siteURL){
        String driverPath = System.getProperty(Constants.HOME_DIRECTORY)+Constants.DRIVER_PATH;
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(siteURL);
    }

    public void loginToMail(String strUserName, String strPassword){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(btnNext));
            driver.findElement(txtEmailID).sendKeys(strUserName);
            driver.findElement(btnNext).click();

            Thread.sleep(10);
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(txtEmailPassword));
            wait.until(ExpectedConditions.elementToBeClickable(btnNext));

            WebElement webElement = driver.findElement(txtEmailPassword);
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].setAttribute('value','" + strPassword + "');", new Object[]{webElement});

            Thread.sleep(5);
            wait.until(ExpectedConditions.elementToBeClickable(btnNext));
            webElement = driver.findElement(btnNext);
            javascriptExecutor.executeScript("arguments[0].click();", new Object[]{webElement});

            wait.until(ExpectedConditions.elementToBeClickable(btnCompose));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

