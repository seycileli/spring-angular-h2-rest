package controller;

import model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ExpenseService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class ExpenseController {
    /* we will name it api to keep it simple here
    * we can name it anything, but we will leave it as v1 for now, because this is version 1 */
    ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        //constructor injected
        this.expenseService = expenseService;
    }

    /**
     * An overloaded Method approach.
     * This will be an easy way to remember which method we will like to call / use
     *
     * The first method, will be a get / find all approach
     * the second method, will return back a specific id #
     * @return get();
     */
    @GetMapping("/expenses")
    public ResponseEntity<List<Expense>> get() {
        List<Expense> expense = expenseService.findAll();

        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @GetMapping("/expenses/{id}")
    public ResponseEntity<Expense> get(@PathVariable("id") Long id) {
        Expense expense = expenseService.findById(id);

        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @PostMapping("/expenses")
    public ResponseEntity<Expense> save(@RequestBody Expense expense) {
        Expense myExpense = expenseService.save(expense);

        return new ResponseEntity<>(myExpense, HttpStatus.OK);
    }

    @DeleteMapping("/expenses/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        //we will return back a message upon deletion being a success
        expenseService.delete(id);

        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

}
