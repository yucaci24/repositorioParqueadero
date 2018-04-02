package com.ceiba.parqueadero.dao;

import com.ceiba.parqueadero.model.Parqueadero;

public class ParqueaderoDaoImpl extends SessionObjeto implements ParqueaderoDao{

	@Override
	public Parqueadero consultarCeldasMoto(int celdasMoto) {
		// TODO Auto-generated method stub
		return (Parqueadero)getSession().createQuery(
				"from Parqueadero where celdasMoto = :celdasMoto")
				.setParameter("celdasMoto", celdasMoto).uniqueResult();
	}

	@Override
	public Parqueadero consultarCeldasCarro(int celdasCarro) {
		// TODO Auto-generated method stub
		return (Parqueadero)getSession().createQuery(
				"from Parqueadero where celdasCarro = :celdasCarro")
				.setParameter("celdasCarro", celdasCarro).uniqueResult();
	}

	@Override
	public void aumentarCeldasMoto(int celdasMoto) {
		// TODO Auto-generated method stub
		getSession().persist(celdasMoto);
	}

	@Override
	public void aumentarCeldasCarro(int celdasCarro) {
		// TODO Auto-generated method stub
		getSession().persist(celdasCarro);
	}

	@Override
	public void disminuirCeldasMoto(int celdasMoto) {
		// TODO Auto-generated method stub
		getSession().persist(celdasMoto);
	}

	@Override
	public void disminuirCeldasCarro(int celdasCarro) {
		// TODO Auto-generated method stub
		getSession().persist(celdasCarro);
	}

	
}
