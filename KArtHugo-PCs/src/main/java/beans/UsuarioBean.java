package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import entities.Usuario;

@ManagedBean
@ApplicationScoped
public class UsuarioBean {
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private Usuario usu = new Usuario();
	private Usuario novoUsu = new Usuario();
	private static int cont = 0;
	private String nomePc;

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	public Usuario getNovoUsu() {
		return novoUsu;
	}

	public void setNovoUsu(Usuario novoUsu) {
		this.novoUsu = novoUsu;
	}

	public static int getCont() {
		return cont;
	}

	public static void setCont(int cont) {
		UsuarioBean.cont = cont;
	}

	public String getNomePc() {
		return nomePc;
	}

	public void setNomePc(String nomePc) {
		this.nomePc = nomePc;
	}
}