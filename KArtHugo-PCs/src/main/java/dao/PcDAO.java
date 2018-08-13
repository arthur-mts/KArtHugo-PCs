package dao;

import java.util.List;

import filtros.PecaFiltro;
import entities.MontagemDeComputador;


public class PcDAO extends DAO<MontagemDeComputador> {
	
	public PcDAO() {
		super(MontagemDeComputador.class);
		
	}

	

	public List<MontagemDeComputador> findBy(PecaFiltro filtro) {
		return null;
	}
	
}
