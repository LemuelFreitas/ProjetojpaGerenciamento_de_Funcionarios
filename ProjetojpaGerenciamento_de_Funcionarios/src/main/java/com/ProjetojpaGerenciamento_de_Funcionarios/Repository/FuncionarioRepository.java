package com.ProjetojpaGerenciamento_de_Funcionarios.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetojpaGerenciamento_de_Funcionarios.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}