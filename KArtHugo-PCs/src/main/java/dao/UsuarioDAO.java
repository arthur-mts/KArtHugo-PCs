package dao;

import java.security.MessageDigest;
import java.util.Base64;
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

	public String hash(String password) {
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes("UTF-8"));
			byte[] digest = md.digest();
			String output = Base64.getEncoder().encodeToString(digest);
			return output;
		} catch (Exception e) {
			return password;
		}
	}

}
