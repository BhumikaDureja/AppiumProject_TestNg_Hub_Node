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
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DialerTest_RealDevice {

	private AndroidDriver<MobileElement> driver;
	TouchAction touchAction;
	
/*	int a11__dialer_x= 1200;
	   int a11__dialer_y= 2000;
	   
	   

	   int a7__dialer_x= 1200;
	   int a7__dialer_y= 2000; */

   @BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "8.0.0");
		desiredCapabilities.setCapability("appium:deviceName", "Galaxy A8 (2018)");
		//desiredCapabilities.setCapability("appium:app", "C:\\Users\\bhumika.dureja\\Downloads\\ApiDemos-debug.apk");
		  desiredCapabilities.setCapability("appium:appPackage", "com.samsung.android.contacts");
		    desiredCapabilities.setCapability("appium:appActivity", "com.android.dialer.DialtactsActivity");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		URL remoteUrl = new URL("http://localhost:4444/wd/hub");

		driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);

		touchAction = new TouchAction(driver); 

	//	System.out.println(driver.getSessionId());
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

	}

   
   public void clickDiapadButton(String num) {
		  
		
	   driver.findElementByXPath("//android.widget.TextView[@text='"+num+"']").click();
		  
	  }

   @Test
   public void sampleTest() throws Throwable  {
		  clickDiapadButton("5");
		  clickDiapadButton("4");
		  clickDiapadButton("3");
		  clickDiapadButton("2");
		  
	  }



  	@AfterTest
	public void tearDown() {
		driver.quit();
	} 
}


//CTRL +A, CTRL+I (for indentation)
