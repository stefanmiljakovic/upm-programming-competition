import java.io.IOException;
import java.util.*;

public class main {

    private static Occurrence calcLines(ArrayList<Point> points){
        ArrayList<Line> lines = new ArrayList<>();

        for(int i = 0; i < points.size()-1; i++) {
            for (int j = i + 1; j < points.size(); j++) {
                lines.add(new Line(points.get(i), points.get(j)));
            }
        }

        lines.sort(Comparator.comparing(Line::getLineLength));


        ArrayList<Occurrence> occurrences = new ArrayList<>();

        int occur = 1;

        for(int i = 0; i < lines.size() - 1; i++){
            if(lines.get(i).getLineLength() == lines.get(i+1).getLineLength())
                occur++;
            else{
                occurrences.add(new Occurrence(occur, lines.get(i).getLineLength()));
                occur = 1;
            }
        }

        occurrences.sort(Comparator.comparing(Occurrence::getOccurrences));

        return occurrences.get(occurrences.size() - 1);

    }

    public static void main(String args[]) throws IOException {

        ArrayList<Point> points = new ArrayList<>();

        System.out.print("Enter number of points: ");
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println();

        int numInputs = scanner.nextInt();

        while(numInputs > 0){
            System.out.println("Point x: ");
            double x = scanner.nextDouble();
            System.out.println("Point y: ");
            double y = scanner.nextDouble();

            System.out.println();
            System.out.println();

            points.add(new Point(x,y));

            numInputs--;
        }

        Occurrence calculateLines = calcLines(points);

        System.out.println();
        System.out.println();

        System.out.println("Occurrences: ");
        System.out.print(calculateLines.getOccurrences());
        System.out.println("\nValue: ");
        System.out.print(calculateLines.getValue());
    }
}
