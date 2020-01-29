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
	private EditoraRepository repo;
	
	public Editora insert(Editora editora) {
		return repo.save(editora);
	}
	
	public Editora update(Editora editora) {
		find(editora.getId());
		return repo.save(editora);
	}
	
	public Editora find(Long id) {
		Optional<Editora> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Editora.class.getName()));
	}
	
	public List<Editora> findAll() {
		return repo.findAll();
	}
	
	public void delete(Long id) {
		find(id);
		repo.deleteById(id);
	}
	
	public Editora fromDTO(EditoraDTO editoraDto) {
		return new Editora(editoraDto.getId(), editoraDto.getNome());
	}
	
}
