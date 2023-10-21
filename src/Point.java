class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

class Triangle {
    Point[] vertices = new Point[3];

    public Triangle(Point p1, Point p2, Point p3) {
        vertices[0] = p1;
        vertices[1] = p2;
        vertices[2] = p3;
    }

    public double getPerimeter()
    {
        double side1 = vertices[0].distanceTo(vertices[1]);
        double side2 = vertices[1].distanceTo(vertices[2]);
        double side3 = vertices[2].distanceTo(vertices[0]);
        return side1 + side2 + side3;
    }

    public double calculateArea() {
        double side1 = vertices[0].distanceTo(vertices[1]);
        double side2 = vertices[1].distanceTo(vertices[2]);
        double side3 = vertices[2].distanceTo(vertices[0]);
        double s = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    }

    public boolean isPointInside(Point point) {
        double areaTotal = calculateArea();
        double area1 = new Triangle(point, vertices[1], vertices[2]).calculateArea();
        double area2 = new Triangle(vertices[0], point, vertices[2]).calculateArea();
        double area3 = new Triangle(vertices[0], vertices[1], point).calculateArea();

        return areaTotal == (area1 + area2 + area3);
    }

    public String type() {
        double side1 = vertices[0].distanceTo(vertices[1]);
        double side2 = vertices[1].distanceTo(vertices[2]);
        double side3 = vertices[2].distanceTo(vertices[0]);

        if (side1 == side2 && side2 == side3) {
            return "Equilateral";
        } else if (side1 == side2 || side2 == side3 || side3 == side1) {
            return "Isosceles";
        } else {
            return "Unknown";
        }
    }
}