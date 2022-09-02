package com.wylworks.crm.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import lombok.Data;  // Gerador de códigos bolierPlate


//@Data // Gera Getters, Setters, HashCode and equals por meio do Lombok
@Entity
public class Client {
	
	// Properties
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // BD fará o incremento automático do ID
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	// Boilerplate codes

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) { // Verifica se o objeto é igual a partir do id
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
