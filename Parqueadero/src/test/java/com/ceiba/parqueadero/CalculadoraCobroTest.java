package com.ceiba.parqueadero;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ceiba.parqueadero.service.CalculadoraCobro;
import com.ceiba.parqueadero.service.ParametrosParqueadero;

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
	
	@Test
	public void validarCobroMinutos0 () {
		//Arrange
		int cantidadMinutos = 0;
		int cobroHora = 500;
		CalculadoraCobro validaciones = new CalculadoraCobro();
		
		//Act
		long cobroMinutos = validaciones.calcularCobroPorMinutos(cantidadMinutos, cobroHora);
		
		//Assert
		assertEquals(500, cobroMinutos);
	}
	
	@Test
	public void validarCobroMinutosNegativo () {
		//Arrange
		int cantidadMinutos = -1;
		int cobroHora = 500;
		CalculadoraCobro validaciones = new CalculadoraCobro();
		
		//Act
		long cobroMinutos = validaciones.calcularCobroPorMinutos(cantidadMinutos, cobroHora);
		
		//Assert
		assertEquals(0, cobroMinutos);
	}
	
	@Test
	public void validarCalcularCobroTotalMoto () {
		CalculadoraCobro validaciones = new CalculadoraCobro();
		long diferenciaFechas = 120584;
		
		long total = validaciones.calcularTotal(diferenciaFechas, ParametrosParqueadero.COBRO_DIA_MOTO, ParametrosParqueadero.COBRO_HORA_MOTO);
		
		assertEquals(9000, total);
	}
}
