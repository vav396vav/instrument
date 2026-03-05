package module6_test.lesson3_expense.dto;

import java.math.BigDecimal;

public record Income(BigDecimal amount, String source, String description) {
    public Income(double amount,String source, String description) {
        this(BigDecimal.valueOf(amount),source ,description);
    }
}
