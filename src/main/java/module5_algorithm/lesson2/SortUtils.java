package module5_algorithm.lesson2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

public class SortUtils {
    private static final Logger journal = LoggerFactory.getLogger(SortUtils.class);

    // Обобщённый метод (Generics)
    // T - любой тип, который реализует интерфейс Comparable<T>
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        // Проверка на корректность входных данных
        if (array == null || array.length == 0) {
            journal.warn("Попытка сортировки null или пустого массива. Операция пропущена.");
            return; // Принудительный выход из метода
        }

        long startTime = System.nanoTime();
        int swapCount = 0;
        int n = array.length;

        // Внешний цикл: проходит по всему массиву
        for (int i = 0; i < n - 1; i++) {
            // Внутренний цикл: сравнивает соседние элементы
            // После каждой итерации внешний цикла наибольший элемент "всплывает" в конец
            for (int j = 0; j < n - i - 1; j++) {
                // Сравнение элементов с помощью метода compareTo
                // Если array[j] > array[j+1], то compareTo вернёт > 0
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // Обмен элементов (swap)
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapCount++;
                }
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        journal.info("Сортировка завершена.");
        journal.info("Затраченное время: {} нс", duration);
        journal.info("Количество обменов (swaps): {}", swapCount);
        journal.debug("Результат: {}", Arrays.toString(array));
    }
}