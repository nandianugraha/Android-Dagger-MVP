package id.co.aliyan05.dagger2.di.module

import dagger.Module
import dagger.Provides
import id.co.aliyan05.dagger2.data.ApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providerRetrofit():Retrofit{
        return Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
fun providerApiService(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)

    }



}