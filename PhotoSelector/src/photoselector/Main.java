/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package photoselector;
import excelReader.*;
import FileController.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
/**
 *
 * @author Yung
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // FileHandler.fileSeacher("algoISO9000", "C:\\test", "C:\\dest");
        // TODO code application logic here
        //File dir = new  File("C:\\test.xls");
       /* FileCopy.EXCELPATH = "C:\\test.xls";
        FileCopy.CHECKBOX = false;
        FileCopy.PREFIX = "o";
        FileCopy.SUBFIX = "9";
        FileCopy.ORIGENPATH = "C:\\test";
        FileCopy.DESTPATH = "C:\\dest";
        List<String> newList =(List) FileCopy.FileCopy();
        
        for (Iterator<String> it = newList.iterator(); it.hasNext();) {
            String string = it.next();
            System.out.println(string + "final");
        }*/
        //System.out.println(dir.getAbsolutePath());
       //FileInputStream fileInputStream = FileController.FileHandler.initExcelFile(dir);
        //dir.get
        /*List<String> fotoList = excelReader.ExcelReader.contentReading(dir.getAbsolutePath());
        for (Iterator<String> it = fotoList.iterator(); it.hasNext();) {
            String string = it.next();
            System.out.println(string);
        }*/
        
        //FileHandler.fileSeacher(fotoList, null, null);
        String oriFile="C:\\Documents and Settings\\YangColor\\My Documents\\Downloads";
        String destPath = "C:\\Documents and Settings\\YangColor\\My Documents\\traceviewer";
        String fileName = "disney3.jpg";
        
        FileHandler.fileSeacher(fileName, oriFile, destPath);
        
    }    
}
