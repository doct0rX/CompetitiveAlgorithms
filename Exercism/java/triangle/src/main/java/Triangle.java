import java.util.stream.DoubleStream;

class Triangle {

    Type type;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0 ||
                side1 + side1 < side3 || side1 + side3 < side2 || side2 + side3 < side1) {
            throw new TriangleException();
        }

        if (side1 == side2 && side1 == side3) {
            type = Type.EQUILATERAL;
        } else if (side1 == side2 || side2 == side3 || side1 == side3) {
            type = Type.ISOSCELES;
        } else {
            type = Type.SCALENE;
        }
    }

    boolean isEquilateral() { return  type == Type.EQUILATERAL; }

    boolean isIsosceles() { return  type == Type.EQUILATERAL || type == Type.ISOSCELES; }

    boolean isScalene() { return type == Type.SCALENE; }


    private enum Type {
        EQUILATERAL,
        ISOSCELES,
        SCALENE
    }
}
