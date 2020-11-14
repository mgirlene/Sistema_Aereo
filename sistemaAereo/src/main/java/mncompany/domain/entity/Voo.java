package mncompany.domain.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "Voo")
public class Voo extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID uuid;

	@Column(nullable = false, length = 45)
	private String origem;

	@Column(nullable = false, length = 45)
	private String destino;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate data_saida;

	@DateTimeFormat(iso = ISO.TIME)
	@Column(nullable = false, columnDefinition = "TIME")
	private LocalTime hora_saida;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate data_chegada;

	@DateTimeFormat(iso = ISO.TIME)
	@Column(nullable = false, columnDefinition = "TIME")
	private LocalTime hora_chegada;

	@Column(nullable = false, length = 45)
	private String companhia;

	@OneToMany(mappedBy = "id_voo")
	private List<Assento> assentos;

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDate getData_saida() {
		return data_saida;
	}

	public void setData_saida(LocalDate data_saida) {
		this.data_saida = data_saida;
	}

	public LocalTime getHora_saida() {
		return hora_saida;
	}

	public void setHora_saida(LocalTime hora_saida) {
		this.hora_saida = hora_saida;
	}

	public LocalDate getData_chegada() {
		return data_chegada;
	}

	public void setData_chegada(LocalDate data_chegada) {
		this.data_chegada = data_chegada;
	}

	public LocalTime getHora_chegada() {
		return hora_chegada;
	}

	public void setHora_chegada(LocalTime hora_chegada) {
		this.hora_chegada = hora_chegada;
	}

	public String getCompanhia() {
		return companhia;
	}

	public void setCompanhia(String companhia) {
		this.companhia = companhia;
	}

	public List<Assento> getAssentos() {
		return assentos;
	}

	public void setAssentos(List<Assento> assentos) {
		this.assentos = assentos;
	}

	public UUID getUuid() {
		return uuid;
	}

}
