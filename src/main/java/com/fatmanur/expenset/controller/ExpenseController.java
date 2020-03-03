package com.fatmanur.expenset.controller;

import com.fatmanur.expenset.model.Category;
import com.fatmanur.expenset.model.Expense;
import com.fatmanur.expenset.model.User;
import com.fatmanur.expenset.service.ExpenseService;
import com.fatmanur.expenset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api-expense")
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    @GetMapping(value = "/getAllLocations")
    public List<String> getAllLocations() {
        return expenseService.getAllLocations();
    }

    @GetMapping(value = "/expenses")
    Collection<Expense> expenses() {
        return expenseService.findAllExpenses();
    }

    @GetMapping("/getexpense/{id}")
    ResponseEntity<?> getExpense(@PathVariable Long id){
        return expenseService.findExpenseyById(id);
    }

    @PostMapping("/saveexpense")
    ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) throws URISyntaxException {
        Expense result= expenseService.createExpense(expense);
        System.out.println("Expense Controller ");
        return ResponseEntity.created(new URI("/api/expense" + result.getId())).body(result);
    }

    @PutMapping("/updatecategory/{id}")
    ResponseEntity<Expense> updateExpense(@Valid @RequestBody Expense expense){
        Expense result= expenseService.createExpense(expense);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/deleteexpense/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id){
        expenseService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
