package module4_reflection.annotation.part2;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Order {
    int value() default Integer.MAX_VALUE;
}
