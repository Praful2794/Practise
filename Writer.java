package com.digital14;

import java.util.function.Function;

public interface Writer {
    String write(String data, Function<String, String>... fn) ;
    void close();
}
