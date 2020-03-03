package com.fatmanur.expenset.serviceimp;


import com.fatmanur.expenset.model.Category;
import com.fatmanur.expenset.model.Expense;
import com.fatmanur.expenset.model.Location;
import com.fatmanur.expenset.repository.ExpenseRepository;
import com.fatmanur.expenset.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;

   @Override
    public List<String> getAllLocations() {
        List<String> locaiton = new ArrayList<String>();
        for (Location lc : Location.values()) {
            locaiton.add(lc.toString());
        }
        return locaiton;
    }

    @Override
    public Collection<Expense> findAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense createExpense(Expense expense) {
        System.out.println("Expense service");
        return expenseRepository.save(expense);
    }

    @Override
    public ResponseEntity<?> findExpenseyById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        return expense.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteById(Long id) {
expenseRepository.deleteById(id);
    }
}