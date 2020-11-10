package mncompany.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "Usuario")
public class Usuario extends AbstractEntity<Long> {
	
	@Column(name = "nome", nullable = false, length = 45)
	private String nome;
	
	@Column(name = "email", nullable = false, unique = true, length = 45)
	private String email;
	
	@Column(name = "senha", nullable = false, length = 45)
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
}
