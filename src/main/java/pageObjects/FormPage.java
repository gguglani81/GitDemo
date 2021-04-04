package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	public FormPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement country;
	
	@AndroidFindBy(xpath = "//*[@text='Bahamas']")
	public WebElement algeria;
	@AndroidFindBy(xpath = "//*[@text='Enter name here']")
	public WebElement name;
	@AndroidFindBy(xpath = "//*[@text='Female']")
	public WebElement female;
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement letsshop;
	
	public WebElement getCountry() {
		System.out.println("Clicking the Country");
		System.out.println("making the changes");
		System.out.println("Committing the changes");
		return country;
	}
	
	
	
	

}
