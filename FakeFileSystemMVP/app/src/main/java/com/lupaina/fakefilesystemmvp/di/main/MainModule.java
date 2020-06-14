package com.lupaina.fakefilesystemmvp.di.main;

import android.app.Application;

import com.lupaina.fakefilesystemmvp.helpClass.CustomParser;
import com.lupaina.fakefilesystemmvp.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainModule {

    @Provides
    static Repository provideRepository(Application application, CustomParser customParser) {
        return new Repository(application, customParser);
    }

    @Provides
    static CustomParser provideCustomParser() {
        return new CustomParser();
    }
}
