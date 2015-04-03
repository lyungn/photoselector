package fileFacade;

import FramePackage.ProgressBarFrame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Yung
 */
public class FileHandler {
    private String searchFileName;
    private String origenFolderPath;
    private String destinationFolderPath;

    private void fileCopyer(String fileasked, String fName) {

        String origenStringFile = fileasked;
        //String destStringFile = this.destinationFolderPath + "\\" + fName;
        String destStringFile = this.destinationFolderPath + File.separator + fName;
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
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    //String stringFile, String originFolderPath, String destFolderPath
    public String fileSeacher() {

        String returnString = "";
        File dirS = new File(this.origenFolderPath);
        File[] files = dirS.listFiles(new MyFileFilter(this.searchFileName));
        if (files.length == 0) {
            returnString = this.searchFileName;

        } else {
            for (File f : files) {
                ProgressBarFrame jPro = ProgressBarFrame.getInstance();
                jPro.setFileName(f.getName());
                jPro.setActualValue(1);
                fileCopyer(f.getAbsolutePath(), f.getName());
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

            String existFile = fileToRename.getParent();
            File filePath = new File(existFile);
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
                            String newmodifle = existFile + File.separator + tempName + "x" + String.valueOf(cantToIncrease) + "F" + ".jpg";
                            File newName = new File(newmodifle);
                            file.renameTo(newName);
                            return false;
                            
                        } else {

                            File newName = new File(filePath + File.separator + tempName + "x2F" + ".jpg");
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
    
    public String getDestinationFolderPath() {
        return destinationFolderPath;
    }

    public void setDestinationFolderPath(String destinationFolderPath) {
        this.destinationFolderPath = destinationFolderPath;
    }

    public String getOrigenFolderPath() {
        return origenFolderPath;
    }

    public void setOrigenFolderPath(String origenFolderPath) {
        this.origenFolderPath = origenFolderPath;
    }

    public String getSearchFileName() {
        return searchFileName;
    }

    public void setSearchFileName(String searchFileName) {
        this.searchFileName = searchFileName;
    }

    public FileHandler(String searchFileName, String origenFolderPath, String destinationFolderPath) {
        this.searchFileName = searchFileName;
        this.origenFolderPath = origenFolderPath;
        this.destinationFolderPath = destinationFolderPath;
    }

    public FileHandler() {
    }
    
}
