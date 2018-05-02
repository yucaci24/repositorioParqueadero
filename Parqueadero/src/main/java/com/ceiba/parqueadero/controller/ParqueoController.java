package com.ceiba.parqueadero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.ceiba.parqueadero.model.RegistrosParqueadero;
import com.ceiba.parqueadero.model.Vehiculo;
import com.ceiba.parqueadero.service.RegistrosParqueaderoService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/")
public class ParqueoController {
	
	@Autowired
	public RegistrosParqueaderoService registrosParqueaderoService;
	
	@RequestMapping(value = "ingresos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> ingresarVehiculo(@RequestBody RegistrosParqueadero registro, Vehiculo vehiculo, UriComponentsBuilder uriComponentsBuilder, boolean estado){
		
		try {
			registrosParqueaderoService.ingresarVehiculo(registro, vehiculo);
		}catch( Exception e ) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FORBIDDEN);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				uriComponentsBuilder.path("ingresos/{id}")
				.buildAndExpand(vehiculo.getPlaca())
				.toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	
	@RequestMapping (value = "salidas/{placa}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Vehiculo> salirVehiculo (@PathVariable("placa") String placa, @RequestBody Vehiculo vehiculo, RegistrosParqueadero registro) {
		Vehiculo vehiculoFuera= null;
		RegistrosParqueadero registroFuera = null;
		try {
			vehiculoFuera = registrosParqueaderoService.consultarVehiculoPorPlaca(placa);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		registroFuera.setEstado(registro.isEstado());
		try {
			registrosParqueaderoService.salirVehiculo(registro, vehiculoFuera);
		} catch (Exception e) {
			e.printStackTrace();
		}
	return new ResponseEntity<Vehiculo>(vehiculoFuera, HttpStatus.OK);
	}
	
	
	@RequestMapping (value = "consultas/{placa}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Vehiculo> consultarVehiculo(@PathVariable("placa")String placa){
		Vehiculo vehiculo = null;
		try {
			vehiculo = registrosParqueaderoService.consultarVehiculoPorPlaca(placa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Vehiculo>(vehiculo, HttpStatus.OK);
	}

}
