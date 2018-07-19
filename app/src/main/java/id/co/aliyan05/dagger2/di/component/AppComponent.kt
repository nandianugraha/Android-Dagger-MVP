package id.co.aliyan05.dagger2.di.component

import dagger.Component
import dagger.Provides
import id.co.aliyan05.dagger2.AppClass
import id.co.aliyan05.dagger2.di.module.AppModule
import javax.inject.Singleton


    @Singleton
    @Component(modules=[AppModule::class])
    interface AppComponent {

        fun activityComponent():ActivityComponent.Builder
        abstract fun inject(appClass: AppClass)


    }