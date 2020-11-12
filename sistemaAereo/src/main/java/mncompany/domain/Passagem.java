package mncompany.domain;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "Passagem")
public class Passagem extends AbstractEntity<Long> {
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario id_usuario;
	
	@OneToOne
	@JoinColumn(name="id_assento")
	private Assento id_assento;
	
	@OneToOne
	@JoinColumn(name="id_pagamento")
	private SituacaoPagamento id_pagamento;

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Assento getId_assento() {
		return id_assento;
	}

	public void setId_assento(Assento id_assento) {
		this.id_assento = id_assento;
	}

	public SituacaoPagamento getId_pagamento() {
		return id_pagamento;
	}

	public void setId_pagamento(SituacaoPagamento id_pagamento) {
		this.id_pagamento = id_pagamento;
	}
}
