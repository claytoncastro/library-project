package br.com.library.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import br.com.library.domain.Autor;
import br.com.library.domain.Editora;
import br.com.library.domain.Livro;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class LivroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String titulo;
	private Date ano;
	private List<Autor> autores;
	private Editora editora;
	
	public LivroDTO(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.ano = livro.getAno();
		this.autores = livro.getAutores();
		this.editora = livro.getEditora();
	}

}
