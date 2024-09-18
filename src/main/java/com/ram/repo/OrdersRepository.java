package com.ram.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.modal.Orders;

/**
 * @author NaveenWodeyar
 * @date 18-Sept-2024
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
