package module6_test.lesson3_expense;

import module6_test.lesson3_expense.dto.Expense;
import module6_test.lesson3_expense.dto.Income;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BudgetManager {
    private final List<Expense> expenses;
    private final List<Income> incomes;

    public BudgetManager() {
        expenses = new ArrayList<>();
        incomes = new ArrayList<>();
    }

    public void addExpenses(Expense expense) {
        expenses.add(expense);
    }

    public void addIncome(Income income){
        incomes.add(income);
    }

    public Optional<BigDecimal> averageIncome() {
        if (incomes.isEmpty()){
            return Optional.empty();
        }
        var incomeCount = new BigDecimal(incomes.size());
        return Optional.of(getTotalIncome().divide(incomeCount, RoundingMode.FLOOR));
    }

    public BigDecimal getTotalIncome() {
        return incomes.stream()
                .map(Income::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalExpense(){
        return expenses.stream()
                .map(Expense::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getBalance() {
        return getTotalIncome().subtract(getTotalExpense());
    }
}
