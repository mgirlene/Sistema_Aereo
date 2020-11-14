package mncompany.dao;

import java.util.List;

import mncompany.domain.entity.Usuario;

public interface UsuarioDao {
	
	void save(Usuario usuario);
	
	void update(Usuario usuario);
	
	void delete(Long id);
	
	Usuario findById(Long id);
	
	List<Usuario> findAll();
	
	Usuario findByLoginAndPassword(String email, String senha);

}
