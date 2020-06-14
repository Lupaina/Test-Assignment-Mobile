package com.lupaina.fakefilesystemmvp.mainActivity;

import com.lupaina.fakefilesystemmvp.MainPresenterInterface;
import com.lupaina.fakefilesystemmvp.models.FileModel;
import com.lupaina.fakefilesystemmvp.models.FolderModel;
import com.lupaina.fakefilesystemmvp.models.MainModel;

import java.util.List;

import io.reactivex.Observable;

public interface MainContract {
    interface View {

        void getData(List<MainModel> mainModels);

        void openFolder(FolderModel folderModel);

        void openFile(FileModel fileModel);
    }

    interface Presenter extends MainPresenterInterface {
        void openFolder(FolderModel folderModel);

        void openFile(FileModel fileModel);

        void initData();

        void onDestroy();
    }

    interface Repository {
        Observable<List<MainModel>> getFolder();

    }

}
