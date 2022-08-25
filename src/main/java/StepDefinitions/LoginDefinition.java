package StepDefinitions;

import java.util.concurrent.TimeUnit;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.sjm.utilities.ConfigProperties;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.LoginPage;
 
public class LoginDefinition {
 
    WebDriver driver;
    private LoginPage signinpage;
    private ConfigProperties config;
 
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
 
    @Given("User is on Login page")
    public void userOnHomePage() {
 
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
 
    @When("User enters username as {string}")
    public void entersUsername(String userName) throws InterruptedException {
 
        System.out.println("Username Entered");
        driver.findElement(By.name("txtUsername")).sendKeys(userName);
 
    }
 
    @When("User enters password as {string}")
    public void entersPassword(String passWord) throws InterruptedException {
 
        System.out.println("Password Entered");
        driver.findElement(By.name("txtPassword")).sendKeys(passWord);
 
        driver.findElement(By.id("btnLogin")).submit();
    }
 
    @Then("User should be able to login successfully")
    public void successfulLogin() throws InterruptedException {
 
        String newPageText = driver.findElement(By.id("welcome")).getText();
        System.out.println("newPageText :" + newPageText);
        
    }
        
        @Given("User Launch the application")
    	public void user_launch_the_application() {
    		signinpage=PageFactory.initElements(driver, LoginPage.class);
    		 driver.get("https://ksrtc.in/oprs-web/login/show.do");
    		 
    	}  
    	
    	@When("User Enter invalid credentials")
    	public void user_enter_invalid_credentials() {
    		signinpage.usrNameTextBox.sendKeys("19wolveogan@gmail.com");
    		signinpage.passwordTextBox.sendKeys("wolvine@19");
    	}
    	@Then("User should be unsuccessfull in login")
    	public void user_should_be_unsuccessfull_in_login() {
    	   signinpage.incorrectLabel.isDisplayed();
    	
    	}
    	@When("User Enter valid credentials")
    	public void user_enter_valid_credentials() {
    		signinpage.usrNameTextBox.sendKeys("19wolverinelogan@gmail.com");
    		signinpage.passwordTextBox.sendKeys("wolverine@19");
        
    	}

    	@When("User clicks the sign in button")
    	public void user_clicks_the_sign_in_button() {
    	  signinpage.loginBtn.click();
    	}

    	@Then("User should be logged in successfully")
    	public void user_should_be_logged_in_successfully() {
    	   signinpage.welcomeLabel.isDisplayed();
    	
    	}
 
    @After
    public void teardown() {
 
        driver.quit();
    }
 
}