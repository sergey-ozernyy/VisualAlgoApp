package com.example.androidvisualalgoapp

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AlgorithmViewModel: ViewModel(), KoinComponent {
    private val router by inject<Router>()


    fun navigateToDetails(){
        router.navigateTo(
            FragmentScreen{
                AlgorithmDetailsFragment()
            }
        )
    }



}