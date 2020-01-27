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

import br.com.library.domain.Autor;
import br.com.library.services.AutorService;

@RestController
@RequestMapping(path = "/")
public class AutorResource {
	
	@Autowired
	private AutorService autorService;
	
	@PostMapping
	public void save(@RequestBody Autor autor) {
		autorService.save(autor);
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Autor> find(@PathVariable(value = "id") Long id) {
		return autorService.find(id);
	}

	@GetMapping(path = "/list")
	public List<Autor> listAll() {
		return autorService.findAll();
	}
	
	@DeleteMapping(value = "/{id}")
	public Long delete(@PathVariable(value = "id") Long id) {
		autorService.delete(id);
		return id;
	}
}
