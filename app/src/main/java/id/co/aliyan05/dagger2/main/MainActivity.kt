package id.co.aliyan05.dagger2.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import id.co.aliyan05.dagger2.AppClass
import id.co.aliyan05.dagger2.R
import id.co.aliyan05.dagger2.di.component.ActivityComponent
import id.co.aliyan05.dagger2.utils.toJson
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {
    val tag = "MainActivity"

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.injectActivity()
        presenter.bind(this)
        this.initView()
    }

    private fun initView() {
        btnClick.setOnClickListener{
            presenter.getClubList()
        }

    }

    private fun injectActivity(){
        val injector:ActivityComponent=(applicationContext as AppClass)
                .appComponent
                .activityComponent()
                .build()

        injector.inject(this)
    }
    override fun showClubList(clubList: List<Club>?) {
        Log.d(tag, "clubList : ${Gson().toJson()}")
    }
}
