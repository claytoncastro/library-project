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

import br.com.library.domain.Autor;
import br.com.library.dto.AutorDTO;
import br.com.library.services.AutorService;

@RestController
@RequestMapping(path = "/autores")
public class AutorResource {
	
	@Autowired
	private AutorService service;
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody AutorDTO autorDto) {
		Autor autor = service.fromDTO(autorDto);
		autor = service.insert(autor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody AutorDTO autorDto, @PathVariable Long id) {
		Autor autor = service.fromDTO(autorDto);
		autor.setId(id);
		service.update(autor);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Autor> find(@PathVariable(value = "id") Long id) {
		Autor autor = service.find(id);
		return ResponseEntity.ok().body(autor);
	}
	
	@GetMapping
	public ResponseEntity<List<AutorDTO>> findAll() {
		List<Autor> autorList = service.findAll();
		List<AutorDTO> autorDto = autorList.stream()
				.map(autor -> new AutorDTO(autor)).collect(Collectors.toList());
		return ResponseEntity.ok().body(autorDto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
