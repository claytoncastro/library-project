package br.com.library.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import br.com.library.domain.Autor;
import br.com.library.domain.Livro;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class AutorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String nome;
	private List<Livro> livros;
	
	public AutorDTO(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.livros = autor.getLivros();
	}
	
}
