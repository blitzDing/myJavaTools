package testFileUtils;


import java.io.IOException;
import java.nio.file.*;

import fileShortCuts.TextFileProcessing;

public class TestOne {

	public static void main(String[] args) throws IOException 
	{
		
		String pfad = "/home/bernstein/Projex/Test.txt";
		Path path = Paths.get(pfad);
		String[] lines = new String[4];
		lines[0] = "Jereamy Cobra";
		lines[1] = "Below C+o";
		lines[2] = "Hmmm another Line!";
		lines[3] = "super";
		
		//File file = new File("/home/bernstein/Projex/Test.txt");
		//TextFileProcessing.saveText(file, lines);
		//TextFileProcessing.loadText(file);
		System.out.println(Files.exists(path));
	}

}
