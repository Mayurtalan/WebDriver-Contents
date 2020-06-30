import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DropDownEnter {

	public DropDownEnter() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.makemytrip.com/");
		Thread.sleep(4000);
		driver.findElement(By.id("fromCity")).sendKeys("mum");
		Thread.sleep(2000);
		for (int i = 1; i < 4; i++) {
			// driver.findElement(By.id("fromCity")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(Keys.ARROW_DOWN);
		}

		Thread.sleep(2000);
		driver.findElement(By.id("fromCity")).sendKeys(Keys.ENTER);

		// WebElement source = driver.findElement(By.id("fromCity"));
		// source.clear();
		//
		// source.sendKeys("mum");
		// source.sendKeys(Keys.ENTER);
		//

	}

}
