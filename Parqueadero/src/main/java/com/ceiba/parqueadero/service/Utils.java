package com.ceiba.parqueadero.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.dao.VehiculoDao;
import com.ceiba.parqueadero.model.Vehiculo;

@Service
@Transactional
public class Utils {
	
	@Autowired
	public VehiculoDao vehiculoDao;
	
	public boolean tipoVehiculo (int tipo) {
		if (tipo==1) {
			return true;
		}return false;
	}
	
	//condiciones de ingreso
	
	public boolean comprobarLetraInicial (String placa) {	
		String primeraLetra = placa.substring(0, 1);
			if (primeraLetra.equals("a")) {
				return true;
			}return false;
	}
	
	public boolean obtenerDia (Date dia){
		GregorianCalendar calendario = new GregorianCalendar();
		calendario.setTime(dia);
		if ((calendario.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY )|| (calendario.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)) {
			return true;
		}return false;
	}
	
	public boolean consultarCantidadCeldasMoto() {
		if (vehiculoDao.consultarCantidadMotos()<10) {
			return true;
		}return false;
	}
	
	public boolean consultarCantidadCeldasCarro() {
		if (vehiculoDao.consultarCantidadCarros()<20) {
			return true;
		}return false;
	}

	public boolean verificarEstado(int estado)	{
		if (estado == 1) {
			return true;
		}return false;
	}
	
	//cobro
	
	public boolean verificarCilindraje(int cilindraje) {
		if (cilindraje >500) {
			return true;
		}return false;
	}
	
	public int cobroAdicionalMotos (int cobroAdicional) {
		int cilindraje = 0;
		if (verificarCilindraje(cilindraje)==true) {
			cobroAdicional=2000;
		}else {
			cobroAdicional=0;
		}
		return cobroAdicional;
	}
	
	public int restarFechas (int horas, int minutos, int dias) {
		//SimpleDateFormat dateFormat = new simpleDateFormat ("yyyy-MM-dd H:m:s");
		Date fechaYHoraDeSalida = new Date ();
		Date fechaYHoraDeEntrada = new Date ();
		int resultado= (int)(fechaYHoraDeSalida.getTime()-fechaYHoraDeEntrada.getTime()/1000);
		
		if (resultado>86400) {
			 dias=(int)Math.floor(resultado/86400);
			 resultado = resultado-(dias*86400);
		}
		if (resultado>3600) {
			horas=(int)Math.floor(resultado/3600);
			resultado=resultado-(horas*3600);
		}
		
		if (resultado>60) {
			minutos=(int)Math.floor(resultado/60);
			resultado=resultado-(minutos*60);
		}
		return resultado;
		
	}
}
