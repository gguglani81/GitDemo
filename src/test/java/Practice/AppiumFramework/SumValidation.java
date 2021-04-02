package Practice.AppiumFramework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.FormPage;
import pageObjects.Utilities;
import pageObjects.checkoutPage;

public class SumValidation extends EcommBase {
	static double inum = 0;

	@Test

	public void totalValidation() throws IOException, InterruptedException {
		service = startServer();
		Thread.sleep(6000);

		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		FormPage fp = new FormPage(driver);
		// fp.country.click();
		fp.getCountry().click();
		Utilities ut = new Utilities(driver);
		ut.scrollToText("Bahamas");
		fp.algeria.click();
		fp.name.sendKeys("Gaurav");
		fp.female.click();
		driver.hideKeyboard();
		fp.letsshop.click();

		/*
		 * driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"))
		 * .click(); driver.
		 * findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Algeria\"));"
		 * ); driver.findElement(By.xpath("//*[@text='Algeria']")).click();
		 * driver.findElement(By.xpath("//*[@text='Enter name here']")).sendKeys(
		 * "Gaurav"); driver.findElement(By.xpath("//*[@text='Female']")).click();
		 * driver.hideKeyboard();
		 * driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).
		 * click();
		 */

		checkoutPage cp = new checkoutPage(driver);
		for (int i = 0; i < 2; i++)
			cp.add.get(i).click();
		// driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
		cp.cart.click();
		// driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String sum = null;
		List<WebElement> k = cp.price;
		// List<AndroidElement> k =
		// driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		for (int j = 0; j < k.size(); j++) {
			sum = k.get(j).getText();
			sum = sum.substring(1);
			inum = inum + Double.parseDouble(sum);

		}
		String comp = cp.total.getText();
		// String comp =
		// driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		comp = comp.substring(1);
		double dest = Double.parseDouble(comp);
		System.out.println(inum);
		System.out.println(comp);
		Assert.assertEquals(inum, dest);
		service.stop();
	}

}
