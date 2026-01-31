package com.example.remed_192.view.route

import com.example.remed_192.R

object DestinasiEditBook : DestinasiNavigasi {
    override val route = "edit_book"
    override val titleRes = R.string.edit_book
    const val itemIdArg = "bookId"
    val routeWithArgs = "$route/{$itemIdArg}"
}