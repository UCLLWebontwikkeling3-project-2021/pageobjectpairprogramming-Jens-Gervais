import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;



// Lennert Van Oosterwyck r0782485 & Jens Gervais r0782113;
public class LogOutTest {
    private WebDriver driver;
    private String path = "http://localhost:8080/";

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "D:\\UCLL\\Web3\\Selenium+Chromedriver\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(path+"?command=Home");
        // inloggen

    }

    @After
    public void clean() {
        driver.quit();
    }


    // kan enkel werken als je een gebruiker hebt in dit geval de ADMIN met als userid= 'admin' en als password = 't'
    @Test
    public void test_logout_works_when_you_are_logged_in(){
        Login_LogoutPage test = PageFactory.initElements(driver, Login_LogoutPage.class);
        // eerst inloggen
        test.setUserid("admin");
        test.setPassword("Web3T3mp");
        test.submitLoginButton();

        // kijk of je de logout button kan zien
        assertTrue(test.logOutButtonIsPresent());
        // uitloggen
        test.submitLogOutButton();
        // kijk of je bent uitgelogd en ook dus terug kan inloggen
        assertTrue(test.loginButtonIsPresent());

    }

    @Test
    public void test_can_not_logout_when_not_logged_in() {
        Login_LogoutPage login_logoutPage = PageFactory.initElements(driver, Login_LogoutPage.class);
        /*boolean gelukt = false;
        // kijken of dat login button zichtbaar is
        assertTrue(login_logoutPage.loginButtonIsPresent());
        // kijken of dat logout button niet zichtbaar is
        assertFalse(login_logoutPage.logOutButtonIsPresent());

        try {
            login_logoutPage.submitLogOutButton();
            gelukt = false;
        }
        catch (NoSuchElementException e) {
            gelukt = true;
        }
        assertFalse(gelukt);*/
        assertFalse(login_logoutPage.logOutButtonIsPresent());
    }



}
