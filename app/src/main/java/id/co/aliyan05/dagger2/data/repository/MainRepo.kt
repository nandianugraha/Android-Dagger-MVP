package id.co.aliyan05.dagger2.data.repository

import id.co.aliyan05.dagger2.data.ApiService
import id.co.aliyan05.dagger2.main.Club
import io.reactivex.Flowable
import javax.inject.Inject

class MainRepo @Inject constructor(val api:ApiService) {

    fun getClubList(): Flowable<List<Club>>{
        return api.getClubList()
                .flatMap {
                    return@flatMap Flowable.fromIterable(it.clubs)
                }
                .map {
                    return@map Club(name = it.name, code = it.code)
                }
                .toList()
                .toFlowable()
    }
}