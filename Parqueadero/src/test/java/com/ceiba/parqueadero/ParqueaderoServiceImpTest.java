package com.ceiba.parqueadero;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ceiba.parqueadero.dao.ParqueaderoDao;
import com.ceiba.parqueadero.model.ReciboPago;
import com.ceiba.parqueadero.service.ParqueaderoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ParqueaderoServiceImpTest {
	
	@InjectMocks
	private ParqueaderoServiceImpl validaciones;
	
	@Mock
	private ParqueaderoDao parqueaderoDao;
	
	@Test
	public void ConsultarCantidadCarros ()  {
		//Arrange
		int cantidadCarros = 2;
		Mockito.when(validaciones.consultarCantidadCarros()).thenReturn(cantidadCarros);
		
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

//	@Test
//	public void consultarVehiculoPorPlacaFail () throws Exception {
//		//Arrange
//		Mockito.when(validaciones.consultarVehiculoPorPlaca(null)).thenReturn(null);
//		
//		//Act
//		ReciboPago consultaFail = validaciones.consultarVehiculoPorPlaca(null);
//		
//		//Assert
//		assertEquals(null, consultaFail);
//	}
	
//	@Test
//	public void consultarVehiculoPorPlacaOk () throws Exception {
//		//Arrange
//		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//		Date horaEntrada = format.parse("10/03/2018 12:20");
//		ReciboPago recibo1 = new ReciboPago("wer013", true, 0, horaEntrada, 0);
//		Mockito.when(validaciones.consultarVehiculoPorPlaca("wer013")).thenReturn(recibo1);
//		
//		//Act
//		ReciboPago consultaOk = validaciones.consultarVehiculoPorPlaca("wer013");
//		
//		//Assert
//		assertEquals(recibo1, consultaOk);
//	}
	
	
}
