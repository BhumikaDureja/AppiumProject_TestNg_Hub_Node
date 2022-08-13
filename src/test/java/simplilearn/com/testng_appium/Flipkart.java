package simplilearn.com.testng_appium;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;




import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flipkart {

	private AndroidDriver<MobileElement> driver;
	TouchAction touchAction;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "7.1.1");
		desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
		desiredCapabilities.setCapability("appium:app", "C:\\Users\\bhumika.dureja\\Downloads\\Flipkart-7.18(1).apk");
		//desiredCapabilities.setCapability("appium:appPackage", "com.google.android.dialer");
		//desiredCapabilities.setCapability("appium:appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);

		touchAction = new TouchAction(driver); 

		//	System.out.println(driver.getSessionId());

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

	}



	@Test
	public void sampleTest() throws Throwable  {
		Thread.sleep(6000);
		MobileElement EnglishLang = driver.findElementByXPath("//android.widget.RelativeLayout[4]");
		EnglishLang.click();
		
		MobileElement ContBtn = driver.findElementById("com.flipkart.android:id/select_btn");
		//other way to find location of ContBtn is by xpath, below can also be used
		//MobileElement ContBtn = driver.findElementByXPath("//android.widget.Button[@text='CONTINUE']");
		ContBtn.click(); 
	
		MobileElement XIcon = driver.findElementById("com.flipkart.android:id/custom_back_icon");
		XIcon.click();
		
		MobileElement SearchBox = driver.findElementById("com.flipkart.android:id/search_widget_textbox");
		SearchBox.click();
		
		MobileElement SearchBox1 = driver.findElementById("com.flipkart.android:id/search_autoCompleteTextView");
		SearchBox1.sendKeys("Laptop Bags");
		
		driver.findElementById("com.flipkart.android:id/root_titles").click();
		
	//	Actions action=new Actions(driver);
	//	action.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(3000);
		
	}



	@AfterTest
	public void tearDown() {
		driver.quit();
	} 
}


//CTRL +A, CTRL+I (for indentation)
