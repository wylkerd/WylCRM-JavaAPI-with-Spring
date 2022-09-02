package com.wylworks.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wylworks.crm.model.Client;

@Repository //Componente do Spring, estereótipo de repositório
public interface ClientRepository extends JpaRepository<Client, Long>{
	// Spring JPA Repository fornece vários metodos padrão automáticamene em tempo de execução
	
	// Métodos customizados
	// A criação de métodos customizados deve atentender um padrão, levando em consideração o nome das props
	List<Client> findByName(String name);
	
	//List<Client> findByNameAndId(String name, Long Id);
}
