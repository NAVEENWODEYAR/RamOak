package com.ram.modal;
/**
 * @author NaveenWodeyar
 * @date 18-Sept-2024
 */
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Orders implements Serializable {
   
	private static final long serialVersionUID = -4739582878367211781L;
	
	@Id
    private Integer id;
	
    private String description;
    
    private Double amount;
    
    public Orders() {}
    
	public Orders(int id, String description, Double amount) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", description=" + description + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, description, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(description, other.description) && id == other.id;
	}

	
}