package mncompany.domain;

import javax.persistence.*;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "Assento")
public class Assento extends AbstractEntity<Long> {

	@Column(name = "nome", nullable = false, length = 45)
	private String nome;
	
	@Column(name = "disponibilidade", nullable = false)
	private boolean disponibilidade;
	
	@Column(name = "classe", nullable = false)
	private String classe;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "preco", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private float preco;

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

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}
