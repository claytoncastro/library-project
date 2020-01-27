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

import br.com.library.domain.Editora;
import br.com.library.services.EditoraService;

@RestController
@RequestMapping(path = "/editora")
public class EditoraResource {
	
	@Autowired
	private EditoraService editoraService;
	
	@PostMapping
	public void save(@RequestBody Editora livro) {
		editoraService.save(livro);
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Editora> find(@PathVariable(value = "id") Long id) {
		return editoraService.find(id);
	}

	@GetMapping(path = "/list")
	public List<Editora> listAll() {
		return editoraService.findAll();
	}
	
	@DeleteMapping(value = "/{id}")
	public Long delete(@PathVariable(value = "id") Long id) {
		editoraService.delete(id);
		return id;
	}
}