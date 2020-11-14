package mncompany.domain.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "Usuario")
public class Usuario extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID uuid;

	@Column(nullable = false, length = 45)
	private String nome;

	@Column(nullable = false, length = 45)
	private String email;

	@Column(nullable = false, length = 45)
	private String senha;

	@OneToMany(mappedBy = "id_usuario")
	private List<Passagem> passagens;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UUID getUuid() {
		return uuid;
	}

	public List<Passagem> getPassagens() {
		return passagens;
	}

	public void setPassagens(List<Passagem> passagens) {
		this.passagens = passagens;
	}
}
