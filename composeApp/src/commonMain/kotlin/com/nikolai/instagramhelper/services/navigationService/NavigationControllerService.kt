package com.nikolai.instagramhelper.services.navigationService

import androidx.navigation.NavHostController
import com.nikolai.instagramhelper.model.navigation.AppDestination
import com.nikolai.instagramhelper.model.popUpToTop

class NavigationControllerService: AppNavigationService {

    private var controller: NavHostController? = null

    override fun setNavigationController(controller: NavHostController) {
        this.controller = controller
    }

    override fun navigateTo(destination: AppDestination, clearBackStack: Boolean) {
        when(clearBackStack) {
            true -> {
                controller?.navigate(destination.route) {
                    popUpToTop(controller!!)
                }
            }
            false -> controller?.navigate(destination.route)
        }
    }

    override fun popBackStack() {
        controller?.popBackStack()
    }
}