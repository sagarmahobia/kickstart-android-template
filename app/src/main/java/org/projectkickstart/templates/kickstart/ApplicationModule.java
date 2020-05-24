package org.projectkickstart.templates.kickstart;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by SAGAR MAHOBIA on 18-Nov-18. at 17:07
 */

@Module()
class ApplicationModule {

    @Provides
    @ApplicationScope
    Context context(Application application) {
        return application.getApplicationContext();
    }

    @Provides
    @ApplicationScope
    SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
