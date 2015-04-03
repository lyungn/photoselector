/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileFacade;

import FramePackage.ProgressBarFrame;
import entities.PhotoLabFile;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Administrator
 */
public class FileManThreadRun implements Runnable{
    public List<String> archNoEnList;
    public PhotoLabFile photoLote;
    private final Thread fileThread;
    
    public void run() {
       if(photoLote.getExcelPath().length()> 1){
           photoLote.setExcelFilelist( excelReader.ExcelReader.contentReading(photoLote.getExcelPath()));
       }
       
        
        ProgressBarFrame jPro = ProgressBarFrame.getInstance();
        jPro.setVisible(true);
        //jPro.setActualValue(0);
        jPro.setMaxValue(photoLote.getExcelFilelist().size());
        if (photoLote.getCheckBox()) {
            //System.out.println("llamo a relleno");
            for (String string : photoLote.getExcelFilelist()) {
                FileHandler fileHandler = new FileHandler(photoLote.getPrefix() + string + photoLote.getSubfix(), photoLote.getOrigenPath(), photoLote.getDestPath());
                
                archNoEnList.add(fileHandler.fileSeacher());
            }
            
        } else {
            for (String string : photoLote.getExcelFilelist()) {
                FileHandler fileHandler = new FileHandler(string, photoLote.getOrigenPath(), photoLote.getDestPath());
                archNoEnList.add(fileHandler.fileSeacher());
            }
        }
        
        //FileJFrame.setMissingString(archNoEnList);
        jPro.dispose();
    }

      public void start() {
        fileThread.start();
    }
      
    public FileManThreadRun() {
        this.archNoEnList = new ArrayList<String>();
        this.photoLote = new PhotoLabFile();
        this.fileThread = new Thread(this);
    }
    
    public void stringTokeniser(String uriString){
        List<String> fileList = new ArrayList<String>();
        StringTokenizer stringTk = new StringTokenizer(uriString, ",");
        while (stringTk.hasMoreTokens()) {            
            fileList.add(stringTk.nextToken());
        }
        photoLote.setExcelFilelist(fileList);
    }
}
