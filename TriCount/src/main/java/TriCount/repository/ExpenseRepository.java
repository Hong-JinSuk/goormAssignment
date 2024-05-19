package TriCount.repository;

import TriCount.domain.Expense;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository {

    public Expense save(Expense expense);

}
