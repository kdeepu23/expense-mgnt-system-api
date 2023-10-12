package com.home.controller;

import com.home.dto.Expense;
import com.home.services.ExpenseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(description="Operations pertaining to products in Online Store")
public class ExpController {

    @Autowired
    ExpenseService expenseService;

    @ApiOperation(value = "Add expense(s) ", response = List.class)
    @PostMapping("/addExpense")
    public List<Long> addExp(@RequestBody(required=true) List<Expense> body){
        return expenseService.storeExp(body).stream().map(val->val.getExpId()).collect(Collectors.toList());
    }

    @GetMapping("/updateExpense")
    public Expense updateExp(){
        return null;
        //return new Expense("Shopping Added",new Date(),120.89,"Guna","Added Expenses");
    }

    @GetMapping("/getExpense")
    public List<Expense> getExp(){
       return expenseService.retriveExp();

        //return new Expense("Grocery-Updated",new Date(),120.89,"Guna","Updated Expenses");
    }
   @GetMapping("/retriveExp")
   public List<Expense> getExp(@RequestParam(required = true, name="exp_id") Long id, @RequestParam(required = true, name="by") String name){
       System.out.println("+++++++++++++"+id);
       return expenseService.retrieveExpById(id, name);
    }

    @GetMapping("/deleteExpense")
    public Expense deleteExp(){
        return null;
        //return new Expense("Shopping Deleted",new Date(),120.89,"Guna","Updated Expenses");
    }



}

