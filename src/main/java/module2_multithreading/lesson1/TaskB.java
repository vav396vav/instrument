package module2_multithreading.lesson1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaskB extends Thread {

    @Override
    public void run() {
        log.info("Поток Б запущен. Имя потока: {}", this.getName());

        for (int i = 1; i <= 10; i++) {
            log.info("Поток Б: обработка элемента {}", i);

            try {
                long sleepTime = 150 + (long)(Math.random() * 200);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                log.error("Поток Б был прерван", e);
                Thread.currentThread().interrupt();
                return;
            }
        }

        log.info("Поток Б завершил работу.");
    }
}