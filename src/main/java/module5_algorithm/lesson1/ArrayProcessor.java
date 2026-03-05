package module5_algorithm.lesson1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayProcessor {
    private static final  Logger log = LoggerFactory.getLogger(ArrayProcessor.class);
    private final int[] array;

    public ArrayProcessor(int[] array) {
        this.array = array;
    }

    public void arrayProcessor() {
        if (array == null || array.length < 1){
            log.error("Массив не может быть пустым");
            return ;
        }
        long start = System.nanoTime();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < array.length; i++){
//            if (array[i] > max){
//                max = array[i];
//            }
//            if (array[i] < min){
//                min = array[i];
//            }
//        }
        for (int j : array) {
            if (j > max) {
                max = j;
            }
            if (j < min) {
                min = j;
            }
        }
        long stop = System.nanoTime();
        long timeDifference = stop - start;

        log.info("Минимально значение массива: {}", min);
        log.info("Максимальное значение массива :{} ", max );
        log.info("Затраченное время: {} ns", timeDifference );
    }
}
