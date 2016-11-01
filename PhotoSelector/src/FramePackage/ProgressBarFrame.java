package FramePackage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class ProgressBarFrame extends javax.swing.JFrame {

    private static ProgressBarFrame myInstance;
    private int minValue;
    private int maxValue;
    private int actualValue;
    private final javax.swing.JProgressBar progressBar;
    private List<String> archNoEnList;
    private Boolean fileThread;
    //JProgressBar 

    public Boolean getFileThread() {
        return fileThread;
    }

    public void setFileThread(Boolean fileThread) {
        this.fileThread = fileThread;
    }

    public int getActualValue() {
        return actualValue;
    }

    public List<String> getArchNoEnList() {
        return archNoEnList;
    }

    public void setArchNoEnList(List<String> archNoEnList) {
        this.archNoEnList = archNoEnList;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setFileName(String fileName) {
        this.setTitle("Copiando..." + fileName);
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        progressBar.setMaximum(maxValue);
        progressBar.setMinimum(0);

    }

    public void setActualValue(int actualValue) {
        this.actualValue = actualValue + this.actualValue;

        if (actualValue == 0) {
            progressBar.setValue(0);
            this.actualValue = 0;
        } else {
            progressBar.setValue(this.actualValue);
            progressBar.setVisible(true);
        }
        progressBar.setStringPainted(true);
    }

    private ProgressBarFrame() {
        this.setSize(450, 150);
        this.setTitle("Copiando...");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((pantallaTamano.width / 2) - (this.getWidth() / 2), (pantallaTamano.height / 2) - (this.getHeight() / 2));
        Container content = this.getContentPane();
        Border border = BorderFactory.createTitledBorder("Copiando...");
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setBorder(border);
        progressBar.setVisible(true);
        content.add(progressBar, BorderLayout.CENTER);
        this.setVisible(true);
        actualValue = 0;
    }

    public static ProgressBarFrame getInstance() {
        if (myInstance == null) {
            myInstance = new ProgressBarFrame();
        }
        return myInstance;
    }
}
