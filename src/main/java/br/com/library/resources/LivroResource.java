package br.com.library.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.library.domain.Livro;
import br.com.library.dto.LivroDTO;
import br.com.library.services.LivroService;

@RestController
@RequestMapping(path = "/livros")
public class LivroResource {
	
	@Autowired
	private LivroService livroService;
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody LivroDTO livroDto) {
		Livro livro = livroService.fromDTO(livroDto);
		livro = livroService.insert(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody LivroDTO livroDto, @PathVariable Long id) {
		Livro livro = livroService.fromDTO(livroDto);
		livro.setId(id);
		livro = livroService.update(livro);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> find(@PathVariable(value = "id") Long id) {
		Livro livro = livroService.find(id);
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll() {
		List<Livro> livroList = livroService.findAll();
		List<LivroDTO> livroDto = livroList.stream()
				.map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
		return ResponseEntity.ok().body(livroDto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
