package module5_algorithm.lesson1;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
//        int size = 10_000; // Подчеркивание для читаемости (Java 7+), равно 10000
//        int[] largeArray = new int[size]; // Создаем массив нужного размера
//        Random random = new Random(); // Создаем генератор
//
//        for (int i = 0; i < largeArray.length; i++) {
//            largeArray[i] = random.nextInt(1000); // Заполняем числами от 0 до 999
//        }

        // Одна строка создает и заполняет массив:
        int[] largeArray = ThreadLocalRandom.current()
                .ints(10_000, 0, 100_000) // 10000 чисел в диапазоне [0, 100000)
                .toArray();

        ArrayProcessor processor = new ArrayProcessor(largeArray);
        processor.arrayProcessor();
    }
}
