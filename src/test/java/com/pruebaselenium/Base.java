package com.pruebaselenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	private WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver chromeDriverConnection() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebElement buscarElemento(By item) {
		return driver.findElement(item);
	}
	
	public List<WebElement> buscarElementos(By item) {
		return driver.findElements(item);
	}
	
	public String obtenerTexto(WebElement item) {
		return item.getText();
	}
	
	public String obtenerTexto(By item) {
		return driver.findElement(item).getText();
	}
	
	public void escribir(String texto, By item) {
		driver.findElement(item).sendKeys(texto);
	}
	
	public void limpiar(By item) {
		driver.findElement(item).clear();
	}
	
	public void click(By item) {
		driver.findElement(item).click();
	}
	
	public Boolean estaListo(By item) {
		try {
			return driver.findElement(item).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public Boolean estaSeleccionado(By item) {
		try {
			return driver.findElement(item).isSelected();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public Boolean estaHabilitado(By item) {
		try {
			return driver.findElement(item).isEnabled();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void visitar(String url) {
		driver.get(url);
	}
	
}
