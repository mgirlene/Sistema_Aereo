package mncompany.domain.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class PesquisaVoo {
	
	private String origem;
	
	private String destino;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataIda;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataVolta;
	
	private String classe;
	
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

	
	public LocalDate getDataIda() {
		return dataIda;
	}

	public void setDataIda(LocalDate dataIda) {
		this.dataIda = dataIda;
	}

	public LocalDate getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(LocalDate dataVolta) {
		this.dataVolta = dataVolta;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

}
