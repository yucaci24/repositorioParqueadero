package com.ceiba.parqueadero;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.ceiba.parqueadero.service.CalculadoraTiempo;


public class CalculadoraTiempoTest {

	@Test
	public void validarCalculoDiferenciaSegundos () throws ParseException {
		//Arrange
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date horaEntrada = format.parse("10/03/2018 12:20");
		Date horaSalida = format.parse("10/03/2018 12:50");
		double diferenciaEsperada= 1800.0;
		CalculadoraTiempo validaciones = new CalculadoraTiempo();
		
		//Act
		double diferenciaFechas = validaciones.calcularDiferenciaTiempoInSeconds(horaEntrada, horaSalida);
		
		//Assert
		assertEquals(0, Double.compare(diferenciaEsperada, diferenciaFechas));
	}

	@Test
	public void validarCalculo1DiaOMas () {
		//Arrange
		double tiempoEnSegundos = 172800.00;
		double cantidadDiasEsperado = 2;
		CalculadoraTiempo validaciones = new CalculadoraTiempo();
		
		//Act
		double cantidadDias = validaciones.calcularDias(tiempoEnSegundos);
		
		//Assert
		assertEquals(0, Double.compare(cantidadDiasEsperado, cantidadDias));
	}
	
	
	@Test
	public void validarCalculoMenos1Dia () {
		//Arrange
		double tiempoEnSegundos = 86300.00;
		double cantidadDiasEsperado = 0;
		CalculadoraTiempo validaciones = new CalculadoraTiempo();
		
		//Act
		double cantidadDias = validaciones.calcularDias(tiempoEnSegundos);
		
		//Assert
		assertEquals(0, Double.compare(cantidadDiasEsperado, cantidadDias));
	}
	
	@Test
	public void validarCalculo1HoraOMas () {
		//Arrange
		double tiempoEnSegundos = 7200.00;
		double cantidadHorasEsperado = 2;
		CalculadoraTiempo validaciones = new CalculadoraTiempo();
		
		//Act
		double cantidadHoras = validaciones.calcularHoras(tiempoEnSegundos);
		
		//Assert
		assertEquals(0, Double.compare(cantidadHorasEsperado, cantidadHoras));
	}
	
	@Test
	public void validarCalculoMenos1Hora () {
		//Arrange
		double tiempoEnSegundos = 3500.00;
		double cantidadHorasEsperado = 0;
		CalculadoraTiempo validaciones = new CalculadoraTiempo();
		
		//Act
		double cantidadHoras = validaciones.calcularHoras(tiempoEnSegundos);
		
		//Assert
		assertEquals(0, Double.compare(cantidadHorasEsperado, cantidadHoras));
	}
	
	@Test
	public void validarCalculoMenos1minuto () {
		//Arrange
		double tiempoEnSegundos = 50.00;
		double cantidadMinutosEsperado = 0;
		CalculadoraTiempo validaciones = new CalculadoraTiempo();
		
		//Act
		double cantidadMinutos = validaciones.calcularPorMinutos(tiempoEnSegundos);
		
		//Assert
		assertEquals(0, Double.compare(cantidadMinutosEsperado, cantidadMinutos));
	}
	
	@Test
	public void validarCalculoMas1minuto () {
		//Arrange
		double tiempoEnSegundos = 120.00;
		double cantidadMinutosEsperado = 2;
		CalculadoraTiempo validaciones = new CalculadoraTiempo();
		
		//Act
		double cantidadMinutos = validaciones.calcularPorMinutos(tiempoEnSegundos);
		
		//Assert
		assertEquals(0, Double.compare(cantidadMinutosEsperado, cantidadMinutos));
	}
}
