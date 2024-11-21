 package org.sampleprojects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class appiumMethods {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException, AWTException {
		AppiumDriverLocalService build = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\lenovo\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		
		build.start();
		
		UiAutomator2Options uiautomator2options = new UiAutomator2Options();
		
		uiautomator2options.setCapability("devicename", "Medium");
		uiautomator2options.setCapability("app", "C:\\Users\\lenovo\\Downloads\\ApiDemos-debug.apk");
		
		AndroidDriver driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/ "),uiautomator2options);
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Auto Complete")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Screen Top")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("India");
		
		DeviceRotation devicerotation = new DeviceRotation(0,0,90);
		driver.rotate(devicerotation);
		Thread.sleep(2000); 
		
	   driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
	   DeviceRotation devicerotation1 = new DeviceRotation(90,0,0);
	   driver.rotate(devicerotation1);
	   driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
		
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click(); 
		
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		js.executeScript("mobile:dragGesture",ImmutableMap.of("elementId",((RemoteWebElement)source).getId(),"endX",628,"endY",559));
		
		String text = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		 if(text.equals("Dropped!")) {
			 
			 System.out.println("print matched");
		 } else
		 {
			 System.out.println("not matched");
		 }
		
		 driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
		 
		 driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		 driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		 WebElement secondimage = driver.findElement(By.xpath("//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));
		 
		 js.executeScript("mobile:swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)secondimage).getId(),"direction","left","percent",0.75));
		 
		 driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
		 System.out.println("hhhhhh");
		 driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
		 
		 driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		 driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		 WebElement src = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		 js.executeScript("mobile:longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)src).getId(),"duration",3000));
		
	
		//driver.close();
		
		
		
		
	}

}
