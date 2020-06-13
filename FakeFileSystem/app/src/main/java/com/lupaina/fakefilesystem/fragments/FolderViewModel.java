package com.lupaina.fakefilesystem.fragments;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.lupaina.fakefilesystem.R;
import com.lupaina.fakefilesystem.models.FileModel;
import com.lupaina.fakefilesystem.models.FolderModel;
import com.lupaina.fakefilesystem.models.MainModel;
import com.lupaina.fakefilesystem.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class FolderViewModel extends ViewModel {
    private static final String TAG = "FolderViewModel";

    private MutableLiveData<FolderModel> currentFolderList = new MutableLiveData<>();
    private MutableLiveData<List<MainModel>> mainFolderList = new MutableLiveData<>();
    private MutableLiveData<String> fileContent = new MutableLiveData<>();
    private MutableLiveData<String> fileTitle = new MutableLiveData<>();
    private MutableLiveData<Boolean> noFilesTitleVisible = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public LiveData<FolderModel> getCurrentFolderList() {
        return currentFolderList;
    }

    public LiveData<List<MainModel>> getMainFolderList() {
        return mainFolderList;
    }

    public LiveData<String> getFileContent() {
        return fileContent;
    }

    public LiveData<String> getFileTitle() {
        return fileTitle;
    }

    public LiveData<Boolean> getNoFilesTitleVisible() {
        return noFilesTitleVisible;
    }

    @Inject
    public FolderViewModel(Repository repository) {

        Disposable disposable = repository.getFiles().subscribe(listFolders -> {
            mainFolderList.setValue(listFolders);
        }, throwable -> {
            mainFolderList.setValue(new ArrayList<>());
            Log.e(TAG, "FolderViewModel: ", throwable);
        });

        compositeDisposable.add(disposable);

    }

    public void openFolder(FolderModel selectFolder, View view) {
        currentFolderList.setValue(selectFolder);
        noFilesTitleVisible.setValue(selectFolder.getItems().size() == 0);
        NavController navController = Navigation.findNavController(view);
        if (navController.getCurrentDestination() != null)
            if (navController.getCurrentDestination().getId() == R.id.startFolderFragment)
                navController.navigate(R.id.action_startFolderFragment_to_folderFragment);
            else
                navController.navigate(R.id.action_folderFragment_self);


    }

    public void openFile(FileModel fileModel, View view) {
        fileContent.setValue(fileModel.getContent());
        fileTitle.setValue(fileModel.getName());
        Navigation.findNavController(view).navigate(R.id.action_folderFragment_to_fileFragment);

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
