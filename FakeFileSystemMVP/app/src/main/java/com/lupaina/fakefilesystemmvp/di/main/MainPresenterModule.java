package com.lupaina.fakefilesystemmvp.di.main;

import com.lupaina.fakefilesystemmvp.mainActivity.MainContract;
import com.lupaina.fakefilesystemmvp.mainActivity.MainPresenter;
import com.lupaina.fakefilesystemmvp.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class MainPresenterModule {


    @Provides
    public MainContract.Presenter providePresenter(MainContract.View view, Repository repository){
        return new MainPresenter(view,repository);
    }
}
