package mncompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mncompany.dao.AssentoDao;
import mncompany.domain.Assento;
import mncompany.domain.Voo;

@Service
@Transactional(readOnly = false)
public class AssentoServiceImpl implements AssentoService {

	@Autowired
	private AssentoDao dao;

	@Override
	public void salvar(Assento assento) {
		dao.save(assento);
	}

	@Override
	public void editar(Assento assento) {
		dao.update(assento);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Assento buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Assento> buscarTodos() {
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Assento> buscarPorAssentos(Voo voo) {
		return dao.findByAssentos(voo);
	}

}
