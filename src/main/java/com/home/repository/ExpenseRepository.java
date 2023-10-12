package com.home.repository;

import com.home.dto.Expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ExpenseRepository extends JpaRepository<Expense, Long> {
    public List<Expense> getByExpId(Long id);
    public List<Expense> getByExpByAndExpId(String by, Long id);
}
