package module2_multithreading.lesson3_runnable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintTask implements Runnable {
    private String taskName;

    public PrintTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            log.info("Задача {}: шаг № {} в потоке {}", taskName, i, Thread.currentThread().getName());
            try{
                Thread.sleep(300);
            } catch (InterruptedException e) {
                log.error("Поток был прерван!");
                Thread.currentThread().interrupt();
                return;
            }
        }
        log.info("Поток {} завершён.", Thread.currentThread().getName());
    }
}
