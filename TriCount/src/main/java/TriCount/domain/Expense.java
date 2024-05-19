package TriCount.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Expense {

    private Long id;

    private String name;
    private Long settlementId;
    private Long payerId;
    private String payerName;
    private BigDecimal amount;
    private LocalDateTime expenseDateTime;

    public Expense() {
    }
}
