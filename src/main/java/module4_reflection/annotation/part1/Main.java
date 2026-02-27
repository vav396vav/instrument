package module4_reflection.annotation.part1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Processor> processorClass = Processor.class;
        Method doProcessMethod = processorClass.getMethod("doProcess");

        Annotation[] declaredAnnotations = doProcessMethod.getDeclaredAnnotations();

        Arrays.stream(declaredAnnotations)
                .map(annotation -> annotation.annotationType().getSimpleName())
                .forEach(System.out::println);
    }
}
