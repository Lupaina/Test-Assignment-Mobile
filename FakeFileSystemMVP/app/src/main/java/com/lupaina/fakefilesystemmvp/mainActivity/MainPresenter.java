package com.lupaina.fakefilesystemmvp.mainActivity;

import android.util.Log;

import com.lupaina.fakefilesystemmvp.models.FileModel;
import com.lupaina.fakefilesystemmvp.models.FolderModel;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "MainPresenter";
    private MainContract.View view;
    private MainContract.Repository repository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public MainPresenter(MainContract.View view, MainContract.Repository repository) {
        this.view = view;
        this.repository = repository;

    }

    @Override
    public void openFolder(FolderModel folderModel) {
        view.openFolder(folderModel);
    }

    @Override
    public void openFile(FileModel fileModel) {
        view.openFile(fileModel);
    }

    @Override
    public void initData() {
        compositeDisposable.add(repository.getFolder().subscribe(mainModels -> {
            view.getData(mainModels);
        }, throwable -> {
            Log.e(TAG, "initData: ", throwable);
        }));
    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
    }
}
