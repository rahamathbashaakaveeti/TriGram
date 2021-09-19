package com.jpmc;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import com.jpmc.Trigram;

class TrigramTest {

	@Test
    public void split_key_value() {
		String[] text = {"word1", "word2","word3"};
		Trigram trigram = new Trigram(text);
		assertEquals("word1 word2", trigram.getKey());
    }
	
	@Test
    public void special_char_test() {
		String[] text = {"word1!", "word2","word3"};
		Trigram trigram = new Trigram(text);
        assertEquals("word1 word2", trigram.getKey());
    }
	
	@Test
    public void generate_key() {
		Trigram trigram = new Trigram(new String[] {"word1", "word2", "word3"});		
        String value = trigram.getValue();        
        assertEquals("word2 word3", trigram.nextKey(value));
    }

}
