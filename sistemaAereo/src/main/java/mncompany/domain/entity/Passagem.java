package mncompany.domain.entity;

import java.util.UUID;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "Passagem")
public class Passagem extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID uuid;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario idUsuario;
	
	@OneToOne
	@JoinColumn(name="id_assento")
	private Assento idAssento;
	
	@OneToOne
	@JoinColumn(name="id_pagamento")
	private SituacaoPagamento idPagamento;

	public UUID getUuid() {
		return uuid;
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
