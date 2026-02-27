package module4_reflection.annotation.part1;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
public @interface AnnotationRuntaim {
}
