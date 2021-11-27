package com.example.newsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.data.api.Article
import com.example.newsapp.databinding.FragmentOpenDetailNewsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class OpenDetailNews : Fragment(R.layout.fragment_open_detail_news), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private var _binding: FragmentOpenDetailNewsBinding? = null
    private val binding get() = _binding
    private var article: Article? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOpenDetailNewsBinding.inflate(inflater, container, false)
        val view = _binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        article = arguments?.getParcelable("key")

        binding?.openDetailTitle?.text = article?.title
        binding?.openDetailContent?.text = article?.content

        binding?.imageOpenDetail?.let {
            Glide.with(requireContext()).load(article?.image).centerCrop()
                .into(binding?.imageOpenDetail!!)
        }
    }


}