public class Occurrence {
    private int occurrences;
    private double value;

    Occurrence(int occurrences, double value){
        this.occurrences = occurrences;
        this.value = value;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public double getValue() {
        return value;
    }
}
