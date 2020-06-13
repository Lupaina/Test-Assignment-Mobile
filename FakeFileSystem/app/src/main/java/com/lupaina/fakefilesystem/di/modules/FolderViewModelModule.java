package com.lupaina.fakefilesystem.di.modules;

import androidx.lifecycle.ViewModel;

import com.lupaina.fakefilesystem.di.ViewModelKey;
import com.lupaina.fakefilesystem.fragments.FolderViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class FolderViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FolderViewModel.class)
    public abstract ViewModel bindFolderViewModel(FolderViewModel folderViewModel);
}
