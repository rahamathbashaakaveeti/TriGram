package com.jpmc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class ProcessText {
    
    private Map<String,Trigram> trigrams;
    private Random random;
    private String text;

    public ProcessText(String text) {        
        this.trigrams = generateTrigrams(text);
        this.random = new Random();
        this.text = text; 
    }

    public String generateText() {
        StringBuilder generatedText = new StringBuilder();
        
        String key = getStartKey();
        
        while(this.trigrams.containsKey(key)) {
            Trigram trigram = this.trigrams.get(key);
            String newVal = trigram.getValue();
            
            generatedText.append(newVal).append(" ");
            
            key = trigram.nextKey(newVal);
        }
        
        return generatedText.toString();
    }
    
    public Map<String, Trigram> getTrigrams() {
        return this.trigrams;
    }
    
    private String getStartKey() {
        Set<String> keys = this.trigrams.keySet();        
        int randIndex = this.random.nextInt(keys.size());
        int counter = 0;        
        for (String key: keys) {
            if (counter == randIndex) {
                return key;
            }            
            counter++;
        }        
        return null;
    }
    
    private Map<String, Trigram> generateTrigrams(String text) {
        Map<String,Trigram> trigrams = new HashMap<String,Trigram>();
        
        String[] words = text.split(" ");        
        int last = words.length - 3;        
        for (int i = 0; i <= last; i++) {
            String[] subset = new String[3];
            subset[0] = words[i];
            subset[1] = words[i+1];
            subset[2] = words[i+2];
            
            Trigram trigram = new Trigram(subset);
            
            String key = trigram.getKey();
            
            if (trigrams.containsKey(key)) {
                trigrams.get(key).setValue(trigram.getValue());
            } else {
                trigrams.put(key, trigram);
            }
        }
        
        return trigrams;
    }
    
    public Map<String, List<String>> printTrigrams() {
        Map<String,List<String>> trigrams = new HashMap<String,List<String>>();
        
        String[] words = this.text.split(" ");        
        int last = words.length - 3;        
        for (int i = 0; i <= last; i++) {
            String[] subset = new String[3];
            subset[0] = words[i];
            subset[1] = words[i+1];
            subset[2] = words[i+2];
            
            Trigram trigram = new Trigram(subset);
            
            String key = trigram.getKey();
            String value = trigram.getValue();
            
            if (!trigrams.containsKey(trigram.getKey())) {
            	trigrams.put(key, new ArrayList<String>());
            }
            
            trigrams.get(trigram.getKey()).add(value);
        }
        
        return trigrams;
    }
    

}