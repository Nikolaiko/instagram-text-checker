package com.nikolai.instagramhelper.services.navigationService

import androidx.navigation.NavHostController
import com.nikolai.instagramhelper.model.navigation.AppDestination

interface AppNavigationService {

    fun setNavigationController(controller: NavHostController)
    fun navigateTo(destination: AppDestination, clearBackStack: Boolean)
    fun popBackStack()
}