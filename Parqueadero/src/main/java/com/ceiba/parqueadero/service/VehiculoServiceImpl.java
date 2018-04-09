package com.ceiba.parqueadero.service;

import java.util.Date;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.dao.VehiculoDao;
import com.ceiba.parqueadero.model.Vehiculo;

@Service("vehiculoService")
@Transactional
public class VehiculoServiceImpl extends Utils implements VehiculoService{

	@Autowired
	public VehiculoDao vehiculoDao;
	

	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) {
		Date date = new Date();
		String letra = vehiculo.getPlaca();
		int tipo = vehiculo.getTipo();
		
		
		
		
		
		
		if (tipoVehiculo(tipo)) {
			
			
			
			
			if (consultarCantidadCeldas( tipo )) {
				
				
				
				if ((comprobarLetraInicial(letra))) {
					if (obtenerDia(date)) {
						vehiculoDao.ingresarVehiculo(vehiculo);
					}else {
						System.out.println("no puede ingresar");
					}
				}else {
					vehiculoDao.ingresarVehiculo(vehiculo);
				}
			}
			System.out.println("no puede ingresar");
		}else {
			
				if ((comprobarLetraInicial(letra))) {
					if (obtenerDia(date)==true) {
						vehiculoDao.ingresarVehiculo(vehiculo);
					}else {
						System.out.println("no puede ingresar");
					}
				}else  {
					vehiculoDao.ingresarVehiculo(vehiculo);
				}		
			}
		}
	
	
	@Override
	public int salirVehiculo(Vehiculo vehiculo) {
		Date fechaYHoraDeSalida = new Date ();
		Date fechaYHoraDeEntrada = vehiculo.getFechaYHoraEntrada();
		int tipo = vehiculo.getTipo();
		int cilindraje = vehiculo.getCilindraje();
		int dias;
		int horas;
		int minutos;
		int cobroDias = 0;
		int cobroHoras = 0;
		int cobroMinutos = 0;
		int cobroTotal;
		int cobroAdicional;
		
		int resultadoRestarFechas= (int)((fechaYHoraDeSalida.getTime()-fechaYHoraDeEntrada.getTime())/1000);
		
		if (tipoVehiculo(tipo)) {
			if (verificarCilindraje(cilindraje)) {
				cobroAdicional=2000;
			}else {
				cobroAdicional=0;
			}
			if (resultadoRestarFechas>86400) {
				 dias=(int)Math.floor(resultadoRestarFechas/86400);
				 cobroDias=dias*4000;
				 resultadoRestarFechas = resultadoRestarFechas-(dias*86400);
				 
			}
			if (resultadoRestarFechas>3600) {
				horas=(int)Math.floor(resultadoRestarFechas/3600);
				resultadoRestarFechas=resultadoRestarFechas-(horas*3600);
				if (horas>9) {
					cobroHoras=4000;
				}cobroHoras=horas*500;
			}
			
			if (resultadoRestarFechas>60) {
				minutos=(int)Math.floor(resultadoRestarFechas/60);
				resultadoRestarFechas=resultadoRestarFechas-(minutos*60);
				if (minutos<60) {
					cobroMinutos=500;
				}
			}	cobroTotal=cobroAdicional+cobroDias+cobroHoras+cobroMinutos;
				System.out.println("el cobro es: "+cobroTotal);
				vehiculoDao.salirVehiculo(vehiculo);
				return cobroTotal;
			
		}else {
		if (resultadoRestarFechas>86400) {
			 dias=(int)Math.floor(resultadoRestarFechas/86400);
			 cobroDias=dias*8000;
			 resultadoRestarFechas = resultadoRestarFechas-(dias*86400);
		}
		if (resultadoRestarFechas>3600) {
			horas=(int)Math.floor(resultadoRestarFechas/3600);
			resultadoRestarFechas=resultadoRestarFechas-(horas*3600);
			if (horas>9) {
				cobroHoras=8000;
			}cobroHoras=horas*1000;
		}
		
		if (resultadoRestarFechas>60) {
			minutos=(int)Math.floor(resultadoRestarFechas/60);
			resultadoRestarFechas=resultadoRestarFechas-(minutos*60);
			if (minutos<60) {
				cobroMinutos=1000;
			}
		}	cobroTotal=cobroDias+cobroHoras+cobroMinutos;
			System.out.println("el cobro es: "+cobroTotal);
			vehiculoDao.salirVehiculo(vehiculo);
			return cobroTotal;
		} 
	}

	
	@Override
	public Vehiculo consultarVehiculoPorPlaca(String placa) {
		return vehiculoDao.consultarVehiculoPorPlaca(placa);
	}
	
	@Override
	public Vehiculo consultarVehiculoPorEstado(boolean estado) {
		return (Vehiculo)vehiculoDao.consultarVehiculoPorEstado(estado);
	}
	
	@Override
	public int consultarCantidadCarros() {
		return vehiculoDao.consultarCantidadCarros();
	}

	@Override
	public int consultarCantidadMotos() {
		return vehiculoDao.consultarCantidadMotos();
	}
}