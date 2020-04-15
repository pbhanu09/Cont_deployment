package com.utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.BaseClass.BaseClass;

public class getScreenShot extends BaseClass
{
	
	public static String ScreenshotOnFailure(String methodname) throws IOException
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "//Screenshot/" + methodname + ".jpg";
		File destination = new File(dest);
		FileUtils.copyFile(scrFile,destination);
		
		return dest;
	}
}
