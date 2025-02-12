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
import com.tismart.apptismart.core.presentation.PoppinsTypography
import com.tismart.apptismart.features.auth.presentation.login.LoginScreenRoot
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
        NavigationRoot(
            navController = navController,
            isLoggedIn = true
        )
    }
}