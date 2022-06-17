package com.teo.dagger2sample.viewmodels

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

//class MainViewModelFactory(val sampleViewmodel: MainViewModel): ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T =
//        if(modelClass == MainViewModel::class.java){
//            sampleViewmodel as T
//        }else{
//            throw  IllegalStateException("Unknown entity")
//        }
//
//}

//TODO this cant state/data when kill or rotation.
class MainViewModelFactory(
    val updateMsg: String
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        MainViewModel(updateMsg) as T
}

/*
@Suppress("UNCHECKED_CAST")
@Singleton
class MainViewModelFactory @Inject
constructor(
    private val creators: Map<Class<out ViewModel>,
            @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("unknown model class " + modelClass)
        }
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}
*/

//class MyViewModelFactory(
//    private val updateMsg: String,
//    owner: SavedStateRegistryOwner,
//    defaultArgs: Bundle? = null
//) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(
//        key: String, modelClass: Class<T>, handle: SavedStateHandle
//    ): T {
//        return MainViewModel(updateMsg, handle) as T
//    }
//}

@Singleton
class ViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>,
        @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        viewModels[modelClass]?.get() as T

}