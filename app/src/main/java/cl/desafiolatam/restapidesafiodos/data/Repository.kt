package cl.desafiolatam.restapidesafiodos.data

import androidx.lifecycle.MutableLiveData


    class Repository {
        val photoList = MutableLiveData<List<Photo>>()
        suspend fun loadFromApi() {
            val response = RetrofitClient.retrofitCliente().getPhotos()

            when (response.isSuccessful) {
                true -> {
                    response.body()?.let {
                        photoList.value = it
                    }
                }

                false -> {
                    print("Error")
                }
            }
        }
    }
