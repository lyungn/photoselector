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
            archivoSelected = new FileInputStream(orignFile);
            archivoSalida = new FileOutputStream(destFile);
            byte[] byteBuf = new byte[16384];
            int numBytesRead;
            while ((numBytesRead = archivoSelected.read(byteBuf)) != -1) {
                archivoSalida.write(byteBuf, 0, numBytesRead);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                archivoSalida.close();
                archivoSelected.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
            }

        }
    }

    public static String fileSeacher(String stringFile,
            String originFolderPath, String destFolderPath) {

        String returnString = "";
        File dirS = new File(originFolderPath);
        File[] files = dirS.listFiles(new MyFileFilter(stringFile));
        if (files.length == 0) {
            returnString = stringFile;

        } else {
            for (File f : files) {
                ProgressBarFrame jPro = ProgressBarFrame.getInstance();
                jPro.setFileName(f.getName());
                jPro.setActualValue(1);
                fileCopyer(f.getAbsolutePath(), destFolderPath, f.getName());
            }
        }
        return returnString;
    }
}
