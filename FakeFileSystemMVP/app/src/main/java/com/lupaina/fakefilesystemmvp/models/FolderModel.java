package com.lupaina.fakefilesystemmvp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class FolderModel extends MainModel implements Parcelable {


    private String name;
    private String type;
    private List<MainModel> items;

    public FolderModel(String name, String type, List<MainModel> items) {
        this.name = name;
        this.type = type;
        this.items = items;
    }

    public FolderModel(Parcel parcel) {
        name = parcel.readString();
        type = parcel.readString();
        items = new ArrayList<>();
        parcel.readList(items, MainModel.class.getClassLoader());


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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(name);
        parcel.writeString(type);
        parcel.writeList(items);
    }

    public static final Parcelable.Creator<FolderModel> CREATOR = new Parcelable.Creator<FolderModel>() {

        @Override
        public FolderModel createFromParcel(Parcel parcel) {
            return new FolderModel(parcel);
        }

        @Override
        public FolderModel[] newArray(int i) {
            return new FolderModel[i];
        }
    };
}
