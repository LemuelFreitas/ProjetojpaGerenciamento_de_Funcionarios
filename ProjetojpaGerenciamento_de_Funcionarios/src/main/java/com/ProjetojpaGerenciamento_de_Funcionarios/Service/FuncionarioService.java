package com.ProjetojpaGerenciamento_de_Funcionarios.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetojpaGerenciamento_de_Funcionarios.Repository.FuncionarioRepository;
import com.ProjetojpaGerenciamento_de_Funcionarios.entities.Funcionario;
@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	public List<Funcionario> buscaTodosFuncionarios(){
		return funcionarioRepository.findAll();
	}
	public Funcionario buscaFuncionarioId(Long id) {
		Optional <Funcionario> Funcionario = funcionarioRepository.findById(id);
		return Funcionario.orElse(null);
	}
	public Funcionario salvaFuncionario(Funcionario Funcionario) {
		return funcionarioRepository.save(Funcionario);
	}
	public Funcionario alterarFuncionario(Long id, Funcionario alterarF) {
		Optional <Funcionario> existeFuncionario = funcionarioRepository.findById(id);
		if(existeFuncionario.isPresent()) {
			alterarF.setId(id);
			return funcionarioRepository.save(alterarF);
		}
		return null;
	}
	public boolean apagarFuncionario(Long id) {
		Optional <Funcionario> existeFuncionario = funcionarioRepository.findById(id);
		if (existeFuncionario.isPresent()) {
			funcionarioRepository.deleteById(id);
			return true;
		}
		return false;
		}
}
