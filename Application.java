package com.digital14;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

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
            return result.toString();
        };

        String textToWrite = "This is my data stupid";
        Writer stringwriter = new StringWriter();
        writeToWriter(stringwriter, textToWrite, toUpperCase, removeStupid);

        textToWrite = "This is is my data";
        Writer fileWriter = new Filewriter();
        writeToWriter(fileWriter, textToWrite, toLowerCase, removeDuplicate);
    }

    @SafeVarargs
    static void writeToWriter(Writer writer, String textToWrite, Function<String, String>... func) {
        writer.write(textToWrite, func);
        writer.close();
    }
}
