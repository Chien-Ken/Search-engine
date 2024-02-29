package a1_2101040041;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Result implements Comparable<Result> {

    private List<Match> danhSachMatch = new Vector<>();

    private final Doc docFunny;


    public Result(Doc d, List<Match> matches) {
        this.docFunny = d;
        this.danhSachMatch = matches;
    }


    public List<Match> getMatches() {
        return this.danhSachMatch;
    }


    public int getTotalFrequency() {
        return getMatches().get(0).getFreq();

    }


    public double getAverageFirstIndex() {
        double sumToFirstIndex = 0.0;
        for (Match match : danhSachMatch) {
            sumToFirstIndex += match.getFirstIndex();
        }
        //System.out.println(danhSachMatch.size());
        return sumToFirstIndex / (double) danhSachMatch.size();
    }


    public String htmlHighlight() {
       return "this task is difficult and i have no time";
    }


    @Override
    public int compareTo(Result o) {
        if(this.getMatches().size() > o.getMatches().size()) {
            return -1;
        } else if (this.getMatches().size() < o.getMatches().size()) {
            return 1;
        } else if (this.getTotalFrequency() > o.getTotalFrequency()) {
            return -2;
        } else if (this.getTotalFrequency() < o.getTotalFrequency()) {
            return 2;
        } else return 0;

    }

    public Doc getDoc() {
        return docFunny;
    }
}






