package com.teo.dagger2sample.dagger.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teo.dagger2sample.viewmodels.MainViewModel
import com.teo.dagger2sample.viewmodels.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

//    @Binds
//    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(MainViewModel::class)
//    abstract fun mainViewModel(viewModel: MainViewModel): ViewModel

//    @Provides
////    @Default
//    fun provideDefault(factory: MainViewModel.MainViewModelFactory) = factory.create("hello")

}

