package week4.day1assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		
		//load the url
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//click on alert box
				driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
				
				Thread.sleep(3000);
				//Accept the alert
				Alert alert = driver.switchTo().alert();
				
				//Get alert Text
				String text = alert.getText();
				System.out.println(text);
				
				
				alert.accept();
				driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
				Thread.sleep(3000);
				Alert alert1 = driver.switchTo().alert();
				alert1.dismiss();
				
				driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
				Alert alert2 = driver.switchTo().alert();

				//Enter the text in prompt alert
				alert2.sendKeys("SVS");
				alert2.accept();
				
//				driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
//				Alert alert3 = driver.switchTo().alert();
//				alert3.accept();
				
				//Sweet alert
				driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[text()='OK']")).click();
				
				//get the text
				String text1 = driver.findElement(By.xpath("//div[@class='swal-text']")).getText();
				System.out.println(text1);
				
				
				//alert.dismiss();  

	}

}
