package com.tismart.apptismart.di

import com.tismart.apptismart.features.auth.presentation.login.LoginViewModel
import com.tismart.apptismart.core.data.HttpClientFactory
import com.tismart.apptismart.features.home.presentation.HomeViewModel
import com.tismart.apptismart.features.news.presentation.news_detail.NewsDetailViewModel
import com.tismart.apptismart.features.news.presentation.news_list.NewsListViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }

    viewModelOf(::LoginViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::NewsListViewModel)
    viewModelOf(::NewsDetailViewModel)
}