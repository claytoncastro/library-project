package br.com.library.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.library.domain.Livro;
import br.com.library.services.LivroService;

@RestController
@RequestMapping(path = "/")
public class LivroResource {
	
	@Autowired
	private LivroService livroService;
	
	@PostMapping
	public void save(@RequestBody Livro livro) {
		livroService.save(livro);
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Livro> find(@PathVariable(value = "id") Long id) {
		return livroService.find(id);
	}

	@GetMapping(path = "/list")
	public List<Livro> listAll() {
		return livroService.findAll();
	}
	
	@DeleteMapping(value = "/{id}")
	public Long delete(@PathVariable(value = "id") Long id) {
		livroService.delete(id);
		return id;
	}
}
