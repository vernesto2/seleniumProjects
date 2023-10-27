package com.pruebaselenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IniciarSesionTest {
	
	private WebDriver driver;
	IniciarSesionSisdevs iniciarSisDevs;
	
	@Before
	public void setUp() throws Exception{
		iniciarSisDevs = new IniciarSesionSisdevs(driver);
		driver = iniciarSisDevs.chromeDriverConnection();
		iniciarSisDevs.visitar("http://sisdevs.com/#/login");
	}
	
	@Test
	public void test() throws InterruptedException {
		iniciarSisDevs.iniciarSesion();
		Thread.sleep(8000);
		iniciarSisDevs.irAInventario();
		Thread.sleep(3000);
		iniciarSisDevs.recorrerLista();
	}
	
	@After
	public void quitar() {
		//driver.quit();
	}
	

}
