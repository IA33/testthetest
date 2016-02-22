package TestFolder;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.utilities;


public class TestOpenBrowser {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
		
	@BeforeTest
		public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://google.hu";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}

	@Test
	public void testJenkins() throws Exception {
		
		//System.out.println("Jenkins Working");
		driver.get(baseUrl + "/?gws_rd=ssl#q=teszt");
		driver.manage().window().maximize();
		
		boolean currentURL = driver.getCurrentUrl().contains("teszt");{
			if (true){
				System.out.println("Test URL: "+currentURL);
				utilities.captureScreenshot(driver, ("TestPassed"));
			}
		}
	}

	@AfterClass
		public void tearDown() throws Exception {
			driver.quit();
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				fail(verificationErrorString);
			}
		}

	private void fail(String verificationErrorString) {
		// TODO Auto-generated method stub
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
			}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} 
			else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}


