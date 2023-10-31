package com.ProjetojpaGerenciamento_de_Funcionarios.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Funcionario")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull

	private String nome;
	
	@NotNull

	private String telefone;
	
	@NotNull

	private String cpf;
	
	@NotNull

	private String rg;
	
	@NotNull

	private String endereco;
	
	@NotNull

	private String cargo;
	
	@NotNull
	private double salario;
	
}