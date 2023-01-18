package lesson1.task3;

public class Square extends Figure{
    private Double h;

    public Square(Double h) {
        this.h = h;
    }

    @Override
    Double findSquare() {
        return h*h;
    }
}
