package dao;

import java.util.List;

import filtros.PecaFiltro;
import entities.Peca;

public class PecaDAO extends DAO<Peca> {
	
	public PecaDAO() {
		super(Peca.class);
	}

	public List<Peca> findBy(PecaFiltro filtro) {
		return null;
	}
	
}
