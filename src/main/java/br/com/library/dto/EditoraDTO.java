package br.com.library.dto;

import br.com.library.domain.Editora;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class EditoraDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String nome;
	
	public EditoraDTO(Editora editora) {
		this.id = editora.getId();
		this.nome = editora.getNome();
	}
	
}
