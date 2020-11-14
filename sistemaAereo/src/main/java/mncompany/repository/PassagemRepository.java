package mncompany.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import mncompany.domain.entity.Passagem;
import mncompany.domain.entity.Usuario;

public interface PassagemRepository  extends JpaRepository<Passagem, UUID> {
	List<Passagem> findByIdUsuario(Usuario idUsuario);
	
}
