package fileShortCuts;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class TextFileProcessing 
{

	private List<String> lines = new ArrayList<>();
	
	/*
		The idea is to load the content and hold its
		content in a List. For quick and random
		access. This might cause trouble with The
		JVM if the file(s) are big. Because of Memory
		Space.
	*/
	public TextFileProcessing(String pfad) throws IOException
	{
		loadText(pfad);
	}
	
	public static void saveText(String pfad, List<String> lines)
	{

	    Path dest = Paths.get(pfad);
	    Charset cs = Charset.forName("UTF-8");
	    try 
	    {
	      Path p = Files.write(dest, lines, cs, StandardOpenOption.WRITE,
	          StandardOpenOption.CREATE);
	    
	      System.out.println("saved " + p.toAbsolutePath());
	    } 
	    catch (IOException e) 
	    {
	      e.printStackTrace();
	    }
	}
	
	private void loadText(String pfad) throws IOException
	{
		
		Path path = Paths.get(pfad);
		if(Files.notExists(path))throw new IllegalArgumentException("File doesn't exist.");
		
		lines = Files.readAllLines(path, Charset.forName("UTF-8"));
	}
	
	public int countFileLines()
	{
		return lines.size();
	}
		
	public void consumeOneLine(int n, BiConsumer<Integer, String> bic)
	{
		bic.accept(n, lines.get(n));
	}
	
	public void consumeCoupleOfLines(List<Integer> lineNrs, BiConsumer<Integer, String> bic)
	{
		
		//Keeps Order of lineNrs!!
		for(int n: lineNrs)bic.accept(n, lines.get(n));
	}
	
	public void consumeLineIntervall(int start, int end, BiConsumer<Integer, String> bic)
	{
		for(int n=start;n<end;n++)bic.accept(n, lines.get(n));
	}
	
	public void consumeLinesUntilN(int end, BiConsumer<Integer, String> bic)
	{
		consumeLineIntervall(0, end, bic);
	}
}