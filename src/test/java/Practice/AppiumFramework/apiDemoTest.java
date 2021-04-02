package Practice.AppiumFramework;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Practice.AppiumFramework.EcommBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import pageObjects.Dependencies;
import pageObjects.HomePage;
import pageObjects.Prefernces;
import resources.DataProv;

public class apiDemoTest extends EcommBase {

	@Test(dataProvider="testdata",dataProviderClass=DataProv.class)
	public void apiDemo(String name) throws IOException, InterruptedException {
		service=startServer();
		AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		HomePage hp = new HomePage(driver);
		hp.prefer.click();
		Prefernces pr = new Prefernces(driver);
		pr.depend.click();
		Dependencies dp = new Dependencies(driver);
		dp.check.click();
		dp.layout.click();
		dp.edittext.sendKeys(name);
		pr.buttons.get(1).click();
		service.stop();
			}
	@BeforeTest
	public void killNodes() throws IOException, InterruptedException {
	Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	Thread.sleep(6000);
	}
}