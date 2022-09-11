package com.digital14;

import java.util.function.Function;

public class StringWriter implements Writer {
    StringBuilder sb = new StringBuilder();

    @SafeVarargs
    @Override
    public final String write(String data, Function<String, String>... fn) {
        for(Function<String, String> func: fn){
            data = func.apply(data);
        }
        sb.append(data);
        return sb.toString();
    }

    @Override
    public void close() {
        System.out.println("Closing string writer");
    }
}
