package com.example.remed_192.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remed_192.repositori.RepositoriPerpustakaan
import com.example.remed_192.room.Book
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(private val repositoriPerpustakaan: RepositoriPerpustakaan): ViewModel() {
    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val homeUiState: StateFlow<HomeUiState> = repositoriPerpustakaan.getAllBookStream()
        .filterNotNull()
        .map { HomeUiState(listBook = it.toList()) }
        .stateIn(scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUiState())

    data class HomeUiState(
        val listBook: List<Book> = listOf()
    )
}