package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSeleniumTest {
	public static AppiumDriver<MobileElement> driver;
	public static WebDriverWait wait;

	public static void main(String[] args) {
		try {
			setup();

			// Tap on “LOGIN” button and login with the ID and password
			driver.findElement(in.Repo.obj("Login_page.Login_Id").sendKeys("digitaltest10"));
			driver.findElement(in.Repo.obj("Login_page.Password").sendKeys("Sphdigital1"));
			driver.findElement(in.Repo.obj("Login_page.Continue")).click();
			
			// Getting SecurityException while launching the app from appium : application is not allowing to launch from test app.
			/** C:\Users\LENOVO>adb shell am start -n  com.buuuk.st/com.sph.straitstimes.views.activities.MainContainerActivity
			Starting: Intent { cmp=com.buuuk.st/com.sph.straitstimes.views.activities.MainContainerActivity }
			Security exception: Permission Denial: starting Intent { flg=0x10000000 cmp=com.buuuk.st/com.sph.straitstimes.views.activities.MainContainerActivity } from null (pid=9064, uid=2000) not exported from uid 10158

			java.lang.SecurityException: Permission Denial: starting Intent { flg=0x10000000 cmp=com.buuuk.st/com.sph.straitstimes.views.activities.MainContainerActivity } from null (pid=9064, uid=2000) not exported from uid 10158
			*/
			
			//verify the user has logged in
			
			//Tap on the “latest” tab and tap on the first article
			
			//Verify that the article is loading successfully with images/videos.

		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("Exception occured Test Case Failed");
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
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"com.sph.straitstimes.views.activities.MainContainerActivity"); // "sk.styk.martin.apkanalyzer.ui.activity.MainActivity");

		caps.setCapability("noReset", "false");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}

}
