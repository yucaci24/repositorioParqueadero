package com.ceiba.parqueadero.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.ceiba.parqueadero.model.Vehiculo;
import com.ceiba.parqueadero.service.VehiculoService;

@Controller
@RequestMapping("/n1")
public class VehiculoController {
	
	@Autowired
	public VehiculoService _vehiculoService;
	
	@RequestMapping (value = "/b")
	@ResponseBody
	public String index() {
		String response = "Bienvenido a  parqueadero :D";
		return response;
	}
	
	@RequestMapping (value = "/consultas/{placa}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Vehiculo> consultarVehiculo(@PathVariable("placa")String placa){
		Vehiculo vehiculo = _vehiculoService.consultarVehiculo(placa);
			if (placa == null) {
					return new ResponseEntity(HttpStatus.NOT_FOUND);
					// You many decide to return HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<Vehiculo>(vehiculo, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
//    public ResponseEntity<Teacher> getCourseById(@PathVariable("id") Long id){
//		Teacher teacher = _teacherService.findById(id);
//        if (teacher == null) {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//            // You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
//    }
	
	@RequestMapping(value = "/ingresos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> ingresarVehiculo(@RequestBody Vehiculo vehiculo, UriComponentsBuilder uriComponentsBuilder){
		if (vehiculo.getPlaca().equals(null) || vehiculo.getPlaca().isEmpty() ) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		if (_vehiculoService.consultarVehiculo(vehiculo.getPlaca())!= null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		_vehiculoService.ingresarVehiculo(vehiculo);
		Vehiculo vehiculo2 = _vehiculoService.consultarVehiculo(vehiculo.getPlaca());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				uriComponentsBuilder.path("/n1/ingresos/{id}")
				.buildAndExpand(vehiculo2.getPlaca())
				.toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	
	
	
	
	@RequestMapping (value = "/salida", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public Vehiculo salirVehiculo (@RequestParam(value="placa", required=false) String placa) {
		return _vehiculoService.salirVehiculo(placa);
	}
}
