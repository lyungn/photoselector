/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excelReader;

/**
 *
 * @author Yung
 **/

import java.io.File;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelReader {

    public static List<String> contentReading(String filePathString) {
        /*  Create a  new instance  for cellDataList */
        List cellDataList = new ArrayList();
        File dir = new File(filePathString);
        
        try {   /* Create a new instance for POIFSFileSystem class     */
                FileInputStream fs = new FileInputStream(dir);
                POIFSFileSystem fsFileSystem = new POIFSFileSystem(fs);

                /* Create a new instance for HSSFWorkBook Class  */
                HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
                HSSFSheet hssfSheet = workBook.getSheetAt(0);
                
                /*Iterate the rows and cells of the spreadsheet
                 * to get all the datas.        */
                Iterator rowIterator = hssfSheet.rowIterator();
                while (rowIterator.hasNext()) {
                    HSSFRow hssfRow = (HSSFRow) rowIterator.next();
                    Iterator iterator = hssfRow.cellIterator();
                    List cellTempList = new ArrayList();
                    while (iterator.hasNext()) {
                        HSSFCell hssfCell = (HSSFCell) iterator.next();
                        cellTempList.add(hssfCell);
                    }
                    cellDataList.add(cellTempList);
                }                
            } catch  (Exception e) {
            System.out.println(e.getMessage());
        }
        List returnList = cellToString(cellDataList);
        return returnList;
    }
    
    private static List<String> cellToString(List cellDataList){
        List <String> listaFile = new ArrayList<String>();
        for (int i=0 ; i< cellDataList.size(); i++){
            List cellTempList = (List) cellDataList.get(i);
            for (int j = 0; j < cellTempList.size(); j++){
                HSSFCell hssfCell = (HSSFCell) cellTempList.get(j);
                hssfCell.setCellType(1);
                String string = hssfCell.getStringCellValue();
                if (string.isEmpty()){

                }else{
                    listaFile.add(string);
                }                
            }
        }        
        return listaFile;
    }
}

