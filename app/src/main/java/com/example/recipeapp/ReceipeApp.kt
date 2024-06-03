package com.example.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun ReceipeApp(navController:NavController) {

    val recipeViewModel: MainViewModel = viewModel()
    val viewstate by recipeViewModel.categorystate


}