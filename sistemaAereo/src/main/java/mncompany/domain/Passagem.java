package mncompany.domain;

import javax.persistence.*;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "Passagem")
public class Passagem extends AbstractEntity<Long> {
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "preco", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private float preco;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario id_usuario;
	
	@OneToOne
	@JoinColumn(name="id_assento")
	private Assento id_assento;
	
	@OneToOne
	@JoinColumn(name="id_pagamento")
	private SituacaoPagamento id_pagamento;

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

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
