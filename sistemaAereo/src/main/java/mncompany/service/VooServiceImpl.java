package mncompany.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mncompany.dao.VooDao;
import mncompany.domain.entity.Voo;
import mncompany.repository.VooRepository;

@Service
@Transactional(readOnly = false)
public class VooServiceImpl implements VooService {
	
	@Autowired
	private VooRepository repository;
	
	public VooServiceImpl(VooRepository repository) {
		this.repository = repository;
	}

	@Override
	public void salvar(Voo voo) {
		this.repository.save(voo);
	}

	@Override
	public void editar(Voo voo) {
		this.salvar(voo);
	}

	@Override
	public void excluir(UUID id) {
		Voo voo = this.buscarPorId(id);
		this.repository.delete(voo);
	}

	@Override @Transactional(readOnly = true)
	public Voo buscarPorId(UUID id) {
		return this.repository.findById(id).orElseThrow(
		        () -> new RuntimeException("O ID do assento informado [%s] nÃ£o existe no banco."));
	}

	@Override @Transactional(readOnly = true)
	public List<Voo> buscarTodos() {
		return this.repository.findAll();
	}

	@Override @Transactional(readOnly = true)
	public List<Voo> buscarPorVoos(String origem, String destino, LocalDate dataIda) {
		return this.repository.findByOrigemAndDestinoAndDataIda(origem, destino, dataIda);
	}
	

}
