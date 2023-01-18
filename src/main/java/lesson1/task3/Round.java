package lesson1.task3;

public class Round extends Figure{
    private Double radius;

    public Round(Double radius) {
        this.radius = radius;
    }

    @Override
    Double findSquare() {
        return 3.14*radius*radius;
    }
}
