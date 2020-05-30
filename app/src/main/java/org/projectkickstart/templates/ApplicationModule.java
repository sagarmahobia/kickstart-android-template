package org.projectkickstart.templates;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Generated using Android KickStart Template.
 * visit https://github.com/sagarmahobia/kickstart-android-template to learn more.
 */

@Module()
class ApplicationModule {

    @Provides
    @ApplicationScope
    Context context(Application application) {
        return application.getApplicationContext();
    }

}
