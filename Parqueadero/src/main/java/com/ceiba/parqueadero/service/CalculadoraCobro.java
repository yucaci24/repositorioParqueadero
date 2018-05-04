package com.ceiba.parqueadero.service;

import java.math.BigDecimal;
import java.util.Date;

import com.ceiba.parqueadero.model.Parqueadero;
import com.ceiba.parqueadero.model.Vehiculo;

public class CalculadoraCobro {
	
	
	private static final int HORAS_MINIMAS_DIA = 9;

	public long calcularCobroPorDia( int cantDias, int valorPorDiaTipoVehiculo ){
		return (cantDias * valorPorDiaTipoVehiculo);
	}
	
	public long calcularCobroPorHoras( int cantHoras, int valorPorHoraTipoVehiculo, int valorPorDiaTipoVehiculo ){
		
		if( cantHoras > HORAS_MINIMAS_DIA ) {
			return valorPorDiaTipoVehiculo;
		}
		
		return (cantHoras * valorPorHoraTipoVehiculo);
	}
	
	public long calcularCobroPorMinutos( int cantMinutos, int valorPorHoraTipoVehiculo  ){
		return cantMinutos > 0 ? valorPorHoraTipoVehiculo : 0;
	}
	
	public long calcularValorSalidaTotal(Parqueadero registro, Vehiculo vehiculo) {
		CalculadoraTiempo calculadoraT = new CalculadoraTiempo();
		Date fechaYHoraDeSalida = new Date ();
		Date fechaYHoraDeEntrada = registro.getFechaYHoraEntrada();
		long cobroTotal = 0;
		int cobroAdicional = 0;
		double diferenciaFechas = 0;
		
		diferenciaFechas = calculadoraT.calcularDiferenciaTiempoInSeconds(fechaYHoraDeEntrada, fechaYHoraDeSalida);
		
		if( vehiculo.getTipo() == TipoVehiculo.MOTO.getTipoVehiculo() ) {			
			cobroTotal = calcularTotal( diferenciaFechas, ParametrosParqueadero.COBRO_DIA_MOTO, ParametrosParqueadero.COBRO_HORA_MOTO);
		}else {
			cobroTotal = calcularTotal( diferenciaFechas, ParametrosParqueadero.COBRO_DIA_CARRO, ParametrosParqueadero.COBRO_HORA_CARRO);
		}
		
		if( vehiculo.getCilindraje() > ParametrosParqueadero.CILINDRAJE_MINIMO  ) {
			cobroAdicional = ParametrosParqueadero.COBRO_ADICIONAL_MOTO;
		}	
		
		return cobroTotal + cobroAdicional;
	}
	
	public long calcularTotal( double diferenciaFechas, int cobroDiaVehiculo, int cobroHoraVehiculo ) {
		CalculadoraTiempo calculadoraT = new CalculadoraTiempo();
		long cobroDias = 0;
		int restoHoras = 0;
		long cobroHoras = 0;
		int restoMinutos = 0;
		long cobroMinutos = 0;
		int dias = 0;
		int minutos = 0;
		
		dias = calculadoraT.calcularDias( diferenciaFechas );
		
		cobroDias = this.calcularCobroPorDia(dias, cobroDiaVehiculo);
		
		restoHoras = BigDecimal.valueOf((diferenciaFechas - ( dias * CalculadoraTiempo.DAY_IN_SECONDS))).intValue(); 
		
		int horas = calculadoraT.calcularHoras( restoHoras );
		
		cobroHoras = this.calcularCobroPorHoras(horas, cobroHoraVehiculo, cobroDiaVehiculo);
		
		restoMinutos = BigDecimal.valueOf((restoHoras - ( horas * CalculadoraTiempo.HOURS_IN_SECONDS))).intValue(); 
		
		minutos = calculadoraT.calcularPorMinutos( restoMinutos );
		
		cobroMinutos = this.calcularCobroPorMinutos(minutos, cobroHoraVehiculo);
		
		return cobroDias + cobroHoras + cobroMinutos;
	}

}
