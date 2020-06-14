package com.lupaina.fakefilesystemmvp.di.folder;

import com.lupaina.fakefilesystemmvp.folderActivity.FolderActivity;
import com.lupaina.fakefilesystemmvp.folderActivity.FolderContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class FolderViewModule {

    @Binds
    abstract FolderContract.View bindsFolderView(FolderActivity activity);
}
