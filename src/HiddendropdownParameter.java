import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddendropdownParameter {

	public HiddendropdownParameter() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://ksrtc.in/oprs-web/");

		driver.findElement(By.id("fromPlaceName")).sendKeys("BEN");
		Thread.sleep(2000);
		driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);

		System.out.println(driver.findElement(By.id("fromPlaceName")).getText());

		// javascript mDOM can extract hidden element.
		// Because Selenium can not identified hidden element. ie (AJAX Element).
		// for that we use JavascriptExecutor

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String script = "return document.getElementById(\"fromPlaceName\").value;";

		String str = (String) js.executeScript(script);
		int j = 0;
		while (!str.equalsIgnoreCase("MOTEBENNUR")) {
			j++;
			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
			str = (String) js.executeScript(script);
			if (j > 10) {
				break;
			}
		}

		if (j < 10) {
			System.out.println("Item is Found");
		} else {
			System.out.println("Not Found");
		}

	}

}
