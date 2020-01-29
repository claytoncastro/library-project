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

import br.com.library.domain.Editora;
import br.com.library.dto.EditoraDTO;
import br.com.library.services.EditoraService;

@RestController
@RequestMapping(path = "/editoras")
public class EditoraResource {
	
	@Autowired
	private EditoraService editoraService;
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody EditoraDTO editoraDto) {
		Editora editora = editoraService.fromDTO(editoraDto);
		editora = editoraService.insert(editora);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(editora.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody EditoraDTO editoraDto, @PathVariable Long id) {
		Editora editora = editoraService.fromDTO(editoraDto);
		editora.setId(id);
		editora = editoraService.update(editora);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Editora> find(@PathVariable(value = "id") Long id) {
		Editora editora = editoraService.find(id);
		return ResponseEntity.ok().body(editora);
	}
	
	@GetMapping
	public ResponseEntity<List<EditoraDTO>> findAll() {
		List<Editora> editoraList = editoraService.findAll();
		List<EditoraDTO> editoraDto = editoraList.stream()
				.map(editora -> new EditoraDTO(editora)).collect(Collectors.toList());
		return ResponseEntity.ok().body(editoraDto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
		editoraService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
