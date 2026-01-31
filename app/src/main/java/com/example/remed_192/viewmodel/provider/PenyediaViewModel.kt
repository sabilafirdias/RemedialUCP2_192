package com.example.remed_192.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.remed_192.repositori.AplikasiPerpustakaan
import com.example.remed_192.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiPerpustakaan().container.repositoriPerpustakaan)
        }
    }
}

fun CreationExtras.aplikasiPerpustakaan(): AplikasiPerpustakaan =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiPerpustakaan)