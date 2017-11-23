public class Line {

    private double lineLength;

    public Line(Point a, Point b){
        this.lineLength = Math.sqrt(Math.pow(a.getX() - b.getX(),2) + Math.pow(a.getY() - b.getY(), 2));
    }

    public double getLineLength() {
        return lineLength;
    }
}
