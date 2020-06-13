package com.lupaina.fakefilesystem.di;

import android.app.Application;

import com.lupaina.fakefilesystem.BaseApplication;
import com.lupaina.fakefilesystem.di.modules.ActivityBuilderModule;
import com.lupaina.fakefilesystem.di.modules.ViewModelFactoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        ViewModelFactoryModule.class, ActivityBuilderModule.class})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
