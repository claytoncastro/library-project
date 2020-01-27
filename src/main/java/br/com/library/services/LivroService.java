package br.com.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.domain.Livro;
import br.com.library.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void save(Livro livro) {
		livroRepository.save(livro);
	}
	
	public Optional<Livro> find(Long id) {
		return livroRepository.findById(id);
	}
	
	public List<Livro> findAll() {
		return livroRepository.findAll();
	}
	
	public void delete(Long id) {
		livroRepository.deleteById(id);
	}
}
