package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signUp {
    private final WebDriver driver;
    private final By signupLink =By.id("signin2");
    private final By signUpModal =By.xpath("//div[@id='signInModal']//div[@class='modal-content']");
    private final By signupUsername = By.xpath("//div[@id='signInModal']//input[@id='sign-username']");
    private final By signupassword = By.xpath("//div[@id='signInModal']//input[@id='sign-password']");
    private final By cancleButton = By.xpath("//div[@id='signInModal']//button[@class='btn btn-secondary']");
    private final By signupButton = By.xpath("//div[@id='signInModal']//button[@class='btn btn-primary']");

    public signUp(WebDriver driver){
        this.driver=driver;

    }

    public By clickSignUp(){
        return signupLink;
    }
    public By[] getSignUpInput(){
        return new By[]{signupUsername,signupassword};
    }

    public By[] getSignUpButton(){
        return new By[]{cancleButton,signupButton};
    }

    public  By signUpModal(){
        return signUpModal;
    }

}
