package services;

import java.io.Serializable;

import java.util.List;

import javax.inject.Inject;

import dao.PecaDAO;
import entities.Peca;

public class PecaService implements Serializable, services.Service<Peca> {
	@Inject
	private PecaDAO dao;

	@Override
	public void save(Peca e) {
		dao.save(e);

	}

	@Override
	public void update(Peca e) {
		dao.update(e);
	}

	@Override
	public void remove(Peca e) {
		dao.remove(e);
	}

	@Override
	public Peca getByID(long userId) {
		return dao.getByID(userId);

	}

	@Override
	public List<Peca> getAll() {
		return dao.getAll();
	}

}
