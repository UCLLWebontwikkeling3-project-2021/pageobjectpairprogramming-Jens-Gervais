import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Lennert Van Oosterwyck r0782485 & Jens Gervais r0782113;
public class Login_LogoutPage extends Page  {


    @FindBy(id="userId")
    private WebElement useridLoginField;



    @FindBy(id="password")
    private WebElement passwordLogInField;

    @FindBy(id="login")
    private WebElement logInButton;

    public Login_LogoutPage(WebDriver driver){
        super(driver);
        this.driver.get(getPath()+"Controller?command=Home");
    }


    public void setUserid(String userid){
        useridLoginField.clear();
        useridLoginField.sendKeys(userid);
    }


    public void setPassword(String password) {
        passwordLogInField.clear();
        passwordLogInField.sendKeys(password);
    }


    public boolean loginButtonIsPresent(){

        try {
            WebElement webElement = driver.findElement(By.id("login"));
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    public void submitLoginButton() {
        WebElement buttonLogin = driver.findElement(By.id("login"));
        buttonLogin.submit();

    }
    public boolean logOutButtonIsPresent(){

        try {
            WebElement webElement = driver.findElement(By.id("logout"));
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    public void submitLogOutButton() {
        WebElement buttonLogin = driver.findElement(By.id("logout"));
        buttonLogin.submit();

    }

    public boolean hasErrorMessage (String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
    }









}
