package flink_Test;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Moisturizer {
	
	public void buyMoisturizer(WebDriver driver) {
		
		driver.findElement(By.linkText("Buy moisturizers")).click();

		List<WebElement> elements = driver
				.findElements(By.xpath("//div[@class='text-center col-4']/p[@class='font-weight-bold top-space-10']"));
		
		addAloeMoisturizer(elements);
		addAlmondMoisturizer(elements);
		
	}

	private void addAloeMoisturizer(List<WebElement> elements) {
		List<WebElement> aloeElements = elements.stream().filter(element -> element.getText().contains("Aloe"))
				.collect(Collectors.toList());

		TreeMap<Integer, WebElement> valuePriceMap = new TreeMap<Integer, WebElement>();

		for (WebElement aloe : aloeElements) {
			System.out.println(aloe.getText());
			WebElement priceTag = aloe.findElement(By.xpath("following-sibling::*"));
			System.out.println(priceTag.getText().replaceAll("\\D+", ""));

			valuePriceMap.put(Integer.parseInt(priceTag.getText().replaceAll("\\D+", "")), aloe);

		}

		Integer lowestPrice = valuePriceMap.keySet().iterator().next();
		WebElement elememtToAdd = valuePriceMap.get(lowestPrice);
		WebElement addToCartButton = elememtToAdd.findElement(By.xpath("following-sibling::*"))
				.findElement(By.xpath("following-sibling::*"));
		
		System.out.println(valuePriceMap.keySet().iterator().next().toString());

		System.out.println(addToCartButton.getText());

		addToCartButton.click();
	}
	
	private void addAlmondMoisturizer(List<WebElement> elements){
		
		List<WebElement> almondElements = elements.stream().filter(element -> element.getText().contains("Almond"))
				.collect(Collectors.toList());
		TreeMap<Integer, WebElement> valuePriceMap = new TreeMap<Integer, WebElement>();

		for (WebElement aloe : almondElements) {
			System.out.println(aloe.getText());
			WebElement priceTag = aloe.findElement(By.xpath("following-sibling::*"));
			System.out.println(priceTag.getText().replaceAll("\\D+", ""));

			valuePriceMap.put(Integer.parseInt(priceTag.getText().replaceAll("\\D+", "")), aloe);

		}

		Integer lowestPrice = valuePriceMap.keySet().iterator().next();
		WebElement elememtToAdd = valuePriceMap.get(lowestPrice);
		WebElement addToCartButton = elememtToAdd.findElement(By.xpath("following-sibling::*"))
				.findElement(By.xpath("following-sibling::*"));

		addToCartButton.click();
	}

}
