package module2_multithreading.lesson1;

import lombok.extern.slf4j.Slf4j;

// Наследуемся от класса Thread.
// Теперь TaskA — это полноценный поток, у него есть методы start(), run(), sleep() и т.д.
@Slf4j
public class TaskA extends Thread {

    // Переопределяем метод run().
    // Всё, что написано здесь, будет выполняться в отдельном потоке при вызове start().
    @Override
    public void run() {
        log.info("Поток А запущен. Имя потока: {}", this.getName());
        // this.getName() эквивалентно Thread.currentThread().getName(),
        // так как внутри метода run() 'this' и есть текущий поток.

        for (int i = 1; i <= 10; i++) {
            log.info("Поток А: шаг номер {}", i);

            try {
                // Метод sleep() статический, но его можно вызывать и просто как sleep(),
                // так как мы находимся внутри класса-наследника Thread.
                // Но лучше писать Thread.sleep() для ясности.
                long sleepTime = 100 + (long)(Math.random() * 200);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                log.error("Поток А был прерван", e);
                // Восстанавливаем флаг прерывания
                Thread.currentThread().interrupt();
                return; // Завершаем выполнение потока
            }
        }

        log.info("Поток А завершил работу.");
    }
}