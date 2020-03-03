package com.fatmanur.expenset.service;


import com.fatmanur.expenset.model.Expense;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

public interface  ExpenseService {
    public List<String> getAllLocations();

    Collection<Expense> findAllExpenses();

    Expense createExpense(Expense expense);

    ResponseEntity<?> findExpenseyById(Long id);

    void deleteById(Long id);
}