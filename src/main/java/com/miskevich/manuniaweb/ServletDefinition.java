package com.miskevich.manuniaweb;

import java.util.List;

public class ServletDefinition {
    private String name;
    private String className;
    private List<String> urls;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "ServletDefinition{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", urls=" + urls +
                '}';
    }
}
