package com.lupaina.fakefilesystem.helpClass;

import android.util.Log;

import com.lupaina.fakefilesystem.models.FileModel;
import com.lupaina.fakefilesystem.models.FolderModel;
import com.lupaina.fakefilesystem.models.MainModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Метою написання цього класу було розпарсить файл JSON
 * в якому може бути не обмежена кількість файлів та папок
 */
public class CustomParser {

    private static final String TAG = "CustomParser";


    public List<MainModel> convertToList(String jsonString) {
        List<MainModel> list = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            list.addAll(parseObject(jsonObject));

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "parse: ", e);

        }

        return list;

    }

    /**
     * takes the object checks the type and adds the appropriate file or folder class to list
     */
    private List<MainModel> parseObject(JSONObject jsonObject) throws JSONException {
        List<MainModel> mainModels = new ArrayList<>();

        String name = jsonObject.getString("name");
        String type = jsonObject.getString("type");
        if (type.equals("FOLDER")) {
            mainModels.add(new FolderModel(name, type, parseFolder(jsonObject.getString("items"))));

        } else {
            String content = jsonObject.getString("content");
            mainModels.add(new FileModel(name, type, content));
        }


        return mainModels;
    }

    /**
     * takes Json array as a string converts it and parse objects
     */
    private List<MainModel> parseFolder(String variable) throws JSONException {
        List<MainModel> mainModels = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(variable);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            mainModels.addAll(parseObject(jsonObject));
        }

        return mainModels;

    }
}
