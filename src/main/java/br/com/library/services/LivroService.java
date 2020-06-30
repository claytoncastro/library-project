package br.com.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.domain.Livro;
import br.com.library.dto.LivroDTO;
import br.com.library.repositories.LivroRepository;
import br.com.library.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	public Livro insert(Livro livro) {
		return repository.save(livro);
	}
	
	public Livro update(Livro livro) {
		find(livro.getId());
		return repository.save(livro);
	}
	
	public Livro find(Long id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}
	
	public List<Livro> findAll() {
		return repository.findAll();
	}
	
	public void delete(Long id) {
		find(id);
		repository.deleteById(id);
	}
	
	public Livro fromDTO(LivroDTO livroDto) {
		return new Livro(livroDto.getId(), livroDto.getTitulo(), livroDto.getAno(), livroDto.getAutores(), livroDto.getEditora());
	}
}
