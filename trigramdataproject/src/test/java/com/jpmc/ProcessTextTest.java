package com.jpmc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.jpmc.ProcessText;
import com.jpmc.Trigram;

public class ProcessTextTest {

	@Test
    public void should_generate_trigrams_from_input() {
        ProcessText processText = new ProcessText("I wish I may I wish I might");
        
        Map<String,Trigram> trigrams = processText.getTrigrams();
                
        assertEquals(4, trigrams.keySet().size());
        
        assertTrue(trigrams.containsKey("i wish"));
        assertTrue(trigrams.containsKey("wish i"));
        assertTrue(trigrams.containsKey("i may"));
        assertTrue(trigrams.containsKey("may i"));
        
        assertEquals("i", trigrams.get("i may").getValue());
        assertEquals(2, trigrams.get("wish i").getAllValues().size());
        assertEquals("may", trigrams.get("wish i").getAllValues().get(0));
        assertEquals("might", trigrams.get("wish i").getAllValues().get(1));       
    }
	
	@Test
	public void test_trigrams_to_text() {
		String str = "I wish! I\" may?. I wish' I might";
		ProcessText processText = new ProcessText(str);	
		
		assertNotNull(processText.generateText());
	    System.out.println("Trigrams to Texts:" + processText.generateText());    
	}
    
	@Test
	public void test_print_trigram() {
		String str = "I wish! I\" may?. I wish' I might";
	    ProcessText processText = new ProcessText(str);
	    Map <String, List<String>> printTrigrams = processText.printTrigrams();	    
	    System.out.println(" printTrigrams : "+printTrigrams);
	}
	
}
