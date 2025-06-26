package com.data.elearning_api.repository;

import com.data.elearning_api.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Account findByUsername(String username);
}