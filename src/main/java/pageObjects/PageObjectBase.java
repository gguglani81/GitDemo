package pageObjects;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class PageObjectBase {
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

		AndroidDriver<AndroidElement> driver;

		// TODO Auto-generated method stub
		File appDir = new File("src");
		File app = new File(appDir, "ApiDemos-debug.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		capabilities.setCapability("autoGrantPermissions", true);
		//capabilities.setCapability("noReset", "false");
		//capabilities.setCapability("fullReset", "true");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
		return driver;
	
	}

}
