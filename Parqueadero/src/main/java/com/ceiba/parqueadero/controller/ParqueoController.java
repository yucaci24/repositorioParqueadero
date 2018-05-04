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
import org.springframework.web.util.UriComponentsBuilder;

import com.ceiba.parqueadero.model.ReciboPago;
import com.ceiba.parqueadero.model.Parqueadero;
import com.ceiba.parqueadero.model.Vehiculo;
import com.ceiba.parqueadero.service.ParqueaderoService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/")
public class ParqueoController {
	
	@Autowired
	public ParqueaderoService registrosParqueaderoService;
	
	@RequestMapping(value = "ingresos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> ingresarVehiculo(@RequestBody Vehiculo vehiculo, UriComponentsBuilder uriComponentsBuilder){
		
		try {
			registrosParqueaderoService.ingresarVehiculo(vehiculo);
			
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
	public ResponseEntity<ReciboPago> salirVehiculo (@PathVariable("placa") String placa, @RequestBody Vehiculo vehiculo, Parqueadero registro) {
		ReciboPago recibo = new ReciboPago(vehiculo.getPlaca(), vehiculo.isEstado(), vehiculo.getCilindraje(), registro.getFechaYHoraEntrada(), registro.getCobro());
		try {
			recibo = registrosParqueaderoService.consultarVehiculoPorPlaca(placa);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		recibo.setEstado(vehiculo.isEstado());
		try {
			registrosParqueaderoService.salirVehiculo( recibo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	return new ResponseEntity<ReciboPago>(recibo, HttpStatus.OK);
	}
	
	
	@RequestMapping (value = "consultas/{placa}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<ReciboPago> consultarVehiculo(@PathVariable("placa")String placa){
		ReciboPago vehiculo = null;
		try {
			vehiculo = registrosParqueaderoService.consultarVehiculoPorPlaca(placa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<ReciboPago>(vehiculo, HttpStatus.OK);
	}

}
