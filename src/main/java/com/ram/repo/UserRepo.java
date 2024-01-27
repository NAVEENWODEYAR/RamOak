package com.ram.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.entity.UserInfo;
import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<UserInfo, Integer> {

    Optional<UserInfo> findByUserName(String userName);
}
