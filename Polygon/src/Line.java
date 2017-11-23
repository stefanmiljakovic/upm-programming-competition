public class Line {

    public Vertice getPoint1() {
        return point1;
    }

    public Vertice getPoint2() {
        return point2;
    }

    private Vertice point1;
    private Vertice point2;

    Line(Vertice a, Vertice b){
        if(a.getX() < b.getX()){
        this.point1 = a;
        this.point2 = b;
        }
        else{
            this.point1 = b;
            this.point2 = a;
        }
    }
}
