package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.System.exit;

public class utility {

    WebDriver driver;

    public WebDriver initializeDriver(String browser){

        switch (browser.toLowerCase()){
            case "chrome": driver = new ChromeDriver();
                break;
            case "firefox": driver = new FirefoxDriver();
                break;
            case "edge": driver = new EdgeDriver();
                break;
            default:
                System.out.println(browser+ "is not a valid browser.");
                exit(1);
        } return driver;

    }
    public List<WebElement> ListElements(WebDriver driver, By element) {
        return driver.findElements(element);
    }

    public  Wait<WebDriver> genericWait(long time, WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public WebElement waitForElementTObeLocated(WebDriver driver, long time, By element){
        Wait<WebDriver> wait= genericWait(time, driver);
       return  wait.until(ExpectedConditions.visibilityOfElementLocated(element));//WebElement

    }

    public WebElement waitForElementTObeInvisible(WebDriver driver, long time, By element){
        Wait<WebDriver> wait= genericWait(time, driver);
       return wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public Alert getAlert(WebDriver driver){
        return driver.switchTo().alert();
    }

    public void checkAlert(long time, WebDriver driver){
        Wait<WebDriver> wait= genericWait(time, driver);
        wait.until(ExpectedConditions.alertIsPresent());

    }
}
