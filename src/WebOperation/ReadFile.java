package WebOperation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFile {

    public StringBuilder read(String fileName) {
        StringBuilder sb = new StringBuilder();
        Extracter ext = new Extracter();
        BufferedWriter bw = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = new String();
            int i = 1;
            while ((line = br.readLine()) != null) {
                String[] array = line.replace("\\s+", "\\s").split("\\s");
                String link = array[1];
                String text = ext.get(link);
                if (text.trim().contains("<wsdl:definitions")) {
                    System.out.println(">>> " + link);

                    File theDir = new File("dataset");
                    if (!theDir.exists()) {
                        boolean result = false;

                        try {
                            theDir.mkdir();
                            result = true;
                        } catch (SecurityException se) {
                            //handle it
                        }
                        if (result) {
                            System.out.println("DIR created");
                        }
                    }

                    File file = new File(theDir + "/" + i + ".txt");
                    file.createNewFile();
                    bw = new BufferedWriter(new FileWriter(file));
//                    String[] str = text.split(" ");
//                    String newText = new String();
//                    for (String str1 : str) {
//                            newText += str1;
//                    }
                    text = "DocName: " + link + "\n" + text;
                    bw.write(text);
                    bw.close();
                    System.out.println(text + "\n");
                    i++;
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb;
    }

//    public static void main(String[] args) {
//        ReadFile rf = new ReadFile();
//        rf.read("WSDream-QoSDataset/wslist.txt");
//    }
}
