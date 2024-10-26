package Test;

import java.io.IOException;

import org.testng.annotations.Test;

import Generic.base;
import POM.WelcomePage;

public class Userlog_211024 extends base{

	@Test
	public void login() throws IOException, InterruptedException {
		
		WelcomePage lg = new WelcomePage(driver);
		lg.fblogin(driver);
		System.out.println("sdfvzdsfvgaerg");
		lg.createAccount();
	}
}