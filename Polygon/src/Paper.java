import java.util.ArrayList;
import java.util.Arrays;

public class Paper {


    private ArrayList<Vertice> vertices;


    Paper() {
        vertices = new ArrayList<>();
    }

    public void addVertice(Vertice... vertices) {
        this.vertices.addAll(Arrays.asList(vertices));
    }

    private boolean betweenNumbers(double a, double b, double num) {
        if (a > b) {
            if (num <= a && num >= b)
                return true;
            return false;
        } else {
            if (num >= a && num <= b)
                return true;
            return false;
        }
    }

    private Double getLineK(Line a) {
        if (a.getPoint2().getX() - a.getPoint1().getX() == 0)
            return null;

        return (a.getPoint2().getY() - a.getPoint1().getY()) / (a.getPoint2().getX() - a.getPoint1().getX());
    }

    private Double getLineN(Line a) {
        if (getLineK(a) == null)
            return null;

        return a.getPoint1().getY() - getLineK(a) * a.getPoint1().getX();
    }

    private Vertice intersectPoint(Line a, Line b) {
        double x, y;

        if (getLineK(a) == null)
            x = a.getPoint1().getX();
        else if (getLineK(b) == null)
            x = b.getPoint1().getX();
        else
            x = (getLineN(a) - getLineN(b)) / (getLineK(b) - getLineK(a));

        if (getLineK(a) != null)
            y = getLineK(a) * x + getLineN(a);
        else
            y = getLineK(b) * x + getLineN(b);

        return new Vertice(x, y);
    }

    private boolean lineExistAtVertice(Line a, Vertice b) {
        if (betweenNumbers(a.getPoint1().getX(), a.getPoint2().getX(), b.getX()) &&
                betweenNumbers(a.getPoint1().getY(), a.getPoint2().getY(), b.getY()))
            return true;

        return false;
    }

    public boolean isIntersect(Line a, Line b) {
        if (getLineK(a) == getLineK(b)) {
                if (getLineN(a) == null) {
                    if (betweenNumbers(a.getPoint1().getY(), a.getPoint2().getY(), b.getPoint1().getY()) ||
                            betweenNumbers(a.getPoint1().getY(), a.getPoint2().getY(), b.getPoint2().getY()))
                        return true;
                    else
                        return false;}
                else
                    return false;

            }
        else {
            Vertice intersectPt = intersectPoint(a, b);

            if (lineExistAtVertice(a, intersectPt) && lineExistAtVertice(b, intersectPt))
                return true;
            else
                return false;
        }

    }

    public boolean isSame(Line a, Line b){
        if(a.getPoint1().getX() == b.getPoint1().getX()
                && a.getPoint1().getY() == b.getPoint1().getY() &&
                a.getPoint2().getX() == b.getPoint2().getX() &&
                a.getPoint2().getY() == b.getPoint2().getY())
            return true;
        return false;
    }
}

