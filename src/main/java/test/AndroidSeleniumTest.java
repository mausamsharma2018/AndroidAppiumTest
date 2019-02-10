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
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSeleniumTest {
	//private static AndroidDriver driver;
	public static AppiumDriver<MobileElement> driver;
    public static WebDriverWait wait;


	public static void main(String[] args) {
		try {
			setup();
			
			driver.findElement(in.Repo.obj("Login_page.Login_Id").sendKeys("digitaltest10"));
			driver.findElement(in.Repo.obj("Login_page.Password").sendKeys("Sphdigital1"));
			driver.findElement(in.Repo.obj("Login_page.Continue")).click();
			
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("Exception occured Test Case Failed");
		}
	}
	
	public static void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Honor 9N");
        //caps.setCapability(MobileCapabilityType.APP, "com.buuuk.st");//sk.styk.martin.apkanalyzer
       
        caps.setCapability("appVersion", "6.8.3");
       
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0");
        caps.setCapability("skipUnlock","true");

        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.buuuk.st"); // "");\"sk.styk.martin.apkanalyzer
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.sph.straitstimes.views.activities.MainContainerActivity"); //"sk.styk.martin.apkanalyzer.ui.activity.MainActivity");
        
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }
 

}
