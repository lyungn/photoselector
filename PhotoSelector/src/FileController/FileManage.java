/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FileController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPopupMenu;

import FramePackage.ProgressBarFrame;

/**
 *
 * @author iung liu
 */
public class FileManage {

    public static String EXCELPATH;
    public static String ORIGENPATH;
    public static String DESTPATH;
    public static Boolean CHECKBOX;
    public static String PREFIX;
    public static String SUBFIX;

    public static List<String> FileManager() {
        List<String> returnString = new ArrayList<String>();
        ArrayList<String> fotoList = (ArrayList<String>) excelReader.ExcelReader.contentReading(EXCELPATH);
        /*ProgressBarFrame jPro = ProgressBarFrame.getInstance();
		int maxValue = fotoList.size();
		jPro.setMaxValue(maxValue);
		jPro.setVisible(true);
		jPro.setActualValue(0);*/
        if (CHECKBOX) {
            System.out.println("llamo a relleno");
            for (Iterator<String> it = fotoList.iterator(); it.hasNext();) {
                String string = PREFIX + it.next() + SUBFIX;
                returnString.add( FileHandler.fileSeacher(string, ORIGENPATH, DESTPATH));                
            }
        } else {
            for (Iterator<String> it = fotoList.iterator(); it.hasNext();) {
                String string = it.next();
                returnString.add(FileHandler.fileSeacher(string, ORIGENPATH, DESTPATH));                
            }
        }                
        //jPro.dispose();
        return returnString;
    }
}
