package id.co.aliyan05.dagger2.data

import com.google.gson.JsonObject
import id.co.aliyan05.dagger2.data.model.ClubResponseModel
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET
import java.util.concurrent.Callable

interface ApiService {
    @GET("opendatajson/football.json/master/2017-18/es.1.clubs.json")
    fun getClubList(): Flowable<ClubResponseModel>
}