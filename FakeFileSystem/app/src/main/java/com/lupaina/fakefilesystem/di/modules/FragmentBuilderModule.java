package com.lupaina.fakefilesystem.di.modules;

import com.lupaina.fakefilesystem.fragments.FileFragment;
import com.lupaina.fakefilesystem.fragments.FolderFragment;
import com.lupaina.fakefilesystem.fragments.StartFolderFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract StartFolderFragment contributeStartFolderFragment();

    @ContributesAndroidInjector
    abstract FolderFragment contributeFolderFragment();

    @ContributesAndroidInjector
    abstract FileFragment contributeFileFragment();
}
