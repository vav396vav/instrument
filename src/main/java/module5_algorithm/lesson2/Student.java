package module5_algorithm.lesson2;

public class Student implements Comparable<Student> {
    private final String name;
    private final int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student other) {
        // Сравниваем текущий объект (this) с другим (other) по полю grade
        // Integer.compare возвращает:
        // < 0, если this.grade < other.grade
        // 0, если равны
        // > 0, если this.grade > other.grade
        return Integer.compare(this.grade, other.grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
