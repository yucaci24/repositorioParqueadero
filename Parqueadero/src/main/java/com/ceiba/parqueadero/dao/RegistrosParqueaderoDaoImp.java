package com.ceiba.parqueadero.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ceiba.parqueadero.model.RegistrosParqueadero;
import com.ceiba.parqueadero.model.Vehiculo;
@Repository("registrosParqueaderoDao")
@Transactional
public class RegistrosParqueaderoDaoImp extends SessionObjeto implements RegistrosParqueaderoDao{

	@Override
	public int consultarCantidadCarros() {
		return ((Number) getSession()
				.createQuery("select count (*) from RegistrosParqueadero ve where ve.estado=1 and ve.tipo=1")
				.uniqueResult()).intValue();
		
	}
	
	@Override
	public int consultarCantidadCeldas( int tipoVehiculo ) {
		
		return ((Number) getSession().createQuery("select count (*) from RegistrosParqueadero ve where ve.estado=1 and ve.tipo=:tipo")
					.setParameter("tipo", tipoVehiculo).uniqueResult()).intValue();

	}

	@Override
	public int consultarCantidadMotos() {
		return  ((Number) getSession()
				.createQuery("select count (*) from RegistrosParqueadero ve where ve.estado=1 and ve.tipo=2")
				.uniqueResult()).intValue();
		
	}
	
	@Override
	public RegistrosParqueadero consultarVehiculoPorEstado(boolean estado) {
		return (RegistrosParqueadero)getSession().createQuery(
				"from parqueadero where estado = :estado")
				.setParameter("estado", estado);
	}
	
	@Override
	public void ingresarVehiculo(RegistrosParqueadero registro) {
		getSession().persist(registro);
	}

	@Override
	public void salirVehiculo(RegistrosParqueadero registro) {
		getSession().update(registro);
	}
	
}
