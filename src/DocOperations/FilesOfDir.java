package DocOperations;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilesOfDir {

    List<String> fileList = new ArrayList<>();

    public List<String> listFilesForFolder(final File folder) {
//        String filePath = folder.getAbsolutePath();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                fileList.add(fileEntry.getName());
                //System.out.println(fileEntry.getName());
            }
        }
        return fileList;
    }

//    public List<String> listf(String directoryName, List<File> files) {
//        File directory = new File(directoryName);
//
//        // get all the files from a directory
//        File[] fList = directory.listFiles();
//
//        for (File file : fList) {
//            if (file.isFile()) {
//                files.add(file);
//            } else if (file.isDirectory()) {
//                listf(file.getAbsolutePath(), files);
//            }
//        }
//        
//        for (File file : files) {
//            fileList.add(file.toString());
//        }
//        
//        return fileList;
//    }
}
