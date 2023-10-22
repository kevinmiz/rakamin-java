package kasirAja.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://kasirdemo.belajarqa.com/";


    @Given("Halaman login kasir Aja")
    public void halaman_login_kasir_aja(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // set timeout for web driver on waiting element
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert, "hai, kasirAja");
    }

    @When("input username")
    public void input_username() {
        driver.findElement(By.id("email")).sendKeys("tdd-selenium@gmail.com");
    }

    @And("input password")
    public void input_password() {
        driver.findElement(By.id("password")).sendKeys("tdd-selenium");
    }

    @And("click login button")
    public void click_login_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("User in on dashboard page")
    public void user_in_on_dashboard_page() {
        driver.findElement(By.xpath("//div[contains(text(),'dashboard')]"));
        String username = driver.findElement(By.xpath("//dd[contains(text(),'hai')]/preceding-sibling::dt")).getText();
        Assert.assertEquals(username, "tdd-selenium");
    }


    @And("input Invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("pass123!");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String ErrorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(ErrorLogin, "Kredensial yang Anda berikan salah");
        driver.close();
    }
}

