package com.lupaina.fakefilesystemmvp.di.main;

import com.lupaina.fakefilesystemmvp.mainActivity.MainActivity;
import com.lupaina.fakefilesystemmvp.mainActivity.MainContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainViewModule {

    @Binds
    abstract MainContract.View bindsView(MainActivity activity);

}
