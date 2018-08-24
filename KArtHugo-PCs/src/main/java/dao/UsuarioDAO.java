package dao;

import java.util.List;


import entities.Usuario;
import filtros.PecaFiltro;


public class UsuarioDAO extends DAO<Usuario> {
	
	public UsuarioDAO() {
		super(Usuario.class);
	}

	public List<Usuario> findBy(PecaFiltro filtro) {
		return null;
	}
	
}
