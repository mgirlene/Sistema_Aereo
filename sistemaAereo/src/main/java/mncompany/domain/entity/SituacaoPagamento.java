package mncompany.domain.entity;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "SituacaoPagamento")
public class SituacaoPagamento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 45)
	private String status;
	
	@OneToOne(mappedBy="idPagamento")
	private Passagem passagem;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	
}
