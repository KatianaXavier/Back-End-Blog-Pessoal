package com.generation.blogpessoal.repository;

import java.util.List;

import com.generation.blogpessoal.model.Postagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
// extende o Jpa para dar o "superpoder" para essa interface efetivamente ser um repository. dentro das <>, indicar a tabela e o tipo de dado do Id
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	public List <Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);

}
