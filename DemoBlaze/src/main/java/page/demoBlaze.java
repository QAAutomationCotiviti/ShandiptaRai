package page;

import org.openqa.selenium.*;
import pageElements.signUp;
import utilities.finalVariables;
import utilities.utility;

public class demoBlaze {

    static utility util = new utility();
    static WebDriver driver = util.initializeDriver("chrome");
    static signUp signUp = new signUp(driver);

    public static void main(String[] args) {
        try {
            driver.manage().window().maximize();
            driver.get("https://www.demoblaze.com/");
            getSignUp("", "");
//            getSignUp("dfsdfsdfsdfsdsdsdg", "sdsfsfsdfsdf");
//            getSignUp("dfsdfsdfsdfsdsdsdg", "sdsfsfsdfsdf");
        }
        catch (ElementNotInteractableException| NoAlertPresentException e){
            System.out.println("Error: " +e);

        }
    }

    public static void getSignUp(String username, String password){
        driver.findElement(signUp.clickSignUp()).click();
        By[] getSignUpInput = signUp.getSignUpInput();
        By[] getSignUpButtton = signUp.getSignUpButton();
        WebElement signUpModal = util.waitForElementTObeLocated(driver,20,signUp.signUpModal());
        System.out.println(signUpModal.isDisplayed());
        WebElement uname = util.waitForElementTObeLocated(driver,20,getSignUpInput[0]);
        uname.clear();
        uname.sendKeys(username);
        WebElement pword = util.waitForElementTObeLocated(driver,20,getSignUpInput[1]);
        pword.clear();
        pword.sendKeys(password);
        signUpModal.findElement(getSignUpButtton[1]).click();
        util.checkAlert(20,driver);
        if(finalVariables.signUpSuccess.equals(util.getAlert(driver).getText())){
            System.out.println(util.getAlert(driver).getText());
            util.getAlert(driver).accept();
        }else{
            System.out.println(util.getAlert(driver).getText());
            util.getAlert(driver).accept();
            signUpModal.findElement(getSignUpButtton[0]).click();

        }driver.navigate().refresh();



    }
}

