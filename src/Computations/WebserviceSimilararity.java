package Computations;

import DocOperations.OpSimilarity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WebserviceSimilararity {

    Map<String, HashMap<String, Double>> textSimilarity = new HashMap<>();
    Map<String, HashMap<String, Double>> wsSimilarity = new HashMap<>();
    public static StringBuilder txtsimi = new StringBuilder();
    public static StringBuilder opsimi = new StringBuilder();
    public static StringBuilder wssimi = new StringBuilder();

    public void wsSim() {
        OpSimilarity opsim = new OpSimilarity();
        Map<String, HashMap<String, Double>> opsimmap = opsim.getOpSimilarity();
        TermWeight tw = new TermWeight();
        CosineSimilarity cs = new CosineSimilarity();
        Map<String, ArrayList<Double>> map = tw.calculateWeight();
        for (Map.Entry<String, ArrayList<Double>> entrySet : map.entrySet()) {
            HashMap<String, Double> temp = new HashMap<>();
            String key = entrySet.getKey();
            ArrayList<Double> value = entrySet.getValue();
            System.out.println(key);
            txtsimi.append("---------------<< " + key + " >>---------------\n");
            for (Map.Entry<String, ArrayList<Double>> entrySet1 : map.entrySet()) {
                String key1 = entrySet1.getKey();
                ArrayList<Double> value1 = entrySet1.getValue();
                Double similarity = cs.cosineSimilarity(value, value1);
                temp.put(key1, similarity);
                textSimilarity.put(key, temp);
                String str = "Similarity of " + key + " with " + key1 + " is " + similarity;
                txtsimi.append(str).append("\n");
                System.out.println("Similarity of " + key + " with " + key1 + " is " + similarity);
            }
            System.out.println();
        }

        for (Map.Entry<String, HashMap<String, Double>> entrySet : opsimmap.entrySet()) {
            String key = entrySet.getKey();
            HashMap<String, Double> value = entrySet.getValue();
            opsimi.append("---------------<< " + key + " >>---------------\n");
            for (Map.Entry<String, Double> entrySet1 : value.entrySet()) {
                String key1 = entrySet1.getKey();
                Double similarity = entrySet1.getValue();
                String str = "Similarity of " + key + " with " + key1 + " is " + similarity;
                opsimi.append(str).append("\n");
            }
            System.out.println();
        }

        for (String file : opsimmap.keySet()) {
            HashMap<String, Double> temp = new HashMap<>();
            for (String withFile : opsimmap.get(file).keySet()) {
                Double val1 = opsimmap.get(file).get(withFile);
                Double val2 = textSimilarity.get(file).get(withFile);
                Double result = val1 + val2;
                temp.put(withFile, result);
            }
            wsSimilarity.put(file, temp);
        }

        for (Map.Entry<String, HashMap<String, Double>> entrySet : wsSimilarity.entrySet()) {
            String key = entrySet.getKey();
            HashMap<String, Double> value = entrySet.getValue();
            System.out.println(key);
            System.out.println(value);
            wssimi.append("---------------<< " + key + " >>---------------\n");
            for (Map.Entry<String, Double> entrySet1 : value.entrySet()) {
                String key1 = entrySet1.getKey();
                Double similarity = entrySet1.getValue();
                String str = "Similarity of " + key + " with " + key1 + " is " + similarity;
                wssimi.append(str).append("\n");
            }
            System.out.println();
        }
    }
}
