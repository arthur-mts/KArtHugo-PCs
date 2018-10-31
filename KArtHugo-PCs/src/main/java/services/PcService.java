package services;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import dao.PcDAO;
import entities.MontagemDeComputador;
import util.TransacionalCdi;

public class PcService implements Serializable, services.Service<MontagemDeComputador> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7315243640875303126L;
	@Inject
	private PcDAO dao;

	@Override
	@TransacionalCdi
	public void save(MontagemDeComputador e) {
		dao.save(e);

	}

	@Override
	@TransacionalCdi
	public void update(MontagemDeComputador e) {
		dao.update(e);

	}

	@Override
	@TransacionalCdi
	public void remove(MontagemDeComputador e) {
		dao.remove(e);

	}

	@Override
	public MontagemDeComputador getByID(long userId) {
		return dao.getByID(userId);
	}

	@Override
	public List<MontagemDeComputador> getAll() {
		return dao.getAll();
	}

}
