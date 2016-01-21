package DocOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseDocument {

    Map<String, String> document = new HashMap<>();

    public Map<String, String> parse() {
        FilesOfDir fod = new FilesOfDir();
        final File folder = new File("dataset/");
        List<String> files = fod.listFilesForFolder(folder);
        try {
            for (String file : files) {
                BufferedReader br = new BufferedReader(new FileReader("dataset/" + file));
                String line = new String();
//                line = br.readLine();
//                ArrayList<String> words = new ArrayList<>();
                String text = new String();
                while ((line = br.readLine()) != null) {
//                    text += line + "\n";
                    Pattern regex = Pattern.compile("\"([^\"]*)\"");
                    ArrayList<String> allMatches = new ArrayList<String>();
                    Matcher matcher = regex.matcher(line);
                    while (matcher.find()) {
                        if (matcher.group(1).contains("http")) {
                        } else {
                            allMatches.add(matcher.group(1));
                        }
                    }
                    if (!allMatches.isEmpty()) {
//                        System.out.println(allMatches);
                        for (String allMatche : allMatches) {
                            text += allMatche + " ";
                        }
                    }
                }
                document.put(file, text);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        for (Map.Entry<String, String> entrySet : document.entrySet()) {
//            String key = entrySet.getKey();
//            String value = entrySet.getValue();
//            System.out.println(key+"--->>");
//            System.out.println(value);
//        }
        return document;
    }
}
