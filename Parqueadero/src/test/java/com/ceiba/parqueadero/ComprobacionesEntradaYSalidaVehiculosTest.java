package com.ceiba.parqueadero;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.ceiba.parqueadero.service.ComprobacionesEntradaYSalidaVehiculos;
import com.ceiba.parqueadero.service.ParametrosParqueadero;


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
	public void validarPlacaEmpiezaA () {
		//Arrange
		String placa = "ART258";
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act
		boolean empiezaA = validaciones.comprobarLetraInicial(placa);
		
		//Assert
		assertTrue(empiezaA);
	}
	
	@Test
	public void validarPlacaNoEmpiezaA () {
		//Arrange
		String placa = "ORT258";
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act
		boolean empiezaA = validaciones.comprobarLetraInicial(placa);
		
		//Assert
		assertFalse(empiezaA);
	}
	
	@Test
	public void validarObtenerDiaSiDomingo () {
		//Arrange
		Calendar fecha = Calendar.getInstance();
		fecha.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		Date dia = fecha.getTime();
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act
		boolean siEsDomingo = validaciones.obtenerDia(dia);
		
		//Assert
		assertTrue(siEsDomingo);
		
	}
	
	@Test
	public void validarObtenerDiaNoDomingo () {
		//Arrange
		Calendar fecha = Calendar.getInstance();
		fecha.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		Date dia = fecha.getTime();
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act
		boolean siEsDomingo = validaciones.obtenerDia(dia);
		
		//Assert
		assertFalse(siEsDomingo);
		
	}
	
	@Test
	public void validarIngresoVehiculoConInicialANoDomingo() {
		//Arrange
		String placa = "ABCD324";
		Calendar fecha = Calendar.getInstance();
		fecha.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		Date dia = fecha.getTime();
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act
		boolean puedeIngresar = validaciones.validoIngresarVehiculo(placa, dia);
		
		//Assert
		assertFalse( puedeIngresar );
	}
	
	@Test
	public void validarIngresoVehiculoConInicialADomingo() {
		//Arrange
		String placa = "ABCD324";
		Calendar fecha = Calendar.getInstance();
		fecha.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		Date dia = fecha.getTime();
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act
		boolean puedeIngresar = validaciones.validoIngresarVehiculo(placa, dia);
		
		//Assert
		assertTrue( puedeIngresar );
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
	public void validarCilindrajeMayor () {
		//Arrange
		int cilindraje = 600;
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act
		boolean cilindrajeMayor = validaciones.verificarCilindraje(cilindraje);
		
		//Assert
		assertTrue(cilindrajeMayor);
	}

	@Test
	public void validarCilindrajeMenor () {
		//Arrange
		int cilindraje = 200;
		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
		
		//Act
		boolean cilindrajeMayor = validaciones.verificarCilindraje(cilindraje);
		
		//Assert
		assertFalse(cilindrajeMayor);
	}
	
	@Test
	public void validarCantidadCeldasCarro() {
		//Arrange
		int carro = 1;
		boolean disponiblesCarros = false;
		
		//Act
		if (carro==1) {
			disponiblesCarros = 19< ParametrosParqueadero.CELDAS_CARROS;
		}
		
		//Assert
		assertTrue(disponiblesCarros);
	}
	
	@Test
	public void validarCantidadCeldasMoto() {
		//Arrange
		int moto = 2;
		boolean disponiblesMotos = false;
		
		//Act
		if (moto==2) {
			disponiblesMotos = 9< ParametrosParqueadero.CELDAS_MOTOS;
		}
		
		//Assert
		assertTrue(disponiblesMotos);
	}
}
