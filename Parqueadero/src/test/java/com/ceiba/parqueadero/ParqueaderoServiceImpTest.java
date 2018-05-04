package com.ceiba.parqueadero;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.parqueadero.model.ReciboPago;
import com.ceiba.parqueadero.service.ComprobacionesEntradaYSalidaVehiculos;
import com.ceiba.parqueadero.service.ParqueaderoService;

public class ParqueaderoServiceImpTest {
	
	@Autowired
	ParqueaderoService validaciones;
	
	@Autowired
	ComprobacionesEntradaYSalidaVehiculos otrasValidaciones;
	
	@Before
	public void setUp () {
		validaciones = Mockito.spy(ParqueaderoService.class);
	}
	
	@Test
	public void ConsultarCantidadCarros ()  {
		//Arrange
		Mockito.when(validaciones.consultarCantidadCarros()).thenReturn(2);
		
		//Act
		int consultaOk = validaciones.consultarCantidadCarros();
		
		//Assert
		assertEquals(2, consultaOk);
	}

	@Test
	public void ConsultarCantidadMotos ()  {
		//Arrange
		Mockito.when(validaciones.consultarCantidadMotos()).thenReturn(2);
		
		//Act
		int consultaOk = validaciones.consultarCantidadMotos();
		
		//Assert
		assertEquals(2, consultaOk);
	}

	@Test
	public void consultarVehiculoPorPlacaFail () throws Exception {
		//Arrange
		Mockito.when(validaciones.consultarVehiculoPorPlaca(null)).thenReturn(null);
		
		//Act
		ReciboPago consultaFail = validaciones.consultarVehiculoPorPlaca(null);
		
		//Assert
		assertEquals(null, consultaFail);
	}
	
	@Test
	public void consultarVehiculoPorPlacaOk () throws Exception {
		//Arrange
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date horaEntrada = format.parse("10/03/2018 12:20");
		ReciboPago recibo1 = new ReciboPago("wer013", true, 0, horaEntrada, 0);
		Mockito.when(validaciones.consultarVehiculoPorPlaca("wer013")).thenReturn(recibo1);
		
		//Act
		ReciboPago consultaOk = validaciones.consultarVehiculoPorPlaca("wer013");
		
		//Assert
		assertEquals(recibo1, consultaOk);
	}
	
	public void ingresoVehiculoSinCeldas () throws Exception{
		//Arrange
		int tipoVehiculo = 1;
		Mockito.when(otrasValidaciones.consultarCantidadCeldas(tipoVehiculo)).thenReturn(false);
		
		//Act
		
		//Assert
		
	}

}
