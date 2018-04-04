package com.ceiba.parqueadero.dao;

import com.ceiba.parqueadero.model.Parqueadero;

public class ParqueaderoDaoImpl extends SessionObjeto implements ParqueaderoDao{

	@Override
	public Parqueadero consultarCeldasMoto(int celdasMoto) {

		return (Parqueadero)getSession().createQuery(
				"from Parqueadero where celdasMoto = :celdasMoto")
				.setParameter("celdasMoto", celdasMoto).uniqueResult();
	}

	@Override
	public Parqueadero consultarCeldasCarro(int celdasCarro) {

		return (Parqueadero)getSession().createQuery(
				"from Parqueadero where celdasCarro = :celdasCarro")
				.setParameter("celdasCarro", celdasCarro).uniqueResult();
	}

	@Override
	public void aumentarCeldasMoto(int celdasMoto) {
		getSession().persist(celdasMoto);
	}

	@Override
	public void aumentarCeldasCarro(int celdasCarro) {
		getSession().persist(celdasCarro);
	}

	@Override
	public void disminuirCeldasMoto(int celdasMoto) {
		getSession().persist(celdasMoto);
	}

	@Override
	public void disminuirCeldasCarro(int celdasCarro) {
		getSession().persist(celdasCarro);
	}



	
}
