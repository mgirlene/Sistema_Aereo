package mncompany.domain.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@SuppressWarnings("serial")
@Entity
@Table(name = "Passagem")
public class Passagem implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="id_usuario")
	private Usuario idUsuario;
	
	@OneToOne
	@JsonIgnore
	@JoinColumn(name="id_assento")
	private Assento idAssento;
	
	@OneToOne
	@JsonIgnore
	@JoinColumn(name="id_pagamento")
	private SituacaoPagamento idPagamento;

	public Long getId() {
		return id;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
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
