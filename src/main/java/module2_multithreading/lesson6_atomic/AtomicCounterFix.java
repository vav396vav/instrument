package module2_multithreading.lesson6_atomic;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class AtomicCounterFix {

    // Было: private static int count = 0;
    // Стало: Используем AtomicInteger. Начальное значение 0.
    private static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];

        // Создаем 10 потоков
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                // Каждый поток увеличивает счетчик 1000 раз
                for (int j = 0; j < 1000; j++) {
                    // ВАЖНО: Метод incrementAndGet() атомарный!
                    // Он делает всё (чтение, +1, запись) за один шаг.
                    atomicCount.incrementAndGet();
                }
            });
            threads[i].start();
        }

        // Ждем завершения всех потоков
        for (Thread thread : threads) {
            thread.join();
        }

        // Получаем итоговое значение методом get()
        int finalResult = atomicCount.get();

        log.info("Ожидаемое значение: 10000");
        log.info("Реальное значение: {}", finalResult);

        if (finalResult == 10000) {
            log.info("✅ УСПЕХ! Все операции сохранены благодаря AtomicInteger.");
        } else {
            log.error("❌ ОШИБКА! Потеряны обновления (этого не должно быть).");
        }
    }
}