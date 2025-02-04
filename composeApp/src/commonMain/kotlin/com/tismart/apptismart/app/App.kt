package com.tismart.apptismart.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.tismart.apptismart.features.auth.presentation.login.LoginScreenRoot
import com.tismart.apptismart.core.presentation.PoppinsTypography
import com.tismart.apptismart.features.home.presentation.HomeScreenRoot
import com.tismart.apptismart.features.news.presentation.news_list.NewsListScreenRoot
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Route.AuthGraph
        ) {
            navigation<Route.AuthGraph>(
                startDestination = Route.Login
            ) {
                composable<Route.Login> {

                    LoginScreenRoot(
                        onLoginSuccess = {
                            navController.navigate(Route.HomeGraph) {
                                popUpTo(Route.AuthGraph) {
                                    inclusive = true
                                }
                            }
                        }
                    )
                }
            }
            navigation<Route.HomeGraph>(
                startDestination = Route.Home
            ) {
                composable<Route.Home> {
                    HomeScreenRoot()
                }
                composable<Route.NewsList> {
                    NewsListScreenRoot()
                }
                composable<Route.NewsDetail> {
                }
            }
        }

    }
}

@Composable
private inline fun <reified T: ViewModel> NavBackStackEntry.sharedKoinViewModel(
    navController: NavController
): T {
    val navGraphRoute = destination.parent?.route ?: return koinViewModel<T>()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return koinViewModel(
        viewModelStoreOwner = parentEntry
    )
}