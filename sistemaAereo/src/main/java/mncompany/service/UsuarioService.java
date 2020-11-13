package mncompany.service;

import java.util.List;

import mncompany.domain.Usuario;

public interface UsuarioService {
	
	void salvar(Usuario usuario);

	void editar(Usuario usuario);

	void excluir(Long id);

	Usuario buscarPorId(Long id);

	List<Usuario> buscarTodos();
	
	Usuario buscarPorEmailESenha(String email, String senha);

}
