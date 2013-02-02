/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class PhotoLabFile {
    private String excelPath;
    private String origenPath;
    private String destPath;
    private Boolean checkBox;
    private String prefix;
    private String subfix;
    private List<String> excelFilelist;

    public Boolean getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(Boolean checkBox) {
        this.checkBox = checkBox;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

    public List<String> getExcelFilelist() {
        return excelFilelist;
    }

    public void setExcelFilelist(List<String> excelFilelist) {
        this.excelFilelist = excelFilelist;
    }

    public String getExcelPath() {
        return excelPath;
    }

    public void setExcelPath(String excelPath) {
        this.excelPath = excelPath;
    }

    public String getOrigenPath() {
        return origenPath;
    }

    public void setOrigenPath(String origenPath) {
        this.origenPath = origenPath;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSubfix() {
        return subfix;
    }

    public void setSubfix(String subfix) {
        this.subfix = subfix;
    }
    
}
