package a1_2101040041;

import java.util.*;


public class Query {
    private final List<Word> keyWordFuns = new Vector<>();

    public Query(String searchPhrase) {
        Scanner sc = new Scanner(searchPhrase);
        while (sc.hasNext()) {
            Word tuMoi = Word.createWord(sc.next());
            if (isKeyWordOKFunny(tuMoi)) {
                keyWordFuns.add(tuMoi);
            }
        }
    }

    boolean isKeyWordOKFunny(Word word) {
        return (word.isKeyword());
    }

    public List<Word> getKeywords() {
        return keyWordFuns;
    }

    public List<Match> matchAgainst(Doc d) {
        List<Match> matchesFunny = new Vector<>();
        for (int i = 0; i < keyWordFuns.size(); i++) {
            int tanXuat = 0, chiMucDauTien = 0;
            if (d != null && d.getAllWordsInDoc().contains(keyWordFuns.get(i))) {
                for (int j = 0; j < d.getAllWordsInDoc().size(); j++) {
                    if (d.getAllWordsInDoc().get(j).equals(keyWordFuns.get(i))) {
                        tanXuat++;
                        chiMucDauTien = j;
                    }
                }
            }
            if (tanXuat != 0 || chiMucDauTien != 0) {
                matchesFunny.add(new Match(d, keyWordFuns.get(i), tanXuat, chiMucDauTien));
            }
        }
        matchesFunny.sort(Match::compareTo);
        return matchesFunny;
    }







}

















