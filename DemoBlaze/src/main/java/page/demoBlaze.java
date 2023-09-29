package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageElements.signUp;
import utilities.finalVariables;
import utilities.utility;

public class demoBlaze {

    static utility util = new utility();
    static WebDriver driver = util.initializeDriver("chrome");
    static signUp signUp = new signUp(driver);

    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        getSignUp("","");
        getSignUp("dfsdfsdfsdfsdsdsdg","sdsfsfsdfsdf");
        getSignUp("dfsdfsdfsdfsdsdsdg","sdsfsfsdfsdf");
    }

    public static void getSignUp(String username, String password){
        driver.findElements(signUp.clickSignUp());
        By[] getSignUpInput = signUp.getSignUpInput();
        By[] getSignUpButtton = signUp.getSignUpButton();
        WebElement signUpModal = util.waitForElementTObeLocated(driver,15,signUp.signUpModal());
        WebElement uname = util.waitForElementTObeLocated(driver,15,getSignUpInput[0]);
        uname.clear();
        uname.sendKeys(username);
        WebElement pword = util.waitForElementTObeLocated(driver,15,getSignUpInput[1]);
        pword.clear();
        pword.sendKeys(password);
        signUpModal.findElement(getSignUpButtton[1]).click();
        util.checkAlert(15,driver);
        if(finalVariables.signUpSuccess.equals(util.getAlert(driver).getText())){
            System.out.println(util.getAlert(driver).getText());
            util.getAlert(driver).accept();
        }else{
            System.out.println(util.getAlert(driver).getText());
            util.getAlert(driver).accept();
            signUpModal.findElement(getSignUpButtton[0]).click();

        }



    }
}

