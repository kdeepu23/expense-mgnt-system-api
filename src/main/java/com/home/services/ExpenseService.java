package com.home.services;

import com.home.dto.Expense;
import com.home.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository ;

    public List<Expense> storeExp(List<Expense> expense){
        return expenseRepository.saveAll(expense);
    }

    public List<Expense> retriveExp(){
        return expenseRepository.findAll();
    }

    public List<Expense> retrieveExpById(Long id, String expByName){
       return expenseRepository.getByExpByAndExpId(expByName, id);
    }
}


