package StepDefinitions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefintions {
	WebDriver driver = new ChromeDriver();
	
	@Given("^user opens the app url.*")
	public void verifyLoginPage() {
		
//		“Geckodriver” can’t be opened because the identity of the developer cannot be confirmed
//		WebDriver driver = new FirefoxDriver();
//		# implicitlyWait.in(10, TimeUnit.SECONDS) deprecated
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	    String base_url = "https://americas.datasite.com";
	    driver.get(base_url);
	}

	@When("user enters invalid credentials")
	public void enterInvalidCredentials() {
		WebElement username = driver.findElement(By.id("username")); 
		WebElement password = driver.findElement(By.id("password"));
		username.sendKeys("bademail@bad.com");
		password.sendKeys("badPASS");		
	}

	@And("^submits.*")
	public void submitForm() {
//		WebElement login_button = driver.findElement(By.xpath("//a[text()='LOG IN']"));
		WebElement login_button = driver.findElement(By.cssSelector(".primary"));
		login_button.click();
	}

//	@Then("this error message is displayed: {string}")
	@Then("^credentials error.*")
	public void verifyCredentialsError(){
//		driver.findElement(By.xpath("//p[text()=\"We didn't recognize the username or password you entered. Please try again.\"]"));
//									"//*[@id='" + recordId + "_ACTION_COLUMN']/a[2]/span"
//									"//td[normalize-space(text())='"+newUser+"']/a"
		//p[contains(text(),"We didn't recognize the username or password you entered. Please try again.")]
		driver.findElement(By.xpath("//p[contains(text(),\"We didn't recognize the username or password you entered. Please try again.\")]"));
	}

//	@Then("this error message is displayed: {string}")
//	public void validatePasswordReset(String error){
	@Then("^email address error:.*")
	public void validatePasswordReset(){
//		driver.findElement(By.xpath("//p[text()=\"We didn't recognize the username or password you entered. Please try again.\"]"));
//									"//*[@id='" + recordId + "_ACTION_COLUMN']/a[2]/span"
//									"//td[normalize-space(text())='"+newUser+"']/a"
		//p[contains(text(),"We didn't recognize the username or password you entered. Please try again.")]
		driver.findElement(By.xpath("//*[contains(text(),\'Error: Email address required')]"));
	}

	
    @When("user clicks forgot password link") 
    public void clickPasswordLink() {	
    	WebElement forgot_password_link = driver.findElement(By.xpath("//a[text()='FORGOT PASSWORD?']"));
    	forgot_password_link.click();
    	
    }
    



}
