package mncompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mncompany.dao.VooDao;
import mncompany.domain.Voo;

@Service
@Transactional(readOnly = false)
public class VooServiceImpl implements VooService {
	
	@Autowired
	private VooDao dao;

	@Override
	public void salvar(Voo voo) {
		dao.save(voo);
	}

	@Override
	public void editar(Voo voo) {
		dao.update(voo);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Voo buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Voo> buscarTodos() {
		return dao.findAll();
	}
	

}
