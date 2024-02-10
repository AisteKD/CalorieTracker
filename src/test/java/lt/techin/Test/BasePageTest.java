package lt.techin.Test;

import lt.techin.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePageTest {

    WebDriver driver;
    HomePage homePage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        driver.get("https://practice.expandtesting.com/tracalorie/?#");
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

    public void palaukti() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}
