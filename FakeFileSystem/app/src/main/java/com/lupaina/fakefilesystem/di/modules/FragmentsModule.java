package com.lupaina.fakefilesystem.di.modules;

import android.app.Application;

import com.lupaina.fakefilesystem.helpClass.CustomParser;
import com.lupaina.fakefilesystem.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class FragmentsModule {


    @Provides
    static Repository provideRepository(Application application, CustomParser customParser) {
        return new Repository(application, customParser);
    }

    @Provides
    static CustomParser provideCustomParser() {
        return new CustomParser();
    }
}
