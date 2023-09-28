package pageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class login {
    private final WebDriver driver;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By loginError = By.xpath("//h3[@data-test='error']");
    private final By logout = By.id("logout_sidebar_link");

    public final By confirmError(){
        return By.xpath("//h3[@data-test='error']");
    }

    public void sendUsernamePassword(String username, String password) {
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void clearInput() {
        driver.findElement(username).sendKeys(Keys.CONTROL, ("a"), Keys.DELETE);
        driver.findElement(password).sendKeys(Keys.CONTROL, ("a"), Keys.DELETE);
    }

    public String getErrorText() {
        return driver.findElement(confirmError()).getText();
    }

    public login(WebDriver driver){
        this.driver = driver;
    }


}
