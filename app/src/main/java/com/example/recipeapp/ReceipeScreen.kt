package com.example.recipeapp

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.recipeapp.ui.theme.Category

@Composable
fun ReceipeScreen(modifier:Modifier=Modifier) {
    val receipeViewModel: MainViewModel = viewModel()
    val viewstate by receipeViewModel.categorystate
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewstate.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            viewstate.error != null -> {
                Text(text = "ERROR OCCURED")
            }

            else -> {
                CatergoryScreen(categories = viewstate.list)

            }
        }

    }
}

@Composable
fun CatergoryScreen(categories:List<Category>){
    LazyVerticalGrid(GridCells.Fixed(2),modifier=Modifier.fillMaxSize()) {
       items(categories) {
           category ->
           CatergoryItem(category =category )
       }
    }
}

// how each items look like
@Composable
fun CatergoryItem(category:Category){
    Column(modifier= Modifier
        .padding(8.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = rememberAsyncImagePainter(category.strCategoryThumb), contentDescription =null,
            modifier= Modifier
                .fillMaxSize()
                .aspectRatio(1f))



        Text(text = category.strCategory,
            color= Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier=Modifier.padding(top=4.dp)
        )

    }
}