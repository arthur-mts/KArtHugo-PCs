package services;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import dao.PcDAO;
import entities.MontagemDeComputador;

public class PcService implements Serializable, services.Service<MontagemDeComputador> {
	@Inject
	private PcDAO dao;

	@Override
	public void save(MontagemDeComputador e) {
		dao.save(e);

	}

	@Override
	public void update(MontagemDeComputador e) {
		dao.update(e);

	}

	@Override
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
