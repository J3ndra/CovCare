package com.junianto.covcare.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.junianto.covcare.R
import com.junianto.covcare.databinding.FragmentNewsBinding
import com.junianto.covcare.model.news.NewsData
import com.junianto.covcare.network.api.Network
import com.junianto.covcare.network.api.NetworkState
import com.junianto.covcare.network.api.apiInterface.NewsApiInterface

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var newsRepository: NewsRepository

    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)

        val apiService: NewsApiInterface = Network.getNewsClient()
        newsRepository = NewsRepository(apiService)

        newsViewModel = getViewModel()

        binding.rvNews.layoutManager = LinearLayoutManager(context)

        newsViewModel.newsData.observe(viewLifecycleOwner, Observer {
            binding.rvNews.adapter = NewsAdapter(it) { position, view ->
                val newsList: List<NewsData> = it
                val newsArray: ArrayList<NewsData> = ArrayList(newsList.size)
                newsArray.addAll(newsList)

                val bundle = bundleOf(
                    "link" to newsArray[position].link
                )

                view.findNavController().navigate(R.id.action_nav_news_to_nav_newsDetail, bundle)
            }
        })

        newsViewModel.networkState.observe(viewLifecycleOwner, Observer {
            binding.isLoading = it == NetworkState.LOADING
            binding.isEmpty = it == NetworkState.ERROR
        })

        return binding.root
    }


    private fun getViewModel(): NewsViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return NewsViewModel(newsRepository) as T
            }
        })[NewsViewModel::class.java]
    }
}