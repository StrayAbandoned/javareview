package lesson1.task3;

public class Triangle extends Figure{
    private Double h;
    private Double baseLength;

    public Triangle(Double h, Double baseLength) {
        this.h = h;
        this.baseLength = baseLength;
    }

    @Override
    Double findSquare() {
        return 0.5*h*baseLength;
    }
}
