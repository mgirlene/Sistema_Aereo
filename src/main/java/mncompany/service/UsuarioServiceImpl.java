package mncompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mncompany.domain.entity.Usuario;
import mncompany.repository.UsuarioRepository;

@Service
@Transactional(readOnly = false)

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public UsuarioServiceImpl(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public void salvar(Usuario usuario) {
		this.repository.save(usuario);
	}

	@Override
	public void editar(Usuario usuario) {
		this.salvar(usuario);
	}

	@Override
	public void excluir(Long id) {
		Usuario usuario = this.buscarPorId(id);
		this.repository.delete(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscarPorId(Long id) {
		return this.repository.findById(id)
				.orElseThrow(() -> new RuntimeException("O ID informado [%s] nÃ£o existe no banco."));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> buscarTodos() {
		return this.repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscarPorEmailESenha(String email, String senha) {
		return this.repository.findByEmailAndSenha(email, senha);
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return this.repository.findByEmail(email);
	}

	public Usuario getEmail(String email) {
		return repository.findByEmail(email);
	}

}
