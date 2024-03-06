package com.example.fish.Model

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.fish.ui.theme.DisplayUI

@Composable
fun Back(nav: NavController, view: DisplayUI ,  goTo:String = "Home")
{
    BackHandler(enabled = true , onBack = {
        nav.navigate(goTo)
        view.changePage(goTo)
    })
}
fun goTo(nav: NavController , view: DisplayUI , goTo:String )
{
    nav.navigate(goTo)
    view.changePage(goTo)
}
