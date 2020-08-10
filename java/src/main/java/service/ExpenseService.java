package service;

import model.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> findAll();
    Expense save(Expense expense);
    Expense findById(Long id);
    void delete(Long id);

}