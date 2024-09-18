package com.ram.service;
/**
 * @author NaveenWodeyar
 * @date 18-Sept-2024
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ram.modal.Orders;
import com.ram.repo.OrdersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository orderRepository;

   
    public Optional<Orders> findById(int id) {
        return orderRepository.findById(id);
    }

    @Cacheable("mycache")
    public List<Orders> findAll() {
    System.out.println("fetchin data from db");
    
    System.out.println("data is fetcing from database");
    
    	return orderRepository.findAll();
    }

    public Orders save(Orders order) {
        return orderRepository.save(order);
    }


    public void delete(int id) {
        orderRepository.deleteById(id);
    }
}