package FileController;

import java.util.ArrayList;
import java.util.Iterator;
import FramePackage.FileJFrame;
import FramePackage.ProgressBarFrame;

public class FileManageThread extends Thread {

    private static String EXCELPATH;
    private static String ORIGENPATH;
    private static String DESTPATH;
    private static Boolean CHECKBOX;
    private static String PREFIX;
    private static String SUBFIX;

    public void fileDispacher(String excelPath, String origenPath,
            String destPath, String prefix, String surfix, Boolean checkBox) {
        EXCELPATH = excelPath;
        ORIGENPATH = origenPath;
        DESTPATH = destPath;
        CHECKBOX = checkBox;
        PREFIX = prefix;
        SUBFIX = surfix;

    }

    @Override
    public void run() {
        ArrayList<String> fotoList = (ArrayList<String>) excelReader.ExcelReader.contentReading(EXCELPATH);
        ArrayList<String> resultString = new ArrayList<String>();
        ProgressBarFrame jPro = ProgressBarFrame.getInstance();
        /*jPro.setVisible(true);
        jPro.setActualValue(0);*/
        int maxValue = (int) fotoList.size();
        jPro.setMaxValue(maxValue);
        if (CHECKBOX) {
            //System.out.println("llamo a relleno");
            for (String string : fotoList) {
                resultString.add(FileHandler.fileSeacher(PREFIX + string + SUBFIX, ORIGENPATH, DESTPATH));
            }
            
        } else {
            for (String string : fotoList) {
                resultString.add(FileHandler.fileSeacher(string, ORIGENPATH, DESTPATH));
            }
        }
        FileJFrame.setMissingString(resultString);
        jPro.dispose();
    }
}
