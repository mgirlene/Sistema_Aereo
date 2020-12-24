package mncompany.service;

import java.util.List;

import mncompany.domain.entity.Passagem;
import mncompany.domain.entity.Usuario;

public interface PassagemService {
	
	void salvar(Passagem passagem);

	void editar(Passagem passagem);

	void excluir(Long id);

	Passagem buscarPorId(Long id);

	List<Passagem> buscarTodos();
	
	List<Passagem> buscarPorPassagens(Usuario usuario);

	List<Passagem> buscaPorJoin(Long id);
}
