import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OTPEmailAutomate {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.findElement(By.cssSelector("a[class='signin']")).click();
		driver.findElement(By.cssSelector("input[name='login']")).sendKeys("**Email Address**");
		driver.findElement(By.cssSelector("input[name='passwd']")).sendKeys("**Password**");
		driver.findElement(By.cssSelector("input[class='signinbtn']")).click();
		Thread.sleep(5000);
		List<WebElement> al = driver.findElements(By.xpath("//div[@class='rd_mail_listing'] //ul//li"));
		System.out.println(al.size());
		
		for (int i = 0; i < al.size(); i++) {
			List<WebElement> bb = driver.findElements(By.xpath("//div[@class='rd_mail_listing'] //ul//li //span[@class='rd_from']"));
		//	System.out.println(bb.get(i).getText());
			if (bb.get(i).getText().equalsIgnoreCase("Search mail subject")) {
//Click the email 
				bb.get(i).click();
				Thread.sleep(5000);
				String str = driver.findElement(By.xpath("//div[@class='ng_mail_text'] //b[3]")).getText();
				System.out.println(str);
				break;
			}
			

		}

	}

}
