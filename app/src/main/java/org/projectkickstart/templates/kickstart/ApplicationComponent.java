package org.projectkickstart.templates.kickstart;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by SAGAR MAHOBIA
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
