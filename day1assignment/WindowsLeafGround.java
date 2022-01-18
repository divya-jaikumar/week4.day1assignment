package week4.day1assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsLeafGround {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		
		//load the url
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("home")).click();
		String ParentWindow = driver.getWindowHandle();
		System.out.println(ParentWindow);
		
		Set<String> Windows = driver.getWindowHandles();
		for (String string : Windows) {
			System.out.println(string);
		}
		
		List<String> listwindows=new ArrayList<String>(Windows);
	    String child = listwindows.get(1);
	    
	    driver.switchTo().window(child);
	    driver.close();
	    
	    driver.switchTo().window(ParentWindow);
	    //click on open multiple windows
	    driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
	    Set<String> Windows1 = driver.getWindowHandles();
		for (String string1 : Windows1) {
			System.out.println(string1);
		}
		List<String> listwindows1=new ArrayList<String>(Windows1);
	     int size = listwindows1.size();
	    System.out.println("total number of windows"+size);
	    
	    driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
	    driver.switchTo().window(listwindows1.get(1));
	    driver.close();
	    driver.switchTo().window(listwindows1.get(2));
	    driver.close();
	    driver.switchTo().window(ParentWindow);
	    
	    //wait for 5 secs to open
	    driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
	    Thread.sleep(5000);
	    driver.close();
	   
	    

	}

}
