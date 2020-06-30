package br.com.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.domain.Autor;
import br.com.library.dto.AutorDTO;
import br.com.library.repositories.AutorRepository;
import br.com.library.services.exceptions.ObjectNotFoundException;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository repository;
	
	public Autor insert(Autor autor) {
		return repository.save(autor);
	}
	
	public Autor update(Autor autor) {
		find(autor.getId());
		return repository.save(autor);
	}
	
	public Autor find(Long id) {
		Optional<Autor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Autor.class.getName()));
	}
	
	public List<Autor> findAll() {
		return repository.findAll();
	}
	
	public void delete(Long id) {
		find(id);
		repository.deleteById(id);
	}
	
	public Autor fromDTO(AutorDTO autorDto) {
		return new Autor(autorDto.getId(), autorDto.getNome(), autorDto.getLivros());
	}
}
