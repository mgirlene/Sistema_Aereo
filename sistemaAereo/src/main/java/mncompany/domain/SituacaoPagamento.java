package mncompany.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "SituacaoPagamento")
public class SituacaoPagamento extends AbstractEntity<Long> {

	@Column(name = "status", nullable = false, length = 45)
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
