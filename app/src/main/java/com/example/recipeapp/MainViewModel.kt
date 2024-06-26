package com.example.recipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.ui.theme.Category
import com.example.recipeapp.ui.theme.recipeService
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    private val _categoristate= mutableStateOf(RecipeState())
    val categorystate:State<RecipeState> = _categoristate

    init {
        fetcategory()
    }

    private fun fetcategory(){
        viewModelScope.launch{
            try{
                val response= recipeService.getCategory()
                   _categoristate.value=_categoristate.value.copy(
                    list=response.categories,
                    loading=false,
                    error = null

                )
            }
            catch (e:Exception){
                _categoristate.value=_categoristate.value.copy(loading= false,
                    error="Error fetching  categories ${e.message}")
            }
        }
    }

    data class RecipeState(
            val loading:Boolean=true,
            val list:List<Category> = emptyList(),
            val error:String? =null
    )
}