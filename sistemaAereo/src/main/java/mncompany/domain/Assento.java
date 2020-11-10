package mncompany.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "Assento")
public class Assento extends AbstractEntity<Long> {

	@Column(name = "nome", nullable = false, length = 45)
	private String nome;
	@Column(name = "disponibilidade", nullable = false)
	private boolean disponibilidade;

	@ManyToOne
	@JoinColumn(name = "id_voo")
	private Voo id_voo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public Voo getId_voo() {
		return id_voo;
	}

	public void setId_voo(Voo id_voo) {
		this.id_voo = id_voo;
	}
}
