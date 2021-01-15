package cl.desafiolatam.restapidesafiodos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.desafiolatam.restapidesafiodos.data.PhotoAdapter
import cl.desafiolatam.restapidesafiodos.databinding.ActivityMainBinding
import cl.desafiolatam.restapidesafiodos.model.PhotoViewModel

class MainActivity : AppCompatActivity() {
   private val viewModel:PhotoViewModel by viewModels()
   private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val adapter=PhotoAdapter()
        binding.rvPhoto.adapter=adapter
        binding.rvPhoto.layoutManager=LinearLayoutManager(this)
        setContentView(binding.root)
        viewModel.listaPhotos().observe(this,{
            adapter.update(it)
        })
    }
}