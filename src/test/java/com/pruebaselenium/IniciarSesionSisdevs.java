package com.pruebaselenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IniciarSesionSisdevs extends Base {
	
	By txtUser = By.id("txtCorreo");
	By txtClave = By.id("txtClave");
	By btnIniciar = By.className("p-button");
	
	By itemInicioCorrecto = By.xpath("//img[@src='assets/layout/images/acopal.png']");
	
	// identificador de inventario
	By linkInventario = By.linkText("Inventario");
	
	// recorrer tabla
	List<TableDataCollection> listaTabla = new ArrayList<>();
	By tbThInventario = By.tagName("th");
	By tbTrInventario = By.tagName("tr");
	By tbTdInventario = By.tagName("td");
	
	public IniciarSesionSisdevs(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void iniciarSesion() {
		if (estaHabilitado(txtUser)) {
			limpiar(txtUser);
			limpiar(txtClave);
			escribir("user_02", txtUser);
			escribir("root2023*", txtClave);
			click(btnIniciar);
		} else {
			System.out.println("No esta visible la pagina");
		}
	}
	
	public boolean inicioCorrecto() {
		return estaListo(itemInicioCorrecto);
	}
	
	public void irAInventario() {
		if (inicioCorrecto()) {
			if (estaHabilitado(linkInventario)) {
				click(linkInventario);
			} else {
				irAInventario();
			}
		} else {
			System.out.println("No se puede continuar");
		}
	}
	
	public void recorrerLista() {
		listaTabla = new ArrayList<TableDataCollection>();
		
		List<WebElement> columnas = buscarElementos(tbThInventario);
		List<WebElement> filas = buscarElementos(tbTrInventario);
		
		int rowIndex = 0;
		for (WebElement row: filas) {
			int colIndex = 0;
			List<WebElement> datos = buscarElementos(tbTdInventario);
			System.out.println("Row: " + rowIndex);
			if (datos.size() != 0) {
				for (WebElement colValue : datos) {
					
					System.out.println("ColName: " + (!columnas.get(colIndex).getText().equals("") ? 
							columnas.get(colIndex).getText() : 
							String.valueOf(colIndex)));
					System.out.println("ColVal: " + colValue.getText());
					
					
					listaTabla.add(new TableDataCollection(rowIndex, 
							!columnas.get(colIndex).getText().equals("") ? 
							columnas.get(colIndex).getText() : 
							String.valueOf(colIndex), colValue.getText(), null));
				}
			}
			
		}
		
		
	}

}
