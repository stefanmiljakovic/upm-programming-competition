public class Vertice {
    public double getX() {
        return xPos;
    }

    public double getY() {
        return yPos;
    }

    private double xPos;
    private double yPos;

    Vertice(double x, double y){
        this.xPos = x;
        this.yPos = y;
    }
}
