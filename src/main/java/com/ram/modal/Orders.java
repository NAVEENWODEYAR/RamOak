package com.ram.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ram.enums.EnumConstants;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Orders implements Serializable {

    private static final long serialVersionUID = -4739582878367211781L;

    @Id
    @NotNull(message = "ID cannot be null")
    private Integer id;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @JsonProperty(value = "Amount")
    private Double amount;

    public Orders() {
        this.amount = EnumConstants.DEFAULT_AMOUNT.value;
    }

    public Orders(Integer id, String description, Double amount) {
        this.id = id;
        this.description = description;
        setAmount(amount); 
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        this.amount = (amount == null) ? EnumConstants.DEFAULT_AMOUNT.value  : amount; 

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
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Orders other = (Orders) obj;
        return Objects.equals(amount, other.amount) &&
               Objects.equals(description, other.description) &&
               Objects.equals(id, other.id);
    }
}
