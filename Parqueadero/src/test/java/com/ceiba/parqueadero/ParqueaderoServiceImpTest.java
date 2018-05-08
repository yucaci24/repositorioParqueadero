package com.ceiba.parqueadero;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ceiba.parqueadero.dao.ParqueaderoDao;
import com.ceiba.parqueadero.dao.VehiculoDao;
import com.ceiba.parqueadero.model.Parqueadero;
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
	
}
