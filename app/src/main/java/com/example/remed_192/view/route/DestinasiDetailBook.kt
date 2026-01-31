package com.example.remed_192.view.route

import com.example.remed_192.R

object DestinasiDetailBook : DestinasiNavigasi {
    override val route = "detail_book"
    override val titleRes = R.string.detail_book
    const val itemIdArg = "bookId"
    val routeWithArgs = "$route/{$itemIdArg}"
}