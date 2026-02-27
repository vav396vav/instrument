package module4_reflection.intro;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Класс для анализа других классов с помощью рефлексии.
 * Демонстрирует основные возможности механизма рефлексии в Java.
 */
public class ClassAnalyzer {

    /**
     * Точка входа в программу.
     * Создаёт объект для анализа и выводит информацию о его классе.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {

        // === ШАГ 1: Создаём объект для анализа ===

        // Создаём экземпляр класса Person с помощью конструктора с тремя параметрами
        // 'new' — оператор создания нового объекта
        // 'Person(...)' — вызов конструктора класса Person
        Person person = new Person("Александр", 25, "alex@example.com");

        // Выводим информацию о созданном объекте
        System.out.println("=== Создан объект для анализа ===");
        System.out.println("Объект: " + person);
        System.out.println();

        // === ШАГ 2: Получаем объект Class для анализа ===

        // Вызываем метод getClass() у объекта person
        // Метод getClass() унаследован от класса Object
        // Возвращает объект типа Class<?>, который содержит метаинформацию о классе Person
        Class<?> personClass = person.getClass();

        // === ШАГ 3: Выводим основную информацию о классе ===

        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                  АНАЛИЗ КЛАССА PERSON                      ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println();

        // Выводим полное имя класса (с пакетом)
        // getName() — метод класса Class, возвращает полное имя класса
        System.out.println("🔹 Полное имя класса: " + personClass.getName());

        // Выводим простое имя класса (без пакета)
        // getSimpleName() — метод класса Class, возвращает только имя класса
        System.out.println("🔹 Простое имя класса: " + personClass.getSimpleName());

        // Выводим имя пакета
        // getPackage() — метод класса Class, возвращает объект Package
        // getName() — метод класса Package, возвращает имя пакета
        System.out.println("🔹 Пакет: " + personClass.getPackage().getName());

        // Проверяем, является ли класс публичным
        // getModifiers() — метод класса Class, возвращает целое число с битовыми флагами модификаторов
        // Modifier.isPublic() — статический метод класса Modifier, проверяет, установлен ли флаг 'public'
        boolean isPublic = Modifier.isPublic(personClass.getModifiers());
        System.out.println("🔹 Модификатор доступа: " + (isPublic ? "public" : "не public"));

        // Проверяем, является ли класс финальным (нельзя наследоваться)
        boolean isFinal = Modifier.isFinal(personClass.getModifiers());
        System.out.println("🔹 Является ли final: " + (isFinal ? "да" : "нет"));

        // Получаем родительский класс
        // getSuperclass() — метод класса Class, возвращает Class<?> родительского класса
        // Если родительский класс — Object, то выводим "Object"
        Class<?> superClass = personClass.getSuperclass();
        System.out.println("🔹 Родительский класс: " + (superClass != null ? superClass.getSimpleName() : "null"));

        System.out.println();

        // === ШАГ 4: Анализируем поля класса ===

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("🔹 ПОЛЯ КЛАССА");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        // Получаем все поля класса (включая private)
        // getDeclaredFields() — метод класса Class
        // Возвращает массив объектов типа Field
        // 'Declared' означает, что возвращаются поля только текущего класса (не родительских)
        Field[] fields = personClass.getDeclaredFields();

        // Если полей нет, выводим сообщение
        if (fields.length == 0) {
            System.out.println("   Нет полей в классе");
        } else {
            // Проходим по каждому полю с помощью цикла for-each
            // 'for (Field field : fields)' — синтаксис цикла for-each
            // 'field' — текущий элемент массива на каждой итерации
            for (Field field : fields) {

                // Получаем модификаторы поля
                // getModifiers() — метод класса Field, возвращает целое число с битовыми флагами
                int modifiers = field.getModifiers();

                // Строим строку с модификаторами
                StringBuilder modifiersStr = new StringBuilder();

                // Проверяем каждый возможный модификатор и добавляем его в строку
                if (Modifier.isPublic(modifiers)) modifiersStr.append("public ");
                if (Modifier.isPrivate(modifiers)) modifiersStr.append("private ");
                if (Modifier.isProtected(modifiers)) modifiersStr.append("protected ");
                if (Modifier.isStatic(modifiers)) modifiersStr.append("static ");
                if (Modifier.isFinal(modifiers)) modifiersStr.append("final ");

                // Получаем тип поля
                // getType() — метод класса Field, возвращает Class<?> типа поля
                // getSimpleName() — возвращает простое имя типа (например, "String", "int")
                String type = field.getType().getSimpleName();

                // Получаем имя поля
                // getName() — метод класса Field, возвращает имя поля
                String name = field.getName();

                // Формируем строку с информацией о поле
                String fieldInfo = "   " + modifiersStr.toString().trim() + " " + type + " " + name;

                // Выводим информацию о поле
                System.out.println(fieldInfo);
            }
        }

        System.out.println();

        // === ШАГ 5: Анализируем методы класса ===

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("🔹 МЕТОДЫ КЛАССА");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        // Получаем все методы класса (включая private)
        // getDeclaredMethods() — метод класса Class
        // Возвращает массив объектов типа Method
        Method[] methods = personClass.getDeclaredMethods();

        // Если методов нет, выводим сообщение
        if (methods.length == 0) {
            System.out.println("   Нет методов в классе");
        } else {
            // Проходим по каждому методу
            for (Method method : methods) {

                // Получаем модификаторы метода
                int modifiers = method.getModifiers();

                // Строим строку с модификаторами
                StringBuilder modifiersStr = new StringBuilder();
                if (Modifier.isPublic(modifiers)) modifiersStr.append("public ");
                if (Modifier.isPrivate(modifiers)) modifiersStr.append("private ");
                if (Modifier.isProtected(modifiers)) modifiersStr.append("protected ");
                if (Modifier.isStatic(modifiers)) modifiersStr.append("static ");
                if (Modifier.isFinal(modifiers)) modifiersStr.append("final ");

                // Получаем тип возвращаемого значения
                // getReturnType() — метод класса Method, возвращает Class<?> типа возвращаемого значения
                String returnType = method.getReturnType().getSimpleName();

                // Получаем имя метода
                String name = method.getName();

                // Получаем параметры метода
                // getParameterTypes() — метод класса Method, возвращает массив Class<?> типов параметров
                Class<?>[] parameterTypes = method.getParameterTypes();

                // Строим строку с типами параметров
                StringBuilder paramsStr = new StringBuilder();
                paramsStr.append("(");

                // Проходим по каждому типу параметра
                for (int i = 0; i < parameterTypes.length; i++) {
                    // Добавляем имя типа параметра
                    paramsStr.append(parameterTypes[i].getSimpleName());

                    // Если это не последний параметр, добавляем запятую и пробел
                    if (i < parameterTypes.length - 1) {
                        paramsStr.append(", ");
                    }
                }

                paramsStr.append(")");

                // Формируем строку с информацией о методе
                String methodInfo = "   " + modifiersStr.toString().trim() + " " +
                        returnType + " " + name + paramsStr.toString();

                // Выводим информацию о методе
                System.out.println(methodInfo);
            }
        }

        System.out.println();

        // === ШАГ 6: Анализируем конструкторы класса ===

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("🔹 КОНСТРУКТОРЫ КЛАССА");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        // Получаем все конструкторы класса (включая private)
        // getDeclaredConstructors() — метод класса Class
        // Возвращает массив объектов типа Constructor<?>
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();

        // Если конструкторов нет, выводим сообщение
        if (constructors.length == 0) {
            System.out.println("   Нет конструкторов в классе");
        } else {
            // Проходим по каждому конструктору
            for (Constructor<?> constructor : constructors) {

                // Получаем модификаторы конструктора
                int modifiers = constructor.getModifiers();

                // Строим строку с модификаторами
                StringBuilder modifiersStr = new StringBuilder();
                if (Modifier.isPublic(modifiers)) modifiersStr.append("public ");
                if (Modifier.isPrivate(modifiers)) modifiersStr.append("private ");
                if (Modifier.isProtected(modifiers)) modifiersStr.append("protected ");

                // Получаем имя класса (конструкторы не имеют имени, но можно получить имя класса)
                String className = constructor.getName();

                // Получаем параметры конструктора
                Class<?>[] parameterTypes = constructor.getParameterTypes();

                // Строим строку с типами параметров
                StringBuilder paramsStr = new StringBuilder();
                paramsStr.append("(");

                for (int i = 0; i < parameterTypes.length; i++) {
                    paramsStr.append(parameterTypes[i].getSimpleName());
                    if (i < parameterTypes.length - 1) {
                        paramsStr.append(", ");
                    }
                }

                paramsStr.append(")");

                // Формируем строку с информацией о конструкторе
                String constructorInfo = "   " + modifiersStr.toString().trim() + " " +
                        className + paramsStr.toString();

                // Выводим информацию о конструкторе
                System.out.println(constructorInfo);
            }
        }

        System.out.println();
        System.out.println("✅ Анализ завершён!");
    }
}