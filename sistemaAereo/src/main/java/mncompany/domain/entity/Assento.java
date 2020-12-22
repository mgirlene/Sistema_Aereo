package mncompany.domain.entity;


import java.io.Serializable;

import javax.persistence.*;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "Assento")
public class Assento implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 45)
	private String nome;
	
	@Column(nullable = false)
	private boolean disponibilidade;
	
	@Column( nullable = false)
	private String classe;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private float preco;

	@ManyToOne
	@JoinColumn(name = "id_voo")
	private Voo idVoo;
	
	@OneToOne(mappedBy="idAssento")
	@JsonIgnore
	private Passagem passagem;


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

	public Voo getIdVoo() {
		return idVoo;
	}

	public void setIdVoo(Voo id_voo) {
		this.idVoo = id_voo;
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

	public Long getId() {
		return id;
	}

	
}
