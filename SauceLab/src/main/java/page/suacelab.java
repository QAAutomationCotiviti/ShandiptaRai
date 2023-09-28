package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageElement.login;
import utilities.finalVariables;
import utilities.utility;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class suacelab {

    static utility util = new utility();
    static WebDriver driver = util.initializeDriver("chrome");
    static String[] errorMessage = finalVariables.getErrorMessage();
    static login login = new login(driver);
    static Logger log;

    public static void main(String[] args) {
log = LogManager.getLogger(suacelab.class);
        driver.manage().window().maximize();
        driver.get("https://saucedemo.com");
        verifyLogin("username", "password");
        verifyLogin("", "");
        verifyLogin("standard_user", "secret_sauce");
    }

    public static void verifyLogin(String username, String password) {
        login.sendUsernamePassword(username, password);
        List<WebElement> myElements = util.ListElements(driver, login.confirmError());
        LinkedHashMap<String, String> mapping = new LinkedHashMap<>();
        if (!myElements.isEmpty()) {
            for (String er : errorMessage) {
                mapping.put(er, login.getErrorText());
            }
            for (Map.Entry<String, String> entry : mapping.entrySet()) {
                if (entry.getKey().equals(entry.getValue())) {
             //      System.out.println(entry.getValue());
                    log.info(entry.getValue());
                    login.clearInput();
                    break;
                }else if (!(util.ListElements(driver, login.confirmError()).isEmpty())) {
                    //error by trivial --warn
                    //System.out.println("Something in the error message has changed.");
                    log.error("Something in the error message has changed.");
            }
        }
        } else  //System.out.println("User logged in successfully");
        log.info("User Logged in successfully");

    }
}
