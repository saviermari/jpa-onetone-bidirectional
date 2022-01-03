package com.smari.server.dao;

import com.smari.server.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author smari
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
