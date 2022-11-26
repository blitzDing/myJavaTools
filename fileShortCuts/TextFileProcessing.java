package fileShortCuts;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

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
	
	public static void consumeOneLine(String pfad, int n)
	{
		
	}
	
	public static void consumeCoupleOfLines(String pfad, List<Integer> n, BiConsumer<Integer, String> bic)
	{
		
	}
	
	public static void consumeLineIntervall(String pfad, int start, int end, BiConsumer<Integer, String> bic)
	{
		
		
	}
	
	public static void consumeLinesUntilN(String pfad, int end, BiConsumer<Integer, String> bic)
	{
		consumeLineIntervall(pfad, 0, end, bic);
	}
}