package module2_multithreading.lesson2_Thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        LongTask longTask = new LongTask();
        longTask.setName("SlowWorker");

        longTask.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error("ошибка",e);
        }

        log.info("Главный поток решил прервать рабочий");
        longTask.interrupt();

        longTask.join();

        log.info("Конец программы");
    }

}
