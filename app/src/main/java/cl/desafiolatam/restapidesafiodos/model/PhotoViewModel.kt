package cl.desafiolatam.restapidesafiodos.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.desafiolatam.restapidesafiodos.data.Photo
import cl.desafiolatam.restapidesafiodos.data.Repository
import kotlinx.coroutines.launch

class PhotoViewModel : ViewModel(){
    private val repository=Repository()
    private val listaPhotos=repository.photoList

    fun listaPhotos():LiveData<List<Photo>> = listaPhotos

    init {
        viewModelScope.launch {
            repository.loadFromApi()
        }
    }

}