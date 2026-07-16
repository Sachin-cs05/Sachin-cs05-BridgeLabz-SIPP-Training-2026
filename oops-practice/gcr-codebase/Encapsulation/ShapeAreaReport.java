public class ShapeAreaReport {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(7),
            new Rectangle(10, 5),
            new Triangle(6, 8, 10)
        };

        String[] shapeNames = {"Circle", "Rectangle", "Triangle"};

        System.out.println("Shape Area Report");
        System.out.println("----------------------------------------------------");
        System.out.printf("%-12s %-15s %-15s%n", "Shape", "Area", "Perimeter");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < shapes.length; i++) {
            System.out.printf("%-12s %-15.2f %-15.2f%n", shapeNames[i], shapes[i].area(), shapes[i].perimeter());
        }

        System.out.println("----------------------------------------------------");
    }
}
