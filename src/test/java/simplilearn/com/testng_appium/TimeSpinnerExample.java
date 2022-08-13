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

public class TimeSpinnerExample {

	private AndroidDriver<MobileElement> driver;
	TouchAction touchAction;

   @BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "7.1.1");
		desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
		//desiredCapabilities.setCapability("appium:app", "C:\\Users\\bhumika.dureja\\Downloads\\ApiDemos-debug.apk");
		  desiredCapabilities.setCapability("appium:appPackage", "io.appium.android.apis");
		    desiredCapabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
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


	public MobileElement getTextViewByContentDesc(String contentDesc) {

		return (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\""+ contentDesc +"\"]");
	}





    @Test
	public void TimeSpinner() throws Throwable {
		getTextViewByContentDesc("Views").click();
		getTextViewByContentDesc("Date Widgets").click();
		getTextViewByContentDesc("1. Dialog").click();
		
		driver.findElementByXPath("//android.widget.Button[@content-desc=\"change the time (spinner)\"]").click();
	
		   MobileElement CenterButton= (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.EditText");
	        System.out.println("CenterButton text ="+CenterButton.getAttribute("text"));
	        System.out.println("CenterButton position X ="+CenterButton.getCenter().getX());
	        System.out.println("CenterButton position Y ="+CenterButton.getCenter().getY());
	        
	        MobileElement DownButton = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[1]/android.widget.Button[2]");
	        System.out.println("DownButton text ="+DownButton.getAttribute("text"));
	        System.out.println("DownButton position X ="+DownButton.getCenter().getX());
	        System.out.println("DownButton position Y ="+DownButton.getCenter().getY());
	        
	        int startX=DownButton.getCenter().getX();
	        int startY=DownButton.getCenter().getY();
	        
	        int endX=CenterButton.getCenter().getX();
	        int endY=CenterButton.getCenter().getY()-400;
	        endY= startY-100;
	        System.out.println("StartY ="+startY);
	        System.out.println("endY ="+endY);
	        
	        Thread.sleep(2000);
	        
	        TouchAction touchAction = new TouchAction(driver);
	        
	        touchAction
	        .press(PointOption.point(startX,startY))
	        .moveTo(PointOption.point(startX,endY))
	        .release()
	        .perform();

	}


  	@AfterTest
	public void tearDown() {
		driver.quit();
	} 
}


//CTRL +A, CTRL+I (for indentation)
