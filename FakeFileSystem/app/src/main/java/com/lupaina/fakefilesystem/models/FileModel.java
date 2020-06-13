package com.lupaina.fakefilesystem.models;

public class FileModel extends MainModel {
    private String name;
    private String type;
    private String content;


    public FileModel(String name, String type, String content) {
        this.name = name;
        this.type = type;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
