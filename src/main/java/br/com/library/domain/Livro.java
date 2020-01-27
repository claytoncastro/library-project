package br.com.library.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Livro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Getter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Getter @Setter
	private String titulo;
	@Getter @Setter
	private Date ano;
	@Getter @Setter
	private List<Autor> autores;
	@Getter @Setter
	private Editora editora;
}
