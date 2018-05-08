package com.ceiba.parqueadero;

import static org.mockito.Matchers.any;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.ceiba.parqueadero.controller.ParqueoController;
import com.ceiba.parqueadero.model.Parqueadero;
import com.ceiba.parqueadero.model.ReciboPago;
import com.ceiba.parqueadero.model.Vehiculo;
import com.ceiba.parqueadero.service.ParqueaderoService;

@RunWith(MockitoJUnitRunner.class)
public class ParqueaderoControllerTest {

	@Mock
	public ParqueaderoService registrosParqueaderoService;
	
	@Mock
	HttpHeaders headers;
	
	@InjectMocks
	private ParqueoController parqueaderoController;
	
	@Test
	public void ingresarVehiculoTest() throws Exception  {
		Vehiculo vehiculo = new Vehiculo("sdf345");
		
		Mockito.when(registrosParqueaderoService.ingresarVehiculo(any(Vehiculo.class))).thenReturn(vehiculo);
		
		ResponseEntity<?> respuesta  = parqueaderoController.ingresarVehiculo(vehiculo, UriComponentsBuilder.newInstance());
		
		Assert.assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());
	}
	
	@Test
	public void ingresarVehiculoErrorTest() throws Exception {
		Vehiculo vehiculo = new Vehiculo("sdf345");
		
		Mockito.when(registrosParqueaderoService.ingresarVehiculo(any(Vehiculo.class))).thenThrow(new Exception(""));
		
		ResponseEntity<?> respuesta  = parqueaderoController.ingresarVehiculo(vehiculo, UriComponentsBuilder.newInstance());
		
		Assert.assertEquals(HttpStatus.FORBIDDEN, respuesta.getStatusCode());
	}
	
	@Test
	public void consultarVehiculoTest() throws Exception  {
		Vehiculo vehiculo = new Vehiculo("sdf345");
		ReciboPago recibo = new ReciboPago("sdf345", true, 0, null, 0);
		
		Mockito.when(registrosParqueaderoService.consultarVehiculoPorPlaca(vehiculo.getPlaca())).thenReturn(recibo);
		
		ResponseEntity<?> respuesta  = parqueaderoController.consultarVehiculo(vehiculo.getPlaca());
		
		Assert.assertEquals(HttpStatus.OK, respuesta.getStatusCode());
	}
	
	@Test
	public void consultarVehiculoErrorTest() throws Exception  {
		Vehiculo vehiculo = new Vehiculo("");
		
		Mockito.when(registrosParqueaderoService.consultarVehiculoPorPlaca(vehiculo.getPlaca())).thenThrow(new Exception(""));
		
		ResponseEntity<?> respuesta  = parqueaderoController.consultarVehiculo(vehiculo.getPlaca());
		
		Assert.assertEquals(HttpStatus.FORBIDDEN, respuesta.getStatusCode());
	}
	
	@Test
	public void salirVehiculoTest() throws Exception  {
		Vehiculo vehiculo = new Vehiculo("sdf345", true);
		ReciboPago recibo = new ReciboPago("sdf345", true, 0, null, 0);
		Parqueadero registro = new Parqueadero();
		
		Mockito.when(registrosParqueaderoService.salirVehiculo(recibo)).thenReturn(recibo);
		Mockito.when(registrosParqueaderoService.consultarVehiculoPorPlaca(vehiculo.getPlaca())).thenReturn(recibo);
		
		ResponseEntity<?> respuesta  = parqueaderoController.salirVehiculo(vehiculo.getPlaca(), vehiculo, registro);
		
		Assert.assertEquals(HttpStatus.OK, respuesta.getStatusCode());
	}
	
	@Test
	public void salirVehiculoError1Test() throws Exception  {
		Vehiculo vehiculo = new Vehiculo("", true);
		ReciboPago recibo = new ReciboPago("", true, 0, null, 0);
		Parqueadero registro = new Parqueadero();
		
		Mockito.when(registrosParqueaderoService.salirVehiculo(recibo)).thenReturn(recibo);
		Mockito.when(registrosParqueaderoService.consultarVehiculoPorPlaca(vehiculo.getPlaca())).thenThrow(new Exception(""));
		
		ResponseEntity<?> respuesta  = parqueaderoController.salirVehiculo(vehiculo.getPlaca(), vehiculo, registro);
		
		Assert.assertEquals(HttpStatus.FORBIDDEN, respuesta.getStatusCode());
	}
	
}


