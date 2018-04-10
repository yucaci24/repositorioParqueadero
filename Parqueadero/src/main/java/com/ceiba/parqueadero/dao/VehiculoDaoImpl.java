package com.ceiba.parqueadero.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ceiba.parqueadero.model.Vehiculo;

@Repository("vehiculoDao")
@Transactional
public class VehiculoDaoImpl extends SessionObjeto implements VehiculoDao{

	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) {
		getSession().persist(vehiculo);
	}

	@Override
	public Vehiculo consultarVehiculoPorPlaca(String placa) {
		return (Vehiculo)getSession().createQuery(
				"from Vehiculo where placa = :placa")
				.setParameter("placa", placa).uniqueResult();
	}
	
	@Override
	public Vehiculo consultarVehiculoPorEstado(boolean estado) {
		return (Vehiculo)getSession().createQuery(
				"from Vehiculo where estado = :estado")
				.setParameter("estado", estado);
	}

	@Override
	public void salirVehiculo(Vehiculo vehiculo) {
		getSession().update(vehiculo);
	}

	@Override
	public int consultarCantidadCarros() {
		return ((Number) getSession()
				.createQuery("select count (*) from Vehiculo ve where ve.estado=1 and ve.tipo=1")
				.uniqueResult()).intValue();
		
	}
	
	@Override
	public int consultarCantidadCeldas( int tipoVehiculo ) {
		
		return ((Number) getSession().createQuery("select count (*) from Vehiculo ve where ve.estado=1 and ve.tipo=:tipo")
					.setParameter("tipo", tipoVehiculo).uniqueResult()).intValue();

	}

	@Override
	public int consultarCantidadMotos() {
		return  ((Number) getSession()
				.createQuery("select count (*) from Vehiculo ve where ve.estado=1 and ve.tipo=2")
				.uniqueResult()).intValue();
		
	}
}