package com.wylworks.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wylworks.crm.model.Client;
import com.wylworks.crm.repository.ClientRepository;

@RestController
@RequestMapping("/clientes")
public class ClientController {
	
	@Autowired // Injeta uma instância de ClientRepository aqui automaticamente, permitindo o uso da interface
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<Client> listar() {
		return clientRepository.findAll();
	}
	
	@GetMapping("GetById/{id}")
	public Optional<Client> listarTodos(@PathVariable Long id) {
		return clientRepository.findById(id);
	}
	
	/*	// Método Post para criar um por um
	 	@PostMapping
		@ResponseStatus(code = HttpStatus.CREATED)
		public Client adicionar(@RequestBody Client cliente) { // RequestBody converte o jsonBody para um obj Java do tipo Cliente
			return clientRepository.save(cliente);
		}
	*/
	
	///*
	@PostMapping("criarVarios")
	@ResponseStatus(code = HttpStatus.CREATED)
	public List<Client> adicionarClientes(@RequestBody List<Client> clientes) { // RequestBody converte o jsonBody para um obj Java do tipo Cliente
		return clientRepository.saveAll(clientes);
	}
	//*/
	
	@DeleteMapping("/{id}")
	public String deleteCliente(@PathVariable Long id) {
		clientRepository.deleteById(id);
		
		return "Cliente excluído com sucesso!";
	}
	
	@DeleteMapping()
	public String deleteAll() {
		clientRepository.deleteAll();
		
		return "Clientes excluídos com sucesso!";
	}
}
