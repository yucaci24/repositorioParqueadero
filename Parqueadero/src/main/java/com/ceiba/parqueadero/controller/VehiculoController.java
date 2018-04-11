package com.ceiba.parqueadero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.ceiba.parqueadero.model.Vehiculo;
import com.ceiba.parqueadero.service.VehiculoService;

@Controller
@RequestMapping("/n1")
public class VehiculoController {
	
	@Autowired
	public VehiculoService vehiculoService;
	
	@RequestMapping (value = "/b")
	@ResponseBody
	public String index() {
		String response = ("Bienvenido a  parqueadero :D");
		return response;
	}
	
	@RequestMapping(value = "/ingresos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> ingresarVehiculo(@RequestBody Vehiculo vehiculo, UriComponentsBuilder uriComponentsBuilder, boolean estado){
		if (vehiculo.getPlaca()==(null) || vehiculo.getPlaca().isEmpty() ) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		if ((vehiculoService.consultarVehiculoPorPlaca(vehiculo.getPlaca())!= null)) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		try {
			vehiculoService.ingresarVehiculo(vehiculo);
		}catch( Exception e ) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FORBIDDEN);
		}
		
		
		Vehiculo vehiculo2 = vehiculoService.consultarVehiculoPorPlaca(vehiculo.getPlaca());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				uriComponentsBuilder.path("/n1/ingresos/{id}")
				.buildAndExpand(vehiculo.getPlaca())
				.toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	
	@RequestMapping (value = "/salidas/{placa}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Vehiculo> salirVehiculo (@PathVariable("placa") String placa, @RequestBody Vehiculo vehiculo) {
		if (placa == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		Vehiculo vehiculoFuera = vehiculoService.consultarVehiculoPorPlaca(placa);
		if (vehiculoFuera==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		vehiculoFuera.setEstado(vehiculo.isEstado());
		vehiculoService.salirVehiculo(vehiculoFuera);
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
