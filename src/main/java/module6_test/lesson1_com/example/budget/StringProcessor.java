package module6_test.lesson1_com.example.budget;

public class StringProcessor {

    public StringProcessor() {
    }

    public String concatenate(String first, String second){
        return first + second;
    }

    public int getLength(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        } else {
            return input.length();
        }
    }
}
