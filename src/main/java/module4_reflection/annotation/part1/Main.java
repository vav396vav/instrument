package module4_reflection.annotation.part1;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;


@Slf4j public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Processor> processorClass = Processor.class;
        Method doProcessMethod = processorClass.getMethod("doProcess");
        System.out.println("Проверка");

        Annotation[] declaredAnnotations = doProcessMethod.getDeclaredAnnotations();

        Arrays.stream(declaredAnnotations)
                .map(annotation -> annotation.annotationType().getSimpleName())
                .forEach(System.out::println);
    }
}
