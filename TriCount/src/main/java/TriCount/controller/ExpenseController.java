package TriCount.controller;

import TriCount.domain.ExpenseDTO;
import TriCount.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<Void> addExpenseToSettlement(@RequestBody ExpenseDTO expenseDTO) {
        expenseService.addExpense(expenseDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
