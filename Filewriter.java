package com.digital14;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.function.Function;

public class Filewriter implements Writer{
    BufferedWriter writer;

    {
        try {
            writer = new BufferedWriter(new FileWriter("Output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SafeVarargs
    @Override
    public final String write(String data, Function<String, String>... fn) {
        try {
            for(Function<String, String> func: fn){
                data = func.apply(data);
                writer.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void close() {
        System.out.println("Closing file writer");
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
