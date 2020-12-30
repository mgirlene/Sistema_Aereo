package mncompany.domain.entity;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "Passagem")
public class Passagem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String usuario;

	@ManyToOne
	@JoinColumn(name = "id_assento")
	private Assento assento;

	@ManyToOne
	@JoinColumn(name = "id_pagamento")
	private SituacaoPagamento pagamento;

	public Long getId() {
		return id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}

	public SituacaoPagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(SituacaoPagamento pagamento) {
		this.pagamento = pagamento;
	}

}
