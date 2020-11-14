package mncompany.service;

import java.util.List;
import java.util.UUID;

import mncompany.domain.entity.Usuario;

public interface UsuarioService {
	
	void salvar(Usuario usuario);

	void editar(Usuario usuario);

	void excluir(UUID id);

	Usuario buscarPorId(UUID id);

	List<Usuario> buscarTodos();
	
	Usuario buscarPorEmailESenha(String email, String senha);

}
