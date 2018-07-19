package id.co.aliyan05.dagger2.di.component

import dagger.Subcomponent
import id.co.aliyan05.dagger2.main.MainActivity
import id.co.aliyan05.dagger2.di.ActivityScope

@ActivityScope
@Subcomponent
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder{
        fun build():ActivityComponent
    }
}