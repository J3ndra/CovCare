package com.junianto.covcare.ui.news.details

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.junianto.covcare.R
import com.junianto.covcare.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_detail, container, false)

//        val webSetting = binding.tvWebView.settings
//        webSetting.javaScriptEnabled
//
//        binding.tvWebView.webViewClient
//
//        arguments?.getString("link")?.let { binding.tvWebView.loadUrl(it) }

        with(binding) {
            val webViewUrl = arguments?.getString("link")

            tvWebView.webViewClient = WebViewClient()
            tvWebView.settings.javaScriptEnabled
            tvWebView.settings.builtInZoomControls = true
            if (webViewUrl != null) {
                tvWebView.loadUrl(webViewUrl)
            }
        }

        return binding.root
    }
}