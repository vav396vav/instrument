package module2_multithreading.lesson2_Thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongTask extends Thread{
    @Override
    public void run() {
        log.info("Начало работы потока");

        while (true) {
            if (this.isInterrupted()) {
                log.warn("Получено прерывание, завершаю работу. ");
                return;
            }

            log.info("Выполняю полезную работу ");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.warn("Поток разбужен принудительно! ");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
