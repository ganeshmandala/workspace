package icd_p;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Page_Objects {

	public final FirefoxDriver browser;
	
	public Page_Objects(FirefoxDriver browser) {
		this.browser=browser;
	}
	
		//LogintoICD
		public  void URL(String url){
			browser.get(url);
			browser.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
			}
		
	//LogintoICD
	public  void LogintoICD(String username,String passsword){
	
		browser.findElement(By.id("textBoxFieldUsername")).sendKeys(username);
		browser.findElement(By.id("textBoxFieldPassword")).sendKeys(passsword);
		browser.findElement(By.xpath("//Button")).click();
		browser.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
	
	// Form
	public void form(String name,String Revision,String Des,String device,String Draft,String component) throws InterruptedException{
		
		
	
		browser.findElement(By.id("textBoxFieldName")).sendKeys(name);
		
		browser.findElement(By.id("textBoxFieldRevision")).sendKeys(Revision);
	
		browser.findElement(By.id("textAreaFieldDescription")).sendKeys(Des);
		
		browser.findElement(By.id("typeaheadTextBoxFieldDevice")).sendKeys(device);
	    new Select(browser.findElement(By.id("releaseLevel"))).selectByVisibleText(Draft);
	    browser.findElement(By.xpath("//input[@id='typeaheadTextBoxFieldComponent']")).sendKeys(component);
	    
	
	  
	}
	   //links
		public void click_link(String link){
			browser.findElement(By.linkText(link)).click();
			browser.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		
	    //button_Name
		public void click_button_name(String name){
			browser.findElement(By.name(name)).click();
			browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		}
		//button_Xpath
				public void click_button_xpath(String name){
					browser.findElement(By.xpath(name)).click();
					browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				}
		
		public void OpenBrowser(String name){
		browser.get(name);
		}
		
		//screen-shot
		public void capturescreenshot(String screenname) throws IOException{
			File scrFile = ((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("screenshots\\"+screenname+".png"));

		}
}
