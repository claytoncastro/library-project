package br.com.library.dto;

import java.io.Serializable;

import br.com.library.domain.Editora;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class EditoraDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	public EditoraDTO(Editora editora) {
		this.id = editora.getId();
		this.nome = editora.getNome();
	}
	
}