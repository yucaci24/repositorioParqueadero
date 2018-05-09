package com.ceiba.parqueadero;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ceiba.parqueadero.dao.ParqueaderoDao;
import com.ceiba.parqueadero.service.VigilanteService;
import com.ceiba.parqueadero.service.ParametrosParqueadero;

@RunWith(MockitoJUnitRunner.class)
public class ComprobacionesEntradaYSalidaVehiculosTest {
	
	@InjectMocks
	VigilanteService comprobacionesEntradaYSalidaVehiculos;
	
	@Mock
	ParqueaderoDao registrosParqueaderoDao;

	@Test
	public void validarTipoVehiculo2() {
		//Arrange
		int tipo = 2;
		VigilanteService validaciones = new VigilanteService();
		
		//Act
		boolean tipoValido = validaciones.tipoVehiculo(tipo);
		
		//Assert
		assertFalse(tipoValido);
	}
	
	@Test
	public void validarTipoVehiculo1() {
		//Arrange
		int tipo = 1;
		VigilanteService validaciones = new VigilanteService();
		
		//Act
		boolean tipoValido = validaciones.tipoVehiculo(tipo);
		
		//Assert
		assertTrue(tipoValido);
	}
	
	@Test
	public void validarPlacaEmpiezaA () {
		//Arrange
		String placa = "ART258";
		VigilanteService validaciones = new VigilanteService();
		
		//Act
		boolean empiezaA = validaciones.comprobarLetraInicial(placa);
		
		//Assert
		assertTrue(empiezaA);
	}
	
	@Test
	public void validarPlacaNoEmpiezaA () {
		//Arrange
		String placa = "ORT258";
		VigilanteService validaciones = new VigilanteService();
		
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
		VigilanteService validaciones = new VigilanteService();
		
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
		VigilanteService validaciones = new VigilanteService();
		
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
		VigilanteService validaciones = new VigilanteService();
		
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
		VigilanteService validaciones = new VigilanteService();
		
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
		VigilanteService validaciones = new VigilanteService();
		
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
		
		VigilanteService validaciones = new VigilanteService();
		
		//Act
		boolean puedeIngresar = validaciones.validoIngresarVehiculo(placa, dia);
		
		//Assert
		assertTrue( puedeIngresar );
	}
	
	@Test
	public void validarEstadoDentro () {
		//Arrange
		boolean estado = true;
		VigilanteService validaciones = new VigilanteService();
		
		//Act 
		boolean dentro = validaciones.verificarEstado(estado);
		
		//Assert
		assertTrue(dentro);
	}
	
	@Test
	public void validarEstadoFuera () {
		//Arrange
		boolean estado = false;
		VigilanteService validaciones = new VigilanteService();
		
		//Act 
		boolean fuera = validaciones.verificarEstado(estado);
		
		//Assert
		assertFalse(fuera);
	}
	
	@Test
	public void validarCilindrajeMayor () {
		//Arrange
		int cilindraje = 600;
		VigilanteService validaciones = new VigilanteService();
		
		//Act
		boolean cilindrajeMayor = validaciones.verificarCilindraje(cilindraje);
		
		//Assert
		assertTrue(cilindrajeMayor);
	}

	@Test
	public void validarCilindrajeMenor () {
		//Arrange
		int cilindraje = 200;
		VigilanteService validaciones = new VigilanteService();
		
		//Act
		boolean cilindrajeMayor = validaciones.verificarCilindraje(cilindraje);
		
		//Assert
		assertFalse(cilindrajeMayor);
	}
	
//	@Test
//	public void validarCantidadCeldasCarro() {
//		//Arrange
//		int carro = 1;
//		ComprobacionesEntradaYSalidaVehiculos validaciones = new ComprobacionesEntradaYSalidaVehiculos();
//		Mockito.when(registrosParqueaderoDao.consultarCantidadCeldas(carro)).thenReturn(10);
//		//Act
//		
//		boolean	disponiblesCarros = validaciones.consultarCantidadCeldas(carro);
//		
//		
//		//Assert
//		assertTrue(disponiblesCarros);
//	}
//	
//	@Test
//	public void validarCantidadCeldasMoto() {
//		//Arrange
//		int moto = 2;
//		boolean disponiblesMotos = false;
//		
//		//Act
//		if (moto==2) {
//			disponiblesMotos = 9< ParametrosParqueadero.CELDAS_MOTOS;
//		}
//		
//		//Assert
//		assertTrue(disponiblesMotos);
	//}
}
