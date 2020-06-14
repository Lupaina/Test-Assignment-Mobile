package com.lupaina.fakefilesystemmvp.folderActivity;

import com.lupaina.fakefilesystemmvp.models.FileModel;
import com.lupaina.fakefilesystemmvp.models.FolderModel;

public class FolderPresenter implements FolderContract.Presenter {

    private FolderContract.View view;

    public FolderPresenter(FolderContract.View view) {
        this.view = view;
    }

    @Override
    public void openFolder(FolderModel folderModel) {
        view.openFolder(folderModel);
    }

    @Override
    public void openFile(FileModel fileModel) {
        view.openFile(fileModel);
    }


}
