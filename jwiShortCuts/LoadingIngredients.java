package jwiShortCuts;

import java.util.List;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;

public class LoadingIngredients 
{

	public static void exploreFood(Dictionary dict)
	{
		String wordStr = "food";
		// look up n-th sense of the word " dog "
		IIndexWord idxWord = dict.getIndexWord(wordStr, POS.NOUN) ;
				

		List<IWordID> wordIDs = idxWord.getWordIDs(); // n-th meaning
		System.out.println(wordIDs);
	}
}
