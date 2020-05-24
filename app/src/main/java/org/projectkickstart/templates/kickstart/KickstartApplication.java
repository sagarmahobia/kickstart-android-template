package org.projectkickstart.templates.kickstart;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

/**
 * Created by SAGAR MAHOBIA
 */

public class KickstartApplication extends android.app.Application implements HasAndroidInjector {
    @Inject
    DispatchingAndroidInjector<Object> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        //Uncomment this snipped after configuring
       /*
       DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this);

        */

    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return activityDispatchingAndroidInjector;
    }
}

//place this snippet to app level build.gradle file.
/*

    implementation 'com.google.dagger:dagger:2.25.2'
    implementation 'com.google.dagger:dagger-android-support:2.25.2'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.24'
    annotationProcessor 'com.google.dagger:dagger-android-processor:2.24'

    dataBinding{
        enabled = true
    }

*/
