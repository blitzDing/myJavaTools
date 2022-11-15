package jwiShortCuts;

import java.io.IOException;

import java.net.URL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;

import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.ISynset;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import edu.mit.jwi.morph.WordnetStemmer;

public class JWIOverhead 
{


	private final IDictionary dict;
	private final String wnHome = "/usr/local/WordNet-3.0/dict/";
	private final URL url;

	//ToDo: More Testing then WordStemmer
	public JWIOverhead() throws IOException
	{
		
		// construct the URL to the Wordnet dictionary directory
		url = new URL("file", null, wnHome ) ;
		
		// construct the dictionary object and open it
		dict = new Dictionary(url) ;
		dict.open();
	}
		
	public void testDictionary () throws IOException 
	{
		
		//String wnhome = System.getenv( " WNHOME " ). Old changed somehow;
		// look up first sense of the word " dog "
		IIndexWord idxWord = dict.getIndexWord("dog",POS.NOUN);
		IWordID wordID = idxWord.getWordIDs().get(0);
		IWord word = dict.getWord(wordID);
		System.out.println(" Id = " + wordID);
		System.out.println(" Lemma = " + word.getLemma());
		System.out.println(" Gloss = " + word.getSynset().getGloss());
		
	}
	
	public List<String> stemWord(String wordStr, POS p)
	{
		WordnetStemmer stemmer = new WordnetStemmer(dict);
		List<String> words = stemmer.findStems(wordStr, p);
		return words;
	}

	public ISynset getSynset(String wordStr, int n, POS partOfSpeech)//Changed 
	{
		
		// get the synset
		//Set<IWord> returnValues = new HashSet<>();
		IIndexWord idxWord = dict.getIndexWord(wordStr, partOfSpeech);
		System.out.println(idxWord);
		int m = idxWord.getWordIDs().size();	
		if(n>m)throw new IllegalArgumentException("Not that many Word-ID's");
		
		IWordID wordID = idxWord.getWordIDs().get(n); // n-th meaning
		IWord word = dict.getWord(wordID);
		ISynset synset = word.getSynset();
		
		return synset;
		
		/* get the hypernyms or hyponyms depends on the Pointer
		List<ISynsetID> nyms = 
				synset.getRelatedSynsets(p) ;
		print out each h y p e r n y m s id and synonyms
		List<IWord>words ;
		for (ISynsetID sid : nyms)
		{
			words = dict.getSynset(sid).getWords();
			returnValues.addAll(words);
			System.out.print(sid + " { " ) ;
			for(Iterator<IWord> i = words.iterator(); i.hasNext();)
			{
				System.out.print(i.next().getLemma());
				if (i.hasNext())System.out.print(" , ");
			}
			System.out.println (" } ") ;
		}
		*/
	}
	
	public void getSynonyms(String wordStr, int n) 
	{
		// look up n-th sense of the word " dog "
		IIndexWord idxWord = dict.getIndexWord(wordStr, POS.NOUN) ;
		
		int m = idxWord.getWordIDs().size();
		if(n>m)throw new IllegalArgumentException("Not that many Word-ID's");

		IWordID wordID = idxWord.getWordIDs().get(n) ; // n-th meaning
		IWord word = dict.getWord (wordID) ;
		ISynset synset = word.getSynset () ;
		// iterate over words associated with the synset
		for(IWord w : synset.getWords())System.out.println(w.getLemma());
	}
	
	public int howManyMeanings(String wordStr, POS partsOfSpeech)//Pos is an enum of JWI
	{

		IIndexWord idxWord = dict.getIndexWord(wordStr, partsOfSpeech);
		return idxWord.getWordIDs().size();
	}
	
	public Set<POS> partsOfSpeech(String wordStr)
	{
		
		Set<POS> parts = new HashSet<>();
		for(POS pos: POS.values())
		{
			IIndexWord idxWord = dict.getIndexWord(wordStr, pos);
			//int m = idxWord.getWordIDs().size(); // n-th meaning
			if(idxWord!=null)parts.add(pos);
		}
		
		return parts;
	}
	
	public Dictionary getDict() { return (Dictionary) dict;}
}