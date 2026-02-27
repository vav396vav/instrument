package module4_reflection.annotation.part2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class PrinterRobot {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Class<Printer> printerClass = Printer.class; // получили класс
        Method[] methods = printerClass.getMethods(); // Получаем все методы класса

        // Фильтруем
        Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(Order.class))
                .sorted(Comparator.comparingInt(method -> method.getAnnotation(Order.class).value()))
                .forEach(
                        method -> {
                            try {
                                method.invoke(printer);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                );
    }
}
