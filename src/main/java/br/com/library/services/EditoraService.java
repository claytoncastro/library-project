package br.com.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.domain.Editora;
import br.com.library.dto.EditoraDTO;
import br.com.library.repositories.EditoraRepository;
import br.com.library.services.exceptions.ObjectNotFoundException;

@Service
public class EditoraService {
	
	@Autowired
	private EditoraRepository repository;
	
	public Editora insert(Editora editora) {
		return repository.save(editora);
	}
	
	public Editora update(Editora editora) {
		find(editora.getId());
		return repository.save(editora);
	}
	
	public Editora find(Long id) {
		Optional<Editora> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Editora.class.getName()));
	}
	
	public List<Editora> findAll() {
		return repository.findAll();
	}
	
	public void delete(Long id) {
		find(id);
		repository.deleteById(id);
	}
	
	public Editora fromDTO(EditoraDTO editoraDto) {
		return new Editora(editoraDto.getId(), editoraDto.getNome());
	}
	
}
