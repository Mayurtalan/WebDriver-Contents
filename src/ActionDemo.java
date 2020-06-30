import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {

	public ActionDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");
		Actions action = new Actions(driver);

		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		action.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click()
				.keyDown(Keys.SHIFT).sendKeys("mayur").contextClick();
		action.moveToElement(move).contextClick().build().perform();

	}

}
