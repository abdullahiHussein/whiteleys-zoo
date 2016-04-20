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
public class AddingAndVeiwingFavouriteAnimals {
    WebDriver driver;
    @Before
    public void setup(){
        driver = new FirefoxDriver();
    }
    @Test
    public void addingAndVeiwFavouriteAnimals() throws InterruptedException {
        driver.get("http://localhost:8080/whiteley-zoo/login.html");
        driver.findElement(By.cssSelector("#username")).sendKeys("Abdullahi121");
        driver.findElement(By.cssSelector("#password")).sendKeys("Abdullahi");
        driver.findElement(By.className("button")).click();
        driver.findElement(By.xpath("//*[@id='navWrap']//li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id='bodyWrap']/p[4]/a/img")).click();
        driver.findElement(By.xpath("//*[@id='bodyWrap']/p[5]/a/img")).click();
        driver.findElement(By.xpath("//*[@id='bodyWrap']/p[4]/a/img")).click();
        driver.findElement(By.cssSelector("#bodyWrap>p>a")).click();

        String expectedResult = driver.findElement(By.cssSelector("#bodyWrap>p")).getText();
        Assert.assertEquals("You don't have any favourites. Browse the gallery to find some you like.", expectedResult);

    }
    @After
    public void terminate(){
        driver.close();

    }
}
