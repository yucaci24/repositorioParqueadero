package com.ceiba.parqueadero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ceiba.parqueadero.service.CalculadoraCobro;

public class CalculadoraCobroTest {
	
	@Test
	public void validarCobroDia () {
		//Arrange
		int cantidadDias = 3;
		int cobroDia = 4000;
		CalculadoraCobro validaciones = new CalculadoraCobro();
		
		//Act
		long cobroDias = validaciones.calcularCobroPorDia(cantidadDias, cobroDia);
		
		//Assert
		assertEquals(12000, cobroDias);
	}
	
	@Test
	public void validarCobroHoraMas9 () {
		//Arrange
		int cantidadHoras = 10;
		int cobroHora = 500;
		int cobroDia = 4000;
		CalculadoraCobro validaciones = new CalculadoraCobro();
		
		//Act
		long cobroHoras = validaciones.calcularCobroPorHoras(cantidadHoras, cobroHora, cobroDia);
		
		//Assert
		assertEquals(4000, cobroHoras);
	}
	
	@Test
	public void validarCobroHoraMenos9 () {
		//Arrange
		int cantidadHoras = 5;
		int cobroHora = 500;
		int cobroDia = 4000;
		CalculadoraCobro validaciones = new CalculadoraCobro();
		
		//Act
		long cobroHoras = validaciones.calcularCobroPorHoras(cantidadHoras, cobroHora, cobroDia);
		
		//Assert
		assertEquals(2500, cobroHoras);
	}

	@Test
	public void validarCobroMinutos () {
		//Arrange
		int cantidadMinutos = 20;
		int cobroHora = 500;
		CalculadoraCobro validaciones = new CalculadoraCobro();
		
		//Act
		long cobroMinutos = validaciones.calcularCobroPorMinutos(cantidadMinutos, cobroHora);
		
		//Assert
		assertEquals(500, cobroMinutos);
	}
	
	
}
