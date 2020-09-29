package com.molette.boondmanager.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.FragmentNavigatorDestinationBuilder
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.molette.boondmanager.R
import com.molette.boondmanager.databinding.BookCellBinding
import com.molette.boondmanager.presentation.home.HomeFragment
import com.molette.boondmanager.presentation.home.HomeFragmentDirections
import com.molette.boondmanager.presentation.models.Book

class BooksAdapter(val navController: NavController): RecyclerView.Adapter<BookViewHolder>() {

    var data: List<Book> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {

        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<BookCellBinding>(inflater, R.layout.book_cell, parent,  false)

        return BookViewHolder(binding, navController, parent.context)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

        val review = data[position]
        holder.bind(review)
    }
}

class BookViewHolder(val binding: BookCellBinding, val navController: NavController, val context: Context): RecyclerView.ViewHolder(binding.root){

    fun bind(book: Book){
        binding.book = book
        Glide.with(context)
            .load(book.cover)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.bookCover)

        binding.root.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?){
                val navDirections = HomeFragmentDirections.actionHomeFragment2ToDetailsFragment(book.id)
                navController.navigate(navDirections)
            }
        })
    }
}