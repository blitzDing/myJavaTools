package fileShortCuts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BiConsumer;

public class TextFilePersitence 
{
	
	public static void saveText(File file, String [] lines) throws IOException
	{
       
		FileOutputStream fos = new FileOutputStream(file);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	 
		for (int i = 0; i < lines.length; i++)
		{
			bw.write(lines[i]);
			bw.newLine();
		}
	 
		bw.close();
	}
	

	public static String[] loadText(File file) throws IOException
	{

		int maxLineNr = (int)countFileLines(file);
		String[] lines = new String[maxLineNr];
		FileReader fis = new FileReader(file);
		
		BufferedReader	reader = new BufferedReader(fis);
		
		String line;
		while((line=reader.readLine())!= null)System.out.println(line);
	
		reader.close();
		
		return lines;
	}
	
	public static long countFileLines(File file) throws IOException
	{
		
		String fileName = file.getAbsolutePath();
		
		Path path = Paths.get(fileName);

	    long lines = Files.lines(path).count();
		
	    return lines;
	}
	
	public static void consumeAllFileLines(File file, BiConsumer<Integer, String> lineProcessor) throws IOException
	{
	
		FileReader fis = new FileReader(file);
		
		BufferedReader	reader = new BufferedReader(fis);
		
		int n = 0;
		String line;
		while((line=reader.readLine())!= null)
		{
			
			lineProcessor.accept(n, line);;
			n++;
		}
		
		reader.close();
		
	}
	
	public static void consumeOneFileLine(File file, BiConsumer<Integer, String> lineProcessor, int n) throws IOException
	{
		//The first line has the number: Zero!
		long maxLineNr = countFileLines(file)-1;
		if(maxLineNr<n)throw new IllegalArgumentException("line Nr.: " + n + " is to big");

		
		FileReader fis = new FileReader(file);
		
		BufferedReader reader = new BufferedReader(fis);
		
		int m = 0;
		String line;
		while((line=reader.readLine())!= null)
		{
			
			if(m==n)
			{
				lineProcessor.accept(n, line);
				reader.close();
				break;
			}
			m++;
		}
	}
	
	public static void consumeCoupleOfFileLines(File file, BiConsumer<Integer, String> lineProcessor, int [] lines) throws IOException
	{
		//Processes Lines in the exact order given.
		//Might be slow if file has Many Lines. 
		//Maybe i should write a Method if Order is
		//not important.
		long maxLineNr = countFileLines(file)-1;
		for(int i=0;i<lines.length;i++)
		{
			
			int currentDestiny = lines[i];
			//The first line has the number: Zero!
			if(maxLineNr<currentDestiny)throw new IllegalArgumentException("line Nr.: " + currentDestiny + " is to big");
			consumeOneFileLine(file,lineProcessor, currentDestiny);
		}
	}
}
