package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
}
