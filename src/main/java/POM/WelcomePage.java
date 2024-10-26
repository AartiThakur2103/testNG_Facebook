package POM;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Generic.lib;

public class WelcomePage {
//----------------Declaration--------------------------------

//login
	@FindBy(id="email")
	private WebElement email;
	@FindBy(id="pass")
	private WebElement password;
	@FindBy(name="login")
	private WebElement clicklogin;
	
//	create account
	@FindBy(xpath="//*[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")
	private WebElement createaccount;
	@FindBy(name="firstname")
	private WebElement firstname;
	@FindBy(name="lastname")
	private WebElement lastname;
	@FindBy(name="reg_email__")
	private WebElement mobilenumber;
	@FindBy(id="password_step_input")
	private WebElement newpassword;
	@FindBy(id="day")
	private WebElement day;
	@FindBy(id="month")
	private WebElement month;
	@FindBy(id="year")
	private WebElement year;
	@FindBy(xpath="//*[@class=\"_5k_2 _5dba\"]")
	private List <WebElement> gender;
	@FindBy(id="u_3_n_2h")
	private WebElement submit;

	
	@FindBy(xpath="//*[text()=\"Meera Mishra\"]")
	private WebElement validate;
	
	
//----------------Initialization--------------------------------
	
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//----------------Utilization--------------------------------

	public void fblogin(WebDriver driver) throws IOException, InterruptedException {
		lib.excelfile("TestData1",1,1);
		int length=lib.Rowlength("TestData1");
		SoftAssert st = new SoftAssert();
		for(int i=0;i<length;i++) {
		String emailbox = lib.excelfile("TestData1",1+i,2);
		email.sendKeys(emailbox);
		String passcode = lib.excelfile("TestData1",1+i,3);
		password.sendKeys(passcode);
//		Thread.sleep(2000);
		
//		implicit wait
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
//	    explicit wait
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clicklogin));
	    
	    /*
//	    fluent wait
	    FluentWait<WebDriver> waits = new FluentWait<>(driver)
	    	    .withTimeout(Duration.ofSeconds(30))
	    	    .pollingEvery(Duration.ofSeconds(5))
	    	    .ignoring(NoSuchElementException.class);

	    	WebElement elements = waits.until(new Function -> driver.findElement(By.id("elementId")));
	    */
//		clicklogin.submit();
//		Thread.sleep(10000);
//		String text=validate.getText();
//		if(text.equals("Meera Mishra")) {
//		if(i==length) 
		
//	    hard assertion
	    Assert.assertEquals(length, 8);
	    System.out.println("end"); 
	    
//	    soft assertion
	    st.assertEquals(3, length);
		Thread.sleep(1000);
		System.out.println("cont. report"); 
		email.clear();
		password.clear();
		
		}st.assertAll();
		}
	
	public void createAccount() throws InterruptedException, IOException {
		createaccount.click();
		Thread.sleep(3000);
		String firstname = lib.property_file("firstname");
		this.firstname.sendKeys(firstname);
		Thread.sleep(3000);
		this.lastname.sendKeys("Mishra");
		Thread.sleep(3000);
		this.mobilenumber.sendKeys("8076434384");
		Thread.sleep(3000);
		this.newpassword.sendKeys("Shiva@2023");
		Thread.sleep(3000);

		Select selectday = new Select(day);
		selectday.selectByVisibleText("4");
		Thread.sleep(3000);

		Select selectmonth = new Select(month);
		selectmonth.selectByIndex(2);
		Thread.sleep(3000);

		Select selectyear = new Select(year);
		selectyear.selectByValue("2003");
		Thread.sleep(3000);

		for(WebElement genderelement2:gender) {
			String text = genderelement2.getText();
			System.out.println(text);
			Thread.sleep(2000);
			
			if(gender.equals("Male")) {
				genderelement2.click();	
				break;
			}
		}
		submit.submit();
	}

	
}