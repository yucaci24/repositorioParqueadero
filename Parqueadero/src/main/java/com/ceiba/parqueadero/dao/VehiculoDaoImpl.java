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
	public void salirVehiculo(Vehiculo vehiculo) {
		getSession().update(vehiculo);
	}

}