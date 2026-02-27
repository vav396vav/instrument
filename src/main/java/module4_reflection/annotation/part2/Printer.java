package module4_reflection.annotation.part2;

public class Printer {

    @Order(20)
    public void print(){
        System.out.println("Printer печатает");
    }

    @Order(10)
    public void on() {
        System.out.println("Включен принтер");
    }

    @Order(30)
    public void off () {
        System.out.print("Выключить принтер");
    }
}
