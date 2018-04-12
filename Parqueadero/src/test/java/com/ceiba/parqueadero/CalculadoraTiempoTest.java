package com.ceiba.parqueadero;

import static org.hamcrest.CoreMatchers.equalTo;
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
		double diferenciaEsperada= 1800.00;
		CalculadoraTiempo validaciones = new CalculadoraTiempo();
		
		//Act
		double diferenciaFechas = validaciones.calcularDiferenciaTiempoInSeconds(horaEntrada, horaSalida);
		
		//Assert
		assertEquals
		(0, Double.compare(diferenciaEsperada, diferenciaFechas));
	}

	@Test
	public void validarCalculoDias () {
		
	}
}
