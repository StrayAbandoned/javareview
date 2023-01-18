package lesson1.task3;

public class TaskThree {
    public static void main(String[] args) {
        Figure r = new Round(5.0);
        Figure t = new Triangle(4.0, 2.0);
        Figure s = new Square(2.0);
        System.out.println("Square of round: " + r.findSquare());
        System.out.println("Square of triangle: " + t.findSquare());
        System.out.println("Square of square: " + s.findSquare());

    }
}
