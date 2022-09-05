package module8.shapes;

public class Triangle extends Shape{
    private static final String TRIANGLE_NAME = "Triangle";

    @Override
    public void printShape() {
        System.out.println(TRIANGLE_NAME);
    }
}
