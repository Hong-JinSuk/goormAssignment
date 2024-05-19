package TriCount.domain;

import TriCount.MemberContext;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExpenseDTO {
    private String name;
    private Long settlementId;
    private Long payerId = MemberContext.getMember().getId();
    private String payerName = MemberContext.getMember().getName();
    private BigDecimal amount;
}
