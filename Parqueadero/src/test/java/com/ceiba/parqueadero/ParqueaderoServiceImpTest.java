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
import com.ceiba.parqueadero.dao.VehiculoDao;
import com.ceiba.parqueadero.model.Parqueadero;
import com.ceiba.parqueadero.model.ReciboPago;
import com.ceiba.parqueadero.model.Vehiculo;
import com.ceiba.parqueadero.service.CalculadoraCobro;
import com.ceiba.parqueadero.service.ParqueaderoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ParqueaderoServiceImpTest {
	
	@InjectMocks
	private ParqueaderoServiceImpl validaciones;
	
	@Mock
	private ParqueaderoDao parqueaderoDao;
	
	@Mock
	private VehiculoDao vehiculoDao;
	
	@Test
	public void ConsultarCantidadCarrosTest ()  {
		//Arrange
		int cantidadCarros = 2;
		Mockito.when(validaciones.consultarCantidadCarros()).thenReturn(cantidadCarros);
		
		//Act
		int consultaOk = validaciones.consultarCantidadCarros();
		
		//Assert
		assertEquals(cantidadCarros, consultaOk);
	}

	@Test
	public void ConsultarCantidadMotosTest ()  {
		//Arrange
		int cantidadMotos = 2;
		Mockito.when(validaciones.consultarCantidadMotos()).thenReturn(cantidadMotos);
		
		//Act
		int consultaOk = validaciones.consultarCantidadMotos();
		
		//Assert
		assertEquals(cantidadMotos, consultaOk);
	}

	@Test
	public void consultarRegistroIdVehiculoTest () {
		//Arrange 
		Parqueadero parqueadero = new Parqueadero(0, 1);
		Mockito.when(validaciones.consultarRegistroIdVehiculo(1)).thenReturn(parqueadero);
		
		//Act
		Parqueadero consultaOk = validaciones.consultarRegistroIdVehiculo(1);
		
		//Assert
		assertEquals(parqueadero, consultaOk);
		
	}
	
//	@Test
//	public void consultarVehiculoPorPlacaOk () throws Exception {
//		//Arrange
//		String placa = "tyu678";
//		
//		Vehiculo vehiculo = new Vehiculo(placa, 0, true, 1);
//		
//		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//		Date horaEntrada = format.parse("10/03/2018 12:20");
//		
//		Parqueadero registro = new Parqueadero(horaEntrada, 0, 1);
//		
//		CalculadoraCobro calculadoraC = new CalculadoraCobro();
//		long valorTotal = calculadoraC.calcularValorSalidaTotal(registro, vehiculo);
//		registro.setCobro(valorTotal);
//		
//		ReciboPago recibo1 = new ReciboPago(placa, true, 0, horaEntrada, valorTotal);
//		
//		Mockito.when(vehiculoDao.consultarVehiculoPorPlaca(placa)).thenReturn(vehiculo);
//		Mockito.when(validaciones.consultarVehiculoPorPlaca(placa)).thenReturn(recibo1);
//		
//		//Act
//		ReciboPago consultaOk = validaciones.consultarVehiculoPorPlaca(placa);
//		
//		//Assert
//		assertEquals(recibo1, consultaOk);
//	}
	
//	@Test
//	public void consultarVehiculoPorPlacaOk () throws Exception {
//		//Arrange
//		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//		Date horaEntrada = format.parse("10/03/2018 12:20");
//		ReciboPago recibo1 = new ReciboPago("wer013", true, 0, horaEntrada, 0);
//		Mockito.when(validaciones.consultarVehiculoPorPlaca("wer013")).thenReturn(recibo1);
	//thenThrow(new Exception(""));
//		
//		//Act
//		ReciboPago consultaOk = validaciones.consultarVehiculoPorPlaca("wer013");
//		
//		//Assert
//		assertEquals(recibo1, consultaOk);
//	}
	
	
}
