package mncompany.dao;

import org.springframework.stereotype.Repository;

import mncompany.domain.Usuario;

@Repository
public class UsuarioDaoImpl extends AbstractDao<Usuario, Long> implements UsuarioDao {

	public Usuario findByLoginAndPassword(String email, String senha) {
		return createQuerySimple("select id from usuario u where u.email = ? and u.senha = ?", email, senha);
	}
}
