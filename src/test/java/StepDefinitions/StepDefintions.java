package StepDefinitions;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
 

public class StepDefintions {
	WebDriver driver = new ChromeDriver();
	
	@Given("^user opens the app url.*")
	public void verifyLoginPage() {
		
//		“Geckodriver” can’t be opened because the identity of the developer cannot be confirmed
//		WebDriver driver = new FirefoxDriver();
//		# implicitlyWait.in(10, TimeUnit.SECONDS) is deprecated
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15	)); 
	    String base_url = "https://americas.datasite.com";
	    driver.get(base_url);
	}

	@When("user enters invalid username (.*) and password (.*)$")
	public void enterInvalidCredentials(String username, String password) {
		WebElement user = driver.findElement(By.id("username")); 
		WebElement pass = driver.findElement(By.id("password"));
		user.sendKeys(username);
		pass.sendKeys(password);		
	}

	@And("^submits.*")
	public void submitForm() {
		WebElement login_button = driver.findElement(By.cssSelector(".primary"));
		login_button.click();
	}

	@Then("^the error: (.*)$")
	public void verifyError(String error){
		driver.findElement(By.xpath(String.format("//*[contains(text(),%s)]", error)));
												   
	}

    @When("user clicks forgot password link") 
    public void clickPasswordLink() {	
    	driver.findElement(By.xpath("//a[text()='FORGOT PASSWORD?']")).click();
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//jv-forgot-password-form")));	
    }

    @And("user vists Terms of Use page")
    public void termsOfUse() {
    	XPath xpath = XPathFactory.newInstance().newXPath();
    	WebElement terms = driver.findElement(By.xpath("//*[text()='TERMS OF USE']"));
    	terms.click();
    }
    
    @Then("verifies the date is correct")
    public void verifyTodaysDate() {
    	String pattern = "MMMM, dd YYYY";
        SimpleDateFormat readable_date = new SimpleDateFormat(pattern);
      
        String date = readable_date.format(new Date());
        driver.findElement(By.xpath(String.format("//*[contains(text(),'Effective as of %s')]", date))).click();           	
    }
    
    @And("^verifies supported language (.*)$")
    public void verifyLanguage (String lang) {	
    	driver.findElement(By.cssSelector("div#menuOpen")).click();
    	driver.findElement(By.xpath("//a[@data-target='languageMenu']")).click();
    	driver.findElement(By.xpath(String.format("//*[text()='%s']", lang)));	
    }
}
