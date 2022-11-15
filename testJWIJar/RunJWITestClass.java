package testJWIJar;

import java.io.IOException;

import edu.mit.jwi.item.POS;
import jwiShortCuts.JWIOverhead;
import jwiShortCuts.LoadingIngredients;

public class RunJWITestClass 
{

	public static void main(String[] args) throws IOException 
	{

		JWIOverhead t = new JWIOverhead();
		//t.testDictionary();
		String word = "food";
		int n = t.howManyMeanings(word, POS.NOUN);
		System.out.println("There a "+n+" meanings for: \""+word+"\" as Noun");
		System.out.println("Parts of Speech: "+t.partsOfSpeech("food"));
		
		for(int i=0;i<n;i++)
		{
			String synsetStr = t.getSynset(word, i, POS.NOUN).toString();
			System.out.println(synsetStr);
			//ISynset iSynset = t.getSynset(word, i, POS.NOUN);
		}
		
		System.out.println(t.stemWord("quantum_mechanics", null));//null is more general then a concrete POS
		LoadingIngredients.exploreFood(t.getDict());
	}
}
