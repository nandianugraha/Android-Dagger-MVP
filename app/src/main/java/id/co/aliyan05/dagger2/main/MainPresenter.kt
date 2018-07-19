package id.co.aliyan05.dagger2.main

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import id.co.aliyan05.dagger2.data.ApiService
import id.co.aliyan05.dagger2.data.repository.MainRepo
import id.co.aliyan05.dagger2.di.ActivityScope
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@ActivityScope
class MainPresenter @Inject constructor(val repo: MainRepo){

    val tag = "MainPresenter"

    private lateinit var view: MainView

    fun getClubList() {
        Log.d("MainPresenter", "MainPresenter : getClubList")
        repo.getClubList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    //ketika sukses
                    Log.e(tag, "club list : ${Gson().toJsonTree(it)}")
                    view.showClubList(it)
                }, {
                    //ketika error
                    Log.e(tag, "Error : ${it.message}")
                })
    }

    fun bind(view: MainView) {
        this.view = view
    }
}