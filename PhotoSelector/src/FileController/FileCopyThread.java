/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FileController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import FramePackage.ProgressBarFrame;

public class FileCopyThread extends Thread {
	private static String fileRequest;
	private static String destPath;
	private static String fileName;
	private int numBytesRead;
	
	public void fileCopierT(String fileasked, String destFolderPath, String fName) {
		 fileRequest = fileasked;
		 destPath = destFolderPath;
		 fileName = fName;		
	}
	@Override
	public void run() {		
		String origenStringFile = fileRequest;
		String destStringFile = destPath + "\\" + fileName;
		File orignFile = new File(origenStringFile);
		File destFile = new File(destStringFile);
		System.out.println();
		System.out.println("Mi id="+this.getId() + "  "+  orignFile.getName() + "orignFile.length()" +orignFile.length());
		FileInputStream archivoSelected = null;
		FileOutputStream archivoSalida = null;
		ProgressBarFrame jPro = ProgressBarFrame.getInstance();
		jPro.setFileName(fileName);
		try {
			archivoSelected = new FileInputStream(orignFile);
			archivoSalida = new FileOutputStream(destFile);
			byte[] byteBuf = new byte[16384];
			
			while ((numBytesRead = archivoSelected.read(byteBuf)) != -1) {				
				archivoSalida.write(byteBuf, 0, numBytesRead);
				try {
					this.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//ProgressBarFrame jPro = ProgressBarFrame.getInstance();
				jPro.setActualValue(numBytesRead);
			}
			System.out.println("Mi id="+this.getId() + "  "+ destFile.getName() +"destFile.length()" + destFile.length());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				archivoSalida.close();
				archivoSelected.close();
				//jPro.setActualValue(0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
	}
	public int getNumBytesRead() {
		return numBytesRead;
	}
	public void setNumBytesRead(int numBytesRead) {
		this.numBytesRead = numBytesRead;
	}
	
}
