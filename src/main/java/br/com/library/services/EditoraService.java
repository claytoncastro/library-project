package br.com.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.domain.Editora;
import br.com.library.repositories.EditoraRepository;

@Service
public class EditoraService {
	
	@Autowired
	private EditoraRepository editoraRepository;
	
	public void save(Editora editora) {
		editoraRepository.save(editora);
	}
	
	public Optional<Editora> find(Long id) {
		return editoraRepository.findById(id);
	}
	
	public List<Editora> findAll() {
		return editoraRepository.findAll();
	}
	
	public void delete(Long id) {
		editoraRepository.deleteById(id);
	}
	
}
