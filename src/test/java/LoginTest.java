import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by AbdullahiHussein on 15/04/2016.
 */
public class LoginTest {
    WebDriver driver;
    @Before
    public void setup(){
        driver = new FirefoxDriver();

    }
    @Test
    public void loginTest() {
        driver.get("http://localhost:8080/whiteley-zoo/login.html");
        driver.findElement(By.cssSelector("#username")).sendKeys("Abdullahi121");
        driver.findElement(By.cssSelector("#password")).sendKeys("Abdullahi");
        driver.findElement(By.className("button")).click();
        String result = driver.findElement(By.cssSelector("#headerWrap>div")).getText();
        Assert.assertEquals("You are logged in as Abdullahi121 (Sex: ) (Logout)", result);
        //Negative Assertion
        //String resultfail = driver.findElement(By.cssSelector("html>body>h2")).getText();
        //Assert.assertEquals("You are logged in as abdul (Sex: )", resultfail);
    }
    @After
    public void terminate(){
        driver.close();

    }
}
