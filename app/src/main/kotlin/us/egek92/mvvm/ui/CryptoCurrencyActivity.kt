package us.egek92.mvvm.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import dagger.android.AndroidInjection

import kotlinx.android.synthetic.main.activity_cryptocurrencies.*
import us.egek.mvvm.R
import us.egek92.mvvm.data.model.CryptoCurrency
import us.egek92.mvvm.utils.Constants
import us.egek92.mvvm.utils.InfiniteScrollListener
import us.egek92.mvvm.utils.toast
import javax.inject.Inject


/**
 * Created by Ege Kuzubasioglu on 9.06.2018 at 23:51.
 * Copyright (c) 2018. All rights reserved.
 */


class CryptoCurrencyActivity : AppCompatActivity() {

  @Inject
  lateinit var cryptoCurrencyViewModelFactory: CryptoCurrencyViewModelFactory
  private var cryptocurrenciesAdapter = CryptoCurrencyAdapter(ArrayList())
  private lateinit var cryptoCurrencyViewModel: CryptoCurrencyViewModel
  private var currentPage = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_cryptocurrencies)
    AndroidInjection.inject(this)

    initializeRecycler()

    cryptoCurrencyViewModel = ViewModelProviders.of(this, cryptoCurrencyViewModelFactory).get(
        CryptoCurrencyViewModel::class.java)

    progressBar.visibility = View.VISIBLE
    loadData()

    cryptoCurrencyViewModel.cryptocurrenciesResult().observe(this,
        Observer<List<CryptoCurrency>> {
          if (it != null) {
            val position = cryptocurrenciesAdapter.itemCount
            cryptocurrenciesAdapter.addCryptocurrencies(it)
            recycler.adapter = cryptocurrenciesAdapter
            recycler.scrollToPosition(position - Constants.LIST_SCROLLING)
          }
        })

    cryptoCurrencyViewModel.cryptocurrenciesError().observe(this, Observer<String> {
      if (it != null) {
        toast(resources.getString(R.string.cryptocurrency_error_message) + it)

      }
    })

    cryptoCurrencyViewModel.cryptocurrenciesLoader().observe(this, Observer<Boolean> {
      if (it == false) progressBar.visibility = View.GONE
    })
  }

  private fun initializeRecycler() {
    val gridLayoutManager = GridLayoutManager(this, 1)
    gridLayoutManager.orientation = LinearLayoutManager.VERTICAL
    recycler.apply {
      setHasFixedSize(true)
      layoutManager = gridLayoutManager
      addOnScrollListener(InfiniteScrollListener({ loadData() }, gridLayoutManager))
    }
  }

  private fun loadData() {
    cryptoCurrencyViewModel.loadCryptocurrencies(Constants.LIMIT, currentPage * Constants.OFFSET)
    currentPage++
  }

  override fun onDestroy() {
    cryptoCurrencyViewModel.disposeElements()
    super.onDestroy()
  }
}