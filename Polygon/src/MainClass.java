import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    public static void main(String args[]){

        Paper paper = new Paper();

        ArrayList<Vertice> vertices = new ArrayList<>();

        System.out.print("Enter number of vertices: ");
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

            vertices.add(new Vertice(x,y));

            numInputs--;
        }

        Player Janko = new Player("Janko");
        Player Metek = new Player("Metek");

        Player [] players = {Janko, Metek};

        paper.addVertice(vertices.toArray(new Vertice[vertices.size()]));
        ArrayList<Line> lines = new ArrayList<>();

        boolean condition = true;

        if(lines.isEmpty()){
            if(vertices.size()/2 < 2)
                condition  = false;
            else
                lines.add(new Line(vertices.get(0), vertices.get(1)));}

        loop:
        while(condition){
            condition = false;
            for(int i = 0; i < vertices.size(); i++){ for(int j = i + 1; j < vertices.size(); j++){
                    boolean errorFound = false;
                    Line temp = new Line(vertices.get(i), vertices.get(j));

                    for(int k = 0; k < lines.size(); k++){
                        if(paper.isSame(temp, lines.get(k)) || paper.isIntersect(temp, lines.get(k))){
                            errorFound = true;

                        }
                    }

                    if(!errorFound){
                        lines.add(temp);
                        condition = true;
                        continue loop;
                    }
                }}
        }

        System.out.println(players[lines.size()%2].getPlayerName() + " has lost the game.");

    }

}
