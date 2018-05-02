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

import com.ceiba.parqueadero.model.Vehiculo;
import com.ceiba.parqueadero.service.VehiculoService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/")
public class ParqueoController {
	
	@Autowired
	public VehiculoService vehiculoService;
	
	@RequestMapping(value = "ingresos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> ingresarVehiculo(@RequestBody Vehiculo vehiculo, UriComponentsBuilder uriComponentsBuilder, boolean estado){
		
		try {
			vehiculoService.ingresarVehiculo(vehiculo);
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
	public ResponseEntity<Vehiculo> salirVehiculo (@PathVariable("placa") String placa, @RequestBody Vehiculo vehiculo) {
		Vehiculo vehiculoFuera = vehiculoService.consultarVehiculoPorPlaca(placa);
		vehiculoFuera.setEstado(vehiculo.isEstado());
		try {
			vehiculoService.salirVehiculo(vehiculoFuera);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return new ResponseEntity<Vehiculo>(vehiculoFuera, HttpStatus.OK);
	}
	
	
	@RequestMapping (value = "/consultas/{placa}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Vehiculo> consultarVehiculo(@PathVariable("placa")String placa){
		Vehiculo vehiculo = vehiculoService.consultarVehiculoPorPlaca(placa);
			if (placa == null) {
					return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Vehiculo>(vehiculo, HttpStatus.OK);
	}

}
