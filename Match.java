package a1_2101040041;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Match implements Comparable<Match> {
    private Doc d;

    private Word w;

    private int freq = 0;

    private int firstIndex;

    private List<Integer> indexFunny;

    public Match(Doc d, Word w) {
        this.d = d;
        this.w = w;
        this.freq = getFreq();
        this.firstIndex = getFirstIndex();
        this.indexFunny = new Vector<>();
    }


    public Match(Doc d, Word w, int freq, int firstIndex) {
        this.d = d;
        this.w = w;
        this.freq = freq;
        this.firstIndex = firstIndex;
        this.indexFunny = new Vector<>();
    }

//    public List<Integer> getIndex() {
//        return indexFunny;
//    }


    public int getFreq() {
        List<Word> documentTextFun = Stream.concat(d.getTitle().stream(), d.getBody().stream())
                .collect(Collectors.toList());

        this.indexFunny = IntStream.range(0, documentTextFun.size())
                .filter(i -> this.w.equals(documentTextFun.get(i)))
                .boxed()
                .collect(Collectors.toList());

        this.freq = this.indexFunny.size();

        return this.freq;
    }






    public int getFirstIndex() {
        List<Word> docWordsFunny = new Vector<>(d.getAllWordsInDoc());

        this.firstIndex = docWordsFunny.indexOf(this.w);

        return firstIndex;
    }




    @Override
    public int compareTo(Match o) {
        int firstIndexThisFun = this.getFirstIndex();
        int firstIndexOtherFun = o.getFirstIndex();

        if (firstIndexThisFun < firstIndexOtherFun) {
            return -1;
        } else if (firstIndexThisFun > firstIndexOtherFun) {
            return 1;
        } else {
            return 0;
        }
    }


    public Word getWord() {
        return this.w;
    }


    }
