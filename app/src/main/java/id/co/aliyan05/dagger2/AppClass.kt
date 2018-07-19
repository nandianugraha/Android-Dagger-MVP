package id.co.aliyan05.dagger2

import android.app.Application
import id.co.aliyan05.dagger2.di.component.AppComponent
import id.co.aliyan05.dagger2.di.component.DaggerAppComponent
import id.co.aliyan05.dagger2.di.module.AppModule

class AppClass:Application(){

    val appComponent:AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule())
                .build()

    }
    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)

    }

}