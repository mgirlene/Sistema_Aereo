package mncompany.domain.entity;

import java.util.UUID;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "SituacaoPagamento")
public class SituacaoPagamento extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID uuid;

	@Column(nullable = false, length = 45)
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UUID getUuid() {
		return uuid;
	}
}
