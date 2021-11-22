package flink_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSuitInit {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://weathershopper.pythonanywhere.com/");

		int temp = Integer.parseInt(driver.findElement(By.id("temperature")).getText().replaceAll("\\D+", ""));

		if (temp > 34) {
			SunsCreens sunCreens = new SunsCreens();
			sunCreens.buySunCreens(driver);
		} else if (temp < 19) {
			Moisturizer moisturizer = new Moisturizer();
			moisturizer.buyMoisturizer(driver);
		} else {
			System.out.println("Do Nothing!");
		}

		try {

			Cart cart = new Cart();
			cart.addToCart(driver);
			cart.verifyCart(driver);

			Payment payment = new Payment();
			payment.addPaymentDetails(driver);
			payment.verifyPayment(driver);
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}

		driver.quit();

	}

}
