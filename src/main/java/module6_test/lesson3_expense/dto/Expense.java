package module6_test.lesson3_expense.dto;

import java.math.BigDecimal;

public record Expense(BigDecimal amount, String description) {
    public Expense(double amount, String description) {
        this(BigDecimal.valueOf(amount), description);
    }
}
