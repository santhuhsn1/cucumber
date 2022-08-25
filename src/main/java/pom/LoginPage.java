package pom;
import com.sjm.utilities.CoustomLibrary;
import com.sjm.utilities.GenericLibraries;
import com.sjm.utilities.Waits;
import static com.sjm.utilities.GenericLibraries.*;
import static com.sjm.utilities.Waits.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
WebDriver driver ;
	
	public LoginPage (WebDriver driver) {
		this.driver=driver;
	}
	
	
	@FindBy(linkText="Sign In")
	public WebElement signInBtnOnHomePage;
	
	@FindBy(id="userName")
	public WebElement usrNameTextBox;
	
	@FindBy(id="password")
	public WebElement passwordTextBox;
	
	@FindBy(css="input[id='submitBtn']")
	public WebElement loginBtn;
	
	@FindBy(id="errorMsg")
	public WebElement incorrectLabel;
	
	
	@FindBy(xpath="//div[contains(text(),'Welcome')]")
	public WebElement welcomeLabel;
	
	// for book your ticket
	@FindBy(xpath = "//input[@id='fromPlaceName']")
	public WebElement fromplacename;
	
	@FindBy(xpath = "//input[@id='toPlaceName']")
	public WebElement toplacename;
	
	@FindBy(xpath = "//input[@id='txtJourneyDate']")
	public WebElement txtJourneyDate;
	
	@FindBy(xpath = "//button[normalize-space()='Search for Bus']")
	public WebElement Searchbutton;
	
	
	



   public boolean loginAsInValidUser(String userNme, String password) {
	
	clickElement(signInBtnOnHomePage, driver);
	
	setValue(usrNameTextBox, userNme, driver);
	
	setValue(passwordTextBox, password, driver);
	
	clickElement(loginBtn, driver);
	 
	return isDisplayed(incorrectLabel);

}  

}
