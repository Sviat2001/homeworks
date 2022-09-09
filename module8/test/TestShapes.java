package module8.test;

import module8.shapes.*;

public class TestShapes {

    public static void print(Shape shape) {
        System.out.println(shape.getName());
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{new Circle(), new Pentagon(), new Triangle(), new Rectangle(), new Octagon()};

        for(Shape shape : shapes) {
            print(shape);
        }
    }
}
