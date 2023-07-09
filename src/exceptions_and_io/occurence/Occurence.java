package exceptions_and_io.occurence;


public class Occurence  implements Comparable<Occurence>{

    private String word;
    private Integer occurence;

    public Occurence(String word) {
        this.word = word;
        this.occurence = 1;
    }

    public String getWord() {
        return word;
    }

    public int getOccurence() {
        return occurence;
    }

    public void setOccurence(int occurence) {
        this.occurence = occurence;
    }

    public void incrementCount(){
        this.occurence = this.occurence + 1;
    }

    @Override
    public String toString() {
        return this.word + " - " + this.occurence;
    }

    @Override
    public int compareTo(Occurence o) {
        return Integer.compare(o.getOccurence(), this.occurence);

    }
}
