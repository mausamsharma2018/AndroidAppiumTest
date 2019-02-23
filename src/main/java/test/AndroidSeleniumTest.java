package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class AndroidSeleniumTest {
	public static AppiumDriver<MobileElement> driver;
	public static WebDriverWait wait;

	public static void main(String[] args) {
		try {
			setup();

			Thread.sleep(3000);
			
			// click on I Agree button 
			driver.findElement(By.xpath("//android.widget.TextView[@index='2']")).click();//"//*[@text='I Agree' and @resource-id='com.buuuk.st:id/btn_tnc_ok']" )).click();   //
			
			// Swipe left to right to go to next page
	        //The viewing size of the device	2
	        Dimension size = driver.manage().window().getSize();

	        //x,y position set to mid-screen horizontally swipe	
	        int width = size.width / 4;
	        int startPoint = 1070;//(int) (size.getWidth() * 0.95);
	        int endPoint = 1;//(int) (size.getWidth() * 0.05);
	        new TouchAction(driver).press(PointOption.point(startPoint, width)).waitAction(WaitOptions
	        		.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(endPoint, width)).release().perform();
	        
	        Thread.sleep(1000);
	        // Click the skip button
	        driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.buuuk.st:id/skip']")).click();
	        Thread.sleep(15000);
			// close the add popup
	        
	        //Click on the left side menu button
	        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.buuuk.st:id/tv_login']")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.buuuk.st:id/et_ldap_login_username']"))
	        .sendKeys("digitaltest10");
	        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.buuuk.st:id/et_ldap_login_password']"))
	        .sendKeys("Sphdigital1");
	        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.buuuk.st:id/btn_ldap_login_continue']")).click();
	        Thread.sleep(2000);
	        
	        // Verify Login successful
	        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
	        Thread.sleep(1000);
	        WebElement loggedInUser = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.buuuk.st:id/tv_login_name']"));//
			//WebElement user = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div[2]/nav/div[2]/div/ul/li[1]/a"));
	        //System.out.println(loggedInUser.getText());
			Assert.assertEquals(loggedInUser.getText(),"Logged in as Digitaltest10");
	       
			driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.buuuk.st:id/iv_home']")).click();
			Thread.sleep(2000);
			//Tap on the “latest” tab and tap on the first article
			  driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.buuuk.st:id/tv_tab_title']")).click();
			 
			 
			 WebElement content = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.buuuk.st:id/article_title']"));
			 String expected = content.getText();
			 System.out.println("expected :" + expected);
			 content.click();
			 
			 // Touch on the screen to close the help alert
			 new TouchAction(driver).press(PointOption.point(746, 1808)).release().perform();
			 //Thread.sleep(4000);
			 
			//Verify that the article is loading successfully with images/videos.
			WebElement articleContent = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.buuuk.st:id/article_headline']"));
			Assert.assertEquals(expected, articleContent.getText());
	        Thread.sleep(2000);
	       
			WebElement imageFile = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.buuuk.st:id/article_image']"));
			
			Assert.assertTrue(imageFile.isDisplayed());
			System.out.println("Test Case Passed !!!");
			//Click on the left side menu button
	        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.buuuk.st:id/tv_logout']")).click();
	        Thread.sleep(1000);
			
			
	        driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured Test Case Failed");
			driver.quit();
		}
	}

	public static void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Honor 9N");
		// caps.setCapability(MobileCapabilityType.APP,
		// "com.buuuk.st");//sk.styk.martin.apkanalyzer

		caps.setCapability("appVersion", "6.8.3");

		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.0");
		caps.setCapability("skipUnlock", "true");

		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.buuuk.st"); // "");\"sk.styk.martin.apkanalyzer
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, // "com.sph.straitstimes.views.activities.TncActivity");
				"com.sph.straitstimes.views.activities.SplashActivity"); // "sk.styk.martin.apkanalyzer.ui.activity.MainActivity");

		caps.setCapability("noReset", "false");
		//caps.setCapability("automationName", "UiAutomator2"); 
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}

}
