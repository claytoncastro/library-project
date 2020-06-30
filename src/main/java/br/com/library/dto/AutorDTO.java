package br.com.library.dto;

import br.com.library.domain.Autor;
import br.com.library.domain.Livro;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
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
