/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DocOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadDataset {

    public StringBuilder read() {
        StringBuilder sb = new StringBuilder();
        FilesOfDir fod = new FilesOfDir();
        final File folder = new File("dataset");
        List<String> files = fod.listFilesForFolder(folder);
        try {
            for (String file : files) {
                Scanner sc = new Scanner(new FileReader("dataset" + File.separator + file));
//                String line = new String();
                String text = new String();
                while (sc.hasNextLine()) {
                    text += sc.nextLine() + "\n\t";
                }
                sb.append("\n\tFile Name: ").append(file).append("\n\n");
                sb.append(text);
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb;
    }
}
