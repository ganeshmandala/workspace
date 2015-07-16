package icd_p;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.*;



public class Sample {

	 FirefoxDriver browser = new FirefoxDriver();
	 Page_Objects PO = null;
	 
	 public Sample(){
		 PO=new Page_Objects(browser);
	 }

	@BeforeClass
	public void LoginIntoICD() {
		
        PO.URL("http://inhvm-esmrft-97:49901/");
        
        
        
			
			
        		 
        		 
        		 
        		 
	    PO.LogintoICD("system", "manager");
	   
	}

	@Test
	public void test2() throws InterruptedException{
		
	
		PO.click_button_xpath("(//img[@alt='ICD'])[2]");
	}
	
	@Test
	public void test3() throws InterruptedException{
		
	    PO.form("", "Revi1", "Des test", "AppBL1", "Draft", "Rdev1");
	    Assert.assertEquals("Name can not be blank", browser.findElement(By.xpath("//textbox-with-validation/div/div/div/div/div[2]/div")).getText());
	    browser.navigate().refresh();
	    
	}
	@Test
	
	public void test4() throws InterruptedException{
		
	    PO.form("Test", "", "Des test", "AppBL1", "Draft", "Rdev1");
	    Assert.assertEquals("Revision can not be blank", browser.findElement(By.xpath("//*[@id='icd-create-update-form']/div/form/textbox-with-validation[2]/div/div/div/div/div[2]/div")).getText());
	    browser.navigate().refresh();
	    
	}
	@Test
	public void test5() throws InterruptedException{
		
	    PO.form("Test two", "Revi1", "", "AppBL1", "Draft", "Rdev1");
	    Assert.assertEquals("Name can not be blank", browser.findElement(By.xpath("//textbox-with-validation/div/div/div/div/div[2]/div")).getText());
	    browser.navigate().refresh();
	    
	}
	
	
	@AfterClass
	public void Logout(){
		
		browser.close();
		browser.quit();
	}
	
}
