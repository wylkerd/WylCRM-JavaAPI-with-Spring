package com.wylworks.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("GetByName") // GetByFilter?name=Wylkerd
	public List<Client> findByName(@RequestParam(value = "name", defaultValue = "wylkerd") String name) {
		return clientRepository.findByName(name);
	}
	
	@GetMapping("GetByFilter") // GetByFilter?name=Wylkerd&&id=1
	public List<Client> findByFilter(
			@RequestParam(value = "name", defaultValue = "wylkerd", required = false) String name,
			@RequestParam(value = "id", defaultValue = "", required = false) Long id
	) {
		// Criando um obj de Client com params recebidos utilizando Lombok @Builder
		Client client = Client.builder()
				.name(name)
				.id(id)
				.build();
		
		// realizando busca por meio das props opcionais
		return clientRepository.findAll(Example.of(client)); // Criando um exemplo de client à partir do objeto
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
