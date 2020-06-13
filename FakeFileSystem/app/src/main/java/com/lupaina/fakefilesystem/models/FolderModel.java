package com.lupaina.fakefilesystem.models;

import java.util.List;

public class FolderModel extends MainModel {


    private String name;
    private String type;
    private List<MainModel> items;

    public FolderModel(String name, String type, List<MainModel> items) {
        this.name = name;
        this.type = type;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<MainModel> getItems() {
        return items;
    }
}
