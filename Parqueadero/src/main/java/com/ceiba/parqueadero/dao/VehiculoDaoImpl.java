package com.ceiba.parqueadero.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ceiba.parqueadero.model.Vehiculo;

@Repository("vehiculoDao")
@Transactional
public class VehiculoDaoImpl extends SessionObjeto implements VehiculoDao{

	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		getSession().persist(vehiculo);
	}

	@Override
	public Vehiculo consultarVehiculo(String placa) {
		// TODO Auto-generated method stub
		return (Vehiculo)getSession().createQuery(
				"from Vehiculo where placa = :placa")
				.setParameter("placa", placa).uniqueResult();
	}

	@Override
	public Vehiculo salirVehiculo(String placa) {
		// TODO Auto-generated method stub
		return (Vehiculo)getSession().createQuery(
				"from Vehiculo where placa = :placa")
				.setParameter("placa", placa).uniqueResult();
	}

}
