package com.jpmc.trigramdataproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trigram {
	private String key;
	private List<String> values;
	
	private static final String NO_ALPHANUM = "[^a-z0-9]";
    	
	public Trigram(String[] threewords) {
		this.key = threewords[0].toLowerCase().replaceAll(NO_ALPHANUM, "") + " "+threewords[1].toLowerCase().replaceAll(NO_ALPHANUM, "");
		this.values = new ArrayList<String>();
		this.values.add(threewords[2].toLowerCase().replaceAll(NO_ALPHANUM, ""));
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		Random rand = new Random();
		int randomIndex = rand.nextInt(values.size());
		return this.values.get(randomIndex);
	}
	
	public List<String> getAllValues() {
		return this.values;				
	}
	
	public void setValue(String value) {
		this.values.add(value);
	}
	
	public String nextKey(String value) {
    	String first = this.key.split(" ")[1];        
        String second = value.toLowerCase().replaceAll(NO_ALPHANUM, "");        
        return first + " " + second;
    }
	
}
