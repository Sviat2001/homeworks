package module8.test;

import module8.shapes.*;

public class TestShapes {

    public static void printer(Shape shape) {
        shape.printShape();
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{new Circle(), new Pentagon(), new Triangle(), new Rectangle(), new Octagon()};

        for(Shape shape : shapes) {
            printer(shape);
        }
    }
}
