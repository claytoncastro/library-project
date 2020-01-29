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
	private LivroRepository repo;
	
	public Livro insert(Livro livro) {
		return repo.save(livro);
	}
	
	public Livro update(Livro livro) {
		find(livro.getId());
		return repo.save(livro);
	}
	
	public Livro find(Long id) {
		Optional<Livro> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}
	
	public List<Livro> findAll() {
		return repo.findAll();
	}
	
	public void delete(Long id) {
		find(id);
		repo.deleteById(id);
	}
	
	public Livro fromDTO(LivroDTO livroDto) {
		return new Livro(livroDto.getId(), livroDto.getTitulo(), livroDto.getAno(), livroDto.getAutores(), livroDto.getEditora());
	}
}
