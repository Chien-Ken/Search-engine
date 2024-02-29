package a1_2101040041;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }
    public static Set<String>stopWords = new HashSet<>();

    public boolean isKeyword(){
        // Check if the word is null or empty
        if (this.word == null || this.word.equals("")) {
            return false;
        }

// Check if the word is a number (using regular expression)
        if (this.word.matches("-?\\d+(\\.\\d+)?")) {
            return false;
        }

// Check if the word is a special character
        if (this.word.matches("[^a-zA-Z0-9]+")) {
            return false;
        }

// Check if the word is in the stopWords set
        if (stopWords.contains(this.word.toLowerCase())) {
            return false;
        }



        if (this.word.matches(".*[a-zA-Z]+.*[0-9]+.*")) {
            return false;
        }
        if (this.word.contains(" ")) {
            return false;
        }

        return true;

    }
    public  String getPrefix(){
        if (this.word.contains(" ")) {
            return "";
        }

        Pattern patternSmooth = Pattern.compile("^([^a-zA-Z0-9]+)([a-zA-Z0-9]+)");
        Matcher matcherSmooth = patternSmooth.matcher(this.word);

        if (matcherSmooth.find()) {
            String authenticWord = matcherSmooth.group(2);

            // Check if the actual word is invalid
            Pattern invalidPatternFunny = Pattern.compile("[^a-zA-Z]+");
            if (invalidPatternFunny.matcher(authenticWord).find()) {
                return "";
            }

            return matcherSmooth.group(1);
        } else {
            return "";
        }
    }
    public String getSuffix() {
        Pattern patternSimple = Pattern.compile("^([^a-zA-Z0-9]*)([a-zA-Z]+)'?s?([^a-zA-Z0-9]*)$");
        Matcher matcherSimple = patternSimple.matcher(this.word);

        if (matcherSimple.matches()) {
            String suffixFunny = matcherSimple.group(3);

            // Special case: If the word ends with 's, treat it as part of the suffix
            if (suffixFunny.isEmpty() && this.word.endsWith("'s")) {
                return "'s";
            }

            // Check if the word is valid and has a suffix
            if (!suffixFunny.isEmpty()) {
                return suffixFunny;
            }
        }

        return "";
    }







    public String getText() {
        Pattern patternEasy = Pattern.compile("^([^a-zA-Z0-9]*)([a-zA-Z]+)'?s?([^a-zA-Z0-9]*)$");

        Matcher matcherEasy = patternEasy.matcher(this.word);

        if (matcherEasy.matches()) {
            String textFunny = matcherEasy.group(2);
            return textFunny;
        } else {
            // Return the original word for invalid words
            return this.word;
        }
    }



    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word tuKhac = (Word) o;
        return this.getText().equalsIgnoreCase(tuKhac.getText());
    }

    @Override
    public String toString(){
        return this.word;
    }
    public static Word createWord(String rawText) {
        return new Word(rawText);
    }
    public static boolean loadStopWords(String fileName) {
        try (BufferedReader brFunny = new BufferedReader(new FileReader(fileName))) {
            String dong;
            while ((dong = brFunny.readLine()) != null) {

                String[] words = dong.split("\\s+");
                for (String eachWord : words) {
                    stopWords.add(eachWord);
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }





    // mission success
    }

