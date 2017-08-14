package com.miskevich.manuniaweb.utils.reader;

import com.miskevich.manuniaweb.ServletDefinition;

import java.util.List;

public interface ServletReader {
    List<ServletDefinition> getServlets(String path);
}
