package com.ram.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author NaveenWodeyar
 * @date 02-Sept-2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SCHEDULERS_USERS")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;

	public Users() {
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + "]";
	}

	public Users(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
