package DocOperations;

import Computations.CosineSimilarity;
import Computations.TermFrequency;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class OpSimilarity {

    TermFrequency tf = new TermFrequency();
    ConcurrentHashMap<String, HashMap<String, Double>> map;
    StopwordRemove swr = new StopwordRemove();
    Stemming stem = new Stemming();
    Map<String, List<String>> docStem = new HashMap<>();
    Map<String, List<String>> keywordsMap = new HashMap<>();
    Map<String, List<String>> inputMap = new HashMap<>();
    Map<String, List<String>> outputMap = new HashMap<>();

    Map<String, HashMap<String, Double>> keywordSimi = new HashMap<>();
    Map<String, HashMap<String, Double>> inputSimi = new HashMap<>();
    Map<String, HashMap<String, Double>> outputSimi = new HashMap<>();

    public ConcurrentHashMap<String, HashMap<String, Double>> getMap() {
        return map;
    }

    public void setMap(ConcurrentHashMap<String, HashMap<String, Double>> map) {
        this.map = map;
    }

    public void read() {
        FilesOfDir fod = new FilesOfDir();
        final File folder = new File("dataset/");
        List<String> files = fod.listFilesForFolder(folder);
        try {
            for (String file : files) {
                List<String> keywords = new ArrayList<>();
                List<String> input = new ArrayList<>();
                List<String> output = new ArrayList<>();

                BufferedReader br = new BufferedReader(new FileReader("dataset/" + file));
                String line = new String();
                while ((line = br.readLine()) != null) {
                    if (line.contains("<wsdl:operation name=")) {
                        keywords.add(line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\"")));
                    }
                    if (line.contains("<wsdl:input message=")) {
                        input.add(line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\"")).trim());
                    }
                    if (line.contains("<wsdl:input>")) {
                        line = br.readLine();
                        line = line.replaceAll("[\\W&&[^\\s]]", " ");
                        input.add(line.trim());
                    }

                    if (line.contains("<wsdl:output message=")) {
                        output.add(line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\"")).trim());
                    }
                    if (line.contains("<wsdl:output>")) {
                        line = br.readLine();
                        line = line.replaceAll("[\\W&&[^\\s]]", " ");
                        output.add(line.trim());
                    }
                    keywordsMap.put(file, keywords);
                    inputMap.put(file, input);
                    outputMap.put(file, output);
                }
