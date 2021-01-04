package com.junianto.covcare.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.junianto.covcare.R
import com.junianto.covcare.databinding.ItemNewsBinding
import com.junianto.covcare.model.news.NewsData

class NewsAdapter (val news: List<NewsData>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_news, parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        news[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int = news.size

    class NewsViewHolder (private val newsBinding: ItemNewsBinding): RecyclerView.ViewHolder(newsBinding.root) {
        fun bind(news: NewsData) {
            newsBinding.news = news
            newsBinding.executePendingBindings()
        }
    }
}