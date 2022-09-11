package com.digital14;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ApplicationTest {
    Function<String, String> toUpperCase = String::toUpperCase;
    Function<String, String> toLowerCase = String::toLowerCase;
    Function<String, String> removeStupid = str -> str.replace("stupid", "");
    Function<String, String> removeDuplicate = str -> {
        String[] allWords = str.split(" ");
        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(allWords));
        StringBuilder result = new StringBuilder();
        for(String word: set){
            result.append(word).append(" ");
        }
        return result.toString().trim();
    };

    @Test
    public void testStringWriter(){
        String textToWrite = "This is my data";
        Writer stringwriter = new StringWriter();
        String result = stringwriter.write(textToWrite);
        assertEquals(textToWrite, result);
    }

    @Test
    public void testStringWriterToUpperCase(){
        String textToWrite = "This is my data";
        Writer stringwriter = new StringWriter();
        String result = stringwriter.write(textToWrite, toUpperCase);
        assertEquals("THIS IS MY DATA", result);
    }

    @Test
    public void testStringWriterToLowerCase(){
        String textToWrite = "This is my data";
        Writer stringwriter = new StringWriter();
        String result = stringwriter.write(textToWrite, toLowerCase);
        assertEquals("this is my data", result);
    }

    @Test
    public void testStringWriterRemoveStupid(){
        String textToWrite = "This is my stupid data";
        Writer stringwriter = new StringWriter();
        String result = stringwriter.write(textToWrite, removeStupid);
        assertEquals("This is my  data", result);
    }

    @Test
    public void testStringWriterRemoveDuplicate(){
        String textToWrite = "This is is my data";
        Writer stringwriter = new StringWriter();
        String result = stringwriter.write(textToWrite, removeDuplicate);
        assertEquals("This is my data", result);
    }

    @Test
    public void testStringWriterRemoveDuplicateAndStupid(){
        String textToWrite = "This is is my stupid data";
        Writer stringwriter = new StringWriter();
        String result = stringwriter.write(textToWrite, removeStupid, removeDuplicate);
        assertEquals("This is my  data", result);
    }
}
