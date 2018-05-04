package com.ceiba.parqueadero.dao;

import javax.transaction.Transactional;

import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.ceiba.parqueadero.model.Parqueadero;
import com.ceiba.parqueadero.model.ReciboPago;
import com.ceiba.parqueadero.model.Vehiculo;
@Repository("registrosParqueaderoDao")
@Transactional
public class ParqueaderoDaoImp extends SessionObjeto implements ParqueaderoDao{

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
	
	@Override
	public ReciboPago consultarVehiculoPorEstado(boolean estado) {
		return (ReciboPago)getSession().createQuery(
				"from Parqueadero where estado = :estado")
				.setParameter("estado", estado);
	}
	
	@Override
	public void ingresarVehiculo(Parqueadero registro) {
		getSession().persist(registro);
	}

	@Override
	public void salirVehiculo(Parqueadero registro) {
		getSession().update(registro);
	}

	@Override
	public Parqueadero consultarRegistroIdVehiculo(int idVehiculo) {
		return (Parqueadero) getSession()
				.createQuery("from Parqueadero where idVehiculo = :idVehiculo")
				.setParameter("idVehiculo", idVehiculo)
				.list().get(0);
	}
	
}
