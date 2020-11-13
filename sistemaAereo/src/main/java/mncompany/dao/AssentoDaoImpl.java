package mncompany.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mncompany.domain.Assento;
import mncompany.domain.Voo;

@Repository
public class AssentoDaoImpl extends AbstractDao<Assento, Long> implements AssentoDao {
	
	public List<Assento> findByAssentos(Voo voo) {
		return createQuery("select * from assento a where a.id_voo = ?", voo.getId());
	}
}
