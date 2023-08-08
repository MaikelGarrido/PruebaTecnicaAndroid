package com.example.pruebatecnicaandroid.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pruebatecnicaandroid.ui.login.LoginScreen
import com.example.pruebatecnicaandroid.ui.login.LoginViewModel
import com.example.pruebatecnicaandroid.ui.scaffold.ScaffoldScreen
import com.example.pruebatecnicaandroid.ui.scaffold.ScaffoldViewModel
import com.example.pruebatecnicaandroid.ui.splash.SplashScreen
import com.example.pruebatecnicaandroid.utils.AsyncData
import com.example.pruebatecnicaandroid.utils.ProgressBar
import com.example.pruebatecnicaandroid.utils.ShowError
import com.example.pruebatecnicaandroid.utils.ShowErrorEthernet

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen { key ->
                navController.apply {
                    popBackStack()
                    when (key) {
                        true -> { navigate(Screen.Scaffold.route) }
                        else -> { navigate(Screen.Login.route) }
                    }
                }
            }
        }

        composable(route = Screen.Login.route) {
            val loginViewModel: LoginViewModel = hiltViewModel()
            val state by loginViewModel.state.collectAsStateWithLifecycle()

            LoginScreen(
                operation = state.operation,
                username = state.username,
                enabled = state.enabled,
                onEvent = loginViewModel::onEvent
            )

            if (state.isSuccess) {
                LaunchedEffect(Unit) {
                    navController.apply {
                        popBackStack()
                        navigate(Screen.Scaffold.route)
                    }
                }
            }

            if(state.isError.isNotEmpty()) {
                ShowError(
                    message = state.isError,
                    onDismiss =  loginViewModel::onEvent
                )
            }

            if(!state.isException.message.isNullOrEmpty()) {
                ShowErrorEthernet(loginViewModel::onEvent)
            }

            if (state.isLoading) {
                ProgressBar()
            }

        }

        composable(route = Screen.Scaffold.route) {
            val scaffoldViewModel: ScaffoldViewModel = hiltViewModel()
            val user by scaffoldViewModel.user.collectAsStateWithLifecycle()
            val state by scaffoldViewModel.state.collectAsStateWithLifecycle()

            AsyncData(user) { user ->
                ScaffoldScreen(
                    user = user,
                    onEvent = scaffoldViewModel::onEvent,
                    items = state.items
                )
            }

            if(state.isLoading) { ProgressBar() }

        }


    }
}



