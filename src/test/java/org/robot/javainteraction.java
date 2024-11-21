package org.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class javainteraction 
{
  public void seleniumwithjava() throws AWTException, InterruptedException
  {
      System.setProperty("webdriver.chrome.driver", "D://chromedriver//chromedriver.exe");
       WebDriver driver =new ChromeDriver();
       driver.get("https://www.tinymce.com" );
       driver.manage().window().maximize();
       driver.findElement(By.xpath("(//div[contains(@aria-label,'Bold')]//i[contains(@class,'mce-i-bold')])[1]")).click();
       Robot r = new Robot();
       String text = "Welcome to the world of automation.";
       StringSelection stringSelection = new StringSelection(text);
       Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
       clipboard.setContents(stringSelection, stringSelection);
       // gdhwsfjshf
       //djsagdhsgf
       //hgsdh
        
       r.keyPress(KeyEvent.VK_CONTROL);
       r.keyPress(KeyEvent.VK_V);
       r.keyRelease(KeyEvent.VK_V);
       r.keyRelease(KeyEvent.VK_CONTROL);
        
       Thread.sleep(1000);
 
       String text1 = "Hope you enjoy This";
       StringSelection stringSelection1 = new StringSelection(text1);
       Clipboard clipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
       clipboard1.setContents(stringSelection1, stringSelection1);
 
       r.keyPress(KeyEvent.VK_CONTROL);
       r.keyPress(KeyEvent.VK_V);
       r.keyRelease(KeyEvent.VK_V);
       r.keyRelease(KeyEvent.VK_CONTROL);
       driver.findElement(By.xpath("(//div[contains(@aria-label,'Italic')]//i[contains(@class,'mce-i-italic')])[1]")).click();
  }
  public static void main(String args[]) throws AWTException, InterruptedException
  {
      javainteraction j1 = new javainteraction();
      j1.seleniumwithjava();
       
  }
}