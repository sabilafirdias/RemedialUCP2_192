package com.example.remed_192.repositori

import android.app.Application
import android.content.Context
import com.example.remed_192.room.DatabasePerpustakaan

interface ContainerApp {
    val repositoriPerpustakaan: RepositoriPerpustakaan
}

class ContainerDataApp(private val context: Context):
    ContainerApp {
    override val repositoriPerpustakaan: RepositoriPerpustakaan by lazy {
        OfflineRepositoriPerpustakaan(
            DatabasePerpustakaan.getDatabase(context).bookDao(),
            DatabasePerpustakaan.getDatabase(context).kategoriDao()
        )
    }
}

class AplikasiPerpustakaan : Application() {

    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}