package id.co.aliyan05.dagger2.data.model

import com.google.gson.annotations.SerializedName

data class ClubResponseModel(
        @field:SerializedName("name")
        val name : String?,
        @field:SerializedName("clubs")
        val clubs : List<ClubModel>?= emptyList()
)