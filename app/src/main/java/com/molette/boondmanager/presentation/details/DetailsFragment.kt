package com.molette.boondmanager.presentation.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.molette.boondmanager.R
import com.molette.boondmanager.databinding.FragmentDetailsBinding
import com.molette.boondmanager.databinding.FragmentHomeBinding
import com.molette.boondmanager.presentation.home.adapter.BooksAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailsFragment : Fragment() {

    private val args: DetailsFragmentArgs by navArgs()
    private val detailsViewModel by viewModel<DetailsViewModel>()
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var adapter: BooksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = BooksAdapter(null)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.authorBooksRv.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailsViewModel.author.observe(viewLifecycleOwner, Observer {
            binding.author = it

            Glide.with(requireContext())
                .load(it.photo)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.authorPhoto)
        })

        detailsViewModel.books.observe(viewLifecycleOwner, Observer {
            adapter.data = it
        })
    }

    override fun onResume() {
        super.onResume()
        detailsViewModel.authorId.value = args.authorId
    }
}