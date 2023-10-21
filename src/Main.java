import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of triangles: ");
        int numTriangles = scanner.nextInt();
        scanner.nextLine();
        if(numTriangles<3){
            System.out.println("Please enter the value greater than 3 or equal to 3...");
            return;
        }
        Triangle[] triangles = new Triangle[numTriangles];

        for (int i = 0; i < numTriangles; i++) {
            System.out.println("Enter the coordinates of the vertices for Triangle " + (i + 1));
            Point[] vertices = new Point[3];

            for (int j = 0; j < 3; j++) {
                System.out.print("Enter the Vertex X for triangle " + (j + 1) + ": ");
                double x = scanner.nextDouble();
                System.out.print("Enter the Vertex Y for triangle " + (j + 1) + ": ");
                double y = scanner.nextDouble();
                vertices[j] = new Point(x, y);
            }

            triangles[i] = new Triangle(vertices[0], vertices[1], vertices[2]);

            Triangle triangle = triangles[i];
            double perimeter = triangle.getPerimeter();
            double area = triangle.calculateArea();
            String classification = triangle.type();
            System.out.println("Triangle " + (i + 1) + " - Perimeter: " + perimeter + ", Area: " + area + " , Type: " + classification);

        }
        System.out.print("Enter a point X to check if it's inside the triangle: ");
        double x = scanner.nextDouble();
        System.out.print("Enter a point Y to check if it's inside the triangle: ");
        double y = scanner.nextDouble();
        Point point = new Point(x, y);

        for(int i = 0; i < numTriangles; i++) {
            Triangle triangle = triangles[i];
            if (triangle.isPointInside(point)) {
                System.out.println("For Traingle" + (i+1) + ":---The point is inside the triangle.---");
            } else {
                System.out.println("For Traingle" + (i+1) + ":---The point is not inside the triangle.---");
            }
        }
    }
}
