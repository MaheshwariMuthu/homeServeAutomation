package automationFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;


public class Utils {

	public static void deleteDir(String pathToDeleteFolder) {
		File extefolder = new File(pathToDeleteFolder);
		if ((extefolder.exists())) {
			deleteFolderDir(extefolder);
		}
	}

	/**
	 * 
	 * Description Method to delete folder directory
	 * @author aatish.slathia
	 * @param folderToDelete
	 */
	public static void deleteFolderDir(File folderToDelete) {
		File[] folderContents = folderToDelete.listFiles();
		if (folderContents != null) {
			for (File folderfile : folderContents) {
				if (!Files.isSymbolicLink(folderfile.toPath())) {
					deleteFolderDir(folderfile);
				}
			}
		}
		folderToDelete.delete();
	}
	
	/**
	 * 
	 * Description Method for fetching of get Current Date Time
	 * @author aatish.slathia
	 */
	public static Date getCurrentDateTime() {
		Calendar calendar = Calendar.getInstance();
		Date currentDateTime = calendar.getTime();
		return currentDateTime;
		
	}
	
	/**
	 * 
	 * Description Method for fetching of get Current Date Time
	 * @author aatish.slathia
	 * @param value
	 */
	public static String getStringWithTimeStampWithoutUnderScore(String value) {
		DateFormat dateFormat = new SimpleDateFormat("ddMMHHmmss");
        String date = dateFormat.format(new Date());
        String randomString=value+date;
		return randomString;
	
	}
	
	/**
	 * 
	 * Description Method for fetching of get Current Date Time
	 * @author aatish.slathia
	 * @param value
	 */
	public static String getStringWithTimeStamp(String value) {
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_HH_mmss");
        String date = dateFormat.format(new Date());
        String randomString=value+date;
		return randomString;
	
	}
}