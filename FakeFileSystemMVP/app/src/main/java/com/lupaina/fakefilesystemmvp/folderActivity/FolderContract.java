package com.lupaina.fakefilesystemmvp.folderActivity;

import com.lupaina.fakefilesystemmvp.MainPresenterInterface;
import com.lupaina.fakefilesystemmvp.models.FileModel;
import com.lupaina.fakefilesystemmvp.models.FolderModel;

public interface FolderContract {

    interface View {

        void openFolder(FolderModel folderModel);

        void openFile(FileModel fileModel);
    }

    interface Presenter extends MainPresenterInterface {
        void openFolder(FolderModel folderModel);

        void openFile(FileModel fileModel);


    }
}
