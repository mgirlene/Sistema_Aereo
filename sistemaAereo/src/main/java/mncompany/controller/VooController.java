package mncompany.controller;
/*
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import mncompany.domain.entity.PesquisaVoo;
import mncompany.service.VooService;

@RestController*/
public class VooController {
	/*
	private Long id;
	
	@Autowired
	private VooService vooService;
	
	
	@GetMapping("/pesquisarPassagem/{id}")
	public String pesquisa(PesquisaVoo voo, @PathVariable("id") Long id) {
		this.id = id;
		return "home";
	}
	
	@PostMapping("/pesquisarPassagem/{id}")
	public ModelAndView buscar(@RequestBody PesquisaVoo voo, @PathVariable("id") Long id) {
		return new ModelAndView("/listagem/{" + id + "}/{" + voo.getOrigem() + "}/{" + voo.getDestino() + "}/{" + voo.getDataIda() 
		+ "}/{" + voo.getDataVolta() + "}/{" + voo.getClasse() + "}");
	}
	
	@GetMapping("/listagem/{id}/{origem}/{destino}/{dataIda}/{dataVolta}/{classe}")
	public ModelAndView listagem(@PathVariable("id") Long id, @PathVariable("origem") String origem, @PathVariable("destino") String destino,
			@PathVariable("dataIda") LocalDate dataIda, @PathVariable("dataVolta") LocalDate dataVolta, @PathVariable("classe") String classe) {
		
		ModelAndView mv = new ModelAndView("/reservas/{id}");
		
		mv.addObject("vooIda", vooService.buscarPorVoos(origem, destino, dataIda));
		
		if(dataVolta != null) {
			mv.addObject("vooVolta", vooService.buscarPorVoos(destino, origem, dataVolta));
		}
		
		return mv;
		
	}*/

}