package testingMath;

import java.util.*;

import someMath.CollectionManupulation;

public class CartesianAndPowerSetTest 
{
	
	static Set<String> s1 = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
	static Set<String> s2 = new HashSet<>(Arrays.asList("@", "€", "µ"));
	static Set<String> s3 = new HashSet<>(Arrays.asList("0", "1"));
	static Set<String> s4 = new HashSet<>(Arrays.asList("*", "+"));
	
	public static void main(String... args)
	{
		
		List<Set<String>> edukte = new ArrayList<>();
		edukte.add(s1);
		edukte.add(s2);
		edukte.add(s3);
		edukte.add(s4);
		
		@SuppressWarnings("unchecked")
		Set<List<String>> erg = CollectionManupulation.cartesianProduct(s1,s2,s3,s4);
		System.out.println("Set of List's size:"+erg.size());
		System.out.println(erg);
		System.out.println("");
		
		Set<Set<String>> powerSet = CollectionManupulation.powerSet(s2);
		System.out.println("Set of Set's size:"+powerSet.size());
		System.out.println(powerSet);
		System.out.println("");
		
		//The empty Set is subSet of every Set. But is not element of every Set.
		List<Set<String>> edukte2 = new ArrayList<>();
		for(Set<String> set: powerSet)if(!set.isEmpty())edukte2.add(set);//empty Set as Element will 
																		 //otherwise make the Cartesian 
																		 //Product make vanish.
		
		Set<List<String>> wundertuete = CollectionManupulation.cartesianProduct(edukte2);
		System.out.println("Set of List's size:"+wundertuete.size());
		System.out.println(wundertuete);
	}

}
