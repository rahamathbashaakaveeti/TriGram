package com.jpmc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jpmc.constants.Errors;
import com.jpmc.exception.ApplicationException;

/*
 * @author Rahamath Basha Akaveeti
 * @Created 21/09/21
 */

public class Trigram {
	private String key;
	private List<String> values;
	
	private static final String ALPHA_NUMERIC_ONLY = "[^a-z0-9]";
    	
	public Trigram(String[] threewords) {
		
		if(threewords.length < 3) {
			throw new ApplicationException(Errors.INVALID_NUMBER_OF_WORDS.getCode(),Errors.INVALID_NUMBER_OF_WORDS.getMessage());
		}
				
		this.key = threewords[0].toLowerCase().replaceAll(ALPHA_NUMERIC_ONLY, "") + " "+threewords[1].toLowerCase().replaceAll(ALPHA_NUMERIC_ONLY, "");
		this.values = new ArrayList<String>();
		this.values.add(threewords[2].toLowerCase().replaceAll(ALPHA_NUMERIC_ONLY, ""));
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
        String second = value.toLowerCase().replaceAll(ALPHA_NUMERIC_ONLY, "");        
        return first + " " + second;
    }
	
}
