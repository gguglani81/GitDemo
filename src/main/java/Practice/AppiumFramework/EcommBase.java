package Practice.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class EcommBase {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;

	public AppiumDriverLocalService startServer() {
		//
		boolean flag = checkIfServerIsRunnning(4723);
		if (!flag) {

			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;

	}

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static void startEmulator() throws IOException, InterruptedException {

		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\emulator.bat");
		Thread.sleep(10000);
	}

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		// prop.get(appName);

		// TODO Auto-generated method stub
		DesiredCapabilities capabilities = new DesiredCapabilities();
		File appDir = new File("src");
		File app = new File(appDir, (String) prop.get(appName));
		//String dev = (String) prop.get("device");
		//String dev = System.getProperty("android.device");
	String dev = System.getProperty("deviceName");
		System.out.println(dev);
		System.out.println("hello");
		if (dev.contains("Emulator")) {
			startEmulator();
		}
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, dev);
		// capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		// capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		return driver;

	}

	public static void getScreenshot(String testFailureName) throws IOException {
		File src = driver.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\reports\\" + testFailureName + ".png";
		FileUtils.copyFile(src, new File(destination));

	}

}
