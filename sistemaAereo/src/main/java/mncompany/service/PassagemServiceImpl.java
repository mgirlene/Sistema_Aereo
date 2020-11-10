package mncompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mncompany.dao.PassagemDao;
import mncompany.domain.Passagem;

@Service
@Transactional(readOnly = false)
public class PassagemServiceImpl implements PassagemService {
	
	@Autowired
	private PassagemDao dao;

	@Override
	public void salvar(Passagem passagem) {
		dao.save(passagem);
	}

	@Override
	public void editar(Passagem passagem) {
		dao.update(passagem);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Passagem buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Passagem> buscarTodos() {
		return dao.findAll();
	}

}
