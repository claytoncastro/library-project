package br.com.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.library.domain.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

}
