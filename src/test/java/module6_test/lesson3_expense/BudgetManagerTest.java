package module6_test.lesson3_expense;

import module6_test.lesson3_expense.dto.Expense;
import module6_test.lesson3_expense.dto.Income;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetManagerTest {
    //  переменная, где хранится объект
    private BudgetManager manager;

    // Метод, где создается объект
    @BeforeEach
    public void setUp() {
        manager = new BudgetManager();
    }

    // Метод, где тестируется добавления расходов
    @Test
    @DisplayName("Test add expenses")
    public void testAddExpense(){
        // Создаем новый расход
        Expense expense = new Expense(new BigDecimal("200"), "Обед" );
        // Добавляем его в список с помощью метода add()
        manager.addExpenses(expense);
        // Метод насчитывает сумму расходов
        var totalExpense = manager.getTotalExpense();
        // Вызываем метод assertEquals(), который сравнивает результат
        assertEquals(new BigDecimal("200"), totalExpense);
    }

    @Test
    @DisplayName("Добавление доходов")
    void testAddIncome(){
        Income income = new Income(new BigDecimal("1000"), "Salary", "main");
        manager.addIncome(income);
        var totalIncome = manager.getTotalIncome();
        assertEquals(new BigDecimal("1000"), totalIncome);
    }

    @Test
    @DisplayName("Проверка баланса")
    public void testGetBalance() {
        Income income = new Income(new BigDecimal("1000"), "Salary", "main");
        manager.addIncome(income);
        Expense expense = new Expense(new BigDecimal("200"), "Обед" );
        manager.addExpenses(expense);
        assertEquals(new BigDecimal("800"), manager.getBalance());
    }

    @Test
    @DisplayName("Проверка на пустой")
    public void testAverageIncomeIfNoIncomes(){
        assertEquals(Optional.empty(), manager.averageIncome());
    }

    @Test
    @DisplayName("Test average if a few incomes")
    public void testAverageIncomeIfFewIncomes() {
        manager.addIncome( new Income(new BigDecimal("20"), "source", "description"));
        manager.addIncome( new Income(new BigDecimal("40"), "source", "description"));
        BigDecimal actual = manager.averageIncome().get();
        assertEquals(new BigDecimal("30"), actual);
    }
}
