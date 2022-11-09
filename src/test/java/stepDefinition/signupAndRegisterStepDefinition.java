package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class signupAndRegisterStepDefinition {
	
public static WebDriver driver;
	
	@Given("elearning website is launched")
	public void elearning_website_is_launched() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\003QHN744\\OneDrive\\Training\\Day3\\src\\test\\chromedriver.exe");
	    driver =new ChromeDriver();
	    driver.get("http://elearningm1.upskills.in/");	
	}
	    
	@When("signup button is visible")
	public void signup_button_is_visible() {
	   driver.findElement(By.xpath("//a[contains(text(),' Sign up! ')]")).isDisplayed();   
	}

	@Then("user clicked on signup")
	public void user_clicked_on_signup() {
		driver.findElement(By.xpath("//a[contains(text(),' Sign up! ')]")).click();
	}
	
	@Given("Registration page is loaded") 
	  public void registration_page_is_loaded() {
	  //this.driver=driver;
	  driver.findElement(By.xpath("//label[@for='firstname']")).isDisplayed();
	  }
	 

	@When("Fill all details in registration page")
	public void fill_all_details_in_registration_page() {
		driver.findElement(By.name("firstname")).sendKeys("Baratam");
		driver.findElement(By.name("lastname")).sendKeys("Yamini");
		driver.findElement(By.name("email")).sendKeys("baratamyamini222@gmail.com");
		//update user name before executing the script
		driver.findElement(By.name("username")).sendKeys("byamini209");
		driver.findElement(By.name("pass1")).sendKeys("Yamini@123");
		driver.findElement(By.name("pass2")).sendKeys("Yamini@123");
	}

	@Then("click on register and check next button is visible")
	public void click_on_register_and_check_next_button_is_visible() {
	    driver.findElement(By.xpath("//button[@name='submit']")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//button[@name='next']")).isDisplayed();
	}
	
	@Then("click on next after successful registration")
	public void click_on_next_after_successful_registration() {
	   driver.findElement(By.xpath("//button[@name='next']")).click();
	}
	
	@Given("user is on messages section under profile")
	public void user_is_on_messages_section_under_profile() {
	    driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'Profile')]")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//li[@class='messages-icon ']//a")).click();
	}

	@When("compose a message by filling all fields")
	public void compose_a_message_by_filling_all_fields() {
	    driver.findElement(By.xpath("//img[@title='Compose message']")).click();
	    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("yamini");
        driver.findElement(By.xpath("//li[@class='select2-results__option']")).click();
	    driver.findElement(By.xpath("//input[@name='title']")).sendKeys("test email");
	    
	    WebElement message = driver.findElement(By.xpath("//div[@id='cke_content']/div/div/iframe"));
	    driver.switchTo().frame(message);
	    driver.findElement(By.xpath("//html[@dir='ltr']")).sendKeys("content");
	    driver.switchTo().defaultContent();
	}

	@Then("send a message")
	public void send_a_message() {
	    driver.findElement(By.xpath("//button[@name='compose']")).click();
	    driver.close();
	}
	

}
