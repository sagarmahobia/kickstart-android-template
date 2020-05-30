package org.projectkickstart.templates;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Generated using Android KickStart Template.
 * visit https://github.com/sagarmahobia/kickstart-android-template to learn more.
 */


@ApplicationScope
@Component(modules = {AndroidInjectionModule.class,
        ApplicationModule.class,
        ActivityProvider.class})
public interface ApplicationComponent {

    void inject(KickstartApplication kickstartApplication);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(android.app.Application application);

        ApplicationComponent build();
    }


}
