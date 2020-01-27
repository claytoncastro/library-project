package br.com.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.library.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
