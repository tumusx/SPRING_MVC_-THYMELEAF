package br.ifg.controller;

import br.ifg.model.entities.Convidado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifg.model.dao.ConvidadoDAO;

@Controller
@RequestMapping("livros")
public class ConvidadoController {

	@Autowired
	ConvidadoDAO livroDAO;
	
	@GetMapping("/listar")
	public ModelAndView listar() {		
		ModelAndView mv = new ModelAndView("/livros/listar");
		mv.addObject("listaLivros", livroDAO.findAll());
		return mv;
	}
		
	@GetMapping("/cadastrar")
	public String cadastrar(Convidado livro) {
		return "/livros/cadastrar";
	}
	
	@PostMapping("/salvar")
	public String salvar(Convidado convidado, RedirectAttributes attr) {
		if (convidado.getNomeConvidado().isEmpty() || convidado.getTipoConvidado().isEmpty()) {
			attr.addFlashAttribute("fail", "Não foi possível inserir");			
		}				
		try {			
			livroDAO.insert(convidado);
			attr.addFlashAttribute("success", "Registro inserido com sucesso");
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Não foi possível inserir");
		}  		
		return "redirect:/livros/cadastrar";
	}
	
	@GetMapping("/editar/{idConvidado}")
	public ModelAndView preEditar(@PathVariable("idConvidado") Long id) {
		ModelAndView mv = new ModelAndView("/livros/cadastrar");
		mv.addObject("convidado", livroDAO.findById(id));
		return mv;
	}
	
	@PostMapping("/editar")
	public String editar(Convidado convidado, RedirectAttributes attr) {
		
		try {
			livroDAO.update(convidado);
			attr.addFlashAttribute("success", "Registro editado com sucesso");
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Não foi possível editar");
			System.out.println(e.getMessage());
		}  
		
		return "redirect:/livros/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {		
		
		try {
			livroDAO.deleteById(id);
			attr.addFlashAttribute("success", "Registro deletado com sucesso");
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Não foi possível deletar");
		}		
		
		return "redirect:/livros/listar";
	}
	
}
