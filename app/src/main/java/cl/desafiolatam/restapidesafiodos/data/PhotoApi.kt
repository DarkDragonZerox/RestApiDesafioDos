package cl.desafiolatam.restapidesafiodos.data

import retrofit2.Response
import retrofit2.http.GET

interface PhotoApi {

        @GET("/photos")
        suspend fun getPhotos(): Response<List<Photo>>


}