package com.habay.repository;

import com.habay.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findAllByIdInOrderById(List<Integer> ids);
}
