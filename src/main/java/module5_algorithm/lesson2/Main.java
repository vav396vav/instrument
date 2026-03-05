package module5_algorithm.lesson2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

public class Main {
    private static final Logger journal = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // 1. Создание тестовых данных
        Student[] students = {
                new Student("Александр", 5),
                new Student("Борис", 3),
                new Student("Виктор", 5),
                new Student("Анна", 4),
                new Student("Дмитрий", 3),
                new Student("Елена", 5),
                new Student("Георгий", 2),
                new Student("Иван", 4),
                new Student("Кирилл", 3),
                new Student("Мария", 5)
        };

        // 2. Логирование исходного состояния
        journal.info("Исходный массив студентов:");
        journal.info("{}", Arrays.toString(students));

        // 3. Вызов метода сортировки
        // Метод статический, поэтому вызываем через имя класса
        SortUtils.bubbleSort(students);

        // 4. Логирование результата
        journal.info("Отсортированный массив студентов:");
        journal.info("{}", Arrays.toString(students));

        // 5. Демонстрация обработки пустого массива (для проверки защиты)
        Student[] emptyArray = {};
        SortUtils.bubbleSort(emptyArray);

        // 6. Демонстрация обработки null (для проверки защиты)
        SortUtils.bubbleSort(null);
    }
}