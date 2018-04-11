package com.ceiba.parqueadero;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.ceiba.parqueadero.service.ComprobacionesEntradaYSalidaVehiculos;

public class ComprobacionesEntradaYSalidaVehiculosTest {
	
	@Test
	public void validarTipoVehiculo2() {
		//Arrange
		int tipo = 2;
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act
		boolean tipoValido = validaciones.tipoVehiculo(tipo);
		
		//Assert
		assertFalse(tipoValido);
	}
	
	@Test
	public void validarTipoVehiculo1() {
		//Arrange
		int tipo = 1;
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act
		boolean tipoValido = validaciones.tipoVehiculo(tipo);
		
		//Assert
		assertTrue(tipoValido);
	}
	
	@Test
	public void validarIngresoVehiculo() {
		//Arrange
		String placa = "ABCD324";
		Date fecha = Calendar.getInstance().getTime();
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act
		boolean puedeIngresar = validaciones.validoIngresarVehiculo(placa, fecha);
		
		//Assert
		assertFalse( puedeIngresar );
	}

	@Test
	public void validarIngresoVehiculoSinInicalA() {
		//Arrange
		String placa = "CBCD324";
		Date fecha = Calendar.getInstance().getTime();
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act
		boolean puedeIngresar = validaciones.validoIngresarVehiculo(placa, fecha);
		
		//Assert
		assertTrue( puedeIngresar );
	}
	
	@Test
	public void validarIngresoVehiculoLunesODomingoConA() {
		//Arrange
		String placa = "ABCD324";
		Calendar fecha = Calendar.getInstance();
		fecha.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		
		Date dia = fecha.getTime();
		
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act
		boolean puedeIngresar = validaciones.validoIngresarVehiculo(placa, dia);
		
		//Assert
		assertTrue( puedeIngresar );
	}
	
	@Test
	public void validarEstadoDentro () {
		//Arrange
		boolean estado = true;
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act 
		boolean dentro = validaciones.verificarEstado(estado);
		
		//Assert
		assertTrue(dentro);
	}
	
	@Test
	public void validarEstadoFuera () {
		//Arrange
		boolean estado = false;
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act 
		boolean fuera = validaciones.verificarEstado(estado);
		
		//Assert
		assertFalse(fuera);
	}
	
	@Test
	public void validarCilindraje () {
		//Arrange
		int cilindraje = 600;
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act
		boolean cilindrajeMayor = validaciones.verificarCilindraje(cilindraje);
		
		//Assert
		assertTrue(cilindrajeMayor);
	}
}

