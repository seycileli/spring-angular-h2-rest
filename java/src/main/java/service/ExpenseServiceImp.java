package service;

import model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ExpenseRepository;

import java.util.List;

@Service
public class ExpenseServiceImp implements ExpenseService {
    ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImp(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<Expense> findAll() {
        //will return all

        return expenseRepository.findAll();
    }

    @Override
    public Expense save(Expense expense) {
        expenseRepository.save(expense);
        return expense;
    }

    @Override
    public Expense findById(Long id) {
        if (expenseRepository.findById(id).isPresent()) {
            return expenseRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        expenseRepository.findById(id);
        expenseRepository.deleteById(id);
    }


}
