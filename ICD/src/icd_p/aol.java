package icd_p;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class aol {

	/**
	 * @param args
	 */
	@Test
	public static void Test1() {
		
		FirefoxDriver browser=new FirefoxDriver();
		
		SoftAssert s_Assert=new SoftAssert();
		
		browser.get("https://my.screenname.aol.com/_cqr/login/login.psp?seamless=novl&locale=us&offerId=newmail-en-us-v2&siteState=ver%3A4|rt%3ASTANDARD|at%3ASNS|ld%3Amail.aol.com|uv%3AAOL|lc%3Aen-us|mt%3AANGELIA|snt%3AScreenName|sid%3Acbcb58bc-ed2b-4f55-abc9-14c2ba87216e&authLev=0&sitedomain=sns.webmail.aol.com&lang=en");

		//TC1
		browser.findElement(By.id("lgnId1")).clear();
		
		browser.findElement(By.id("pwdId1")).clear();
		
		browser.findElement(By.id("submitID")).click();
		
		String actual = browser.findElement(By.id("snPwdErr")).getText();
		//hard assert
		//Assert.assertEquals(actual, "Error: Pleas enter Username or Email.");
		//soft assert
		s_Assert.assertEquals(actual, "Error: Pleas enter Username or Email.");
		
		//TC2
				browser.findElement(By.id("lgnId1")).sendKeys("ganesh");
				
				browser.findElement(By.id("pwdId1")).clear();
				
				browser.findElement(By.id("submitID")).click();
				
				String actual2 = browser.findElement(By.id("snPwdErr")).getText();
				Assert.assertEquals(actual2, "Error: You must enter a value for Password.");
		
		
		browser.close();
		browser.quit();
		
		
		
	}

}
