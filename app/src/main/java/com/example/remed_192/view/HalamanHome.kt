package com.example.remed_192.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToBookEntry: () -> Unit,
    navigateToBookDetail: (Int) -> Unit
) {
    val context = LocalContext.current
    val app = context.applicationContext as AplikasiPerpustakaan

    val viewModel: BookViewModel = viewModel {
        BookViewModel(app.container.repositoriPerpustakaan)
    }

    val listBook by viewModel.books.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Perpustakaan") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToBookEntry
            ) {
                Text("+")
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            Text(
                text = "Daftar Buku",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            if (listBook.isEmpty()) {
                Text("Belum ada data buku")
            } else {
                listBook.forEach { book ->
                    BookItem(
                        book = book,
                        onClick = { navigateToBookDetail(book.id) }
                    )
                }
            }
        }
    }
}
