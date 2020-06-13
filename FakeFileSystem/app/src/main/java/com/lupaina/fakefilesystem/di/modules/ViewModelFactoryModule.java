package com.lupaina.fakefilesystem.di.modules;

import androidx.lifecycle.ViewModelProvider;

import com.lupaina.fakefilesystem.di.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory factory);


}
