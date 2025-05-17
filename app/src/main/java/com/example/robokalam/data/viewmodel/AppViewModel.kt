package com.example.robokalam.data.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.robokalam.data.db.Portfolio
import com.example.robokalam.data.db.PortfolioDatabase
import com.example.robokalam.data.api.QuoteApiService
import kotlinx.coroutines.launch

class AppViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = PortfolioDatabase.getDb(application).dao()
    private val quoteApi = QuoteApiService.create()

    private val _quote = MutableLiveData("Loading...")
    val quote: LiveData<String> = _quote

    private val _portfolio = MutableLiveData<Portfolio?>()
    val portfolio: LiveData<Portfolio?> = _portfolio

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    fun fetchQuote() {
        viewModelScope.launch {
            try {
                val result = quoteApi.getTodayQuote()[0]
                _quote.value = "${result.q} — ${result.a}"
            } catch (e: Exception) {
                _quote.value = "Stay motivated!"
            }
        }
    }

    fun loadPortfolio(email: String) {
        viewModelScope.launch {
            val portfolio = dao.getPortfolio(email)
            _portfolio.value = portfolio
            _username.value = portfolio?.username ?: "User"
        }
    }

    fun savePortfolio(portfolio: Portfolio, onSuccess: () -> Unit) {
        viewModelScope.launch {
            dao.insert(portfolio)
            _portfolio.value = portfolio
            _username.value = portfolio.username
            onSuccess()
        }
    }

    class Factory(private val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AppViewModel(app) as T
        }
    }
}
