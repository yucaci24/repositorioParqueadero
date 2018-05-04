package com.ceiba.parqueadero;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import com.ceiba.parqueadero.service.ParqueaderoService;

public class ParqueaderoServiceImpTest {
	
	@Autowired
	ParqueaderoService validaciones;
	
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

}
