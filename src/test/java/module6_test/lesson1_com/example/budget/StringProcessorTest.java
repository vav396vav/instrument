package module6_test.lesson1_com.example.budget;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringProcessorTest {
    private StringProcessor processor;

    @BeforeEach
    public void setUp() {
        processor = new StringProcessor();
    }

    @Test
    @DisplayName("Конкатенация строк")
    void test_concatenate() {
        String first = "Hello";
        String second = "World";

        String result = processor.concatenate(first, second);

        assertEquals("HelloWorld", result);
    }

    @Test
    @DisplayName("Получение длины строки")
    void test_GetLength(){
        String input = "hello";

        int length = processor.getLength(input);

        assertEquals(5,length);
    }
}
