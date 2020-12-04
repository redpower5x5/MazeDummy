package theory;

public class Rectangle implements Figure {
    private double width;
    private double height;

    public Rectangle(double w, double h) {
        this.width = w;
        this.height = h;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double square() {
        return height * width;
    }

    @Override
    public double length() {
        return 2 * (height + width);
    }

    @Override
    public void print() {
        System.out.println("Прямоигольник, w: " + width + ", h: " + height);
    }
}
