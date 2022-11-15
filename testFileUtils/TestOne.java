package testFileUtils;

import java.io.File;
import java.io.IOException;

import fileShortCuts.TextFilePersitence;

public class TestOne {

	public static void main(String[] args) throws IOException 
	{
		
		String[] lines = new String[4];
		lines[0] = "Jereamy Cobra";
		lines[1] = "Below C+o";
		lines[2] = "Hmmm another Line!";
		lines[3] = "super";
		
		File file = new File("/home/bernstein/Projex/Test.txt");
		TextFilePersitence.saveText(file, lines);
		TextFilePersitence.loadText(file);
		System.out.println(TextFilePersitence.countFileLines(file));
	}

}
