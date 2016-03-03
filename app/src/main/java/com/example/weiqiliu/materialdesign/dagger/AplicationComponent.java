package com.example.weiqiliu.materialdesign.dagger;

import android.content.Context;

import com.example.weiqiliu.materialdesign.MainActivity;
import com.example.weiqiliu.materialdesign.dagger.Module.ActivityModule;
import com.example.weiqiliu.materialdesign.dagger.Module.ApplicationModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class,
                      ActivityModule.class})
public interface AplicationComponent {
//    void inject(MainActivity mainActivity);
//
//    //Exposed to sub-graphs.
//    String getHello();
}
