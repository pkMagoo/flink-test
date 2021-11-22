package flink_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Cart {
	
	
	public void addToCart(WebDriver driver){
		
		WebElement cartElement = driver
				.findElement(By.xpath("/html[1]/body[1]/nav[1]/ul[1]/button[1]"));
		
		cartElement.click();
		
		
	}

	public void verifyCart(WebDriver driver) throws AssertionError{
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		Assert.assertEquals(rows.size(), 2);
		
	}

}
