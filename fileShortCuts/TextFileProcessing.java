package fileShortCuts;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileProcessing 
{

	public static void saveText(String pfad, List<String> lines)
	{
		
		Path path = Paths.get(pfad);
		if(Files.isDirectory(path.getParent())&&Files.notExists(path))
		{
			
			
			for(String line: lines)
			{
			
			}
		}
	}
	
	public static List<String> loadText(String path)
	{
		
		List<String> lines = new ArrayList<>();
		
		
		return lines;
	}
	
	public static int countFileLines()
	{
		
		return 0;
	}
	
	public static void createDir(String pfad)
	{
		
	}
}