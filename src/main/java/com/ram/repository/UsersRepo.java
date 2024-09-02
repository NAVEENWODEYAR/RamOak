package com.ram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.model.Users;
/**
 * @author NaveenWodeyar
 * @date 02-Sept-2024
 */
@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {

}