//                break;
            }
            System.out.println("____________________________ keywords");
            for (Map.Entry<String, List<String>> entrySet : keywordsMap.entrySet()) {
                String key = entrySet.getKey();
                List<String> value = entrySet.getValue();
                System.out.println(key);
                System.out.println(value);
            }
            System.out.println("____________________________ input");
            for (Map.Entry<String, List<String>> entrySet : inputMap.entrySet()) {
                String key = entrySet.getKey();
                List<String> value = entrySet.getValue();
                System.out.println(key);
                System.out.println(value);
            }
            System.out.println("____________________________ output");
            for (Map.Entry<String, List<String>> entrySet : outputMap.entrySet()) {
                String key = entrySet.getKey();
                List<String> value = entrySet.getValue();
                System.out.println(key);
                System.out.println(value);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void keySimilarity() {
        OpSimilarity opSim = new OpSimilarity();
        opSim.read();
        opSim.normalize(opSim.keywordsMap);
        HashMap<String, Double> temp = new HashMap<>();
        CosineSimilarity cs = new CosineSimilarity();
        Map<String, ArrayList<Double>> map = opSim.calculateWeight();
        for (Map.Entry<String, ArrayList<Double>> entrySet : map.entrySet()) {
            String key = entrySet.getKey();
            ArrayList<Double> value = entrySet.getValue();
            System.out.println(key);
            for (Map.Entry<String, ArrayList<Double>> entrySet1 : map.entrySet()) {
                String key1 = entrySet1.getKey();
                ArrayList<Double> value1 = entrySet1.getValue();
                Double similarity = cs.cosineSimilarity(value, value1);
                temp.put(key1, similarity);
                keywordSimi.put(key, temp);
                System.out.println("keyword CosineSimilarity of " + key + " with " + key1 + " is " + similarity);

            }
        }
    }

    public void inputSimilarity() {
        OpSimilarity opSim = new OpSimilarity();
        opSim.read();
        opSim.normalize(opSim.inputMap);
        HashMap<String, Double> temp = new HashMap<>();
        CosineSimilarity cs = new CosineSimilarity();
        Map<String, ArrayList<Double>> map = opSim.calculateWeight();
        for (Map.Entry<String, ArrayList<Double>> entrySet : map.entrySet()) {
            String key = entrySet.getKey();
            ArrayList<Double> value = entrySet.getValue();
            System.out.println(key);
            for (Map.Entry<String, ArrayList<Double>> entrySet1 : map.entrySet()) {
                String key1 = entrySet1.getKey();
                ArrayList<Double> value1 = entrySet1.getValue();
                Double similarity = cs.cosineSimilarity(value, value1);
                temp.put(key1, similarity);
                inputSimi.put(key, temp);
                System.out.println("input CosineSimilarity of " + key + " with " + key1 + " is " + similarity);
            }
        }
    }

    public void outputSimilarity() {
        OpSimilarity opSim = new OpSimilarity();
        opSim.read();
        opSim.normalize(opSim.outputMap);

        CosineSimilarity cs = new CosineSimilarity();
        Map<String, ArrayList<Double>> map = opSim.calculateWeight();
        for (Map.Entry<String, ArrayList<Double>> entrySet : map.entrySet()) {
            HashMap<String, Double> temp = new HashMap<>();
            String key = entrySet.getKey();
            ArrayList<Double> value = entrySet.getValue();
            System.out.println(key);
            for (Map.Entry<String, ArrayList<Double>> entrySet1 : map.entrySet()) {
                String key1 = entrySet1.getKey();
                ArrayList<Double> value1 = entrySet1.getValue();
                Double similarity = cs.cosineSimilarity(value, value1);
                temp.put(key1, similarity);
                outputSimi.put(key, temp);
                System.out.println("output CosineSimilarity of " + key + " with " + key1 + " is " + similarity);
            }
        }
    }

    public void normalize(Map<String, List<String>> keywordsMap) {
        for (Map.Entry<String, List<String>> entrySet : keywordsMap.entrySet()) {
            String file = entrySet.getKey();
            List<String> words = entrySet.getValue();
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
        System.out.println("______________________ normalize\n");
        for (Map.Entry<String, List<String>> entrySet : docStem.entrySet()) {
            String key = entrySet.getKey();
            List<String> value = entrySet.getValue();
            System.out.println(key);
            System.out.println(value);
        }
    }

    public Map<String, HashMap<String, Double>> idf() {
        Set<String> allWords = new HashSet<>();
        for (Map.Entry<String, List<String>> entrySet : docStem.entrySet()) {
            String key = entrySet.getKey();
            List<String> value = entrySet.getValue();
            System.out.println(key + "--> ");
            System.out.println(value);
            allWords.addAll(value);
        }
        map = tf.tf(allWords, docStem);
        Integer totalDoc = docStem.size();
        Map<String, HashMap<String, Double>> mapIdf = new HashMap<>();
        for (Map.Entry<String, HashMap<String, Double>> entrySet : map.entrySet()) {
            String key = entrySet.getKey();
            HashMap<String, Double> value = entrySet.getValue();
//            System.out.println(key);
//            System.out.println(value);
            Set<String> words = value.keySet();
            HashMap<String, Double> wordIdf = new HashMap<>();
            for (String word : words) {
                double cnt = 0;
                for (Map.Entry<String, List<String>> entrySet1 : docStem.entrySet()) {
                    String key1 = entrySet1.getKey();
                    List<String> value1 = entrySet1.getValue();
                    for (String value11 : value1) {
                        if (value11.equals(word)) {
                            cnt++;
                            break;
                        }
                    }
                }
//                Double val = (Math.log(totalDoc / (cnt))) / Math.log(2);
                Double val = totalDoc / (cnt);
                val = (Math.log(val)) / Math.log(2);
//                System.out.println(val);
                wordIdf.put(word, val);
            }
            mapIdf.put(key, wordIdf);
        }
        System.out.println();
        System.out.println("------------------<< IDF >>----------------\n");
        for (Map.Entry<String, HashMap<String, Double>> entrySet : mapIdf.entrySet()) {
            String key = entrySet.getKey();
            HashMap<String, Double> value = entrySet.getValue();
            System.out.println(key);
            System.out.println(value);
        }
        return mapIdf;
    }

    public Map<String, ArrayList<Double>> calculateWeight() {

        Map<String, HashMap<String, Double>> mapIDF = idf();
        Map<String, HashMap<String, Double>> mapTF = getMap();
        Map<String, ArrayList<Double>> finalMap = new HashMap<>();

//        HashMap<String, Double> submapTF = mapTF.keySet();
        for (String key : mapTF.keySet()) {
            Double val = 0.0;
            Set<String> temp = mapTF.get(key).keySet();
            ArrayList<Double> tempMap = new ArrayList<>();
            for (String temp1 : temp) {
                Double val1 = mapTF.get(key).get(temp1);
                Double val2 = mapIDF.get(key).get(temp1);
                val = val1 * Math.pow(val2, 2);
                tempMap.add(val);
            }
            finalMap.put(key, tempMap);
        }

        for (Map.Entry<String, ArrayList<Double>> entrySet : finalMap.entrySet()) {
            String key = entrySet.getKey();
            ArrayList<Double> value = entrySet.getValue();
            System.out.println(key);
            System.out.println(value);
        }
        return finalMap;
    }

    public Map<String, HashMap<String, Double>> getOpSimilarity() {
        OpSimilarity opSim = new OpSimilarity();
        opSim.keySimilarity();
        opSim.inputSimilarity();
        opSim.outputSimilarity();
        Map<String, HashMap<String, Double>> opSimilarity = new HashMap<>();
        for (String file : opSim.keywordSimi.keySet()) {
            HashMap<String, Double> temp = new HashMap<>();
            for (String withFile : opSim.keywordSimi.get(file).keySet()) {
                Double val1 = opSim.keywordSimi.get(file).get(withFile);
                Double val2 = opSim.inputSimi.get(file).get(withFile);
                Double val3 = opSim.outputSimi.get(file).get(withFile);
                Double result = val1 + val2 + val3;
                temp.put(withFile, result);
            }
            opSimilarity.put(file, temp);
        }

        for (Map.Entry<String, HashMap<String, Double>> entrySet : opSimilarity.entrySet()) {
            String key = entrySet.getKey();
            HashMap<String, Double> value = entrySet.getValue();
            System.out.println(key);
            System.out.println(value);
        }
        return opSimilarity;
    }
}
