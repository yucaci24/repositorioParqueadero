package com.ceiba.parqueadero.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ceiba.parqueadero.model.ReciboPago;
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
	public Vehiculo consultarVehiculoId(int id) {
		return (Vehiculo)getSession().createQuery(
				"from Vehiculo where id = :id")
				.setParameter("id", id).uniqueResult();
	}

	@Override
	public void salirVehiculo(ReciboPago recibo) {
		Vehiculo v = consultarVehiculoPorPlaca(recibo.getPlaca());
		getSession().update(v);
	}

}