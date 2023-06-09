package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// indica ao spring que o objeto de postragem vai virar uma tabela no banco de dados
@Entity
// passar um nome para a tabela no banco de dados
@Table(name = "tb_postagens")

public class Postagem {

	// indica a chave primária da tabela de postagem
	@Id

	// equivalente ao auto_increment na criação da chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// validações
	@NotBlank(message = "O atributo 'título' é obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo 'título' deve conter no mínimo 5 e no máximo 100 caracteres!")
	private String titulo;

	@NotBlank(message = "O atributo 'texto' é obrigatório!")
	@Size(min = 10, max = 700, message = "O atributo 'texto' deve conter no mínimo 10 e no máximo 700 caracteres!")
	private String texto;

	// pega a hora e dia
	@UpdateTimestamp
	private LocalDateTime data;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	// getters e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}