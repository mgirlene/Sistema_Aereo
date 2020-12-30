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

	@OneToOne
	@JoinColumn(name = "id_assento")
	private Assento idAssento;

	@OneToOne
	@JoinColumn(name = "id_pagamento")
	private SituacaoPagamento idPagamento;

	public Long getId() {
		return id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Assento getIdAssento() {
		return idAssento;
	}

	public void setIdAssento(Assento idAssento) {
		this.idAssento = idAssento;
	}

	public SituacaoPagamento getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(SituacaoPagamento idPagamento) {
		this.idPagamento = idPagamento;
	}

}
