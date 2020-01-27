package br.com.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.domain.Autor;
import br.com.library.repositories.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;
	
	public void save(Autor autor) {
		autorRepository.save(autor);
	}
	
	public Optional<Autor> find(Long id) {
		return autorRepository.findById(id);
	}
	
	public List<Autor> findAll() {
		return autorRepository.findAll();
	}
	
	public void delete(Long id) {
		autorRepository.deleteById(id);
	}
}
