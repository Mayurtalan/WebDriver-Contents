import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableData {

	public TableData() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int sum = 0;
		System.setProperty("webdriver.chrome.driver", "D:\\Testing Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/23907/ben-vs-odsa-2nd-quarter-final-ranji-trophy-2019-20");

		WebElement table = driver.findElement(By.id("innings_1"));

		int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
		for (int i = 0; i < count - 2; i++) {
			String str = table.findElements(By.cssSelector(
					"div[class='cb-col cb-col-100 cb-scrd-itms'] div[class='cb-col cb-col-8 text-right text-bold']"))
					.get(i).getText();
			int temp = Integer.parseInt(str);
			sum += temp;
		}

		String Ext = table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		int ExtraRun = Integer.parseInt(Ext);
		sum = sum + ExtraRun;
		System.out.println(sum);
	}

}
