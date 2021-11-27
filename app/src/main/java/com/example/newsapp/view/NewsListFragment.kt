package com.example.newsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.data.api.Article
import com.example.newsapp.data.presenter.NewsCallback
import com.example.newsapp.data.presenter.NewsListContract
import com.example.newsapp.data.retrofit.NewsRepository
import com.example.newsapp.databinding.FragmentNewsListBinding
import com.example.newsapp.view.adapter.NewsAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class NewsListFragment : Fragment(), CoroutineScope, NewsListContract.View {
    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private var _binding: FragmentNewsListBinding? = null
    private val binding get() = _binding

    lateinit var adapter: NewsAdapter
    private var newsList: MutableList<Article>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        val view = _binding!!.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
    }

    fun init() {
        adapter = NewsAdapter(callback)
        binding?.recyclerNews?.adapter = adapter
        binding?.recyclerNews?.layoutManager = LinearLayoutManager(requireContext())
        val repository = NewsRepository()

        launch {
            newsList = repository.getData().await() as MutableList<Article>?
            newsList?.let {
                adapter.setData(it)
            }
        }

    }

    override fun setData(article: List<Article>) {
        adapter.setData(article)
    }

    override fun replaceData(article: List<Article>) {
        adapter.replaceList(article)
    }

    val callback = object : NewsCallback {
        override fun setData(article: Article) {

        }

        override fun openFragment(article: Article) {
            val fragment = OpenDetailNews()
            val bundle = Bundle()
            bundle.putParcelable("key", article)
            fragment.arguments = bundle

            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, fragment)
                ?.addToBackStack(null)
                ?.commit()
        }

    }
}