package be.katas.berlinclock.di

import be.katas.berlinclock.utils.BerlinClockUtils
import be.katas.berlinclock.viewmodel.BerlinClockViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { BerlinClockUtils() }
    viewModel { BerlinClockViewModel(get()) }
}