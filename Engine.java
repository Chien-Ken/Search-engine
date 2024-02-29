package a1_2101040041;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Engine {
    private Doc[] documents = new Doc[50];

    private int quantityOfDoc = 0;






    public int loadDocs(String dirname) {
        int soLuongDocs = 0;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dirname))) {
            for (Path file : stream) {
                try (BufferedReader brFun = Files.newBufferedReader(file)) {
                    StringBuilder docTextFun = new StringBuilder();
                    String lineFun;
                    while ((lineFun = brFun.readLine()) != null) {
                        docTextFun.append(lineFun).append("\n");
                    }
                    Doc a = new Doc(docTextFun.toString());
                    documents[quantityOfDoc] = a;
                    soLuongDocs++;
                    quantityOfDoc++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return soLuongDocs;
    }




    public Doc[] getDocs() {
       return documents;
    }





    public List<Result> search(Query q) {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < quantityOfDoc; i++) {
            if (q.matchAgainst(documents[i]).size() != 0) {
                Result r = new Result(documents[i], q.matchAgainst(documents[i]));
                results.add(r);
            }
        }
        results.sort(Result::compareTo);
        return results;
    }


    public String htmlResult(List<Result> results) {
      return "i don't like this task";
    }


}
