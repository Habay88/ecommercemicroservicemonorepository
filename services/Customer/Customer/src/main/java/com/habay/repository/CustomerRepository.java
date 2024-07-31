package com.habay.repository;
import com.habay.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface CustomerRepository extends MongoRepository<Customer, String > {

        }

