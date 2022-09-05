package module8.shapes;

public class Circle extends Shape{
    private static final String CIRCLE_NAME = "Circle";

    @Override
    public void printShape() {
        System.out.println(CIRCLE_NAME);
    }
}
