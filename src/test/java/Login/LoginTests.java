package Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class LoginTests {
    private WebDriver driver;
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);
        //1. maximize the window
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        //This line of code is logging in and entering user's details
        driver.findElement(By.linkText("Login / Signup")).click();
        driver.findElement(By.id("username")).sendKeys("sulaimondamola96@gmail.com");
        driver.findElement(By.id("password")).sendKeys("sherifat29");
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
        Actions actions = new Actions (driver);
        //this line of code is hovering on the element before selecting
        WebElement Konga_Fashion =
        driver.findElement(By.linkText("Konga Fashion"));
        //hover on the element before clicking
        actions.moveToElement(Konga_Fashion).build().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //click on women's accessories, then pause
        driver.findElement(By.linkText("Ballerinas & Flats")).click();
        Thread.sleep(3000);
        //to search for an item
        driver.findElement(By.xpath("(//input[@name='search'])[2]")).sendKeys("Shonex Women Butterfly Embellished Shiny Canvas Loafers - Blue");
        driver.findElement(By.xpath("(//button[@class='fdd83_39Iap'])[2]")).click();
        Thread.sleep(3000);
        //to click on the add to cart button
        driver.findElement(By.xpath("//div[@class='af885_1iPzH']//h3[1]")).click();
        //to ad 4 pieces to the cart
        driver.findElement(By.xpath("(//button[@class='c4079_DW1vB'])[2]")).click();
        //to buy the item
        driver.findElement(By.xpath("(//button[text()='Buy Now'])[2]")).click();
        //to increase the number of pieces
        driver.findElement(By.xpath("(//button[@class='c4079_DW1vB'])[2]")).click();
        //to go to checkout
        driver.findElement(By.xpath("(//a[@href='/checkout/complete-order'])[2]")).click();




    }






    public static void main(String args[]) throws InterruptedException {
        LoginTests test = new LoginTests();
        test.setUp();
    }
}