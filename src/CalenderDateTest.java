import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderDateTest {

	public CalenderDateTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.id("travel_date")).click();

		while (!driver.findElement(By.className("datepicker-switch")).getText().contains("July")) {
			driver.findElement(By.cssSelector("th.next")).click();
		}

		int count = driver.findElements(By.className("day")).size();

		// List<WebElement> list = driver.findElements(By.className("day"));

		for (int i = 1; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();

			if (text.equalsIgnoreCase("10")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}

	}

}
