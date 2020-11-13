package mncompany.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mncompany.domain.Passagem;
import mncompany.domain.Usuario;

@Repository
public class PassagemDaoImpl extends AbstractDao<Passagem, Long> implements PassagemDao {

	public List<Passagem> findByPassagens(Usuario usuario) {
		return createQuery("select * from passagem p where p.id_usuario = ?", usuario.getId());
	}
}
