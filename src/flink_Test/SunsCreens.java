package flink_Test;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SunsCreens {
	
	public void buySunCreens(WebDriver driver) {
		
		driver.findElement(By.linkText("Buy sunscreens")).click();

		List<WebElement> elements = driver
				.findElements(By.xpath("//div[@class='text-center col-4']/p[@class='font-weight-bold top-space-10']"));
		
		addSuncreenSPF50(elements);
		addSuncreenSPF30(elements);
		
	}

	private void addSuncreenSPF50(List<WebElement> elements) {
		List<WebElement> aloeElements = elements.stream().filter(element -> element.getText().contains("SPF-50"))
				.collect(Collectors.toList());

		TreeMap<Integer, WebElement> priceElementMap = new TreeMap<Integer, WebElement>();

		for (WebElement aloe : aloeElements) {
			System.out.println(aloe.getText());
			WebElement priceTag = aloe.findElement(By.xpath("following-sibling::*"));
			System.out.println(priceTag.getText().replaceAll("\\D+", ""));

			priceElementMap.put(Integer.parseInt(priceTag.getText().replaceAll("\\D+", "")), aloe);

		}

		addToCartCheapestItem(priceElementMap);
		
	}
	
	private void addSuncreenSPF30(List<WebElement> elements){
		
		List<WebElement> almondElements = elements.stream().filter(element -> element.getText().contains("SPF-30"))
				.collect(Collectors.toList());
		TreeMap<Integer, WebElement> priceElementMap = new TreeMap<Integer, WebElement>();

		for (WebElement aloe : almondElements) {
			System.out.println(aloe.getText());
			WebElement priceTag = aloe.findElement(By.xpath("following-sibling::*"));
			System.out.println(priceTag.getText().replaceAll("\\D+", ""));

			priceElementMap.put(Integer.parseInt(priceTag.getText().replaceAll("\\D+", "")), aloe);

		}

		addToCartCheapestItem(priceElementMap);
	}
	
	private void addToCartCheapestItem(TreeMap<Integer, WebElement> priceElementMap)
	{
		Integer lowestPrice = priceElementMap.keySet().iterator().next();
		WebElement elememtToAdd = priceElementMap.get(lowestPrice);
		WebElement addToCartButton = elememtToAdd.findElement(By.xpath("following-sibling::*"))
				.findElement(By.xpath("following-sibling::*"));
		
		System.out.println(priceElementMap.keySet().iterator().next().toString());

		System.out.println(addToCartButton.getText());

		addToCartButton.click();
	}

}
