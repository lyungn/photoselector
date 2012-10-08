package FileController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import FramePackage.ProgressBarFrame;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 * @author Yung
 */
public class FileHandler {

    private static void fileCopyer(String fileasked, String destFolderPath,
            String fName) {

        String origenStringFile = fileasked;
        String destStringFile = destFolderPath + "\\" + fName;
        File orignFile = new File(origenStringFile);
        File destFile = new File(destStringFile);
        FileInputStream archivoSelected = null;
        FileOutputStream archivoSalida = null;
        try {
            if (fileRenamer(destFile, orignFile.getName())) {
                archivoSelected = new FileInputStream(orignFile);
                archivoSalida = new FileOutputStream(destFile);
                byte[] byteBuf = new byte[16384];
                int numBytesRead;
                while ((numBytesRead = archivoSelected.read(byteBuf)) != -1) {
                    archivoSalida.write(byteBuf, 0, numBytesRead);

                }
                archivoSalida.close();
                archivoSelected.close();

            } else {
                
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String fileSeacher(String stringFile, String originFolderPath, String destFolderPath) {

        String returnString = "";
        File dirS = new File(originFolderPath);
        File[] files = dirS.listFiles(new MyFileFilter(stringFile));
        if (files.length == 0) {
            returnString = stringFile;

        } else {
            for (File f : files) {
                /*ProgressBarFrame jPro = ProgressBarFrame.getInstance();
                jPro.setFileName(f.getName());
                jPro.setActualValue(1);*/
                fileCopyer(f.getAbsolutePath(), destFolderPath, f.getName());
            }
        }
        return returnString;
    }

    private static boolean fileRenamer(File fileToRename, String oriFileName) {

        String fileName = fileToRename.getName();
        String tempName = null;
        int pos = fileName.lastIndexOf(".");
        if (pos > 0) {
            tempName = fileName.substring(0, pos);
        }
        try {

            String ss = fileToRename.getParent();
            File filePath = new File(ss);
            File[] files = filePath.listFiles(new MyFileFilter(tempName));
            if (files.length == 0) {
                return true;

            } else {
                if (files.length == 1) {
                    for (File file : files) {
                        String modifyFile = file.getName();
                        int fileNameLen = tempName.length();

                        modifyFile = modifyFile.substring(fileNameLen);
                        if (modifyFile.contains("x") || modifyFile.contains("X")) {
                            int posF = modifyFile.indexOf("F");
                            String intRepeat = modifyFile.substring(1,posF);
                            int cantToIncrease = Integer.parseInt(intRepeat);
                            cantToIncrease = cantToIncrease +1;
                            String newmodifle = ss + "\\" + tempName + "x" + String.valueOf(cantToIncrease) + "F" + ".jpg";
                            File newName = new File(newmodifle);
                            file.renameTo(newName);
                            return false;
                            
                        } else {

                            File newName = new File(filePath + "\\" + tempName + "x1F" + ".jpg");
                            file.renameTo(newName);
                            //fileToRename.delete();
                            return false;
                        }
                    }
                }
                return false;


            }
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return false;
    }
}
