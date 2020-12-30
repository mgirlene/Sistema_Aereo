package mncompany.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "Voo")
public class Voo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 45)
	private String origem;

	@Column(nullable = false, length = 45)
	private String destino;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_saida", nullable = false, columnDefinition = "DATE")
	private LocalDate dataSaida;

	@DateTimeFormat(iso = ISO.TIME)
	@Column(name = "hora_saida", nullable = false, columnDefinition = "TIME")
	private LocalTime horaSaida;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_chegada", nullable = false, columnDefinition = "DATE")
	private LocalDate dataChegada;

	@DateTimeFormat(iso = ISO.TIME)
	@Column(name = "hora_chegada", nullable = false, columnDefinition = "TIME")
	private LocalTime horaChegada;

	@Column(nullable = false, length = 45)
	private String companhia;
	
	@OneToMany(mappedBy  = "voo")
	@JsonIgnore
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

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public LocalTime getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalTime horaSaida) {
		this.horaSaida = horaSaida;
	}

	public LocalDate getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(LocalDate dataChegada) {
		this.dataChegada = dataChegada;
	}

	public LocalTime getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(LocalTime horaChegada) {
		this.horaChegada = horaChegada;
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

	public Long getId() {
		return id;
	}

}
