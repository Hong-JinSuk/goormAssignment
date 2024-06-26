package TriCount.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Balance {

    private BigDecimal payAmount;
    private BigDecimal getAmount;

}
