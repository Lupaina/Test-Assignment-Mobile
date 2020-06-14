package com.lupaina.fakefilesystemmvp.di.folder;

import com.lupaina.fakefilesystemmvp.folderActivity.FolderContract;
import com.lupaina.fakefilesystemmvp.folderActivity.FolderPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class FolderPresenterModule {


    @Provides
    public FolderContract.Presenter provideFolderPresenter(FolderContract.View view){
        return new FolderPresenter(view);
    }
}
