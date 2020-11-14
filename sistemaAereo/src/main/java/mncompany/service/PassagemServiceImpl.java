package mncompany.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mncompany.dao.PassagemDao;
import mncompany.domain.entity.Passagem;
import mncompany.domain.entity.Usuario;
import mncompany.repository.PassagemRepository;

@Service
@Transactional(readOnly = false)
public class PassagemServiceImpl implements PassagemService {
	
	private PassagemRepository repository;
	
	public PassagemServiceImpl(PassagemRepository repository) {
		this.repository = repository;
	}

	@Override
	public void salvar(Passagem passagem) {
		this.repository.save(passagem);
	}

	@Override
	public void editar(Passagem passagem) {
		this.salvar(passagem);
	}

	@Override
	public void excluir(UUID id) {
		Passagem passagem = this.buscarPorId(id);
		this.repository.delete(passagem);
	}

	@Override @Transactional(readOnly = true)
	public Passagem buscarPorId(UUID id) {
		return this.repository.findById(id).orElseThrow(
				() -> new RuntimeException("O ID informado [%s] não existe no banco."));
		}

	@Override @Transactional(readOnly = true)
	public List<Passagem> buscarTodos() {
		return this.repository.findAll();
	}

	@Override @Transactional(readOnly = true)
	public List<Passagem> buscarPorPassagens(Usuario usuario) {
		return this.repository.findByIdUsuario(usuario);
	}

}
