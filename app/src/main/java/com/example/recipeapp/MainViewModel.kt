package com.example.recipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.recipeapp.ui.theme.Category

class MainViewModel:ViewModel() {

    private val _categoristate= mutableStateOf(RecipeState())
    val categorystate:State<RecipeState> = _categoristate

    data class RecipeState(
            val loading:Boolean=false,
            val list:List<Category> = emptyList(),
            val error:String?=null
    )
}