package com.lupaina.fakefilesystemmvp;

import com.lupaina.fakefilesystemmvp.models.FileModel;
import com.lupaina.fakefilesystemmvp.models.FolderModel;

public interface MainPresenterInterface {

    void openFolder(FolderModel folderModel);

    void openFile(FileModel fileModel);

}
