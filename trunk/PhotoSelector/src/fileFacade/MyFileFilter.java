/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fileFacade;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 
 * @author Instructor
 */
public class MyFileFilter implements FilenameFilter {
	private String filter;

	public MyFileFilter(String filter) {
		this.filter = filter;
	}

	public boolean accept(File dir, String name) {
		return (name.contains(filter));
	}
}
