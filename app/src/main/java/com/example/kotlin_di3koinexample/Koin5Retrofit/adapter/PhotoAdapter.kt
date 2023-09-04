package com.example.kotlin_di3koinexample.Koin5Retrofit.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.kotlin_di3koinexample.Koin5Retrofit.models.Photo
import com.example.kotlin_di3koinexample.R
import com.example.kotlin_di3koinexample.databinding.ItemPhotoRowBinding

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    private lateinit var binding: ItemPhotoRowBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemPhotoRowBinding.inflate(inflater, parent, false)
        context = parent.context
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun getItemViewType(position: Int): Int = position
    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Photo.Hit) {
            binding.apply {
                tvUserName.text = item.user
                tvCommentCount.text = item.comments.toString()
                tvLikeCount.text = item.likes.toString()
                imgArt.load(item.previewURL) {
                    crossfade(true)
                    placeholder(R.drawable.placeholder)
                    scale(Scale.FILL)
                }
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Photo.Hit>() {
        override fun areItemsTheSame(
            oldItem: Photo.Hit, newItem: Photo.Hit
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Photo.Hit, newItem: Photo.Hit
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

}