package image;

import javafx.scene.paint.Color;

import java.util.List;

public class Polygon implements Shape {

    private final List<Point> points;
    private final Color color;

    public Polygon(List<Point> points, Color color) {
        super();
        this.points = points;
        this.color = color;
    }

    @Override
    public boolean contains(Point test) {
        // The idea is to take a ray starting from the point to test, which goes to the right. Then, for each line in
        // the polygon, we check for collision with that ray.
        // The point is in the polygon if the number of collisions is odd.

        // There is the used algorithm, and a good explanation just below here:
        // https://stackoverflow.com/questions/8721406/how-to-determine-if-a-point-is-inside-a-2d-convex-polygon

        boolean isOdd = false;

        // For each line in the polygon
        for (int i = 0, j = points.size() - 1; i < points.size(); j = i++) {
            Point a = points.get(i), b = points.get(j);

            // For a collision to happen, the point must be (vertically) between A and B
            if (a.y > test.y == (b.y > test.y))
                continue;

            // The collision point must also be to the right of the tested point (since the ray is going right)
            int collisionX = (b.x - a.x) * (test.y - a.y) / (b.y - a.y) + a.x;

            if (collisionX > test.x)
                isOdd = !isOdd;
        }

        return isOdd;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
