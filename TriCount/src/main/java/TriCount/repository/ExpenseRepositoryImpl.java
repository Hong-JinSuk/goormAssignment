package TriCount.repository;

import TriCount.domain.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class ExpenseRepositoryImpl implements ExpenseRepository{

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    public ExpenseRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("expense")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Expense save(Expense expense) {
        Map<String, Object> param = new HashMap<>();

        param.put("name", expense.getName());
        param.put("settlement_id", expense.getSettlementId());
        param.put("payer_id", expense.getPayerId());
        param.put("payer_name", expense.getPayerName());
        param.put("amount", expense.getAmount());
        param.put("expense_date_time", expense.getExpenseDateTime());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(param));
        expense.setId(key.longValue());

        return expense;
    }
}
