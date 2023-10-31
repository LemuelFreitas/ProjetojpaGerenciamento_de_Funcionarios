package com.ProjetojpaGerenciamento_de_Funcionarios.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetojpaGerenciamento_de_Funcionarios.Service.FuncionarioService;
import com.ProjetojpaGerenciamento_de_Funcionarios.entities.Funcionario;


import jakarta.validation.Valid;


@RestController
@RequestMapping("/Funcionario")
public class FuncionarioController {

	private final FuncionarioService funcionarioService;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioservice) {
		this.funcionarioService = funcionarioservice;
	}

	@GetMapping("/{id}")
	
	public ResponseEntity<Funcionario> buscaFuncionarioControlId(@PathVariable Long id) {
		Funcionario funcionario = funcionarioService.buscaFuncionarioId(id);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	
	public ResponseEntity<List<Funcionario>> buscaTodosFuncionariosControl() {
		List<Funcionario> Funcionario = funcionarioService.buscaTodosFuncionarios();
		return ResponseEntity.ok(Funcionario);
	}

	@PostMapping("/")
	
	public ResponseEntity<Funcionario> salvaFuncionarioControl(@RequestBody Funcionario funcionario) {
		Funcionario salvaFuncionario = funcionarioService.salvaFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaFuncionario);
	}

	@PutMapping("/{id}")
	
	public ResponseEntity<Funcionario> alteraFuncionarioControl(@PathVariable Long id, @RequestBody @Valid Funcionario funcionario) {
		Funcionario alteraFuncionario = funcionarioService.alterarFuncionario(id, funcionario);
		if (alteraFuncionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<Funcionario> apagaFuncionarioControl(@PathVariable Long id) {
		boolean apagar = funcionarioService.apagarFuncionario(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}