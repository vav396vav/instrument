package module2_multithreading.lesson1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("=== Начало программы ===");

        // 1. Создаем объекты потоков.
        // Так как TaskA extends Thread, то taskA — это и есть поток.
        TaskA threadA = new TaskA();
        TaskB threadB = new TaskB();

        // (Опционально) Зададим имена потокам для красоты в логах
        threadA.setName("Worker-A");
        threadB.setName("Worker-B");

        // 2. ЗАПУСКАЕМ потоки
        // Вызываем метод start(), который определен в родителе (Thread).
        // Он создает новый системный поток и вызывает наш переопределенный метод run().
        threadA.start();
        threadB.start();

        log.info("Потоки запущены. Главный поток ждет завершения...");

        // 3. Ждем завершения (Join)
        try {
            // Главный поток (main) заблокируется здесь, пока threadA не закончит
            threadA.join();
            // Затем ждет threadB
            threadB.join();
        } catch (InterruptedException e) {
            log.error("Главный поток прерван во время ожидания", e);
            Thread.currentThread().interrupt();
        }

        log.info("=== Все задачи выполнены. Программа завершена ===");
    }
}