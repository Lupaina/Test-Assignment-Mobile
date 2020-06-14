package com.lupaina.fakefilesystemmvp.di;

import com.lupaina.fakefilesystemmvp.di.folder.FolderPresenterModule;
import com.lupaina.fakefilesystemmvp.di.folder.FolderViewModule;
import com.lupaina.fakefilesystemmvp.di.main.MainModule;
import com.lupaina.fakefilesystemmvp.di.main.MainPresenterModule;
import com.lupaina.fakefilesystemmvp.di.main.MainViewModule;
import com.lupaina.fakefilesystemmvp.folderActivity.FolderActivity;
import com.lupaina.fakefilesystemmvp.mainActivity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = {MainModule.class, MainPresenterModule.class, MainViewModule.class})
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(modules = {FolderPresenterModule.class, FolderViewModule.class})
    abstract FolderActivity contributeFolderActivity();

}
