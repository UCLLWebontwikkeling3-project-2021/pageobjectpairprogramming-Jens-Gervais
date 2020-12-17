import org.openqa.selenium.WebDriver;

// Lennert Van Oosterwyck r0782485 & Jens Gervais r0782113;
public abstract class Page {

    WebDriver driver;
    String path = "http://localhost:8080/";

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }




    public String getPath() {
        return path;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
