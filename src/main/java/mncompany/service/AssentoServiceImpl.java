package mncompany.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mncompany.domain.entity.Assento;
import mncompany.domain.entity.Voo;
import mncompany.repository.AssentoRepository;

@Service
@Transactional(readOnly = false)
public class AssentoServiceImpl implements AssentoService {
	
	@Autowired
	private AssentoRepository repository;
	
	public AssentoServiceImpl(AssentoRepository repository) {
		this.repository = repository;
	}

	@Override
	public void salvar(Assento assento) {
		this.repository.save(assento);
	}

	@Override
	public void editar(Assento assento) {
		this.salvar(assento);
	}

	@Override
	public void excluir(Long id) {
		Assento assento = this.buscarPorId(id);
		this.repository.delete(assento);
	}

	@Override
	@Transactional(readOnly = true)
	public Assento buscarPorId(Long id) {
		return this.repository.findById(id).orElseThrow(
			() -> new RuntimeException("O ID do assento informado [%s] não existe no banco."));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Assento> buscarTodos() {
		return this.repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Assento> buscarPorAssentos(Voo voo) {
		return this.repository.findByVoo(voo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Assento> buscarAssentosDisponiveis(Voo voo) {
		return this.repository.findByVoo(voo).stream().
				filter(Assento::isDisponibilidade).collect(Collectors.toList());
	}

}
