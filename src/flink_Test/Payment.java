package flink_Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

public class Payment {

	private static final String CARD_NUMBER = "4242";
	private static final String EMAIL = "abc@gmail.com";
	private static final String CVV = "123";
	private static final String MONTH = "02";
	private static final String YEAR = "22";
	private static final String ZIP = "44287";

	public void addPaymentDetails(WebDriver driver) {
		WebElement payElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/button[1]"));

		payElement.click();

		addCardDetails(driver);
		
		

	}


	public void verifyPayment(WebDriver driver) throws AssertionError{
		driver.switchTo().defaultContent();
		String actualString = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/p[1]")).getText();
		Assert.assertTrue(actualString.contains("Your payment was successful"));
		
	}

	private void addCardDetails(WebDriver driver) {

		try {
			synchronized (driver) {

				driver.wait(5000);

				driver.switchTo().frame(0);

				WebElement emailInput = driver.findElement(By.id("email"));
				emailInput.sendKeys(EMAIL);

				WebElement cardInput = driver.findElement(By.id("card_number"));
				cardInput.sendKeys(CARD_NUMBER);
				cardInput.sendKeys(CARD_NUMBER);
				cardInput.sendKeys(CARD_NUMBER);
				cardInput.sendKeys(CARD_NUMBER);

				WebElement dateInput = driver.findElement(By.id("cc-exp"));
				dateInput.sendKeys(MONTH);
				dateInput.sendKeys(YEAR);

				WebElement cvvInput = driver.findElement(By.id("cc-csc"));
				cvvInput.sendKeys(CVV);

				WebElement zipInput = driver.findElement(By.id("billing-zip"));
				zipInput.sendKeys(ZIP);

				WebElement payButton = driver.findElement(By.id("submitButton"));
				payButton.click();

			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
