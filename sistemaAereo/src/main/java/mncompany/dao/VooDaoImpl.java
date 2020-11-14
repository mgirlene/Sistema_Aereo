package mncompany.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import mncompany.domain.entity.Voo;

@Repository
public class VooDaoImpl extends AbstractDao<Voo, Long> implements VooDao  {

	public List<Voo> findByVoos(String origem, String destino, LocalDate dataIda) {
		return createQuery("select * from voo v where v.origem = ? and v.destino = ? and v.data_ida = ?", origem, destino, dataIda);
	}
}
