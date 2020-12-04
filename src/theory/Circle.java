package theory;

public class Circle implements Figure {
    private double radius;

    public Circle(double r) {
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double square() {
        return 3.14 * radius * radius;
    }

    @Override
    public double length() {
        return 3.14 * 2 * radius;
    }

    @Override
    public void print() {
        System.out.println("Окружность, r: " + radius);
    }
}
