package com.example.recipeapp

sealed class Screen(val route :String) {
    object ReceipeScreen:Screen("receipescreen")
    object DetailScreen:Screen("receipescreen")

}