import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by AbdullahiHussein on 15/04/2016.
 */
public class RegisterTest {
    WebDriver driver;
    @Before
    public void setup(){
        driver = new FirefoxDriver();

    }
    @Test
    public void registerest() throws InterruptedException {
        driver.get("http://localhost:8080/whiteley-zoo/register.html");
        driver.findElement(By.cssSelector("#username")).sendKeys("Abdullahi121");
        driver.findElement(By.cssSelector("#password")).sendKeys("Abdullahi");
        driver.findElement(By.cssSelector("#password2")).sendKeys("Abdullahi");
        Select date_ = new Select(driver.findElement(By.cssSelector("#dobDay")));
        date_.selectByVisibleText("11");
        Select month = new Select(driver.findElement(By.cssSelector("#dobMonth")));
        month.selectByVisibleText("July");
        Select year = new Select(driver.findElement(By.cssSelector("#dobYear")));
        year.selectByVisibleText("1976");
        driver.findElement(By.cssSelector("#sex1")).click();
        driver.findElement(By.cssSelector("#postcode")).sendKeys("N17 7DY");
        driver.findElement(By.className("button")).click();
        String expectedResult = driver.findElement(By.cssSelector("#headerWrap>div")).getText();
        Assert.assertEquals("You are logged in as Abdullahi121 (Sex: ) (Logout)", expectedResult);

        /*String negativeResult = driver.findElement(By.cssSelector("html>body>h2")).getText();
        Assert.assertEquals("You are logged in as Abdullahi121 (Sex: ) (Logout)", result);
        Assert.assertEquals("HTTP ERROR 500", negativeResult);*/


    }
    @After
    public void terminate(){
          driver.close();

    }
}
