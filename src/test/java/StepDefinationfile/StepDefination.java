package StepDefinationfile;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefination 
{
	WebDriver driver;
	@Given("user navigate to login page")
	public void user_navigate_to_login_page() 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\AUTOMATION SUPPORT\\chromedriver.exe");
	     driver=new ChromeDriver();
		driver.get("http://retailm1.upskills.in/admin/index.php?route=common/dashboard&token=fOtazgcSDn3hST8dy4F1RPyPR15xQsnO");
		driver.manage().window().maximize();
	}

	@When("user enter username as {string} and password as {string}")
	public void user_enter_username_as_and_password_as(String uname, String pass) 
	{
		driver.findElement(By.id("input-username")).sendKeys(uname);
		driver.findElement(By.id("input-password")).sendKeys(pass);
	}

	@When("click on login")
	public void click_on_login() 
	{
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}

	@Then("user should able to login")
	public void user_should_able_to_login() 
	{
	
			Assert.assertEquals("Dashboard", driver.findElement(By.xpath("(//*[text()='Dashboard'])[3]")).getText());
			
			
	}

	@When("user navigate to coupons")
	public void user_navigate_to_coupons() 
	{
		Actions act=new Actions(driver);
		WebElement w=driver.findElement(By.xpath("//*[@class='fa fa-share-alt fw']"));
		WebElement w2=driver.findElement(By.xpath("(//*[text()='Coupons'])[1]"));
		act.moveToElement(w).build().perform();
		act.moveToElement(w2).click().build().perform();
	}

	@When("user create new coupon")
	public void user_create_new_coupon()
	{
		driver.findElement(By.xpath("//*[@class='fa fa-plus']")).click();
		driver.findElement(By.xpath("//*[@id='input-name']")).sendKeys("sk124");
		driver.findElement(By.xpath("//*[@id='input-code']")).sendKeys("1111");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}

	@When("verify the coupon is created")
	public void verify_the_coupon_is_created() 
	{
       String couponXpath="//*[text()='sk124']";
	    
	    Assert.assertTrue(driver.findElement(By.xpath(couponXpath)).isDisplayed()); 
	    
	}

	
       @When("user edit the coupon list")
	public void user_edit_the_coupon_list()
	{

    	   driver.findElement(By.xpath("(//*[@data-original-title='Edit'])[2]")).click();
    	   driver.findElement(By.xpath("//*[@id='input-name']")).clear();
    	   driver.findElement(By.xpath("//*[@id='input-code']")).clear();
    	   driver.findElement(By.xpath("//*[@id='input-name']")).sendKeys("ki124");
    	   driver.findElement(By.xpath("//*[@id='input-code']")).sendKeys("8111");
    	   driver.findElement(By.xpath("//*[@type='submit']")).click();
	}

	@When("Verify the edited coupon is in the list")
	public void verrify_the_edited_coupon_is_in_the_list()
	{
		  String couponXpath="//*[text()='ki124']";
		  Assert.assertTrue(driver.findElement(By.xpath(couponXpath)).isDisplayed());
		  
	}

	@When("user delete coupon")
	public void user_delete_coupon() 
	{
		driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();
		driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();
		
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}

	@Then("user verify coupon successfully deleted from list")
	public void user_verify_coupon_successfully_deleted_from_list()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Success: ')]")).isDisplayed());
		
	}

	

}

