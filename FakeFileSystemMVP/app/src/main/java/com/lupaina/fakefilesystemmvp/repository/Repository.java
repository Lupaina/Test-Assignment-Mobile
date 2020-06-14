package com.lupaina.fakefilesystemmvp.repository;

import android.content.Context;

import com.lupaina.fakefilesystemmvp.helpClass.CustomParser;
import com.lupaina.fakefilesystemmvp.mainActivity.MainContract;
import com.lupaina.fakefilesystemmvp.models.MainModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Парсинг JSON файлу відбувається в окремому потоці за допомогою RXJava 2
 * в даному випадку він не потрібен зважаючи на розмір файлу,
 * але додаток розрахований на необмежену кількість папок та файлів.
 */

public class Repository implements MainContract.Repository {

    private Context context;
    private CustomParser customParser;

    public Repository(Context context, CustomParser customParser) {
        this.context = context;
        this.customParser = customParser;
    }

    @Override
    public Observable<List<MainModel>> getFolder() {
        return Observable.just(customParser.convertToList(inputStreamToString()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private String inputStreamToString() {
        try {
            InputStream inputStream = context.getAssets().open("filesystem_sample.json");
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            return new String(bytes);
        } catch (IOException e) {
            return "{}";
        }
    }


}
