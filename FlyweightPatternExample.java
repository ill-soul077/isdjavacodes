
import java.util.HashMap;
import java.util.Map;

public class FlyweightPatternExample {

    interface Shape {

        void draw();
    }

    static class Circle implements Shape {

        private String color;

        public Circle(String color) {
            this.color = color;
        }

        @Override
        public void draw() {
            System.out.println("Drawing Circle with color: " + color);
        }
    }

    class ShapeFactory {

        private static final Map<String, Shape> circleMap = new HashMap<>();

        public static Shape getCircle(String color) {
            Circle circle = (Circle) circleMap.get(color);
            if (circle == null) {
                circle = new Circle(color);
                circleMap.put(color, circle);
                System.out.println("Creating new Circle with color: " + color);
            } else {
                System.out.println(
                "Returning the already existing circle of color: " + color);
            }
            return circle;
        }
    }



    public static void main(String[] args) {
        // Using the flyweight factory to get circles with different colors
        Shape redCircle = ShapeFactory.getCircle("Red");
        Shape greenCircle = ShapeFactory.getCircle("Green");
        Shape blueCircle = ShapeFactory.getCircle("Blue");
        Shape redCircleAgain = ShapeFactory.getCircle("Red"); // Reusing
    }
}
