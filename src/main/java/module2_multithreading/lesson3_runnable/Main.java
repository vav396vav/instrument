package module2_multithreading.lesson3_runnable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        PrintTask task = new PrintTask("Alpha");

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.setName("Worker-1");
        thread2.setName("Worker-2");

        // 1. СНАЧАЛА ЗАПУСКАЕМ
        thread1.start();
        thread2.start();

        log.info("Оба потока запущены. Ждем завершения...");

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            log.warn("Поток прерван во время ожидания");
        }

        log.info("Оба потока завершили работу с одной задачей.");
    }
}
