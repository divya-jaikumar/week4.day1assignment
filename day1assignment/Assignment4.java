package week4.day1assignment;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		//launch the browser    
		ChromeDriver driver=new ChromeDriver();
		
		//load the url
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		

		driver.switchTo().frame(0);
		WebElement clickbutton = driver.findElement(By.xpath("//button[text()='Click Me']"));
		File source1 = clickbutton.getScreenshotAs(OutputType.FILE);
		File destination1=new File("./images/click.png");
		FileUtils.copyFile(source1, destination1);
		
		driver.switchTo().defaultContent();
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
	      System.out.println(frames.size());
		
				


	}

}
