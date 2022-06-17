package com.teo.dagger2sample.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

//class MainViewModel @AssistedInject constructor(@Assisted(IDENTIFIER_TAG_KEY) val updateMsg: String?) : ViewModel() {
class MainViewModel @AssistedInject constructor(@Assisted val updateMsg: String) : ViewModel() {

    // It's a factory of this viewmodel, we need
    // to annotate this factory interface
    // with @AssistedFactory in order to
    // let Dagger-Hilt know about it
    @AssistedFactory
    interface MainViewModelFactory {
//        fun create(@Assisted(IDENTIFIER_TAG_KEY) updateMsg: String): MainViewModel
        fun create(@Assisted updateMsg: String): MainViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        private const val IDENTIFIER_TAG_KEY = "updateMsg"
        // putting this function inside
        // companion object so that we can
        // access it from outside i.e. from fragment/activity
        fun providesFactory(
            assistedFactory: MainViewModelFactory,
            updateMsg: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                // using our MainViewModelFactory's create function
                // to actually create our viewmodel instance
                return assistedFactory.create(updateMsg) as T
            }
        }
    }

//    init {
//        myMessage()
//    }

    val hello: String = "Hello world."

     fun myMessage(): String {
        return updateMsg ?: hello
    }


}