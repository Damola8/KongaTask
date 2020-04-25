package Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;
    public class KongaTest {
    private WebDriver driver;
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
       //click on the chrome browser
        driver = new ChromeDriver();
        //enter the url
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);
        //1. maximize the window
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        //logging in and entering user's details
        driver.findElement(By.linkText("Login / Signup")).click();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
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
        driver.findElement(By.xpath("(//input[@name='search'])[2]")).sendKeys("Non Piercing Magnetic Pyramid Stud - Black");
        driver.findElement(By.xpath("(//button[@class='fdd83_39Iap'])[2]")).click();
        Thread.sleep(3000);

        //to click on the add to cart button
        driver.findElement(By.xpath("//div[@class='af885_1iPzH']//h3[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //to add 4 pieces of the selected item to the cart
        driver.findElement(By.xpath("(//button[@class='c4079_DW1vB'])[2]")).click();
        driver.findElement(By.xpath("(//button[@class='c4079_DW1vB'])[2]")).click();
        driver.findElement(By.xpath("(//button[@class='c4079_DW1vB'])[2]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //to click on the buy button
        driver.findElement(By.xpath("(//button[@class='_0a08a_3czMG _6d187_pzjfk'])[2]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //to click on checkout button
        driver.findElement(By.xpath("(//a[@href='/checkout/complete-order'])[2]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Select a delivery option
        driver.findElement(By.xpath("(//a[@class='_0a08a_3czMG _7e22a_3zNWE'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //to select an address
        driver.findElement(By.xpath("(//button[@name='selectDeliveryAddress'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //to choose an existing address
        driver.findElement(By.linkText("Use this Address")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //to select a payment method
        driver.findElement(By.name("selectPaymentMethod")).click();

        //to continue to payment
        driver.findElement(By.name("placeOrder")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //to switch to the iframe
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='kpg-frame-component']"));
        driver.switchTo().frame(iframe);

        //To confirm if the iframe targeted exists
        int i = driver.findElements(By.xpath("//div[@id='channel-template']/div[2]/div[1]/div[1]/button[1]")).size();
        if(i == 0)
            System.out.println("Iframe element is not present");
        else
            System.out.println("Iframe element is present");

        //Click on the Card payment option
        driver.findElement(By.cssSelector(".Card")).click();

        // to enter the card details
        driver.findElement(By.id("card-number")).sendKeys("4242 4242 4242 4242  ");
        driver.findElement(By.xpath("(//input[@class='date input_class'])[1]")).sendKeys(" 04/2023");
        driver.findElement(By.id("cvv")).sendKeys("419 ");
        driver.findElement(By.id("validateCardForm")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //To display the card error
        System.out.println(driver.findElement(By.id("card-number_unhappy")).getText());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //to close the window and end the session
        WebDriver driver = null;
        driver.quit();

    }

    public static void main(String args[]) throws InterruptedException {
        KongaTest test = new KongaTest();
        test.setUp();
    }

}