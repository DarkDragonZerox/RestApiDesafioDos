package cl.desafiolatam.restapidesafiodos.data

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.restapidesafiodos.databinding.PhotosListItemBinding
import coil.load

class PhotoAdapter:RecyclerView.Adapter<PhotoVH>() {
    private var photos= listOf<Photo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoVH {
       val binding=PhotosListItemBinding.inflate(LayoutInflater.from(parent.context))
        return PhotoVH(binding)
    }

    override fun onBindViewHolder(holder: PhotoVH, position: Int) {
        val photo=photos[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int {
       return photos.size
    }
    fun update(list:List<Photo>)
    {
        photos= list
        notifyDataSetChanged()
    }
}

class PhotoVH(val binding: PhotosListItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(photos:Photo){
        binding.tvTitle.text=photos.title
        binding.ivPhoto.load(photos.url)


    }

}
