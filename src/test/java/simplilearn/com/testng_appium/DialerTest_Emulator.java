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

public class DialerTest_Emulator {

	private AndroidDriver<MobileElement> driver;
	TouchAction touchAction;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "7.1.1");
		desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
		//desiredCapabilities.setCapability("appium:app", "C:\\Users\\bhumika.dureja\\Downloads\\ApiDemos-debug.apk");
		desiredCapabilities.setCapability("appium:appPackage", "com.google.android.dialer");
		desiredCapabilities.setCapability("appium:appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
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


	int a7__dialer_x= 240;
	int a7__dialer_y= 750; 

	public void clickDiapadButton(String num) {


		driver.findElementByXPath("//android.widget.TextView[@text='"+num+"']").click();

	}

	@Test
	public void sampleTest() throws Throwable  {


		//	driver.findElementById("com.google.android.dialer:id/floating_action_button_container").click();  
		// instead of ID (above statement) we can click DialerButton by tapping using x,y cordinates, like below. Cordinates are initailised above

		touchAction.tap(PointOption.point(240, 750)).perform();
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
