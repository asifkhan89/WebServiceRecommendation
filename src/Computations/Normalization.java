package Computations;

import DocOperations.FilesOfDir;
import DocOperations.ParseDocument;
import DocOperations.Stemming;
import DocOperations.StopwordRemove;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Normalization {

    StopwordRemove swr = new StopwordRemove();
    Stemming stem = new Stemming();
    TermFrequency tf = new TermFrequency();
    FilesOfDir fod = new FilesOfDir();
    Map<String, List<String>> docStem = new HashMap<>();
    ParseDocument doc = new ParseDocument();

    public void normalize() {

        Map<String, String> document = doc.parse();
        for (Map.Entry<String, String> entrySet : document.entrySet()) {
            String file = entrySet.getKey();
            String text = entrySet.getValue();
            ArrayList<String> words = new ArrayList<>();
            String[] array = text.split("\\s");
            for (String array1 : array) {
                words.add(array1);
            }
            List<String> stopwordRemoved = swr.removeStopWords(words);
            List<String> stemword = new ArrayList<>();
            for (String stopwordRemoved1 : stopwordRemoved) {
//                    System.out.print(stopwordRemoved1 + " ");
                String word = new String();
                if (!stopwordRemoved1.equals("")) {
                    word = stem.stripAffixes(stopwordRemoved1);
                }
                if (!word.equals("")) {
                    stemword.add(word);
                }
            }
            docStem.put(file, stemword);
        }
    }
}
