package TriCount.service;

import TriCount.domain.Expense;
import TriCount.domain.ExpenseDTO;
import TriCount.domain.Settlement;
import TriCount.repository.ExpenseRepository;
import TriCount.repository.SettlementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final SettlementRepository settlementRepository;

    public void addExpense(ExpenseDTO expenseDTO) {
        Optional<Settlement> settlementOptional = settlementRepository.findById(expenseDTO.getSettlementId());
        if (!settlementOptional.isPresent()) {
            throw new RuntimeException("");
        }

        Expense expense = new Expense();
        expense.setName(expenseDTO.getName());
        expense.setSettlementId(expenseDTO.getSettlementId());
        expense.setPayerId(expenseDTO.getPayerId());
        expense.setPayerName(expenseDTO.getPayerName());
        expense.setAmount(expenseDTO.getAmount());
        expense.setExpenseDateTime(LocalDateTime.now());

        expenseRepository.save(expense);
    }
}
