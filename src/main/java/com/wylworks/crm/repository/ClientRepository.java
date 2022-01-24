package com.wylworks.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wylworks.crm.model.Client;

@Repository //Componente do Spring, estereótipo de repositório
public interface ClientRepository extends JpaRepository<Client, Long>{
	// Spring JPA fornece vários metodos padrão automáticamene em tempo de execução
}
