package com.lupaina.fakefilesystemmvp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class FileModel extends MainModel implements Parcelable {
    private String name;
    private String type;
    private String content;


    public FileModel(String name, String type, String content) {
        this.name = name;
        this.type = type;
        this.content = content;
    }

    public FileModel(Parcel parcel) {
        name = parcel.readString();
        type = parcel.readString();
        content = parcel.readString();


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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(name);
        parcel.writeString(type);
        parcel.writeString(content);
    }

    public static final Parcelable.Creator<FileModel> CREATOR = new Parcelable.Creator<FileModel>() {

        @Override
        public FileModel createFromParcel(Parcel parcel) {
            return new FileModel(parcel);
        }

        @Override
        public FileModel[] newArray(int i) {
            return new FileModel[i];
        }
    };
}
