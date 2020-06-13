package com.lupaina.fakefilesystem.di.modules;

import com.lupaina.fakefilesystem.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = {FolderViewModelModule.class,
            FragmentBuilderModule.class, FragmentsModule.class})
    abstract MainActivity contributeMainActivity();
}
