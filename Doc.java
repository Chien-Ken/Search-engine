package a1_2101040041;

import java.io.*;
import java.util.*;

public class Doc {
    private final List<Word> theTitleFunny = new Vector<>();

    private final List<Word> theBodyFunny = new Vector<>();

    private final List<Word> allInWordsFun = new Vector<>();

    private Word[] words = new Word[allInWordsFun.size()];



    public Doc(String content) {
        String[] linesFunny = content.split("\n");

        String l1 = linesFunny[0];
        String l2 = linesFunny[1];

        String[] wordsL1 = l1.split(" ");
        String[] wordsL2 = l2.split(" ");

        for (String wordFun : wordsL1) {
            Word w = Word.createWord(wordFun);
            theTitleFunny.add(w);
        }

        for (String wordFun : wordsL2) {
            Word w = Word.createWord(wordFun);
            theBodyFunny.add(w);
        }

        allInWordsFun.addAll(theTitleFunny);
        allInWordsFun.addAll(theBodyFunny);
    }



    public List<Word> getTitle() {
        return theTitleFunny;
    }


    public List<Word> getBody() {
        return theBodyFunny;
    }

    public List<Word> getAllWordsInDoc() {
        return allInWordsFun;
    }


public boolean equals(Object o) {

    if (this == o) {

        return true;
    }

    if (o == null || getClass() != o.getClass()) {

        return false;
    }

    Doc caiDocKhac = (Doc) o;

    return theTitleFunny.equals(caiDocKhac.theTitleFunny) && theBodyFunny.equals(caiDocKhac.theBodyFunny);
}










}









