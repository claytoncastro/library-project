package br.com.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.library.domain.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
