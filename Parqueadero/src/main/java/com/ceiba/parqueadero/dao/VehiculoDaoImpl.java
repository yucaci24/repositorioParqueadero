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
	public Vehiculo consultarVehiculo(String placa) {
		return (Vehiculo)getSession().createQuery(
				"from Vehiculo where placa = :placa")
				.setParameter("placa", placa).uniqueResult();
	}

	@Override
	public Vehiculo salirVehiculo(String placa) {
		return (Vehiculo)getSession().createQuery(
				"from Vehiculo where placa = :placa")
				.setParameter("placa", placa).uniqueResult();
	}

	@Override
	public int consultarCantidadCarros() {
		int cantidad= ((Number) getSession()
				.createQuery("select count (*) from Vehiculo ve where ve.estado=1 and ve.tipo=1")
				.uniqueResult()).intValue();
		return cantidad;
	}

	@Override
	public int consultarCantidadMotos() {
		int cantidad= ((Number) getSession()
				.createQuery("select count (*) from Vehiculo ve where ve.estado=1 and ve.tipo=2")
				.uniqueResult()).intValue();
		return cantidad;
	}
}